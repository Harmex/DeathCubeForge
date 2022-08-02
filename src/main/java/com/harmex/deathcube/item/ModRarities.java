package com.harmex.deathcube.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class ModRarities {
    public static final Rarity JUNK = Rarity.create("junk", style -> style.withColor(0x555555));
    public static final Rarity COMMON = Rarity.create("common", style -> style.withColor(0x000000));
    public static final Rarity UNCOMMON = Rarity.create("uncommon", style -> style.withColor(0x00AA55));
    public static final Rarity RARE = Rarity.create("rare", style -> style.withColor(0x00AAFF));
    public static final Rarity EPIC = Rarity.create("epic", style -> style.withColor(0x5555FF));
    public static final Rarity LEGENDARY = Rarity.create("legendary", style -> style.withColor(0xFFAA55));
    public static final Rarity MYTHIC = Rarity.create("mythic", style -> style.withColor(0xFF55AA));
}
