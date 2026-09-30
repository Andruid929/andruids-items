package net.druidlabs.moreitems.custom;

import net.druidlabs.moreitems.MoreItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;

import org.jspecify.annotations.NonNull;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> RESIDUUM =
                createTag("residuum");

        private static @NonNull TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> REPAIRS_ANDID_GEAR = createTag("repairs_ethereal_gear");

        public static final TagKey<Item> ETHEREAL_GEAR = createTag("ethereal_gear");

        private static @NonNull TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name));
        }
    }
}
