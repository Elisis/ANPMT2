package com.elisis.anpmt2.block;

import java.util.Objects;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.tile.TileDewar;
import com.elisis.anpmt2.tile.TileDewarTier1;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.items.wrapper.InvWrapper;

public class BlockDewarTier1 extends Block {

	public BlockDewarTier1(Material materialIn) {
		super(materialIn);
		this.setRegistryName(new ResourceLocation(ANPMT2.MODID, "dewar.1"));
		this.setUnlocalizedName("dewar.1");
		this.setCreativeTab(ANPMT2.fluidTab);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileDewarTier1();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack heldItemStack = playerIn.getHeldItemMainhand();
		
		ANPMT2.LOGGER.warn("Activated!");
		
		if (heldItemStack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {
			
			ANPMT2.LOGGER.warn("Capability!");
			
			IFluidHandlerItem item = heldItemStack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
			TileEntity te = worldIn.getTileEntity(pos);
			
			if (te instanceof TileDewar) {
				TileDewarTier1 tdwr = (TileDewarTier1) te;
				FluidStack itemFluid = FluidUtil.getFluidContained(heldItemStack);
				FluidActionResult result = FluidActionResult.FAILURE;
				if (true) {
				
					
					if (!Objects.isNull(itemFluid)) {
						
						if (itemFluid.amount > 0) { // We may deposit into dewar
							
							
							ANPMT2.LOGGER.warn("Filling");
							result = FluidUtil.tryEmptyContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), Integer.MAX_VALUE, playerIn, true);
						
						}
						
					} else { // Item is empty, may get fluid from dewar
						
						
						ANPMT2.LOGGER.warn("Emptying");
						result = FluidUtil.tryFillContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), tdwr.tank.getFluidAmount(), playerIn, true);
						
					}
					/*
					
					if (!Objects.isNull(itemFluid) && itemFluid.isFluidEqual(tdwr.tank.getFluid())) {
					
						if (itemFluid.amount < item.getTankProperties()[0].getCapacity()) {
							ANPMT2.LOGGER.warn("AA4");
							result = FluidUtil.tryEmptyContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), tdwr.tank.getFluidAmount(), playerIn, true);
							
						} else {
							ANPMT2.LOGGER.warn("AA3");
							result = FluidUtil.tryFillContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), tdwr.tank.getFluidAmount(), playerIn, true);
							
						}
					
					} else if (itemFluid.amount == 0) {
						ANPMT2.LOGGER.warn("AA2");
						result = FluidUtil.tryFillContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), tdwr.tank.getFluidAmount(), playerIn, true);
						
						
						
					} else if (Objects.isNull(itemFluid)) {
						
						result = FluidUtil.tryFillContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), tdwr.tank.getFluidAmount(), playerIn, true);
						
					}
					
					else {
						ANPMT2.LOGGER.warn("AA1");
						result = FluidUtil.tryEmptyContainerAndStow(heldItemStack, tdwr.tank, new InvWrapper(playerIn.inventory), Integer.MAX_VALUE, playerIn, true);
						
					}
						*/
						
						
					
				}
				
				if (result.isSuccess()) {
					ANPMT2.LOGGER.warn("SUCCESS");
					te.markDirty();
					playerIn.setHeldItem(hand, result.getResult());
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
