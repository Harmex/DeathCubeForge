package com.harmex.deathcube.item.container;

import com.google.common.collect.Lists;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class BagContainer extends SimpleContainer {
    private final int size;
    private final NonNullList<ItemStack> items;
    @Nullable
    private List<ContainerListener> listeners;

    public BagContainer(int pSize) {
        super(pSize);
        this.size = pSize;
        this.items = NonNullList.withSize(pSize, ItemStack.EMPTY);
    }

    @Override
    public void addListener(@NotNull ContainerListener pListener) {
        if (this.listeners == null) {
            this.listeners = Lists.newArrayList();
        }

        this.listeners.add(pListener);
    }

    @Override
    public void removeListener(@NotNull ContainerListener pListener) {
        if (this.listeners != null) {
            this.listeners.remove(pListener);
        }
    }

    @Override
    public void fromTag(@NotNull ListTag pContainerNbt) {
        // Set all slots to empty
        for(int i = 0; i < this.getContainerSize(); ++i) {
            this.setItem(i, ItemStack.EMPTY);
        }

        CompoundTag itemsTag = new CompoundTag();
        itemsTag.put("Items", pContainerNbt);

        ContainerHelper.loadAllItems(itemsTag, items);

    }

    @Override
    public @NotNull ListTag createTag() {
        CompoundTag itemsTag = new CompoundTag();

        ContainerHelper.saveAllItems(itemsTag, items, true);

        return itemsTag.getList("Items", Tag.TAG_LIST);
    }

    @Override
    public void setItem(int pIndex, @NotNull ItemStack pStack) {
        this.items.set(pIndex, pStack);
        if (!pStack.isEmpty() && pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }
        this.setChanged();
    }

    @Override
    public void setChanged() {
        if (this.listeners != null) {
            for(ContainerListener containerlistener : this.listeners) {
                containerlistener.containerChanged(this);
            }
        }
    }

    @Override
    public int getContainerSize() {
        return this.size;
    }
}
