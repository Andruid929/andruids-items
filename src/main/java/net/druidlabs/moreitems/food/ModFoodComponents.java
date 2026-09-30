package net.druidlabs.moreitems.food;

import net.druidlabs.moreitems.MoreItems;
import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties DRUID_APPLE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.3f)
            .alwaysEdible().build();

    public static final FoodProperties LEAF = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f)
            .alwaysEdible().build();

    public static void registerModFoodComponents() {
        MoreItems.LOGGER.info("Registering mod food components for " + MoreItems.MOD_ID);
    }
}
