package net.druidlabs.moreitems.datagen;

import static net.minecraft.data.recipes.RecipeProvider.getItemName;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    private final List<ItemLike> ANDID_SMELTABLES = List.of(ModItems.RAW_ANDID,
            ModBlocks.ANDID_ORE, ModBlocks.NETHER_ANDID_ORE);

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private void offerAndidUpgradeRecipe(@NotNull RecipeProvider generator, RecipeOutput exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ANDID_UPGRADE),
                        Ingredient.of(input),
                        Ingredient.of(ModBlocks.ANDID_BLOCK),
                        category,
                        result)
                .unlocks("has_andid_block", generator.has(ModBlocks.ANDID_BLOCK))
                .save(exporter, getItemName(result) + "_smithing");
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registryLookup, @NonNull RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                oreSmelting(ANDID_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC,
                        ModItems.ANDID, 0.8f, 220, "andid");
                oreBlasting(ANDID_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC,
                        ModItems.ANDID, 1.5f, 100, "andid");


                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.ANDID, RecipeCategory.TOOLS,
                        ModBlocks.ANDID_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ANDID, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_ANDID_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.HEATED_EMBER, RecipeCategory.DECORATIONS,
                        ModBlocks.EMBER_BLOCK);

                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, ModItems.ANDID_HELM);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, ModItems.ANDID_CHESTPLATE);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, ModItems.ANDID_LEGGINGS);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, ModItems.ANDID_BOOTS);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, ModItems.ANDID_SWORD);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_SPEAR, RecipeCategory.COMBAT, ModItems.ANDID_SPEAR);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_AXE, RecipeCategory.TOOLS, ModItems.ANDID_AXE);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, ModItems.ANDID_PICKAXE);
                offerAndidUpgradeRecipe(this, output, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, ModItems.ANDID_SHOVEL);

                shaped(RecipeCategory.FOOD, ModItems.DRUID_APPLE, 1)
                        .pattern("AAA")
                        .pattern("AEA")
                        .pattern("AAA")
                        .define('A', ModBlocks.ANDID_BLOCK)
                        .define('E', Items.ENCHANTED_GOLDEN_APPLE)
                        .unlockedBy(getHasName(Items.ENCHANTED_GOLDEN_APPLE), has(Items.ENCHANTED_GOLDEN_APPLE))
                        .save(output, getSimpleRecipeName(ModItems.DRUID_APPLE));

                shaped(RecipeCategory.FOOD, ModItems.LEAF, 1)
                        .pattern("GGG")
                        .pattern("GFG")
                        .pattern("GGG")
                        .define('G', Items.GHAST_TEAR)
                        .define('F', Items.FLOWERING_AZALEA_LEAVES)
                        .unlockedBy(getHasName(Items.FLOWERING_AZALEA_LEAVES), has(Items.FLOWERING_AZALEA_LEAVES))
                        .unlockedBy(getHasName(Items.GHAST_TEAR), has(Items.GHAST_TEAR))
                        .save(output, getSimpleRecipeName(ModItems.LEAF));

                shaped(RecipeCategory.MISC, ModItems.ANDID_UPGRADE, 2)
                        .pattern("AUA")
                        .pattern("ARA")
                        .pattern("AAA")
                        .define('A', ModItems.ANDID)
                        .define('U', ModItems.ANDID_UPGRADE)
                        .define('R', ModBlocks.RAW_ANDID_BLOCK)
                        .unlockedBy(getHasName(ModItems.ANDID_UPGRADE), has(ModItems.ANDID_UPGRADE))
                        .unlockedBy(getHasName(ModBlocks.RAW_ANDID_BLOCK.asItem()), has(ModBlocks.RAW_ANDID_BLOCK))
                        .save(output, "andid_upgrade_duplication");
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "More items recipes";
    }
}
