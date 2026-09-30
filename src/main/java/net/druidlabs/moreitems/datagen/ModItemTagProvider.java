package net.druidlabs.moreitems.datagen;

import static net.druidlabs.moreitems.item.ModItems.*;

import net.druidlabs.moreitems.custom.ModTags;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ANDID_HELM, ANDID_CHESTPLATE, ANDID_LEGGINGS, ANDID_BOOTS);

        valueLookupBuilder(ItemTags.CREEPER_IGNITERS)
                .add(HEATED_EMBER);

        valueLookupBuilder(ItemTags.PIGLIN_LOVED)
                .add(ANDID);

        valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ANDID);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ANDID_SWORD);

        valueLookupBuilder(ItemTags.AXES)
                .add(ANDID_AXE);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ANDID_PICKAXE);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ANDID_SHOVEL);

        valueLookupBuilder(ItemTags.SPEARS)
                .add(ANDID_SPEAR);

        valueLookupBuilder(ModTags.Items.REPAIRS_ANDID_GEAR)
                .add(ANDID);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ANDID_HELM);
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ANDID_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ANDID_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ANDID_BOOTS);

        valueLookupBuilder(ModTags.Items.ETHEREAL_GEAR).
                add(ANDID_BOOTS, ANDID_SPEAR, ANDID_LEGGINGS, ANDID_HELM, ANDID_AXE, ANDID_CHESTPLATE,
                        ANDID_PICKAXE, ANDID_SHOVEL, ANDID_SWORD);

        valueLookupBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.HARMON_TUNE_MUSIC_DISC, ModItems.YOKAI_TUNE_MUSIC_DISC);
    }
}
