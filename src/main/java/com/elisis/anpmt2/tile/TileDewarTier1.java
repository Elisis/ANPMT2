package com.elisis.anpmt2.tile;

import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidTank;

public class TileDewarTier1 extends TileDewar implements ITickable {
	
	private final int INSULATION = 50;
	
	private FluidTank tank = new FluidTank(100_000);

}
