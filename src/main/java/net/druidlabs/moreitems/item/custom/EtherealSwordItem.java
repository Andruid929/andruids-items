package net.druidlabs.moreitems.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class EtherealSwordItem extends Item {

    public EtherealSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.@NotNull Properties settings) {
        super(settings.sword(toolMaterial, attackDamage, attackSpeed));
    }

    @Override
    public @NonNull InteractionResult use(@NotNull Level world, @NotNull Player player, @NonNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer && !player.isShiftKeyDown()) {

            if (!serverPlayer.getCooldowns().isOnCooldown(stack)) {
                MobEffectInstance effect = player.getEffect(MobEffects.SPEED);

                int speedLevel = (effect != null) ? effect.getAmplifier() + 1 : 0;

                player.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, speedLevel, false, false, true));
            }

            serverPlayer.getCooldowns().addCooldown(stack, 100);
        }

        if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer && player.isShiftKeyDown()) {

            if (!serverPlayer.getCooldowns().isOnCooldown(stack)) {
                MobEffectInstance effect = player.getEffect(MobEffects.HEALTH_BOOST);

                int boostLevel = (effect != null) ? effect.getAmplifier() + 5 : 4;

                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, boostLevel, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 10, false, false, true));
            }

            serverPlayer.getCooldowns().addCooldown(stack, 400);
        }

        return super.use(world, player, hand);
    }
}
