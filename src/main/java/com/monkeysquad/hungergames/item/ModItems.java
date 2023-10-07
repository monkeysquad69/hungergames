package com.monkeysquad.hungergames.item;

import com.monkeysquad.hungergames.HungerGames;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item CANDY = registerItem("candy", new Item(new FabricItemSettings()));
    public static final Item CANDY_SWORD = registerItem("candy_sword", new SwordItem(ModToolMaterial.Gumy, 5, 3f, new FabricItemSettings().maxCount(1)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(CANDY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(HungerGames.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HungerGames.LOGGER.info("Registering Mod Items for " + HungerGames.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
