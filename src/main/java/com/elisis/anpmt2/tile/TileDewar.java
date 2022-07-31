package com.elisis.anpmt2.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;

public abstract class TileDewar extends TileEntity implements ITickable {
	
	public FluidTank tank;
	
	@SuppressWarnings("unused")
	protected static int calculateLoss(Fluid fluid, int insulation) {
		int loss = (fluid.getTemperature() >= 298 ? (Math.abs((10000*((1/fluid.getTemperature()) * 150)/insulation) + 5)) : 0);
		return loss;
	}
	
	

}
