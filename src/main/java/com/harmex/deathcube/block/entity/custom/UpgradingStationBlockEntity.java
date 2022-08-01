package com.harmex.deathcube.block.entity.custom;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.entity.ModBlockEntities;
import com.harmex.deathcube.recipe.UpgradingStationRecipe;
import com.harmex.deathcube.screen.UpgradingStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
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

public class UpgradingStationBlockEntity extends BlockEntity implements MenuProvider {
    /* Capability */
    public final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();


    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> UpgradingStationBlockEntity.this.hasBaseIngredient;
                default -> 0;
            };
        }

        @Override
        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0 -> UpgradingStationBlockEntity.this.hasBaseIngredient = pValue;
            }
        }

        @Override
        public int getCount() {
            return 1;
        }
    };
    int hasBaseIngredient;

    private final RecipeManager.CachedCheck<SimpleContainer, UpgradingStationRecipe> quickCheck =
            RecipeManager.createCheck(UpgradingStationRecipe.Type.INSTANCE);

    public UpgradingStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.UPGRADING_STATION_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    //region Capability
    @Override
    public <T> @NotNull LazyOptional<T> getCapability(Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap);
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
        pTag.putBoolean("hasBaseIngredient", hasBaseIngredient != 0);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        hasBaseIngredient = pTag.getBoolean("hasBaseIngredient") ? 1 : 0;
    }
    //endregion

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        if (this.level != null) {
            Containers.dropContents(this.level, this.worldPosition, inventory);
        }
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, UpgradingStationBlockEntity pBlockEntity) {
        ItemStack item = pBlockEntity.itemHandler.getStackInSlot(0);
        SimpleContainer container = new SimpleContainer(item);

        ItemStack result = pBlockEntity.quickCheck.getRecipeFor(container, pLevel)
                .map(upgradingStationRecipe -> upgradingStationRecipe.assemble(container)).orElse(ItemStack.EMPTY);



        if (result.isEmpty()) {
            pBlockEntity.hasBaseIngredient = 0;
        } else {
            pBlockEntity.hasBaseIngredient = 1;
            pBlockEntity.itemHandler.setStackInSlot(0, result);
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container." + DeathCube.MODID + ".upgrading_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new UpgradingStationMenu(pContainerId, pPlayerInventory, this,
                ContainerLevelAccess.create(pPlayer.level, this.getBlockPos()), this.dataAccess);
    }
}
