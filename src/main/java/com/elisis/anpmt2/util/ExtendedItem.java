package com.elisis.anpmt2.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtendedItem extends Item {
	
	private String matName;
	private String typeName;
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) { //This is lazy, need to implement some kind of config that changes display depending on lang
        String capitalMatName = matName.substring(0, 1).toUpperCase() + matName.substring(1);
        String capitalTypeName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
        
        return capitalMatName + " " + capitalTypeName; //e.g. Aluminium Dust
    }
	
	public ExtendedItem setMatName(String matName) {
		this.matName = matName;
		return this;
	}
	
	public ExtendedItem setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}

}
