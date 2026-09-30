package net.druidlabs.moreitems.util;

import com.mojang.serialization.Codec;

import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public record ModToolTipAppender(String tooltipKey) implements TooltipProvider {

    public static final Codec<ModToolTipAppender> CODEC = Codec.STRING.xmap(ModToolTipAppender::new, ModToolTipAppender::tooltipKey);

    @Override
    public void addToTooltip(Item.@NonNull TooltipContext context, @NotNull Consumer<Component> textConsumer, @NonNull TooltipFlag type, DataComponentGetter components) {
        textConsumer.accept(Component.translatable(tooltipKey));
    }

}
