package net.druidlabs.moreitems;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.components.ModDataComponents;
import net.druidlabs.moreitems.food.ModFoodComponents;
import net.druidlabs.moreitems.item.ModItemGroups;
import net.druidlabs.moreitems.item.ModItems;
import net.druidlabs.moreitems.registries.ModFuels;
import net.druidlabs.moreitems.sound.ModSounds;
import net.druidlabs.moreitems.util.ModLootTableModifiers;
import net.druidlabs.moreitems.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;
import net.minecraft.core.component.DataComponents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreItems implements ModInitializer {

    public static final String MOD_ID = "moreitems";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();

        ItemComponentTooltipProviderRegistry.addFirst(ModDataComponents.ABILITY_TOOLTIP_APPENDER);
        ItemComponentTooltipProviderRegistry.addAfter(DataComponents.ENCHANTMENTS, ModDataComponents.TOOLTIP_APPENDER);

        ModLootTableModifiers.modifyLootTables();

        ModSounds.registerSounds();

        ModFoodComponents.registerModFoodComponents();

        ModWorldGeneration.generateModWorldGen();

        ModFuels.registerModFuels();

    }

}
