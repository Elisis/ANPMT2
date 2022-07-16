package com.elisis.anpmt2;

import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.elisis.anpmt2.enums.Materials;

@Mod(modid = ANPMT2.MODID, name = ANPMT2.NAME, version = ANPMT2.VERSION)
public class ANPMT2
{
    public static final String MODID = "anpmt2";
    public static final String NAME = "ANPM";
    public static final String VERSION = "1.0";

    public static Logger LOGGER;

    static {
    	FluidRegistry.enableUniversalBucket();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
        
        Materials.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
