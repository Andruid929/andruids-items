package net.druidlabs.moreitems.item.custom;

import net.druidlabs.moreitems.food.ModConsumableComponents;
import net.druidlabs.moreitems.food.ModFoodComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class OpAppleItem extends Item {

    public OpAppleItem(@NotNull Properties settings) {
        super(settings.food(ModFoodComponents.DRUID_APPLE, ModConsumableComponents.DRUID_APPLE_COMPONENT)
                .stacksTo(8).rarity(Rarity.EPIC));
    }

    @Override
    public boolean isFoil(@NonNull ItemStack stack) {
        return true;
    }

}
