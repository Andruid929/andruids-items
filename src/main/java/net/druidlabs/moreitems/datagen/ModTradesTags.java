package net.druidlabs.moreitems.datagen;

import static net.druidlabs.moreitems.custom.ModTrades.*;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModTradesTags extends FabricTagsProvider<VillagerTrade> {
    public ModTradesTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        getOrCreateRawBuilder(VillagerTradeTags.ARMORER_LEVEL_4)
                .add(tagEntryElement(ARMORER_4_EMERALD_ANDID_HELM))
                .add(tagEntryElement(ARMORER_4_EMERALD_ANDID_BOOTS));

        getOrCreateRawBuilder(VillagerTradeTags.ARMORER_LEVEL_5)
                .add(tagEntryElement(ARMORER_5_EMERALD_ANDID_CHESTPLATE))
                .add(tagEntryElement(ARMORER_5_EMERALD_ANDID_LEGGINGS));

        getOrCreateRawBuilder(VillagerTradeTags.TOOLSMITH_LEVEL_4)
                .add(tagEntryElement(TOOLSMITH_4_EMERALD_ANDID_PICKAXE))
                .add(tagEntryElement(TOOLSMITH_4_EMERALD_ANDID_SHOVEL));

        getOrCreateRawBuilder(VillagerTradeTags.WEAPONSMITH_LEVEL_4)
                .add(tagEntryElement(WEAPONSMITH_4_EMERALD_ANDID_AXE))
                .add(tagEntryElement(WEAPONSMITH_4_EMERALD_ANDID_SWORD));
    }

    @Contract("_ -> new")
    private @NonNull TagEntry tagEntryElement(@NonNull ResourceKey<VillagerTrade> resourceKey) {
        return TagEntry.element(resourceKey.identifier());
    }
}
