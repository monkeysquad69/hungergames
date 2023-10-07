package com.monkeysquad.hungergames.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class FreezePlayers implements ModInitializer {

    private static boolean isFrozen = false;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(this::registerCommands);
    }

    private void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        LiteralCommandNode<ServerCommandSource> freezeCommand = dispatcher.register(CommandManager.literal("freeze")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(this::toggleFreeze));

        dispatcher.getRoot().addChild(freezeCommand);
    }

    private int toggleFreeze(CommandContext<ServerCommandSource> context) {
        isFrozen = !isFrozen;

        String statusMessage = isFrozen ? "Players are frozen." : "Players are unfrozen.";
        context.getSource().getPlayer().sendMessage(Text.of(statusMessage), false);

        return 1;
    }

}
