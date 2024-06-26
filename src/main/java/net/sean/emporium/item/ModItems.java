package net.sean.emporium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sean.emporium.AnimalEmporium;
import net.sean.emporium.fluid.ModFluids;

public class ModItems {

    public static final Item WORM = registerItem("worm", new Item(new FabricItemSettings().food(ModFoodComponents.WORM)));
    public static final Item WORM_STICK = registerItem("worm_stick", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item SLOP_BUCKET = registerBucketItem("slop_bucket", new BucketItem(ModFluids.STILL_SLOP, new FabricItemSettings()));

    private static void addItemsToFoodTab(FabricItemGroupEntries entries){
        entries.add(WORM);
    }
    private static void addItemsToToolsTab(FabricItemGroupEntries entries){
        entries.add(WORM_STICK);
        entries.add(SLOP_BUCKET);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AnimalEmporium.MOD_ID, name), item);
    }
    private static BucketItem registerBucketItem(String name, BucketItem item){
        return Registry.register(Registries.ITEM, new Identifier(AnimalEmporium.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AnimalEmporium.LOGGER.info("Registering Mod Items for " + AnimalEmporium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTab);


    }
}
