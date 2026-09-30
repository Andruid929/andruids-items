package net.druidlabs.moreitems.datagen;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.custom.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        valueLookupBuilder(ModTags.Blocks.RESIDUUM)
                .add(ModBlocks.ANDID_ORE, ModBlocks.NETHER_ANDID_ORE);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ANDID_BLOCK, ModBlocks.ANDID_ORE, ModBlocks.NETHER_ANDID_ORE, ModBlocks.XP_BLOCK, ModBlocks.EMBER_BLOCK, ModBlocks.RAW_ANDID_BLOCK);

        valueLookupBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.SEIREI_FLOWER);

        valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
                .add(ModBlocks.SEIREI_FLOWER);

        valueLookupBuilder(BlockTags.SOUL_SPEED_BLOCKS)
                .add(ModBlocks.XP_BLOCK);

        valueLookupBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModBlocks.ANDID_BLOCK, ModBlocks.XP_BLOCK, ModBlocks.RAW_ANDID_BLOCK);

        valueLookupBuilder(BlockTags.FALL_DAMAGE_RESETTING)
                .add(ModBlocks.XP_BLOCK);

        valueLookupBuilder(BlockTags.HOGLIN_REPELLENTS)
                .add(ModBlocks.SEIREI_FLOWER);

        valueLookupBuilder(BlockTags.DAMPENS_VIBRATIONS)
                .add(ModBlocks.XP_BLOCK);

        valueLookupBuilder(BlockTags.SNAPS_GOAT_HORN)
                .add(ModBlocks.ANDID_BLOCK, ModBlocks.RAW_ANDID_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ANDID_ORE, ModBlocks.NETHER_ANDID_ORE, ModBlocks.RAW_ANDID_BLOCK, ModBlocks.EMBER_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ANDID_BLOCK, ModBlocks.XP_BLOCK);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.XP_BLOCK);

        valueLookupBuilder(BlockTags.INFINIBURN_OVERWORLD)
                .add(ModBlocks.EMBER_BLOCK);

        valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.ANDID_BLOCK);

        valueLookupBuilder(BlockTags.STRIDER_WARM_BLOCKS)
                .add(ModBlocks.RAW_ANDID_BLOCK, ModBlocks.EMBER_BLOCK);

    }
}
