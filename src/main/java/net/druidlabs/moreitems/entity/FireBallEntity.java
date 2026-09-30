package net.druidlabs.moreitems.entity;

import net.druidlabs.moreitems.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;

import org.jspecify.annotations.NonNull;

public class FireBallEntity extends Snowball {

    public FireBallEntity(Level world, LivingEntity owner, ItemStack stack) {
        super(world, owner, stack);
    }

    @Override
    protected void onHit(@NonNull HitResult hitResult) {
        super.onHit(hitResult);

        if (!this.level().isClientSide()) {
            Level world = this.level();

            world.explode(this, this.getX(), this.getY(), this.getZ(),
                    2f, true, Level.ExplosionInteraction.TNT);

            this.discard();
        }
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return ModItems.FIRE_BALL;
    }
}
