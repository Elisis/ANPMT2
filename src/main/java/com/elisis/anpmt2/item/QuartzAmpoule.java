package com.elisis.anpmt2.item;

import java.util.Objects;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.util.ExtendedItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

public class QuartzAmpoule extends ExtendedItem {
	
	private int capacity = 0; //in mB
	private boolean decays = false;
	
	//We take mB to mean mL. I know it's not totally sensical but it's the least annoying interpretation
	
	public QuartzAmpoule(int capacity) {
		super();
		this.capacity = capacity;
		//this.setCreativeTab();
		this.setUnlocalizedName("ampoule" + "." + capacity);
		this.setRegistryName("ampoule" + "." + capacity);
		this.setMaxStackSize(64);
		this.setCreativeTab(ANPMT2.fluidTab);
		this.setTypeName("empty");
		this.setMatName("Quartz Ampoule " + capacity + "mB");
		this.setHumanTypeName("- Empty");
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		
		if (!isInCreativeTab(tab)) {
			return;
		}
		
		subItems.add(getEmptyAmpoule(this.capacity));
		
		for (Fluid fluid : FluidRegistry.getRegisteredFluids().values()) {
			subItems.add(QuartzAmpoule.getFilledAmpoules(fluid, this.capacity, 1).setStackDisplayName("Quartz Ampoule " + this.capacity + "mB - " + fluid.getName())); //Italic for some reason
			
			//subItems.add(QuartzAmpoule.getFilledAmpoules(fluid, this.capacity, 1));
			//ANPMT2.LOGGER.warn("Added subItem ampoule " + fluid.getName());
		}
	}

	public static ItemStack getFilledAmpoules(Fluid fluid, int capacity, int count) {
		Objects.requireNonNull(fluid);
		ItemStack ampoule = new ItemStack(Items.ampoules.get(capacity));
		new FluidHandler(ampoule, capacity).fill(new FluidStack(fluid, capacity), true);
		ampoule.setCount(count);
		return ampoule;
	}

	public static ItemStack getEmptyAmpoule(int capacity) {
		return new ItemStack(Items.ampoules.get(capacity));
	}
	
	public static class FluidHandler extends FluidHandlerItemStack {
		
		public FluidHandler(ItemStack container, int capacity) {
			super(container, capacity);
		}
		
		@Override
		public ItemStack getContainer() {
			return new ItemStack(Items.ampoules.get(this.capacity));
		}
		
	}
	

}
