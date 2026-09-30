package net.druidlabs.moreitems.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

import org.jspecify.annotations.NonNull;

import java.util.List;

public class EtherealAxeItem extends AxeItem {

    public EtherealAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void postHurtEnemy(@NonNull ItemStack stack, @NonNull LivingEntity target, @NonNull LivingEntity attacker) {
        if (attacker instanceof Player) {

            Level world = attacker.level();

            AABB aoe = new AABB(target.blockPosition()).inflate(5);

            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, aoe, e -> e != attacker);

            if (attacker.isShiftKeyDown() && attacker instanceof ServerPlayer serverPlayer) {
                if (!serverPlayer.getCooldowns().isOnCooldown(stack)) {

                    for (LivingEntity entity : entities) {
                        Vec3 direction = new Vec3(entity.getX() - attacker.getX(), 0, entity.getZ() - attacker.getZ());
                        entity.push(direction.x * 0.5d, 1, direction.z * 0.5d);

                        entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 3));
                    }

                    serverPlayer.getCooldowns().addCooldown(stack, 60);
                }
            }
        }

        super.postHurtEnemy(stack, target, attacker);
    }

    @Override
    public @NonNull InteractionResult interactLivingEntity(@NonNull ItemStack stack, @NonNull Player player,
                                                           @NonNull LivingEntity entity, @NonNull InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer && !player.isShiftKeyDown()) {

            if (!serverPlayer.getCooldowns().isOnCooldown(stack)) {
                Level world = player.level();

                AABB area = new AABB(entity.blockPosition()).inflate(5);

                List<LivingEntity> mobs = world.getEntitiesOfClass(LivingEntity.class, area, e -> e != player);

                for (LivingEntity entity1 : mobs) {
                    entity1.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 5,
                            false, false, false));
                }

                serverPlayer.getCooldowns().addCooldown(stack, 100);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
