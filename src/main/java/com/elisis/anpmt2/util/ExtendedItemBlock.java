package com.elisis.anpmt2.util;

import java.util.Locale;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ExtendedItemBlock extends ItemBlock {

	private String matName;
	private String typeName;
	private String humanTypeName;
	
	private ExtendedBlock extendedBlock;
	
	public ExtendedItemBlock(ExtendedBlock block) {
		super(block);
		this.matName = block.getMatName();
		this.typeName = block.getTypeName();
		this.humanTypeName = block.getHumanName();
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) { //This is lazy, need to implement some kind of config that changes display depending on lang
        
		//ANPMT2.LOGGER.warn(this.getRegistryName());
		//ANPMT2.LOGGER.warn("matName: " + matName);
		//ANPMT2.LOGGER.warn("typeName: " + typeName);
		String capitalMatName = matName.substring(0, 1).toUpperCase(Locale.ROOT) + matName.substring(1);
        //String capitalTypeName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
        
        return capitalMatName + " " + humanTypeName; //e.g. Aluminium 12ga Wire
    
	}
	/*
	public ExtendedItemBlock setMatName(String matName) {
		this.matName = this.extendedBlock.getMatName();
		return this;
	}
	
	public ExtendedItemBlock setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}
	
	public ExtendedItemBlock setHumanTypeName(String humanTypeName) {
		this.humanTypeName = humanTypeName;
		return this;
	}
	*/
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getHumanName() {
		return this.humanTypeName;
	}

	

}
