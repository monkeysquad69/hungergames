package com.monkeysquad.hungergames;

import com.monkeysquad.hungergames.block.ModBlocks;
import com.monkeysquad.hungergames.command.FreezePlayers;
import com.monkeysquad.hungergames.item.ModItemGroups;
import com.monkeysquad.hungergames.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HungerGames implements ModInitializer {
	public static final String MOD_ID = "hungergames";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		CommandRegistrationCallback.EVENT.register((dispatcher, dispatcher2, dispatcher3) -> FreezePlayers.register(dispatcher));
	}
}