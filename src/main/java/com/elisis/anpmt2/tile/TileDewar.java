package com.elisis.anpmt2.tile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public abstract class TileDewar extends TileEntity implements ITickable {
	
	private int tick;
	private final int INSULATION = 0;
	
	private FluidTank tank;
	
	private static int calculateLoss(Fluid fluid, int insulation) {
		int loss = (fluid.getTemperature() >= 298 ? (Math.abs((10000*((1/fluid.getTemperature()) * 150)/insulation) + 5)) : 0);
		return loss;
	}
	
	@SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
            return (T) tank;
        return super.getCapability(capability, facing);
    }
	
	@Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }
	
	@Override
	public void update() {
		
		World world = this.getWorld();
		if (!world.isRemote) {
			
			tick++;
			if (tick >= (400)) { //Every 5 minutes
				
				tick = 0;
				
				int toDrain = calculateLoss(this.tank.getFluid().getFluid(), this.INSULATION)/5;
				this.tank.drain(toDrain, true);		
				
			}
			
			
		}
		
	}

}
