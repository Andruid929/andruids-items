package net.druidlabs.moreitems.item.custom;

import net.druidlabs.moreitems.entity.FireBallEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class FireBallItem extends Item {

    public FireBallItem(Properties settings) {
        super(settings);
    }

    @Override
    public @NonNull InteractionResult use(@NotNull Level world, @NotNull Player user, @NonNull InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);

        if (!world.isClientSide()) {
            FireBallEntity fireBallEntity = new FireBallEntity(world, user, stack);

            fireBallEntity.setItem(stack);
            fireBallEntity.shootFromRotation(user, user.getXRot(), user.getYRot(), 0f, 1.5f, 0f);

            world.addFreshEntity(fireBallEntity);

            if (!user.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }

        return super.use(world, user, hand);
    }
}
