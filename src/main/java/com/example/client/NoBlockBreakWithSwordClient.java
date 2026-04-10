package com.example.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class NoBlockBreakWithSwordClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            if (player.getMainHandStack().isOf(Items.WOODEN_SWORD) ||
                player.getMainHandStack().isOf(Items.STONE_SWORD) ||
                player.getMainHandStack().isOf(Items.IRON_SWORD) ||
                player.getMainHandStack().isOf(Items.GOLDEN_SWORD) ||
                player.getMainHandStack().isOf(Items.DIAMOND_SWORD) ||
                player.getMainHandStack().isOf(Items.NETHERITE_SWORD)) {

                return ActionResult.FAIL;
            }

            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            if (player.getMainHandStack().isOf(Items.SWORD)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
