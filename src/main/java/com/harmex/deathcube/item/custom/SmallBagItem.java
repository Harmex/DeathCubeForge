package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
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
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallBagItem extends Item {
    private final Map<CompoundTag, ItemStack> itemStackFromId = new HashMap<>();
    private final Map<ItemStack, SimpleContainer> containerFromItemStack = new HashMap<>();
    private final Map<SimpleContainer, CompoundTag> compoundTagFromContainer = new HashMap<>();
    private static final Component CONTAINER_TITLE = Component.translatable("container.enderchest");

    public SmallBagItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)
                .stacksTo(1)
        );
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pIsSelected) {
            //If the Item Stack is linked to a Simple Container
            if (containerFromItemStack.containsKey(pStack)) {
                //Get the Simple Container linked to the Item Stack
                Container container = containerFromItemStack.get(pStack);
                //If the Simple Container is linked to a Tag List of Item Stacks
                if (compoundTagFromContainer.containsKey(container)) {
                    CompoundTag itemListTag = compoundTagFromContainer.get(container);
                    ListTag items = new ListTag();
                    for (int i = 0; i < container.getContainerSize(); i++) {
                        if (container.getItem(i) != ItemStack.EMPTY) {
                            CompoundTag itemTag = new CompoundTag();
                            itemTag.putInt("Slot", i);
                            container.getItem(i).save(itemTag);
                            items.add(itemTag);
                        }
                    }
                    itemListTag.put("Items", items);
                    pStack.setTag(itemListTag);
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if (!containerFromItemStack.containsKey(itemStack)) {
            containerFromItemStack.put(itemStack, new SimpleContainer(27));
        }
        SimpleContainer container = containerFromItemStack.get(itemStack);

        if (!compoundTagFromContainer.containsKey(containerFromItemStack.get(itemStack))) {
            compoundTagFromContainer.put(containerFromItemStack.get(itemStack), new CompoundTag());
        }
        CompoundTag itemTagList = compoundTagFromContainer.get(container);


        ListTag items = itemTagList.getList("Items", Tag.TAG_COMPOUND);
        for (int i = 0; i < items.size(); i++) {
            CompoundTag itemTag = items.getCompound(i);
            int slot = itemTag.getInt("Slot");

            if (slot >= 0 && slot < container.getContainerSize()) {
                container.setItem(slot, ItemStack.of(itemTag));
            }
        }

        pPlayer.openMenu(new SimpleMenuProvider((Id, Player, BlockEntity) -> ChestMenu
                .threeRows(Id, Player, container), CONTAINER_TITLE));
        return InteractionResultHolder.consume(itemStack);
    }
}
