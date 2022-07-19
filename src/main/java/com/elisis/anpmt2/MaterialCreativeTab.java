package com.elisis.anpmt2;

import java.util.Arrays;

import com.elisis.anpmt2.enums.Materials;
import com.elisis.anpmt2.util.ExtendedItem;
import com.elisis.anpmt2.util.MaterialUtils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaterialCreativeTab extends CreativeTabs {

	public MaterialCreativeTab() {
		super(ANPMT2.MODID + ".material");
	}
		
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(MaterialUtils.getItem(Materials.Magnesium, "ingot"));
	}
	
	@Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        
		
		
		
		
		super.displayAllRelevantItems(items);
		
		ANPMT2.LOGGER.warn("List length " + items.size());
		for (ItemStack item : items.toArray(new ItemStack[0])) {
			ANPMT2.LOGGER.warn("display " + item.getItem().getUnlocalizedName());
		}
		
		//for (ExtendedItem item : Item.REGISTRY)
        //items.sort(new TabAlphaComparator()/*.thenComparing(new TabNumberComparator())*/); //More hacky shite. Sorts by alpha, then numerically
        //ANPMT2.LOGGER.warn(Arrays.toString(items.toArray()));
    }
		
}


