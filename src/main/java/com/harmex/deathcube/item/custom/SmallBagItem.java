package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
import com.harmex.deathcube.item.container.BagContainer;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SmallBagItem extends Item {
    private final int containerSize = 27;
    private final BagContainer container = new BagContainer(containerSize);
    private static final Component CONTAINER_TITLE = Component.translatable("container.deathcube.small_bag");

    public SmallBagItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)
                .stacksTo(1)
        );
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        //if (pIsSelected) {
        //    CompoundTag itemsTag = new CompoundTag();
        //    ListTag itemListTag = container.createTag();
//
        //    itemsTag.put("Items", itemListTag);
        //    pStack.setTag(itemsTag);
//
        //}
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        CompoundTag itemsTag = itemStack.getTag();
        if (pUsedHand.equals(InteractionHand.MAIN_HAND)) {
            if (itemsTag != null) {
                if (itemsTag.contains("Items", Tag.TAG_LIST)) {
                    this.container.fromTag(itemsTag.getList("Items", Tag.TAG_COMPOUND));
                }
            }
            pPlayer.openMenu(new SimpleMenuProvider((Id, Player, BlockEntity) -> ChestMenu
                    .threeRows(Id, Player, this.container), CONTAINER_TITLE));
            return InteractionResultHolder.consume(itemStack);
        }
        return InteractionResultHolder.fail(itemStack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        CompoundTag itemsTag = pStack.getTag();
        if (itemsTag != null) {
            NonNullList<ItemStack> items = NonNullList.withSize(this.containerSize, ItemStack.EMPTY);
            ContainerHelper.loadAllItems(itemsTag, items);
            for (ItemStack item : items) {
                if (item != ItemStack.EMPTY) {
                    pTooltipComponents.add(Component.literal(item.getCount() + "x " + item.getHoverName()));
                }
            }
        }
    }
}
