package com.teamabnormals.caverns_and_chasms.common.item.silver;

import com.teamabnormals.blueprint.core.util.item.filling.TargetedItemCategoryFiller;
import com.teamabnormals.caverns_and_chasms.core.CavernsAndChasms;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SilverHorseArmorItem extends HorseArmorItem {
	private static final TargetedItemCategoryFiller FILLER = new TargetedItemCategoryFiller(() -> Items.GOLDEN_HORSE_ARMOR);

	public SilverHorseArmorItem(Item.Properties builder) {
		super(6, new ResourceLocation(CavernsAndChasms.MOD_ID, "textures/entity/horse/armor/horse_armor_silver.png"), builder);
	}

	@Override
	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
		FILLER.fillItem(this, group, items);
	}
}