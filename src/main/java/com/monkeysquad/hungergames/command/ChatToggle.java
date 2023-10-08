package com.monkeysquad.hungergames.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class ChatToggle {
    private static boolean chatEnabled = true;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("chat-mute")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(argument("chat-mute", BoolArgumentType.bool())
                                .executes(context -> {
                                    boolean toggleValue = BoolArgumentType.getBool(context, "chat-mute");
                                    toggleChat(context.getSource(), toggleValue);
                                    return 1;
                                })
                        )
        );
    }

    private static void toggleChat(ServerCommandSource source, boolean toggleValue) {
        chatEnabled = toggleValue;

        String statusMessage = chatEnabled ? "Enabled" : "Disabled";
        source.sendFeedback(() -> Text.literal("Chat is now " + statusMessage), true);
    }
}
