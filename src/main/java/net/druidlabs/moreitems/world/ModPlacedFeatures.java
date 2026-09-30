package net.druidlabs.moreitems.world;

import net.druidlabs.moreitems.MoreItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import org.jspecify.annotations.NonNull;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ANDID_ORE_PLACED_KEY = registerKey("andid_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ANDID_ORE_PLACED_KEY = registerKey("nether_andid_ore_placed");
    public static final ResourceKey<PlacedFeature> XP_BLOCK_PLACED_KEY = registerKey("xp_block_placed");

    public static void bootstrap(@NonNull BootstrapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ANDID_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ANDID_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(-1))));
        register(context, NETHER_ANDID_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ANDID_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(3), VerticalAnchor.absolute(120))));
        register(context, XP_BLOCK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.XP_BLOCK_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(40), VerticalAnchor.absolute(120))));

    }

    public static @NonNull ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));
    }

    private static void register(@NonNull BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
