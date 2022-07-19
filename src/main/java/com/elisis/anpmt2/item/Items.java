package com.elisis.anpmt2.item;

import java.util.LinkedHashMap;

import com.elisis.anpmt2.ANPMT2;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Items {
	
	public static LinkedHashMap<Integer, QuartzAmpoule> ampoules = new LinkedHashMap<>();
	
	public static void populateAmpoules() {
		for (int i = 1; i <= 5; i++) { //1..5mB
			
			QuartzAmpoule ampoule = new QuartzAmpoule(i);
			ampoules.put(i, ampoule);
			ANPMT2.LOGGER.warn("Added ampoule of capacity " + i + "mB");
			
		}
		
		for (int i = 10; i <= 50; i += 10) { //10..50mB
			QuartzAmpoule ampoule = new QuartzAmpoule(i) {
				@Override
				public String getItemStackDisplayName(ItemStack stack) { //Lazy awful solution
			        return "Quartz Ampoule " + this.getCapacity() + "mB";
			    }
			};
			ampoules.put(i, ampoule);
			ANPMT2.LOGGER.warn("Added ampoule of capacity " + i + "mB");
		}
	}
	
	public static void init() {
		populateAmpoules();
	}

}
