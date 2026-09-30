package net.druidlabs.moreitems.registries;

import net.druidlabs.moreitems.block.ModBlocks;
import net.druidlabs.moreitems.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelValueEvents;

public class ModFuels {

    public static void registerModFuels() {
        FuelValueEvents.BUILD.register((builder, _) -> {
            builder.add(ModItems.HEATED_EMBER, 1200);
            builder.add(ModBlocks.EMBER_BLOCK, 18000);
        });
    }

}
