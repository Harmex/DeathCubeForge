package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
import com.harmex.deathcube.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import org.jetbrains.annotations.NotNull;

public class EnderBagItem extends Item {
    private static final Component CONTAINER_TITLE = Component.translatable("container.enderchest");

    public EnderBagItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
        );
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        PlayerEnderChestContainer playerenderchestcontainer = pPlayer.getEnderChestInventory();
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        if (playerenderchestcontainer != null && itemStack.getItem() instanceof EnderBagItem) {
            if (pLevel.isClientSide) {
                return InteractionResultHolder.success(itemStack);
            } else {
                pPlayer.openMenu(new SimpleMenuProvider((Id, Player, BlockEntity) -> {
                    return ChestMenu.threeRows(Id, Player, playerenderchestcontainer);
                }, CONTAINER_TITLE));
                return InteractionResultHolder.consume(itemStack);
            }
        } else {
            return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide);
        }
    }
}
