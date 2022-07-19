package com.elisis.anpmt2.util;

import java.util.Comparator;

import com.elisis.anpmt2.ANPMT2;

import net.minecraft.item.ItemStack;

public class TabNumberComparator implements Comparator<ItemStack> {
	
	private Comparator<String> natural = Comparator.reverseOrder();
	
	@Override
	public int compare(ItemStack o1, ItemStack o2) {
		//return natural.compare(o1.getDisplayName().replaceAll("[a-zA-Z]", ""), o2.getDisplayName().replaceAll("[a-zA-Z]", ""));
		ANPMT2.LOGGER.warn("o1 " + o1.getDisplayName() + " o2 " + o2.getDisplayName());
		return (Integer.parseInt(o1.getDisplayName().replaceAll("[^\\d]", "")) - Integer.parseInt(o2.getDisplayName().replaceAll("[^\\d]", "")));
		//return natural.compare(o1.getDisplayName(), o2.getDisplayName());
	}

}
