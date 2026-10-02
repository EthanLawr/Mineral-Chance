package com.serilum.mineralchance.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.mineralchance.util.Reference;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double extraMineralChanceOnOverworldStoneBreak = 0.02;
	@Entry(min = 0, max = 1.0) public static double extraMineralChanceOnNetherStoneBreak = 0.01;
	@Entry public static boolean enableOverworldMinerals = true;
	@Entry public static boolean enableNetherMinerals = true;
	@Entry public static boolean disableMineralDropsWithSilkTouch = true;
	@Entry public static boolean sendMessageOnMineralFind = true;
	@Entry public static String foundMineralMessage = "You've found a mineral hidden in the block!";
	@Entry public static boolean ignoreFakePlayers = true;

	@Entry public static int overworldCopperIngotWeight = 20;
	@Entry public static int overworldCoalWeight = 20;
	@Entry public static int overworldIronIngotWeight = 20;
	@Entry public static int overworldGoldIngotWeight = 10;
	@Entry public static int overworldRedstoneWeight = 10;
	@Entry public static int overworldLapisWeight = 10;
	@Entry public static int overworldEmeraldWeight = 8;
	@Entry public static int overworldDiamondWeight = 2;

	@Entry public static int netherQuartz = 60;
	@Entry public static int netherGoldIngot = 39;
	@Entry public static int netherNetherite = 1;

	public static void initConfig() {
		configMetaData.put("extraMineralChanceOnOverworldStoneBreak", Arrays.asList(
			"The chance a mineral is dropped when an overworld stone block is broken. By default 1/50."
		));
		configMetaData.put("extraMineralChanceOnNetherStoneBreak", Arrays.asList(
			"The chance a mineral is dropped when a nether stone block is broken. By default 1/100."
		));
		configMetaData.put("enableOverworldMinerals", Arrays.asList(
			"If enabled, mining overworld stone blocks in the overworld has a chance to drop an overworld mineral. These consist of diamonds, gold nuggets, iron nuggets, lapis lazuli, redstone and emeralds."
		));
		configMetaData.put("enableNetherMinerals", Arrays.asList(
			"If enabled, mining nether stone blocks in the nether has a chance to drop a nether mineral. These consist of quartz and gold nuggets."
		));
		configMetaData.put("disableMineralDropsWithSilkTouch", Arrays.asList(
			"If enabled, minerals won't drop from stone mined with the silk touch enchantment."
		));
		configMetaData.put("sendMessageOnMineralFind", Arrays.asList(
			"If enabled, sends a message when a mineral is found to the player who broke the stone block."
		));
		configMetaData.put("foundMineralMessage", Arrays.asList(
			"The message sent to the player who found a hidden mineral when 'sendMessageOnMineralFind' is enabled."
		));
		configMetaData.put("overworldCopperIngotWeight", Arrays.asList(
			"The integer chance a copper ingot is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldCoalWeight", Arrays.asList(
				"The integer chance coal is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldIronIngotWeight", Arrays.asList(
				"The integer chance an iron ingot is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldGoldIngotWeight", Arrays.asList(
				"The integer chance a gold ingot is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldRedstoneWeight", Arrays.asList(
				"The integer chance a redstone dust is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldLapisWeight", Arrays.asList(
				"The integer chance a lapis is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldEmeraldWeight", Arrays.asList(
				"The integer chance an emerald is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("overworldDiamondWeight", Arrays.asList(
				"The integer chance a diamond is dropped when an overworld stone block is broken. Weight is added to an overworld total sum based on what you provide."
		));
		configMetaData.put("netherQuartz", Arrays.asList(
				"The integer chance 1 quartz is dropped when nether stone block is broken. Weight is added to an nether total sum based on what you provide."
		));
		configMetaData.put("netherGoldIngot", Arrays.asList(
				"The integer chance 1 gold ingot is dropped when nether stone block is broken. Weight is added to an nether total sum based on what you provide."
		));
		configMetaData.put("netherNetherite", Arrays.asList(
				"The integer chance 1 netherite scrap is dropped when nether stone block is broken. Weight is added to an nether total sum based on what you provide."
		));


		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}
