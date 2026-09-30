package net.druidlabs.moreitems.item;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab ANDID_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, "andid"),
            FabricCreativeModeTab.builder().title(Component.translatable("itemgroup.andid"))
                    .icon(() -> new ItemStack(ModBlocks.ANDID_BLOCK)).displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.ANDID);
                        entries.accept(ModItems.RAW_ANDID);

                        entries.accept(ModItems.DRUID_APPLE);
                        entries.accept(ModItems.LEAF);

                        entries.accept(ModItems.ANDID_UPGRADE);

                        entries.accept(ModItems.HEATED_EMBER);

                        entries.accept(ModItems.HARMON_TUNE_MUSIC_DISC);
                        entries.accept(ModItems.YOKAI_TUNE_MUSIC_DISC);

                        entries.accept(ModBlocks.SEIREI_FLOWER);

                        entries.accept(ModItems.FIRE_BALL);

                        entries.accept(ModItems.ANDID_AXE);
                        entries.accept(ModItems.ANDID_PICKAXE);
                        entries.accept(ModItems.ANDID_SHOVEL);
                        entries.accept(ModItems.ANDID_SWORD);
                        entries.accept(ModItems.ANDID_SPEAR);

                        entries.accept(ModItems.ANDID_HELM);
                        entries.accept(ModItems.ANDID_CHESTPLATE);
                        entries.accept(ModItems.ANDID_LEGGINGS);
                        entries.accept(ModItems.ANDID_BOOTS);

                        entries.accept(ModBlocks.ANDID_BLOCK);
                        entries.accept(ModBlocks.RAW_ANDID_BLOCK);
                        entries.accept(ModBlocks.ANDID_ORE);
                        entries.accept(ModBlocks.NETHER_ANDID_ORE);
                        entries.accept(ModBlocks.XP_BLOCK);
                        entries.accept(ModBlocks.EMBER_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        MoreItems.LOGGER.info("Registering Item Groups for " + MoreItems.MOD_ID);
    }
}
