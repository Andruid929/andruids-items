package net.druidlabs.moreitems.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class RawAndidBlock extends Block {
    public RawAndidBlock(@NonNull Properties settings) {
        super(settings.strength(5f,6f)
                .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK));
    }

    @Override
    public void stepOn(@NonNull Level world, @NonNull BlockPos pos, @NonNull BlockState state, @NotNull Entity entity) {

        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.hurtServer((ServerLevel) world, world.damageSources().hotFloor(), 2.0f);
        }

        super.stepOn(world, pos, state, entity);
    }
}
