package com.monkeysquad.hungergames.block;

import com.monkeysquad.hungergames.HungerGames;
import com.monkeysquad.hungergames.fluid.GreenLavaFluid;
import com.monkeysquad.hungergames.fluid.GreenLavaFluidBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final GreenLavaFluid GREEN_LAVA_FLUID = new GreenLavaFluid();
    public static final Block GREEN_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier("hungergames", "green_lava"), new GreenLavaFluidBlock(GREEN_LAVA_FLUID, FabricBlockSettings.copyOf(Blocks.LAVA)));
    public static final Item GREEN_LAVA_BUCKET = Registry.register(Registries.ITEM, new Identifier("hungergames", "green_lava_bucket"), new BucketItem(GREEN_LAVA_FLUID, new FabricItemSettings()));
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
