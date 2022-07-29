package com.harmex.deathcube.thirst;

import net.minecraft.nbt.CompoundTag;

public class PlayerThirst {
    private int thirst;
    private final int MIN_THIRST = 0;
    private final int MAX_THIRST = 20;

    public int getThirst() {
        return thirst;
    }

    public void addThirst(int add) {
        this.thirst = Math.min(this.thirst + add, MAX_THIRST);
    }

    public void subThirst(int sub) {
        this.thirst = Math.max(this.thirst - sub, MIN_THIRST);
    }

    public void copyFrom(PlayerThirst source) {
        this.thirst = source.thirst;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("thirst", thirst);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.thirst = nbt.getInt("thirst");
    }
}
