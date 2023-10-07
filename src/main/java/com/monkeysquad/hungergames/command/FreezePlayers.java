package com.monkeysquad.hungergames.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.world.GameMode;

import java.util.function.Supplier;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class FreezePlayers {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("freeze")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(argument("freeze", BoolArgumentType.bool())
                                .executes(context -> {
                                    boolean freeze = BoolArgumentType.getBool(context, "freeze");
                                    freezePlayers(context.getSource(), freeze);
                                    return 1;
                                })
                        )
        );
    }
    private static void freezePlayers(ServerCommandSource source, boolean freeze) {
        source.getServer().getPlayerManager().getPlayerList().forEach(player -> {
            if (player instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity) player;
                //playerEntity.setGameMode(GameMode.ADVENTURE);

                playerEntity.getAbilities().allowFlying = !freeze;
                playerEntity.getAbilities().flying = !freeze;

                playerEntity.getAbilities().setWalkSpeed(freeze ? 0.0f : 0.0f);
            }
            player.sendAbilitiesUpdate();
        });

        source.sendFeedback(() -> Text.literal("Frozen all players"), true);
    }


}
