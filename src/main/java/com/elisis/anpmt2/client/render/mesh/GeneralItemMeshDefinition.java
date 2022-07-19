package com.elisis.anpmt2.client.render.mesh;

import com.elisis.anpmt2.ANPMT2;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class GeneralItemMeshDefinition implements ItemMeshDefinition {

	//private String type;
	private ModelResourceLocation generalItemModelLocation;
	
	public GeneralItemMeshDefinition(String type) {
		//this.type = type;
		this.generalItemModelLocation = new ModelResourceLocation(ANPMT2.MODID + ":" + "meta." + type); //e.g. anpmt2:meta.ingot
		//ANPMT2.LOGGER.warn("Added modellocation " + generalItemModelLocation.toString() + " to item");
	}
	
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		//ANPMT2.LOGGER.warn("Added modellocation " + generalItemModelLocation.toString() + " to item " + stack.getItem().getRegistryName());
		return generalItemModelLocation;
	}

}
