package com.elisis.anpmt2;

import com.elisis.anpmt2.enums.Materials;
import com.elisis.anpmt2.util.MaterialUtils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaterialCreativeTab extends CreativeTabs {

	public MaterialCreativeTab() {
		super(ANPMT2.MODID);
	}
		
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(MaterialUtils.getItem(Materials.Boron, "ingot"));
	}
		
}


