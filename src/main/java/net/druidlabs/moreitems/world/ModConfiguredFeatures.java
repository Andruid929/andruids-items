package net.druidlabs.moreitems.world;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import org.jspecify.annotations.NonNull;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANDID_ORE_KEY = registryKey("andid_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ANDID_ORE_KEY = registryKey("nether_andid_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> XP_BLOCK_KEY = registryKey("xp_block");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldAndidOre =
                List.of(OreConfiguration.target(deepslateReplaceables, ModBlocks.ANDID_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherAndidOres =
                List.of(OreConfiguration.target(netherrackReplaceables, ModBlocks.NETHER_ANDID_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> xpBlock =
                List.of(OreConfiguration.target(endReplaceables, ModBlocks.XP_BLOCK.defaultBlockState()));

        register(context, ANDID_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAndidOre, 9));
        register(context, NETHER_ANDID_ORE_KEY, Feature.ORE, new OreConfiguration(netherAndidOres, 7));
        register(context, XP_BLOCK_KEY, Feature.ORE, new OreConfiguration(xpBlock, 5));
    }

    public static @NonNull ResourceKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(@NonNull BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature,
                                                                                          FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
