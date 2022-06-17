package com.harmex.deathcube.item;

import com.harmex.deathcube.DeathCube;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    LOG("log", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ItemTags.LOGS)
    ),
    BONE("bone", 5, new int[]{1, 3, 4, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(Items.BONE)
    ),
    COPPER("copper", 15, new int[]{2, 5, 6, 2}, 18, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> Ingredient.of(Items.COPPER_INGOT)
    ),
    EMERALD("emerald", 28, new int[]{2, 6, 7, 3}, 20, SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.0F, 0.0F, () -> Ingredient.of(Items.EMERALD)
    ),
    OBSIDIAN("obsidian", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0F, 0.1F, () -> Ingredient.of(Items.OBSIDIAN)
    );

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtection, int enchantmentValue,
                              SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtection;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return DeathCube.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
