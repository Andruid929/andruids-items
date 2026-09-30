package net.druidlabs.moreitems.datagen;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {

    public ModLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.ANDID_BLOCK);
        dropSelf(ModBlocks.RAW_ANDID_BLOCK);
        dropSelf(ModBlocks.EMBER_BLOCK);

        add(ModBlocks.ANDID_ORE, createOreDrop(ModBlocks.ANDID_ORE, ModItems.RAW_ANDID));
        add(ModBlocks.NETHER_ANDID_ORE, createOreDrop(ModBlocks.NETHER_ANDID_ORE, ModItems.RAW_ANDID));
        dropSelf(ModBlocks.SEIREI_FLOWER);
        dropPottedContents(ModBlocks.POTTED_SEIREI_FLOWER);
    }
}
