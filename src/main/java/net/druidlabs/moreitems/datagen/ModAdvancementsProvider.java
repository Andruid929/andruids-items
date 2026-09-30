package net.druidlabs.moreitems.datagen;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.ConsumeItemTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {

    public ModAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.@NonNull Provider registryLookup, @NonNull Consumer<AdvancementHolder> consumer) {

        AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
                .display(
                        ModBlocks.ANDID_BLOCK,
                        Component.translatable("advancements.moreitems.andruids_items"),
                        Component.translatable("advancements_desc.moreitems.andruids_items"),
                        Identifier.fromNamespaceAndPath("minecraft", "gui/advancements/backgrounds/adventure"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                )
                .addCriterion("got_residuum", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_ANDID))
                .save(consumer, MoreItems.MOD_ID + "/root");

        AdvancementHolder gotAndid = Advancement.Builder.advancement().parent(rootAdvancement)
                .display(
                        ModItems.ANDID,
                        Component.translatable("advancement.moreitems.got_andid"),
                        Component.translatable("advancement_desc.moreitems.got_andid"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_andid", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDID))
                .save(consumer, MoreItems.MOD_ID + "/got_andid");

        AdvancementHolder gotAndide = Advancement.Builder.advancement().parent(gotAndid)
                .display(
                        ModBlocks.ANDID_BLOCK,
                        Component.translatable("advancement.moreitems.got_andid_block"),
                        Component.translatable("advancement_desc.moreitems.got_andid_block"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("got_andide", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ANDID_BLOCK))
                .save(consumer, MoreItems.MOD_ID + "/got_andide");

        AdvancementHolder ignored = Advancement.Builder.advancement().parent(rootAdvancement)
                .display(
                        ModBlocks.EMBER_BLOCK,
                        Component.translatable("advancement.moreitems.got_ember_block"),
                        Component.translatable("advancement_desc.moreitems.got_ember_block"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("got_ember_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMBER_BLOCK))
                .save(consumer, MoreItems.MOD_ID + "/got_ember_block");

        AdvancementHolder ignored1 = Advancement.Builder.advancement().parent(gotAndide)
                .display(
                        ModItems.DRUID_APPLE,
                        Component.translatable("advancement.moreitems.got_the_apple"),
                        Component.translatable("advancement_desc.moreitems.got_the_apple"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("got_the_apple", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRUID_APPLE))
                .save(consumer, MoreItems.MOD_ID + "/got_the_apple");

        AdvancementHolder gotLeaf = Advancement.Builder.advancement().parent(rootAdvancement)
                .display(
                        ModItems.LEAF,
                        Component.translatable("advancement.moreitems.got_leaf"),
                        Component.translatable("advancement_desc.moreitems.got_leaf"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("got_leaf", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEAF))
                .save(consumer, MoreItems.MOD_ID + "/got_leaf");

        AdvancementHolder ignored2 = Advancement.Builder.advancement().parent(gotAndide)
                .display(
                        ModItems.ANDID_PICKAXE,
                        Component.translatable("advancement.moreitems.got_pick"),
                        Component.translatable("advancement_desc.moreitems.got_pick"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("got_pick", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDID_PICKAXE))

                .save(consumer, MoreItems.MOD_ID + "/got_pick");
        AdvancementHolder ignored4 = Advancement.Builder.advancement().parent(gotAndide)
                .display(
                        ModItems.ANDID_CHESTPLATE,
                        Component.translatable("advancement.moreitems.full_set"),
                        Component.translatable("advancement_desc.moreitems.full_set"),
                        null,
                        AdvancementType.CHALLENGE,
                        true, true, false
                )
                .rewards(AdvancementRewards.Builder.experience(2000))
                .addCriterion("got_helm", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDID_HELM))
                .addCriterion("got_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDID_CHESTPLATE))
                .addCriterion("got_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDID_LEGGINGS))
                .addCriterion("got_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDID_BOOTS))
                .save(consumer, MoreItems.MOD_ID + "/full_armour_set");

        AdvancementHolder ignored3 = Advancement.Builder.advancement().parent(gotLeaf)
                .display(
                        ModItems.LEAF,
                        Component.translatable("advancement.moreitems.ate_leaf"),
                        Component.translatable("advancement_desc.moreitems.ate_leaf"),
                        null,
                        AdvancementType.GOAL,
                        true, true, false
                )
                .addCriterion("ate_leaf", ConsumeItemTrigger.TriggerInstance.usedItem(BuiltInRegistries.ITEM, ModItems.LEAF))
                .save(consumer, "moreitems" + "/ate_leaf");
    }
}
