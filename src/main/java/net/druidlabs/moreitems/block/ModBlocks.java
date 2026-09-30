package net.druidlabs.moreitems.block;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.block.custom.EmberBlock;
import net.druidlabs.moreitems.block.custom.RawAndidBlock;
import net.druidlabs.moreitems.block.custom.SeireiFlowerBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ANDID_BLOCK = registerModBlockAndCopy("andid_block", Blocks.NETHERITE_BLOCK,
            properties -> new Block(properties.requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel(_ -> 4)));

    public static final Block RAW_ANDID_BLOCK = registerModBlockAndCopy("raw_andid_block", Blocks.RAW_IRON_BLOCK,
            RawAndidBlock::new);

    public static final Block ANDID_ORE = registerModBlockAndCopy("andid_ore", Blocks.DEEPSLATE_DIAMOND_ORE,
            properties -> new DropExperienceBlock(UniformInt.of(15, 30), properties));

    public static final Block NETHER_ANDID_ORE = registerModBlockAndCopy("nether_andid_ore", Blocks.NETHER_QUARTZ_ORE,
            properties -> new DropExperienceBlock(UniformInt.of(30, 50), properties.sound(SoundType.NETHERRACK)
                    .strength(0.6f)));

    public static final Block XP_BLOCK = registerModBlock("xp_block",
            properties -> new DropExperienceBlock(UniformInt.of(60, 150),
                    properties.noLootTable().instabreak().friction(1.0f).sound(SoundType.SCULK)));

    public static final Block EMBER_BLOCK = registerModBlockAndCopy("ember_block", Blocks.MAGMA_BLOCK,
            EmberBlock::new);

    public static final Block SEIREI_FLOWER = registerModBlock("seirei_flower",
            properties -> new SeireiFlowerBlock(MobEffects.NAUSEA, 200,
                    properties.noCollision().lightLevel(_ -> 4)));

    public static final Block POTTED_SEIREI_FLOWER = registerModBlockAndCopy("potted_seirei_flower",
            Blocks.POTTED_ALLIUM, properties -> new FlowerPotBlock(SEIREI_FLOWER, properties.noOcclusion()));

    private static void registerBlockItem(String name, Block block) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));

        Item.Properties settings = new Item.Properties()
                .useBlockDescriptionPrefix()
                .setId(key);

        Registry.register(BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name), new BlockItem(block, settings));
    }

    private static Block registerModBlock(String name, @NotNull Function<BlockBehaviour.Properties, Block> settingsBlockFunction) {
        return registerModBlockAndCopy(name, null, settingsBlockFunction);
    }

    private static Block registerModBlockAndCopy(String name, @Nullable Block copyFrom, @NotNull Function<BlockBehaviour.Properties, Block> settingsBlockFunction) {
        BlockBehaviour.Properties settings = (copyFrom == null)
                ? BlockBehaviour.Properties.of()
                : BlockBehaviour.Properties.ofFullCopy(copyFrom);

        ResourceKey<Block> resourceKey = ResourceKey.create(Registries.BLOCK,
                Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));

        Block blockToRegister = settingsBlockFunction.apply(settings.setId(resourceKey));

        registerBlockItem(name, blockToRegister);

        return Registry.register(BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name),
                blockToRegister);
    }

    public static void registerModBlocks() {
        MoreItems.LOGGER.info("Registering ModBlocks for " + MoreItems.MOD_ID);
    }
}
