package net.druidlabs.moreitems.gear;

import com.google.common.collect.Maps;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.custom.ModTags;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface ModArmourMaterials {

    ResourceKey<EquipmentAsset> ANDID_EQUIPMENT_ASSET_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, "andid"));

    ArmorMaterial ANDID = new ArmorMaterial(40,
            andidDefenseMap(),
            17,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3f,
            1f,
            ModTags.Items.REPAIRS_ANDID_GEAR,
            ANDID_EQUIPMENT_ASSET_KEY);

// BASE_DURABILITY = {20, 28, 28, 21};

    @Contract(" -> new")
    private static @NotNull Map<ArmorType, Integer> andidDefenseMap() {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, 7, ArmorType.LEGGINGS, 7, ArmorType.CHESTPLATE, 9, ArmorType.HELMET, 6, ArmorType.BODY, 12));
    }
}
