package com.elisis.anpmt2.util;

import java.awt.Color;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Objects;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.enums.Materials;
import com.elisis.anpmt2.enums.SubTags;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class MaterialUtils {

	private static LinkedHashSet<ExtendedItem> ITEMS_TO_REGISTER = new LinkedHashSet<>();
	private static LinkedHashSet<ExtendedBlock> BLOCKS_TO_REGISTER = new LinkedHashSet<>();
	
	private static LinkedHashSet<ExtendedItemBlock> ITEM_BLOCKS_TO_REGISTER = new LinkedHashSet<>();
	
	private static LinkedHashSet<ExtendedFluid> FLUIDS_TO_REGISTER = new LinkedHashSet<>();
	
	private static int ingotCount;
	private static int plateCount;
	private static int dustCount;
	
	public static void generateIngot(Materials mat) {
		ANPMT2.LOGGER.warn("Registering ingot" + mat.getName());
		ExtendedItem itemGenerated = (ExtendedItem) new ExtendedItem().setMatName(mat.getName()).setTypeName("ingot").setHumanTypeName("Ingot").setRegistryName(ANPMT2.MODID, "ingot." + mat.getName().replace(" ", "")).setUnlocalizedName("ingot." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", "")).setCreativeTab(ANPMT2.materialTab);
		//Item itemGenerated = new Item().setRegistryName(ANPMT2.MODID, "ingot." + mat.getName()).setUnlocalizedName("ingot." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);

	}
	
	public static void generatePlate(Materials mat) {
		ExtendedItem itemGenerated = (ExtendedItem) new ExtendedItem().setMatName(mat.getName()).setTypeName("plate").setHumanTypeName("Plate").setRegistryName(ANPMT2.MODID, "plate." + mat.getName().replace(" ", "")).setUnlocalizedName("plate." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", "")).setCreativeTab(ANPMT2.materialTab);
		//Item itemGenerated = new Item().setRegistryName(ANPMT2.MODID, "ingot." + mat.getName()).setUnlocalizedName("ingot." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);
	}
	
	public static void generateDust(Materials mat) {
		
		ExtendedItem itemGenerated = (ExtendedItem) new ExtendedItem().setMatName(mat.getName()).setTypeName("dust").setHumanTypeName("Dust").setRegistryName(ANPMT2.MODID, "dust." + mat.getName().replace(" ", "")).setUnlocalizedName("dust." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", "")).setCreativeTab(ANPMT2.materialTab);
		//Item itemGenerated = new Item().setRegistryName(ANPMT2.MODID, "dust." + mat.getName()).setUnlocalizedName("dust." + mat.getName().toLowerCase()).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);
		
	}
	
	public static void generateFineDust(Materials mat) {
		
		ExtendedItem itemGenerated = (ExtendedItem) new ExtendedItem()
				.setMatName(mat.getName()).setTypeName("powder").setHumanTypeName("Powder")
				.setRegistryName(ANPMT2.MODID, "powder." + mat.getName().replace(" ", ""))
				.setUnlocalizedName("powder." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", ""))
				.setCreativeTab(ANPMT2.materialTab);
		
		ITEMS_TO_REGISTER.add(itemGenerated);
	}
	
	public static void generateWires(Materials mat) {
		/*
		for (int i = 0; i <= 24; i++) {
			
			ExtendedItem itemGenerated = (ExtendedItem) new ExtendedItem()
					.setMatName(mat.getName()).setTypeName("wire" + i).setHumanTypeName(i + "ga Wire")
					.setRegistryName(ANPMT2.MODID, "wire." + i + "." + mat.getName().replace(" ", ""))
					.setUnlocalizedName("wire." + i + "." + mat.getName().toLowerCase().replace(" ", ""))
					.setCreativeTab(ANPMT2.materialTab);
			
			ITEMS_TO_REGISTER.add(itemGenerated);
		}
		*/
		ExtendedItem itemGenerated = (ExtendedItem) new ExtendedItem().setMatName(mat.getName()).setTypeName("finewire").setHumanTypeName("Fine Wire").setRegistryName(ANPMT2.MODID, "finewire." + mat.getName().replace(" ", "")).setUnlocalizedName("finewire." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", "")).setCreativeTab(ANPMT2.materialTab);
		ITEMS_TO_REGISTER.add(itemGenerated);
	}
	
	public static void generateOre(Materials mat) {
		
		ExtendedBlock oreGenerated = (ExtendedBlock) new ExtendedBlock(Material.ROCK).setMatName(mat.getName()).setTypeName("ore").setHumanTypeName("Ore").setRegistryName(ANPMT2.MODID, "ore." + mat.getName().replace(" ", ""))
				.setUnlocalizedName("ore." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", ""));
		ExtendedItemBlock itemBlock = makeItemBlock(oreGenerated);
		
		ITEM_BLOCKS_TO_REGISTER.add(itemBlock);
		BLOCKS_TO_REGISTER.add(oreGenerated);
		
		ANPMT2.LOGGER.warn("Generating ore " + mat.getName() + "\n");
	
	}
	
	public static void generateWireBlock(Materials mat) {
		for (int i = 0; i <= 24; i++) {
			
			ExtendedBlock wireBlockGenerated = (ExtendedBlock) new ExtendedBlock(Material.CARPET).setMatName(mat.getName()).setTypeName("wire" + i).setHumanTypeName(i + "ga Wire")
					.setRegistryName(ANPMT2.MODID, "wire." + i + "." + mat.getName().replace(" ", ""))
					.setUnlocalizedName("wire." + i + "." + mat.getName().toLowerCase(Locale.ROOT).replace(" ", ""))
					.setCreativeTab(ANPMT2.materialTab)
					;
			
			ExtendedItemBlock itemBlock = makeItemBlock(wireBlockGenerated);
			//itemBlock = (ExtendedItemBlock) itemBlock.setMatName(mat.getName()).setTypeName("wire" + i).setHumanTypeName(i + "ga Wire"); //Sets English name
			
			ANPMT2.LOGGER.warn("Adding itemBlock " + itemBlock.getUnlocalizedName(null));
			ANPMT2.LOGGER.warn("adding block " + wireBlockGenerated.getLocalizedName());
			
			ITEM_BLOCKS_TO_REGISTER.add(itemBlock);
			BLOCKS_TO_REGISTER.add(wireBlockGenerated);
			
			
		}
	}
	
	public static ExtendedItemBlock makeItemBlock(ExtendedBlock block) {
		ExtendedItemBlock itemBlock = (ExtendedItemBlock) new ExtendedItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName());
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
		
		ExtendedFluid gasGenerated = (ExtendedFluid) new ExtendedFluid("gas." + mat.getName().replace(" ", ""), new ResourceLocation(ANPMT2.MODID, "gas." + mat.getName() + ".still"), new ResourceLocation(ANPMT2.MODID, "gas." + mat.getName() + ".flow"))
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
	
	
	
	public static ExtendedItem[] getItemsToRegisterArray() {
		if (ITEMS_TO_REGISTER.size() != 0) {
			ExtendedItem[] itemRegisterArray = MaterialUtils.ITEMS_TO_REGISTER.toArray(new ExtendedItem[0]);
			return itemRegisterArray;
		} else {
			ANPMT2.LOGGER.error("Generated items list empty, check definitions!\n");
			return null;
		}
	}
	
	public static ExtendedBlock[] getBlocksToRegisterArray() {
		if (BLOCKS_TO_REGISTER.size() != 0) {
			ExtendedBlock[] blockRegisterArray = MaterialUtils.BLOCKS_TO_REGISTER.toArray(new ExtendedBlock[0]);
			return blockRegisterArray;
		} else {
			ANPMT2.LOGGER.error("Generated blocks list empty, check definitions!\n");
			return null;
		}
	}
	
	public static ExtendedItemBlock[] getItemBlocksToRegisterArray() {
		if (ITEM_BLOCKS_TO_REGISTER.size() != 0) {
			ExtendedItemBlock[] itemBlockRegisterArray = MaterialUtils.ITEM_BLOCKS_TO_REGISTER.toArray(new ExtendedItemBlock[0]);
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
		
		String loc = new ResourceLocation(ANPMT2.MODID, type + "." + mat.getName()).toString();
		
		if (!Objects.isNull(Item.getByNameOrId(loc))) { 
			
			return Item.getByNameOrId(loc); //e.g. anpmt2:dust.aluminium
		
		} else {
			
			ANPMT2.LOGGER.warn("No such type " + type + " for material " + mat.getName());
			return Items.AIR;
		
		}
		 
	}
	
}
