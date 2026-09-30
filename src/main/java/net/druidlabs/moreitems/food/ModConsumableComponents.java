package net.druidlabs.moreitems.food;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import org.jspecify.annotations.NonNull;

import java.util.List;

public final class ModConsumableComponents {

    private ModConsumableComponents() {
    }

    public static final Consumable DRUID_APPLE_COMPONENT = create(List.of(
                    new MobEffectInstance(MobEffects.REGENERATION, 200, 5),
                    new MobEffectInstance(MobEffects.RESISTANCE, 3600, 3),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 1),
                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 15000, 4),
                    new MobEffectInstance(MobEffects.HASTE, 600, 3))).build();

    public static final Consumable SEIREI_LEAF_COMPONENT = create(List.of(
            new MobEffectInstance(MobEffects.REGENERATION, 100, 7),
            new MobEffectInstance(MobEffects.SPEED, 100, 5),
            new MobEffectInstance(MobEffects.RESISTANCE, 100, 0)),
            0.8f).build();

    private static Consumable.@NonNull Builder create(List<MobEffectInstance> effects) {
        return Consumable.builder()
                .hasConsumeParticles(true)
                .onConsume(new ApplyStatusEffectsConsumeEffect(effects));
    }

    private static Consumable.@NonNull Builder create(List<MobEffectInstance> effects, float consumeSeconds) {
        return create(effects).consumeSeconds(consumeSeconds);
    }
}
