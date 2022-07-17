package com.elisis.anpmt2.util;

import java.awt.Color;
import java.util.LinkedHashSet;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.enums.Materials;
import com.elisis.anpmt2.enums.SubTags;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class MaterialUtils {

	private static LinkedHashSet<Item> ITEMS_TO_REGISTER = new LinkedHashSet<>();
	private static LinkedHashSet<Block> BLOCKS_TO_REGISTER = new LinkedHashSet<>();
	
	private static LinkedHashSet<Item> ITEM_BLOCKS_TO_REGISTER = new LinkedHashSet<>();
	
	private static LinkedHashSet<ExtendedFluid> FLUIDS_TO_REGISTER = new LinkedHashSet<>();
	
	public static void generateIngot(Materials mat) {
		ANPMT2.LOGGER.warn("Registering ingot" + mat.getName());
		Item itemGenerated = new ExtendedItem().setMatName(mat.getName()).setTypeName("ingot").setRegistryName(ANPMT2.MODID, "ingot." + mat.getName().replace(" ", "")).setUnlocalizedName("ingot." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		//Item itemGenerated = new Item().setRegistryName(ANPMT2.MODID, "ingot." + mat.getName()).setUnlocalizedName("ingot." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);

	}
	
	public static void generatePlate(Materials mat) {
		
	}
	
	public static void generateDust(Materials mat) {
		
		Item itemGenerated = new ExtendedItem().setMatName(mat.getName()).setTypeName("dust").setRegistryName(ANPMT2.MODID, "dust." + mat.getName().replace(" ", "")).setUnlocalizedName("dust." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		//Item itemGenerated = new Item().setRegistryName(ANPMT2.MODID, "dust." + mat.getName()).setUnlocalizedName("dust." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);
		
	}
	
	public static void generateFineDust(Materials mat) {
		
		Item itemGenerated = new Item().setRegistryName(ANPMT2.MODID, "fineDust." + mat.getName()).setUnlocalizedName("finedust." + mat.getName().replace(" ", "")).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);
	}
	
	public static void generateOre(Materials mat) {
		
		Block oreGenerated = new Block(Material.ROCK).setRegistryName(ANPMT2.MODID, "ore." + mat.getName())
				.setUnlocalizedName("ore." + mat.getName().toLowerCase());
		Item itemBlock = makeItemBlock(oreGenerated);
		
		ITEM_BLOCKS_TO_REGISTER.add(itemBlock);
		BLOCKS_TO_REGISTER.add(oreGenerated);
		
		ANPMT2.LOGGER.warn("Generating ore " + mat.getName() + "\n");
	
	}
	
	public static Item makeItemBlock(Block block) {
		Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
		return itemBlock;		
	}
	
	
	public static void generateGas(Materials mat) {
		
		int temperature = (!(mat.getSublimationPoint() > 0) ? mat.getBoilingPoint() : mat.getSublimationPoint()) + 20; //Take sublimation point if it exists, boils otherwise
		boolean generateBlock = (mat.contains(SubTags.PLACEABLE) ? true : false);
		
		int density = (mat.getId() > 2 ? 1 : -1); //IDs below 2 flow upwards. Note that this allows for negative IDs
		ANPMT2.LOGGER.warn("Mat ID = " + mat.getId());
		
		int r = mat.getRGBA()[0];
		int g = mat.getRGBA()[1];
		int b = mat.getRGBA()[2];	
		int a = mat.getRGBA()[3];
		
		//Conditions here
		
		ExtendedFluid gasGenerated = (ExtendedFluid) new ExtendedFluid("gas." + mat.getName(), new ResourceLocation(ANPMT2.MODID, "gas." + mat.getName() + ".still"), new ResourceLocation(ANPMT2.MODID, "gas." + mat.getName() + ".flow"))
				.setGenerateBlock(generateBlock).setDensity(density).setGaseous(true).setTemperature(temperature).setColor(new Color(r, g, b, a));
		
		FLUIDS_TO_REGISTER.add(gasGenerated);
		/*
		if (gasGenerated.getGenerateBlock()) {
			Block fluidBlock = new BlockFluidFinite(gasGenerated, Material.WATER).setRegistryName(ANPMT2.MODID, "gas" + mat.getName());
			BLOCKS_TO_REGISTER.add(fluidBlock);
			ANPMT2.LOGGER.warn("Placeable gas: " + fluidBlock.getUnlocalizedName());
		}
		*/
		
	}
	
	
	
	public static Item[] getItemsToRegisterArray() {
		if (ITEMS_TO_REGISTER.size() != 0) {
			Item[] itemRegisterArray = MaterialUtils.ITEMS_TO_REGISTER.toArray(new Item[0]);
			return itemRegisterArray;
		} else {
			ANPMT2.LOGGER.error("Generated items list empty, check definitions!\n");
			return null;
		}
	}
	
	public static Block[] getBlocksToRegisterArray() {
		if (BLOCKS_TO_REGISTER.size() != 0) {
			Block[] blockRegisterArray = MaterialUtils.BLOCKS_TO_REGISTER.toArray(new Block[0]);
			return blockRegisterArray;
		} else {
			ANPMT2.LOGGER.error("Generated blocks list empty, check definitions!\n");
			return null;
		}
	}
	
	public static Item[] getItemBlocksToRegisterArray() {
		if (ITEM_BLOCKS_TO_REGISTER.size() != 0) {
			Item[] itemBlockRegisterArray = MaterialUtils.ITEM_BLOCKS_TO_REGISTER.toArray(new Item[0]);
			return itemBlockRegisterArray;
		} else {
			ANPMT2.LOGGER.error("Generated itemBlock list empty, check definitions!\n");
			return null;
		}
	}
	
	public static ExtendedFluid[] getFluidsToRegisterArray() {
		if (FLUIDS_TO_REGISTER.size() != 0) {
			ExtendedFluid[] FluidRegisterArray = MaterialUtils.FLUIDS_TO_REGISTER.toArray(new ExtendedFluid[0]);
			return FluidRegisterArray;
		} else {
			ANPMT2.LOGGER.error("Generated fluid list empty, check definitions!\n");
			return null;
		}
		
	}
	
	public static Item getItem(Materials mat, String type) {
		return Item.REGISTRY.getObject(new ResourceLocation(ANPMT2.MODID, type + "." + mat.getName())); //e.g. anpmt2:dust.aluminium
	}
	
}
