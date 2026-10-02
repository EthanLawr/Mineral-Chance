package com.serilum.mineralchance.util;

import com.natamus.collective.data.GlobalVariables;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import com.serilum.mineralchance.config.ConfigHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Util {

	// Defined weighted lists: Item -> Weight
	private static final List<Entry<Item, Integer>> OVERWORLD_MINERALS = List.of(
			Map.entry(Items.COPPER_INGOT, ConfigHandler.overworldCopperIngotWeight),  // 10% Chance
			Map.entry(Items.COAL, ConfigHandler.overworldCoalWeight),          // 30% Chance
			Map.entry(Items.IRON_INGOT, ConfigHandler.overworldIronIngotWeight),    // 40% chance
			Map.entry(Items.GOLD_INGOT, ConfigHandler.overworldGoldIngotWeight),    // 25% chance
			Map.entry(Items.REDSTONE_BLOCK, ConfigHandler.overworldRedstoneWeight),       // 15% chance
			Map.entry(Items.LAPIS_LAZULI, ConfigHandler.overworldLapisWeight),   // 10% chance
			Map.entry(Items.EMERALD, ConfigHandler.overworldEmeraldWeight),          // 8% chance
			Map.entry(Items.DIAMOND, ConfigHandler.overworldDiamondWeight)         // 2% chance
	);

	private static final List<Entry<Item, Integer>> NETHER_MINERALS = List.of(
			Map.entry(Items.QUARTZ, ConfigHandler.netherQuartz),          // ~60% chance
			Map.entry(Items.GOLD_INGOT, ConfigHandler.netherGoldIngot),     // ~35% chance
			Map.entry(Items.NETHERITE_SCRAP, ConfigHandler.netherNetherite)   // ~5% chance
	);

	// Calculate total weights once on class load
	private static final int OVERWORLD_TOTAL_WEIGHT = OVERWORLD_MINERALS.stream().mapToInt(Entry::getValue).sum();
	private static final int NETHER_TOTAL_WEIGHT = NETHER_MINERALS.stream().mapToInt(Entry::getValue).sum();

	public static Item getRandomOverworldMineral() {
		return getRandomWeightedItem(OVERWORLD_MINERALS, OVERWORLD_TOTAL_WEIGHT);
	}

	public static Item getRandomNetherMineral() {
		return getRandomWeightedItem(NETHER_MINERALS, NETHER_TOTAL_WEIGHT);
	}

	private static Item getRandomWeightedItem(List<Entry<Item, Integer>> weightedList, int totalWeight) {
		int randomWeight = GlobalVariables.random.nextInt(totalWeight);
		int currentWeight = 0;

		for (Entry<Item, Integer> entry : weightedList) {
			currentWeight += entry.getValue();
			if (randomWeight < currentWeight) {
				return entry.getKey();
			}
		}

		return weightedList.get(0).getKey(); // Fallback
	}
}
