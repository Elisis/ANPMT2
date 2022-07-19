package com.elisis.anpmt2.util;

import java.util.Locale;

import com.elisis.anpmt2.ANPMT2;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtendedItem extends Item {
	
	private String matName;
	private String typeName;
	private String humanTypeName;
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) { //This is lazy, need to implement some kind of config that changes display depending on lang
        
		//ANPMT2.LOGGER.warn(this.getRegistryName());
		//ANPMT2.LOGGER.warn("matName: " + matName);
		//ANPMT2.LOGGER.warn("typeName: " + typeName);
		String capitalMatName = matName.substring(0, 1).toUpperCase(Locale.ROOT) + matName.substring(1);
        //String capitalTypeName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
        
        return capitalMatName + " " + humanTypeName; //e.g. Aluminium Dust
    }
	
	public ExtendedItem setMatName(String matName) {
		this.matName = matName;
		return this;
	}
	
	public ExtendedItem setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}
	
	public ExtendedItem setHumanTypeName(String humanTypeName) {
		this.humanTypeName = humanTypeName;
		return this;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getHumanName() {
		return this.humanTypeName;
	}

}
