package net.druidlabs.moreitems.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class EtherealPickaxeItem extends Item {

    public EtherealPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, @NotNull Properties settings) {
        super(settings.pickaxe(material, attackDamage, attackSpeed));
    }

    @Override
    public @NonNull InteractionResult useOn(@NotNull UseOnContext context) {
        Level world = context.getLevel();

        Player player = context.getPlayer();

        BlockPos pos = context.getClickedPos();

        ItemStack itemStack = context.getItemInHand();

        int remainingDurability = itemStack.getMaxDamage() - itemStack.getDamageValue();

        if (!world.isClientSide() && player != null) {
            if (!player.isShiftKeyDown()) {

                if (remainingDurability >= 9) {
                    BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            for (int z = -1; z <= 1; z++) {
                                mutablePos.set(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

                                BlockState blockState = world.getBlockState(mutablePos);

                                if (!blockState.isAir() && blockState.getDestroySpeed(world, mutablePos) != -1.0f) {
                                    world.destroyBlock(mutablePos, true, player);
                                }
                            }
                        }
                    }
                    context.getItemInHand().hurtWithoutBreaking(9, context.getPlayer());
                } else {
                    player.sendSystemMessage(Component.translatable("message.low_burrow_durability"));
                }
            }

            if (player.isShiftKeyDown()) {
                if (remainingDurability >= 15) {
                    boolean canMine = !world.getBlockState(pos).isAir();

                    int distanceToBreak = 15;

                    for (int blocksInFront = 0; blocksInFront < distanceToBreak; blocksInFront++) {
                        BlockPos lowerPosToBreak = pos.relative(context.getHorizontalDirection(), blocksInFront);
                        BlockPos upperPosToBreak = lowerPosToBreak.above();

                        if (canMine) {
                            world.destroyBlock(lowerPosToBreak, true);
                            world.destroyBlock(upperPosToBreak, true);
                        } else if (world.getBlockState(upperPosToBreak).isAir()) {
                            world.destroyBlock(lowerPosToBreak, true);
                        }
                    }

                    context.getItemInHand().hurtWithoutBreaking(30, context.getPlayer());

                } else {
                    player.sendSystemMessage(Component.translatable("message.low_strip_durability"));
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
