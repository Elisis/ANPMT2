package com.elisis.anpmt2.tile;

import static com.elisis.anpmt2.tile.TileDewar.calculateLoss;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class TileDewarTier1 extends TileDewar {
	
	private int tick;
	
	private int insulation;
	public FluidTank tank = new FluidTank(100_000);
	
	public TileDewarTier1() {
		super();
		this.insulation = 50;
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

				int toDrain = calculateLoss(this.tank.getFluid().getFluid(), this.insulation)/5;
				this.tank.drain(toDrain, true);		

			}


		}
	}

}
