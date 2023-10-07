package com.monkeysquad.hungergames.command;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class PlayerMoveListener {
    private static boolean shouldFreezePlayers = false;

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof PlayerEntity) {
                PlayerEntity targetPlayer = (PlayerEntity) entity;
                if (shouldFreezePlayers) {
                    return ActionResult.FAIL;
                }
            }
            return ActionResult.PASS;
        });
    }

    public static void setFreezePlayers(boolean freeze) {
        shouldFreezePlayers = freeze;
    }
}