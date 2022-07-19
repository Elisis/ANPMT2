package com.elisis.anpmt2.loader;

import java.util.Arrays;
import java.util.Objects;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.item.Items;
import com.elisis.anpmt2.util.ExtendedBlock;
import com.elisis.anpmt2.util.ExtendedFluid;
import com.elisis.anpmt2.util.ExtendedItem;
import com.elisis.anpmt2.util.ExtendedItemBlock;
import com.elisis.anpmt2.util.MaterialUtils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = ANPMT2.MODID)
public class RegistrationHandler {
	
	private static ExtendedItem[] itemRegisterArray = MaterialUtils.getItemsToRegisterArray();
	private static ExtendedBlock[] blockRegisterArray = MaterialUtils.getBlocksToRegisterArray();
	private static ExtendedItemBlock[] itemBlockRegisterArray = MaterialUtils.getItemBlocksToRegisterArray();
	private static ExtendedFluid[] fluidRegisterArray = MaterialUtils.getFluidsToRegisterArray();
	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		
		long startTime = System.currentTimeMillis();
		
		if (!Objects.isNull(itemRegisterArray)) {
			event.getRegistry().registerAll(itemRegisterArray);
		}
		
		if (!Objects.isNull(itemBlockRegisterArray)) {
			ANPMT2.LOGGER.warn("In RegHandler Registering " + Arrays.toString(itemBlockRegisterArray));
			event.getRegistry().registerAll(itemBlockRegisterArray);
		}	
		
		if (!Objects.isNull(Items.ampoules)) {
			event.getRegistry().registerAll((Item[]) Items.ampoules.values().toArray(new Item[0]));
		}
		
		long endTime = System.currentTimeMillis();
		
		long timeTaken = (endTime - startTime);
		
		ANPMT2.LOGGER.warn("[[Registered items into forge!]]");
		ANPMT2.LOGGER.warn("[[Registration took " + timeTaken + "ms]]");
		
	}
	
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		if (!Objects.isNull(blockRegisterArray)) {
			event.getRegistry().registerAll(blockRegisterArray);
		}
		
		//Fluid Blocks, being here ensures that this runs after the fluids have been registered!!!
		for (ExtendedFluid fluid : fluidRegisterArray) {
			if (fluid.getGenerateBlock()) {
				ANPMT2.LOGGER.warn("A1 " + fluid.getName());
				Block fluidBlock = new BlockFluidClassic(fluid, Material.WATER).setRegistryName(ANPMT2.MODID, fluid.getName()); //e.g. gas.hydrogen
				event.getRegistry().register(fluidBlock);
				ANPMT2.LOGGER.warn("Placeable gas: " + fluidBlock.getRegistryName());
				
			}
		}
	}
	
	public static void registerFluids() {
		
		if (!Objects.isNull(fluidRegisterArray)) {
			for (ExtendedFluid fluid : fluidRegisterArray) {
				
				FluidRegistry.registerFluid(fluid);
				FluidRegistry.addBucketForFluid(fluid); //For now, need to forbid this happening for certain fluids
				ANPMT2.LOGGER.warn("Registered gas " + fluid.getName() + "\n");
				
				
			
			
			
			
			}
	
		} else {
			ANPMT2.LOGGER.warn("Fluid registering array is empty, check definitions!\n");
		}
	}

}
