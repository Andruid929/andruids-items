package net.druidlabs.moreitems.datagen;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.gear.ModArmourMaterials;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jetbrains.annotations.NotNull;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NotNull BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.ANDID_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.NETHER_ANDID_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.EMBER_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.XP_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_ANDID_BLOCK);
        blockStateModelGenerator.createPlant(ModBlocks.SEIREI_FLOWER, ModBlocks.POTTED_SEIREI_FLOWER,
                BlockModelGenerators.PlantType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleItemModel(ModBlocks.ANDID_BLOCK.asItem(), ModelLocationUtils.getModelLocation(ModBlocks.ANDID_BLOCK));
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.ANDID, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_ANDID, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HEATED_EMBER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DRUID_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.LEAF, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANDID_UPGRADE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HARMON_TUNE_MUSIC_DISC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.YOKAI_TUNE_MUSIC_DISC, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.ANDID_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANDID_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANDID_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANDID_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.FIRE_BALL, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateSpear(ModItems.ANDID_SPEAR);

        itemModelGenerator.generateTrimmableItem(ModItems.ANDID_HELM, ModArmourMaterials.ANDID_EQUIPMENT_ASSET_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);

        itemModelGenerator.generateTrimmableItem(ModItems.ANDID_CHESTPLATE, ModArmourMaterials.ANDID_EQUIPMENT_ASSET_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);

        itemModelGenerator.generateTrimmableItem(ModItems.ANDID_LEGGINGS, ModArmourMaterials.ANDID_EQUIPMENT_ASSET_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);

        itemModelGenerator.generateTrimmableItem(ModItems.ANDID_BOOTS, ModArmourMaterials.ANDID_EQUIPMENT_ASSET_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
    }
}
