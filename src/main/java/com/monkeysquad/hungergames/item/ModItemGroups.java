package com.monkeysquad.hungergames.item;

import com.monkeysquad.hungergames.HungerGames;
import com.monkeysquad.hungergames.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(HungerGames.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.CANDY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CANDY);
                        entries.add(ModBlocks.AUTUMN_LEAVES_GRASS_BLOCK);
                    }).build());
    public static void registerItemGroups() {
        HungerGames.LOGGER.info("Registering Item Groups for" + HungerGames.MOD_ID);
    }
}
