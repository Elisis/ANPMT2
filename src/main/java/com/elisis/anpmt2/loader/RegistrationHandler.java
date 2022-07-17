package com.elisis.anpmt2.loader;

import java.util.Objects;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.util.ExtendedFluid;
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
	
	private static Item[] itemRegisterArray = MaterialUtils.getItemsToRegisterArray();
	private static Block[] blockRegisterArray = MaterialUtils.getBlocksToRegisterArray();
	private static Item[] itemBlockRegisterArray = MaterialUtils.getItemBlocksToRegisterArray();
	private static ExtendedFluid[] fluidRegisterArray = MaterialUtils.getFluidsToRegisterArray();
	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		
		if (!Objects.isNull(itemRegisterArray)) {
			event.getRegistry().registerAll(itemRegisterArray);
		}
		
		if (!Objects.isNull(itemBlockRegisterArray)) {
			event.getRegistry().registerAll(itemBlockRegisterArray);
		}	
		
		ANPMT2.LOGGER.warn("Registered materials into forge: " + itemRegisterArray[0].getUnlocalizedName());
		
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
