package net.druidlabs.moreitems.block.custom;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class SeireiFlowerBlock extends FlowerBlock {

    public SeireiFlowerBlock(Holder<MobEffect> stewEffect, int duration, Properties settings) {
        super(stewEffect, duration, settings);
    }

    @Override
    protected void entityInside(@NonNull BlockState state, @NotNull Level world, @NonNull BlockPos pos, @NonNull Entity entity, @NonNull InsideBlockEffectApplier handler, boolean bl) {
        if (!world.isClientSide()) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo((ServerLevel) world, world.damageSources().wither())) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 200));
                }
            }

        }
        super.entityInside(state, world, pos, entity, handler, bl);
    }
}
