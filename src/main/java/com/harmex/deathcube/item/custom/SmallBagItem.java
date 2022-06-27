package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SmallBagItem extends Item {
    private final int containerSize = 27;
    private final SimpleContainer mainContainer = new SimpleContainer(containerSize);
    private static final Component CONTAINER_TITLE = Component.translatable("container.deathcube.small_bag");

    public SmallBagItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)
                .stacksTo(1)
        );
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pIsSelected) {
            CompoundTag itemTag = new CompoundTag();
            NonNullList<ItemStack> containerItems = NonNullList.withSize(containerSize, ItemStack.EMPTY);

            for (int i = 0; i < containerSize; i++) {
                containerItems.set(i, mainContainer.getItem(i));
            }

            ContainerHelper.saveAllItems(itemTag, containerItems, false);

            pStack.setTag(itemTag);
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        CompoundTag itemTag = itemStack.getTag();
        if (pUsedHand.equals(InteractionHand.MAIN_HAND)) {
            if (itemTag != null) {
                NonNullList<ItemStack> containerItems = NonNullList.withSize(containerSize, ItemStack.EMPTY);
                if (itemTag.contains("Items", Tag.TAG_LIST)) {
                    ContainerHelper.loadAllItems(itemTag, containerItems);
                }

                SimpleContainer container = new SimpleContainer(containerSize);
                for (int i = 0; i < containerSize; i++) {
                    container.setItem(i, containerItems.get(i));
                }

                pPlayer.openMenu(new SimpleMenuProvider((Id, Player, BlockEntity) -> ChestMenu
                        .threeRows(Id, Player, container), CONTAINER_TITLE));
            }
            return InteractionResultHolder.consume(itemStack);
        }
        return InteractionResultHolder.fail(itemStack);
    }
}
