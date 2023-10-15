package com.monkeysquad.hungergames;

import com.monkeysquad.hungergames.block.ModBlocks;
import com.monkeysquad.hungergames.command.ChatToggle;
import com.monkeysquad.hungergames.command.FreezePlayers;
import com.monkeysquad.hungergames.fluid.AcidFluid;
import com.monkeysquad.hungergames.item.ModItemGroups;
import com.monkeysquad.hungergames.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HungerGames implements ModInitializer {
	public static final String MOD_ID = "hungergames";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static FlowableFluid STILL_ACID;
	public static FlowableFluid FLOWING_ACID;
	public static Item ACID_BUCKET;
	public static Block ACID;

	@Override
	public void onInitialize() {
		STILL_ACID = Registry.register(Registries.FLUID, new Identifier("hungergames", "acid"), new AcidFluid.Still());
		FLOWING_ACID = Registry.register(Registries.FLUID, new Identifier("hungergames", "flowing_acid"), new AcidFluid.Flowing());
		ACID_BUCKET = Registry.register(Registries.ITEM, new Identifier("hungergames", "acid_bucket"),
				new BucketItem(STILL_ACID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
		ACID = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "acid"), new FluidBlock(STILL_ACID, FabricBlockSettings.copy(Blocks.LAVA)));


		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		CommandRegistrationCallback.EVENT.register((dispatcher, dispatcher2, dispatcher3) -> FreezePlayers.register(dispatcher));
		CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> ChatToggle.register(dispatcher)));
	}
}