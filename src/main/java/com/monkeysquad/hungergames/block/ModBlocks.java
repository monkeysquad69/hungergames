package com.monkeysquad.hungergames.block;

import com.monkeysquad.hungergames.HungerGames;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block AUTUMN_LEAVES_GRASS_BLOCK = registerBlock("autumn_leaves_grass_block", new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));
    public static final Block LEAVES = registerBlock("leaves_block", new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(HungerGames.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(HungerGames.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        HungerGames.LOGGER.info("Registering Mod Blocks for " + HungerGames.MOD_ID);
    }
}
