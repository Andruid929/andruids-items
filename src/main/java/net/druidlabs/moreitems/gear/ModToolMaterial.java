package net.druidlabs.moreitems.gear;

import net.druidlabs.moreitems.custom.ModTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.tags.BlockTags;

public interface ModToolMaterial {

    ToolMaterial ANDID = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2500, 10F, 6F, 22,
            ModTags.Items.REPAIRS_ANDID_GEAR);

}
