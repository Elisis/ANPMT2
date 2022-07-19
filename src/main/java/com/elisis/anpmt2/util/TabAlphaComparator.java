package com.elisis.anpmt2.util;

import java.util.Comparator;

import net.minecraft.item.ItemStack;

public class TabAlphaComparator implements Comparator<ItemStack> {

	private Comparator<String> natural = Comparator.naturalOrder();
	
	@Override
	public int compare(ItemStack o1, ItemStack o2) {
		return natural.compare(o1.getDisplayName().replaceAll("\\d", ""), o2.getDisplayName().replaceAll("\\d", ""));
		
		//return natural.compare(o1.getDisplayName(), o2.getDisplayName());
	}
	/*
	private int extractInt(String s) {
		String num = s.replaceAll("\\D", "");
		return num.isEmpty() ? 0 : Integer.parseInt(num);
	}
*/
}
