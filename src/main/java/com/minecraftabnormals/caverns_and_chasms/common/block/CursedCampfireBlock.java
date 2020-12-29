package com.minecraftabnormals.caverns_and_chasms.common.block;

import com.minecraftabnormals.caverns_and_chasms.common.tileentity.CursedCampfireTileEntity;
import com.minecraftabnormals.caverns_and_chasms.core.registry.CCParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

public class CursedCampfireBlock extends CampfireBlock {

	public CursedCampfireBlock(Properties properties) {
		super(false, 2, properties);
	}

	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new CursedCampfireTileEntity();
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (stateIn.get(LIT)) {
			if (rand.nextInt(10) == 0) {
				worldIn.playSound((float) pos.getX() + 0.5F, ((float) pos.getY() + 0.5F), ((float) pos.getZ() + 0.5F), SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.6F, false);
			}

			if (rand.nextInt(5) == 0) {
				for (int i = 0; i < rand.nextInt(1) + 1; ++i) {
					worldIn.addParticle(CCParticles.CURSED_AMBIENT.get(), ((float) pos.getX() + 0.5F), ((float) pos.getY() + 0.5F), ((float) pos.getZ() + 0.5F), (rand.nextFloat() / 2.0F), 5.0E-5D, (rand.nextFloat() / 2.0F));
				}
			}
		}
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && state.get(LIT) && entityIn instanceof LivingEntity && ((LivingEntity) entityIn).isEntityUndead() && !EnchantmentHelper.hasFrostWalker((LivingEntity) entityIn)) {
			entityIn.attackEntityFrom(DamageSource.IN_FIRE, 4.0F);
		}
	}
}
