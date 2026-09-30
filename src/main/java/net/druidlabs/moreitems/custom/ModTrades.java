package net.druidlabs.moreitems.custom;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;

import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;

public class ModTrades {

    public static final ResourceKey<VillagerTrade> ARMORER_4_EMERALD_ANDID_HELM = createKey("armorer/4/emerald_andid_helm");
    public static final ResourceKey<VillagerTrade> ARMORER_4_EMERALD_ANDID_BOOTS = createKey("armorer/4/emerald_andid_boots");

    public static final ResourceKey<VillagerTrade> ARMORER_5_EMERALD_ANDID_CHESTPLATE = createKey("armorer/5/emerald_andid_chestplate");
    public static final ResourceKey<VillagerTrade> ARMORER_5_EMERALD_ANDID_LEGGINGS = createKey("armorer/5/emerald_andid_leggings");

    public static final ResourceKey<VillagerTrade> WEAPONSMITH_4_EMERALD_ANDID_SWORD = createKey("weaponsmith/4/emerald_andid_sword");
    public static final ResourceKey<VillagerTrade> WEAPONSMITH_4_EMERALD_ANDID_AXE = createKey("weaponsmith/4/emerald_andid_axe");

    public static final ResourceKey<VillagerTrade> TOOLSMITH_4_EMERALD_ANDID_PICKAXE = createKey("toolsmith/4/emerald_andid_pickaxe");
    public static final ResourceKey<VillagerTrade> TOOLSMITH_4_EMERALD_ANDID_SHOVEL = createKey("toolsmith/4/emerald_andid_shovel");

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {

        //Armorer 4
        register(context, ARMORER_4_EMERALD_ANDID_HELM, new VillagerTrade(
                new TradeCost(Items.EMERALD, 38),
                new ItemStackTemplate(ModItems.ANDID_HELM),
                2, 10, 0.5f, Optional.empty(), List.of()));

        register(context, ARMORER_4_EMERALD_ANDID_BOOTS, new VillagerTrade(
                new TradeCost(Items.EMERALD, 38),
                new ItemStackTemplate(ModItems.ANDID_BOOTS),
                2, 10, 0.5f, Optional.empty(), List.of()));

        //Armorer 5
        register(context, ARMORER_5_EMERALD_ANDID_CHESTPLATE, new VillagerTrade(
                new TradeCost(Items.EMERALD, 38),
                new ItemStackTemplate(ModItems.ANDID_CHESTPLATE),
                2, 10, 0.5f, Optional.empty(), List.of()));

        register(context, ARMORER_5_EMERALD_ANDID_LEGGINGS, new VillagerTrade(
                new TradeCost(Items.EMERALD, 38),
                new ItemStackTemplate(ModItems.ANDID_LEGGINGS),
                2, 10, 0.5f, Optional.empty(), List.of()));

        //Weaponsmith 4
        register(context, WEAPONSMITH_4_EMERALD_ANDID_SWORD, new VillagerTrade(
                new TradeCost(Items.EMERALD, 30),
                new ItemStackTemplate(ModItems.ANDID_SWORD),
                2, 10, 0.5f, Optional.empty(), List.of()));

        register(context, WEAPONSMITH_4_EMERALD_ANDID_AXE, new VillagerTrade(
                new TradeCost(Items.EMERALD, 40),
                new ItemStackTemplate(ModItems.ANDID_AXE),
                2, 10, 0.5f, Optional.empty(), List.of()));

        //Toolsmith 4
        register(context, TOOLSMITH_4_EMERALD_ANDID_PICKAXE, new VillagerTrade(
                new TradeCost(Items.EMERALD, 30),
                new ItemStackTemplate(ModItems.ANDID_PICKAXE),
                2, 10, 0.5f, Optional.empty(), List.of()));

        register(context, TOOLSMITH_4_EMERALD_ANDID_SHOVEL, new VillagerTrade(
                new TradeCost(Items.EMERALD, 30),
                new ItemStackTemplate(ModItems.ANDID_SHOVEL),
                2, 10, 0.5f, Optional.empty(), List.of()));
    }

    private static @NonNull ResourceKey<VillagerTrade> createKey(String name) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));
    }

    private static void register(@NonNull BootstrapContext<VillagerTrade> context, ResourceKey<VillagerTrade> resourceKey,
                                 VillagerTrade trade) {
        context.register(resourceKey, trade);
    }
}

