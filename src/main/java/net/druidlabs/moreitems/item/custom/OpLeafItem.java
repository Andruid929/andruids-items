package net.druidlabs.moreitems.item.custom;

import net.druidlabs.moreitems.food.ModConsumableComponents;
import net.druidlabs.moreitems.food.ModFoodComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

public class OpLeafItem extends Item {

    public OpLeafItem(@NotNull Properties settings) {
        super(settings
                .food(ModFoodComponents.LEAF, ModConsumableComponents.SEIREI_LEAF_COMPONENT)
                .stacksTo(16)
                .rarity(Rarity.EPIC));
    }
}
