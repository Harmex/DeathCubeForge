package com.harmex.deathcube.entity.custom;

import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.entity.ModEntityTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);
    public ModBoatEntity(EntityType<? extends ModBoatEntity> p_38290_, Level p_38291_) {
        super(p_38290_, p_38291_);
    }

    public enum Type {
        CHERRY(ModBlocks.CHERRY_PLANKS.get(), "cherry");

        private final String name;
        private final Block planks;

        Type(Block p_38427_, String p_38428_) {
            this.name = p_38428_;
            this.planks = p_38427_;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static ModBoatEntity.Type byId(int pId) {
            ModBoatEntity.Type[] aboat$type = values();
            if (pId < 0 || pId >= aboat$type.length) {
                pId = 0;
            }

            return aboat$type[pId];
        }

        public static ModBoatEntity.Type byName(String pName) {
            ModBoatEntity.Type[] aboat$type = values();

            for (Type type : aboat$type) {
                if (type.getName().equals(pName)) {
                    return type;
                }
            }

            return aboat$type[0];
        }
    }
}
