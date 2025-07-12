package me.purse.modid;

import me.purse.modid.items.Spear;
import net.fabricmc.api.ModInitializer;
// import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	private static final Item BURGER = new Item(
			new Item
					.Settings()
					.maxCount(16)
					.food(
                            new FoodComponent.Builder()
									.hunger(5)
									.saturationModifier(1.1f)
									.statusEffect(
									new StatusEffectInstance(
											StatusEffects.FIRE_RESISTANCE, 500, 1
									), 0.5f
							).alwaysEdible().build()
					)
	);  // new FabricItemSettings();

	private static final Item BANANA = new Item(
			new Item.Settings().maxCount(4).food(FoodComponents.BREAD)
	);

	public static final Item SPEAR = new Spear(new Item.Settings().maxCount(1));
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.ITEM, new Identifier("modid", "burger"), BURGER);
		Registry.register(Registries.ITEM, new Identifier("modid", "banana"), BANANA);

		Registry.register(Registries.ITEM, new Identifier("modid", "spear"), SPEAR);
	}
}
