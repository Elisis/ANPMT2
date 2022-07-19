package com.elisis.anpmt2.util;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class ExtendedBlock extends Block {

	private String matName;
	private String typeName;
	private String humanTypeName;
	
	public ExtendedBlock(Material materialIn) {
		super(materialIn);
		
	}
	
	@Override
	public String getLocalizedName() { //This is lazy, need to implement some kind of config that changes display depending on lang
        
		//ANPMT2.LOGGER.warn(this.getRegistryName());
		//ANPMT2.LOGGER.warn("matName: " + matName);
		//ANPMT2.LOGGER.warn("typeName: " + typeName);
		String capitalMatName = matName.substring(0, 1).toUpperCase(Locale.ROOT) + matName.substring(1);
        //String capitalTypeName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
        
        return capitalMatName + " " + humanTypeName; //e.g. Aluminium 12ga Wire
    
	}
	
	public ExtendedBlock setMatName(String matName) {
		this.matName = matName;
		return this;
	}
	
	public ExtendedBlock setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}
	
	public ExtendedBlock setHumanTypeName(String humanTypeName) {
		this.humanTypeName = humanTypeName;
		return this;
	}
	
	public String getMatName() {
		return this.matName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getHumanName() {
		return this.humanTypeName;
	}

}
