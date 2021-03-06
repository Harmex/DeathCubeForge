/*package com.harmex.deathcube.event.loot;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

// TODO : changer les global loot modifier
public class EnderDragonScaleFromEnderDragonAdditionModifier extends LootModifier {
    private final Item addition;

    protected EnderDragonScaleFromEnderDragonAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(addition, Mth.randomBetweenInclusive(RandomSource.create(), 24, 48)));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<EnderDragonScaleFromEnderDragonAdditionModifier> {

        @Override
        public EnderDragonScaleFromEnderDragonAdditionModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new EnderDragonScaleFromEnderDragonAdditionModifier(ailootcondition, addition);
        }

        @Override
        public JsonObject write(EnderDragonScaleFromEnderDragonAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(instance.addition)).toString());
            return json;
        }
    }
}
*/