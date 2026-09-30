package net.druidlabs.moreitems.components;

import net.druidlabs.moreitems.MoreItems;
import net.druidlabs.moreitems.util.ModAbilityToolTipAppender;
import net.druidlabs.moreitems.util.ModToolTipAppender;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

public final class ModDataComponents {
    public static final DataComponentType<ModToolTipAppender> TOOLTIP_APPENDER = register("tooltip_appender",
            builder -> builder.persistent(ModToolTipAppender.CODEC));

    public static final DataComponentType<ModAbilityToolTipAppender> ABILITY_TOOLTIP_APPENDER = register("ability_tooltip_appender",
            builder -> builder.persistent(ModAbilityToolTipAppender.CODEC));

    private static <T> DataComponentType<T> register(String name, @NotNull UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name),
                builderOperator.apply(DataComponentType.builder()).build());
    }

}
