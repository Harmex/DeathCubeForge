package com.harmex.deathcube.thirst.data;

import net.minecraft.nbt.CompoundTag;

public class PlayerThirst {
    private float thirst;

    public float getThirst() {
        return thirst;
    }

    public void setThirst(float thirst) {
        this.thirst = thirst;
    }

    public void decayThirst(float decay) {
        this.thirst -= decay;
    }

    public void saveNBT(CompoundTag compoundTag) {
        compoundTag.putFloat("deathcube.thirst", this.thirst);
    }

    public void loadNBT(CompoundTag compoundTag) {
        this.thirst = compoundTag.getFloat("deathcube.thirst");
    }
}
