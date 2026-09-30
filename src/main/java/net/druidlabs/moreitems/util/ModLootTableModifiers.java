package net.druidlabs.moreitems.util;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.resources.Identifier;

public final class ModLootTableModifiers {

    private ModLootTableModifiers() {
    }

    private static final Identifier END_CITY_ID =
            Identifier.withDefaultNamespace("chests/end_city_treasure");
    private static final Identifier BLAZE_ID =
            Identifier.withDefaultNamespace("entities/blaze");
    private static final Identifier ANCIENT_CITY_ID =
            Identifier.withDefaultNamespace("chests/ancient_city");
    private static final Identifier BASTION_ID =
            Identifier.withDefaultNamespace("chests/bastion_treasure");
    private static final Identifier MANSION_ID =
            Identifier.withDefaultNamespace("chests/woodland_mansion");
    private static final Identifier TOOLSMITH_ID =
            Identifier.withDefaultNamespace("chests/village/village_toolsmith");
    private static final Identifier WEAPONSMITH_ID =
            Identifier.withDefaultNamespace("chests/village/village_weaponsmith");
    private static final Identifier ARMORER_ID =
            Identifier.withDefaultNamespace("chests/village/village_armorer");
    private static final Identifier MAGMA_BLOCK_ID =
            Identifier.withDefaultNamespace("blocks/magma_block");
    private static final Identifier FORTRESS_ID =
            Identifier.withDefaultNamespace("chests/nether_bridge");
    private static final Identifier RUINED_PORTAL_ID =
            Identifier.withDefaultNamespace("chests/ruined_portal");
    private static final Identifier DESERT_PYRAMID_ID =
            Identifier.withDefaultNamespace("chests/desert_pyramid");
    private static final Identifier STRONGHOLD_CORRIDOR_ID =
            Identifier.withDefaultNamespace("chests/stronghold_corridor");
    private static final Identifier STRONGHOLD_LIBRARY_ID =
            Identifier.withDefaultNamespace("chests/stronghold_library");
    private static final Identifier TRIAL_CHAMBER_ID =
            Identifier.withDefaultNamespace("chests/trial_chambers/reward_common");
    private static final Identifier TRIAL_CHAMBER_OMINOUS_ID =
            Identifier.withDefaultNamespace("chests/trial_chambers/reward_ominous_common");
    private static final Identifier OUTPOST_ID =
            Identifier.withDefaultNamespace("chests/pillager_outpost");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {

            //Mob drop
            if (BLAZE_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.3f))
                        .add(LootItem.lootTableItem(ModItems.HEATED_EMBER))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //End city chest
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.07f))
                        .add(LootItem.lootTableItem(ModBlocks.ANDID_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.15f))
                        .add(LootItem.lootTableItem(ModItems.DRUID_APPLE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModBlocks.XP_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 5f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.10f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_BOOTS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_LEGGINGS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_CHESTPLATE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_HELM))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_AXE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SHOVEL))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_PICKAXE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SWORD))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2f))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_UPGRADE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Ancient city chest
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.4f))
                        .add(LootItem.lootTableItem(ModItems.HARMON_TUNE_MUSIC_DISC))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.4f))
                        .add(LootItem.lootTableItem(ModItems.YOKAI_TUNE_MUSIC_DISC))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(3))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(4))
                        .when(LootItemRandomChanceCondition.randomChance(0.08f))
                        .add(LootItem.lootTableItem(ModItems.DRUID_APPLE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(3))
                        .when(LootItemRandomChanceCondition.randomChance(0.5f))
                        .add(LootItem.lootTableItem(ModBlocks.XP_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(5f, 7f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_LEGGINGS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_CHESTPLATE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_HELM))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.20f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_AXE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.25f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SHOVEL))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.20f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_PICKAXE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.20f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SWORD))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModBlocks.ANDID_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.4f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_BOOTS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Treasure bastion chest
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModBlocks.ANDID_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.15f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.DRUID_APPLE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.5f))
                        .add(LootItem.lootTableItem(ModBlocks.XP_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3f, 5f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.07f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_BOOTS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_LEGGINGS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_CHESTPLATE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.09f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_HELM))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_AXE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.15f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SHOVEL))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_UPGRADE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_PICKAXE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.07f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SWORD))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.68f))
                        .add(LootItem.lootTableItem(ModItems.ANDID))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 4f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.01f))
                        .add(LootItem.lootTableItem(ModItems.FIRE_BALL))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 6f)).build());
                tableBuilder.pool(poolBuilder.build());
            }


            //Woodland mansion chest
            if (MANSION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.7f))
                        .add(LootItem.lootTableItem(ModItems.DRUID_APPLE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (MANSION_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 5f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Magma block drop
            if (MAGMA_BLOCK_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.HEATED_EMBER))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Village toolsmith chest
            if (TOOLSMITH_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.06f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_PICKAXE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TOOLSMITH_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.06f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_AXE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TOOLSMITH_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.12f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SHOVEL))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Village weaponsmith chest
            if (WEAPONSMITH_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.06f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_AXE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (WEAPONSMITH_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.06f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SWORD))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Village armourer chest
            if (ARMORER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.06f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_HELM))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ARMORER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.04f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_CHESTPLATE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ARMORER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_LEGGINGS))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (ARMORER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.06f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_BOOTS))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Ruined portal chest
            if (RUINED_PORTAL_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.9f))
                        .add(LootItem.lootTableItem(ModItems.ANDID))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 3f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (RUINED_PORTAL_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.HEATED_EMBER))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 5f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (RUINED_PORTAL_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Desert pyramid chest
            if (DESERT_PYRAMID_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (DESERT_PYRAMID_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.01f))
                        .add(LootItem.lootTableItem(ModBlocks.ANDID_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (DESERT_PYRAMID_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.65f))
                        .add(LootItem.lootTableItem(ModItems.RAW_ANDID))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 4f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Stronghold corridor chest
            if (STRONGHOLD_CORRIDOR_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.25f))
                        .add(LootItem.lootTableItem(ModItems.HARMON_TUNE_MUSIC_DISC))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (STRONGHOLD_CORRIDOR_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.26f))
                        .add(LootItem.lootTableItem(ModItems.YOKAI_TUNE_MUSIC_DISC))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Stronghold library chest
            if (STRONGHOLD_LIBRARY_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_UPGRADE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Fortress chest
            if (FORTRESS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Regular trial chamber vault reward
            if (TRIAL_CHAMBER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))
                        .add(LootItem.lootTableItem(ModItems.ANDID))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 4f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.03f))
                        .add(LootItem.lootTableItem(ModItems.LEAF))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.02f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_UPGRADE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Ominous trial vault reward
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_UPGRADE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.01f))
                        .add(LootItem.lootTableItem(ModBlocks.ANDID_BLOCK))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f))
                        .add(LootItem.lootTableItem(ModBlocks.XP_BLOCK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4f, 6f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.03f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_CHESTPLATE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.03f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_LEGGINGS))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.03f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_AXE))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TRIAL_CHAMBER_OMINOUS_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.04f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_SWORD))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(registry, ConstantValue.exactly(15)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            //Pillager outpost
            if (OUTPOST_ID.equals(key.identifier())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.7f))
                        .add(LootItem.lootTableItem(ModItems.ANDID_UPGRADE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }
}
