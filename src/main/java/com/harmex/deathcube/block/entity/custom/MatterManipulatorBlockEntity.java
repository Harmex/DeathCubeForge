package com.harmex.deathcube.block.entity.custom;

import com.google.gson.JsonSyntaxException;
import com.harmex.deathcube.block.entity.ModBlockEntities;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import com.harmex.deathcube.screen.MatterManipulatorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MatterManipulatorBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int pIndex) {
            switch (pIndex) {
                case 0:
                    return MatterManipulatorBlockEntity.this.manipulationProgress;
                case 1:
                    return MatterManipulatorBlockEntity.this.manipulationTimeTotal;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0:
                    MatterManipulatorBlockEntity.this.manipulationProgress = pValue;
                    break;
                case 1:
                    MatterManipulatorBlockEntity.this.manipulationTimeTotal = pValue;
                    break;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };
    int manipulationProgress;
    int manipulationTimeTotal;

    public MatterManipulatorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.MATTER_MANIPULATOR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.manipulationProgress = 0;
        this.manipulationTimeTotal = 50;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("container.deathcube.matter_manipulator");
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new MatterManipulatorMenu(pContainerId, pInventory, this, this.dataAccess);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("ManipulationTime", this.manipulationProgress);
        pTag.putInt("ManipulationTimeTotal", this.manipulationTimeTotal);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        manipulationProgress = pTag.getInt("ManipulationTime");
        manipulationTimeTotal = pTag.getInt("ManipulationTimeTotal");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, MatterManipulatorBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.manipulationProgress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.manipulationProgress > pBlockEntity.manipulationTimeTotal) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(MatterManipulatorBlockEntity pBlockEntity) {
        Level level = pBlockEntity.level;
        SimpleContainer inventory = new SimpleContainer(pBlockEntity.itemHandler.getSlots());
        for (int i = 0; i < pBlockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pBlockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<ShapedMatterManipulationRecipe> match = level.getRecipeManager()
                .getRecipeFor(ShapedMatterManipulationRecipe.Type.INSTANCE, inventory, level);

                /*if (level.getServer() != null && match.isPresent()) {
                    if (level.getServer().getPlayerList().getPlayerByName("Dev") != null) {
                        if (level.getServer().getPlayerList().getPlayerByName("Dev").getItemInHand(InteractionHand.MAIN_HAND) != null) {
                            level.getServer().getPlayerList().getPlayerByName("Dev")
                                    .getItemInHand(InteractionHand.MAIN_HAND).setHoverName(
                                    Component.literal("" + match.get().getManipulationTime()));
                        }

                    }
                }*/

        if (match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())) {
            pBlockEntity.manipulationTimeTotal = match.get().getManipulationTime();

        }

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
    }

    private static void craftItem(MatterManipulatorBlockEntity pBlockEntity) {
        Level level = pBlockEntity.level;
        SimpleContainer inventory = new SimpleContainer(pBlockEntity.itemHandler.getSlots());
        for (int i = 0; i < pBlockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pBlockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<ShapedMatterManipulationRecipe> match = level.getRecipeManager()
                .getRecipeFor(ShapedMatterManipulationRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {
            for (int i = 0; i < pBlockEntity.itemHandler.getSlots(); i++) {
                pBlockEntity.itemHandler.extractItem(i, 1, false);
            }

            pBlockEntity.itemHandler.insertItem(10, match.get().getResultItem(), false);

            pBlockEntity.resetProgress();
        }
    }

    private void resetProgress() {
        this.manipulationProgress = 0;
        this.manipulationTimeTotal = 200;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer pContainer, ItemStack pResult) {
        return pContainer.getItem(10).getItem() == pResult.getItem() || pContainer.getItem(10).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer pContainer) {
        return pContainer.getItem(10).getMaxStackSize() > pContainer.getItem(10).getCount();
    }
}
