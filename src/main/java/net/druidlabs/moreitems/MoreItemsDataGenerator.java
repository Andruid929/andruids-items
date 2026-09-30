package net.druidlabs.moreitems;

import net.druidlabs.moreitems.custom.ModTrades;
import net.druidlabs.moreitems.datagen.*;
import net.druidlabs.moreitems.world.ModConfiguredFeatures;
import net.druidlabs.moreitems.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import org.jetbrains.annotations.NotNull;

public class MoreItemsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(@NotNull FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModAdvancementsProvider::new);
        pack.addProvider(ModTradesTags::new);
        pack.addProvider(ModDynamicRegistryProvider::new);
    }

    @Override
    public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        registryBuilder.add(Registries.VILLAGER_TRADE, ModTrades::bootstrap);
    }
}
