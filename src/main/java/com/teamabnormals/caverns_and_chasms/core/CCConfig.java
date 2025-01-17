package com.teamabnormals.caverns_and_chasms.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

public class CCConfig {

	public static class Common {
		public final BooleanValue creepersDropAllBlocks;
		public final BooleanValue creeperExplosionNerf;
		public final DoubleValue creeperExplosionNerfFactor;

		public final BooleanValue deepersDropAllBlocks;
		public final IntValue deeperMaxSpawnHeight;
		public final IntValue peeperMaxSpawnHeight;

		public final BooleanValue chainmailArmorIncreasesDamage;
		public final BooleanValue goldenArmorIncreasesSpeed;

		public final BooleanValue betterRailPlacement;
		public final IntValue betterRailPlacementRange;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("mobs");
			builder.push("creeper");
			creepersDropAllBlocks = builder.define("Creeper explosions drop all blocks", true);
			creeperExplosionNerf = builder.comment("Creeper explosions have a weaker power").define("Creeper explosion nerf", true);
			creeperExplosionNerfFactor = builder.comment("How much weaker Creeper explosions are").defineInRange("Creeper explosion nerf factor", 0.5D, 0, Double.MAX_VALUE);
			builder.pop();
			builder.push("deeper");
			deepersDropAllBlocks = builder.define("Deeper explosions drop all blocks", true);
			deeperMaxSpawnHeight = builder.defineInRange("Deeper max spawn height", 60, -64, 320);
			builder.pop();
			builder.push("peeper");
			peeperMaxSpawnHeight = builder.defineInRange("Peeper max spawn height", -4, -64, 320);
			builder.pop();
			builder.pop();

			builder.push("tweaks");
			chainmailArmorIncreasesDamage = builder.comment("Chainmail armor increases the user's attack damage").define("Chainmail armor increases damage", true);
			goldenArmorIncreasesSpeed = builder.comment("Golden armor increases the user's movement speed").define("Golden armor increases speed", true);
			builder.push("rails");
			betterRailPlacement = builder.comment("Rails can be placed in the direction you're looking at by clicking on another rail, similar to scaffolding").define("Better rail placement", true);
			betterRailPlacementRange = builder.comment("The range in blocks that better rail placement can reach").defineInRange("Placement range", 7, 0, Integer.MAX_VALUE);
			builder.pop();
			builder.pop();
		}
	}

	public static class Client {
		public final BooleanValue compassesDisplayPosition;
		public final BooleanValue depthGaugesDisplayPosition;
		public final BooleanValue barometersDisplayWeather;

		public final BooleanValue clocksDisplayTime;
		public final BooleanValue clocksDisplayDay;
		public final BooleanValue clocksUse24hrTime;

		public Client(ForgeConfigSpec.Builder builder) {
			builder.push("items");
			builder.push("compass");
			compassesDisplayPosition = builder.comment("Compasses display X and Z coordinates in the item description").define("Compasses display position", true);
			builder.pop();
			builder.push("clock");
			clocksDisplayTime = builder.comment("Clocks display the time of day in the item description").define("Clocks display time", true);
			clocksDisplayDay = builder.comment("Clocks display the what day it is in the item description").define("Clocks display day", true);
			clocksUse24hrTime = builder.comment("Clocks use 24-hour time if displaying the time").define("Clocks use 24-hour time", false);
			builder.pop();
			builder.push("depth_gauge");
			depthGaugesDisplayPosition = builder.comment("Depth Gauges display Y coordinates in the item description").define("Depth Gauges display position", true);
			builder.pop();
			builder.push("barometer");
			barometersDisplayWeather = builder.comment("Barometers display the weather in the item description").define("Barometers display weather", true);
			builder.pop();
			builder.pop();
		}
	}

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	public static final ForgeConfigSpec CLIENT_SPEC;
	public static final Client CLIENT;

	static {
		Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = commonSpecPair.getRight();
		COMMON = commonSpecPair.getLeft();

		Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = clientSpecPair.getRight();
		CLIENT = clientSpecPair.getLeft();
	}
}