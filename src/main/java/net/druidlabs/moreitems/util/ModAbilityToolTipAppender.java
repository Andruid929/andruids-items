package net.druidlabs.moreitems.util;

import com.mojang.serialization.Codec;

import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public record ModAbilityToolTipAppender(String tooltipKeysString) implements TooltipProvider {

    public static final Codec<ModAbilityToolTipAppender> CODEC = Codec.STRING.xmap(ModAbilityToolTipAppender::new, ModAbilityToolTipAppender::tooltipKeysString);

    @Override
    public void addToTooltip(Item.@NonNull TooltipContext context, @NotNull Consumer<Component> textConsumer, @NonNull TooltipFlag type, @NonNull DataComponentGetter components) {
        textConsumer.accept(Component.literal(""));

        for (String key : StringTokeniser.getKeys(tooltipKeysString)) {

            textConsumer.accept(Component.translatable(key).withStyle(ChatFormatting.AQUA));
        }
    }

}
