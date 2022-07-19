package com.elisis.anpmt2;

import org.apache.logging.log4j.Logger;

import com.elisis.anpmt2.enums.Materials;
import com.elisis.anpmt2.item.Items;
import com.elisis.anpmt2.item.QuartzAmpoule;
import com.elisis.anpmt2.loader.RegistrationHandler;
import com.elisis.anpmt2.util.MaterialUtils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ANPMT2.MODID, name = ANPMT2.NAME, version = ANPMT2.VERSION)
public class ANPMT2
{
    public static final String MODID = "anpmt2";
    public static final String NAME = "ANPM";
    public static final String VERSION = "1.0";

    public static Logger LOGGER;
    
    public static final MaterialCreativeTab materialTab = new MaterialCreativeTab();
    public static final FluidCreativeTab fluidTab = new FluidCreativeTab();

    static {
    	FluidRegistry.enableUniversalBucket();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
        
        Materials.init();
        
        Items.init();
        
        RegistrationHandler.registerFluids();
        
        
        
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        LOGGER.warn("Getting object " + MaterialUtils.getItem(Materials.Lithium, "ingot").getRegistryName());
        //ClientEvents.bakeModels();
        
        for (Item item : Item.REGISTRY) {
        	LOGGER.warn("AAITEM " + item.getItemStackDisplayName(new ItemStack(item)));
        } 
        
        for (Block block : Block.REGISTRY) {
        	Item item = Item.getItemFromBlock(block);
        	//LOGGER.warn("AABLOCK " + Item.getItemFromBlock(block).getItemStackDisplayName(new ItemStack));
        	LOGGER.warn("AABLOCK " + item.getItemStackDisplayName(new ItemStack(item)));
        } 
        
        
    }
    
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer && !event.getEntity().world.isRemote) {
        	Minecraft.getMinecraft().player.addItemStackToInventory(QuartzAmpoule.getFilledAmpoules(FluidRegistry.getFluid("gas.hydrogen"), 10, 1));
        }
        
        
    }
}
