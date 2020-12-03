package com.minecraftabnormals.caverns_and_chasms.common.item.necromium;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class NecromiumHoeItem extends HoeItem {

	public NecromiumHoeItem(IItemTier tier, int maxDamage, float attackSpeedIn, Properties builder) {
		super(tier, maxDamage, attackSpeedIn, builder);
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60, 1));
		return super.hitEntity(stack, target, attacker);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.caverns_and_chasms.slowing").mergeStyle(TextFormatting.GRAY));
	}
}