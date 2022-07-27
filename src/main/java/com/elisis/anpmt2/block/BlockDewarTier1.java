package com.elisis.anpmt2.block;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.tile.TileDewarTier1;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

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

}
