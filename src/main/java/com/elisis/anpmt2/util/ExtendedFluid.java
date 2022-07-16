package com.elisis.anpmt2.util;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class ExtendedFluid extends Fluid {
	
	private boolean generateBlock = false;

	public ExtendedFluid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
	}
	
	public ExtendedFluid setGenerateBlock(boolean generateBlock) {
		this.generateBlock = generateBlock;
		return this;
	}
	
	public boolean getGenerateBlock() {
		return this.generateBlock;
	}
	
	@Override
	public void vaporize(@Nullable EntityPlayer player, World worldIn, BlockPos pos, FluidStack fluidStack)
    {
        worldIn.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

        for (int l = 0; l < 8; ++l)
        {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }

}
