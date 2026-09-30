package net.druidlabs.moreitems.item;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.gear.ModArmourMaterials;
import net.druidlabs.moreitems.gear.ModToolMaterial;
import net.druidlabs.moreitems.item.custom.*;
import net.druidlabs.moreitems.sound.ModSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class ModItems {

    private ModItems() {
    }

    public static final Item ANDID = registerModItem("andid", Item::new);

    public static final Item RAW_ANDID = registerModItem("raw_andid", Item::new);

    public static final Item HEATED_EMBER = registerModItem("ember", Item::new);

    public static final Item DRUID_APPLE = registerModItem("druid_apple", OpAppleItem::new);

    public static final Item LEAF = registerModItem("leaf", OpLeafItem::new);

    public static final Item ANDID_AXE = registerModItem("andid_axe", properties ->
            new EtherealAxeItem(ModToolMaterial.ANDID, 8, 1.4f, properties.fireResistant()));

    public static final Item ANDID_PICKAXE = registerModItem("andid_pickaxe", properties ->
            new EtherealPickaxeItem(ModToolMaterial.ANDID, 3, 1f, properties.fireResistant()));

    public static final Item ANDID_SHOVEL = registerModItem("andid_shovel", properties ->
            new ShovelItem(ModToolMaterial.ANDID,
                    4, 1.3f, properties.fireResistant()));

    public static final Item ANDID_SWORD = registerModItem("andid_sword", properties ->
            new EtherealSwordItem(ModToolMaterial.ANDID,
                    5, 2.4f, properties.fireResistant()));

    public static final Item ANDID_SPEAR = registerModItem("andid_spear", properties ->
            new Item(properties.spear(ModToolMaterial.ANDID, 1.10F,
                    1.5F, 0.2F, 2.1F,
                    6.8F, 4.85F, 5.1F,
                    8.5F, 4.6F).fireResistant()));

    public static final Item FIRE_BALL = registerModItem("fireball", properties ->
            new FireBallItem(properties.stacksTo(8)));

    public static final Item ANDID_HELM = registerModItem("andid_helm", properties ->
            new Item(properties.humanoidArmor(ModArmourMaterials.ANDID, ArmorType.HELMET)
                    .stacksTo(1)
                    .fireResistant()));

    public static final Item ANDID_CHESTPLATE = registerModItem("andid_chestplate", properties ->
            new Item(properties.humanoidArmor(ModArmourMaterials.ANDID, ArmorType.CHESTPLATE)
                    .stacksTo(1)
                    .fireResistant()));

    public static final Item ANDID_LEGGINGS = registerModItem("andid_leggings", properties ->
            new Item(properties.humanoidArmor(ModArmourMaterials.ANDID, ArmorType.LEGGINGS)
                    .stacksTo(1)
                    .fireResistant()));

    public static final Item ANDID_BOOTS = registerModItem("andid_boots", properties ->
            new Item(properties.humanoidArmor(ModArmourMaterials.ANDID, ArmorType.BOOTS)
                    .stacksTo(1)
                    .fireResistant()));

    public static final Item ANDID_UPGRADE = registerModItem("andid_upgrade", Item::new);

    public static final Item HARMON_TUNE_MUSIC_DISC = registerModItem("the_music_disc", properties ->
            new Item(properties.stacksTo(1).rarity(Rarity.EPIC).jukeboxPlayable(ModSounds.HARMON_TUNE_KEY)));

    public static final Item YOKAI_TUNE_MUSIC_DISC = registerModItem("yokai_music_disc", properties ->
            new Item(properties.stacksTo(1).rarity(Rarity.EPIC).jukeboxPlayable(ModSounds.YOKAI_TUNE_KEY)));

    private static Item registerModItem(String name, @NotNull Function<Item.Properties, Item> itemSettings) {

        Item.Properties settings = new Item.Properties();

        Identifier identifier = Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name);

        ResourceKey<Item> itemResourceKey = ResourceKey.create(Registries.ITEM, identifier);

        Item itemToRegister = itemSettings.apply(settings.setId(itemResourceKey));

        return Registry.register(BuiltInRegistries.ITEM, identifier, itemToRegister);
    }

    public static void registerModItems() {
        MoreItems.LOGGER.info("Registering Mod Items for " + MoreItems.MOD_ID);
    }
}
