package com.example.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.client.MinecraftClient;

public class NoBlockBreakWithSwordClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            ItemStack item = player.getStackInHand(hand);

            if (item.isOf(Items.WOODEN_SWORD) ||
                item.isOf(Items.STONE_SWORD) ||
                item.isOf(Items.IRON_SWORD) ||
                item.isOf(Items.GOLDEN_SWORD) ||
                item.isOf(Items.DIAMOND_SWORD) ||
                item.isOf(Items.NETHERITE_SWORD)) {

                return ActionResult.FAIL;
            }

            return ActionResult.PASS;
        });
    }
}
