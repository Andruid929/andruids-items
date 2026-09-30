package net.druidlabs.moreitems.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class EmberBlock extends Block {

    public EmberBlock(@NotNull Properties settings) {
        super(settings.lightLevel(_ -> 12));
    }

    @Override
    public void stepOn(@NonNull Level world, @NonNull BlockPos pos, @NonNull BlockState state, @NotNull Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {

            if (world instanceof ServerLevel serverWorld) {
                entity.hurtServer(serverWorld, world.damageSources().hotFloor(), 3.5f);
            }
        }
        super.stepOn(world, pos, state, entity);
    }
}
