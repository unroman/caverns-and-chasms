package com.teamabnormals.caverns_and_chasms.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamabnormals.caverns_and_chasms.client.model.DeeperModel;
import com.teamabnormals.caverns_and_chasms.client.renderer.entity.layers.DeeperPowerLayer;
import com.teamabnormals.caverns_and_chasms.client.renderer.entity.layers.DeeperPrimedLayer;
import com.teamabnormals.caverns_and_chasms.common.entity.monster.Deeper;
import com.teamabnormals.caverns_and_chasms.core.other.CCModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DeeperRenderer extends MobRenderer<Deeper, DeeperModel<Deeper>> {

	public DeeperRenderer(EntityRendererProvider.Context context) {
		super(context, new DeeperModel<>(DeeperModel.DeeperSprite.BASE, context.bakeLayer(CCModelLayers.DEEPER)), 0.5F);
		this.addLayer(new DeeperPrimedLayer(this, context));
		this.addLayer(new DeeperPowerLayer(this, context.getModelSet()));
	}

	@Override
	protected void scale(Deeper entity, PoseStack matrixStackIn, float partialTickTime) {
		float f = entity.getSwelling(partialTickTime);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f = f * f;
		f = f * f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		matrixStackIn.scale(f2, f3, f2);
	}

	@Override
	public ResourceLocation getTextureLocation(Deeper entity) {
		return MissingTextureAtlasSprite.getLocation();
	}
}