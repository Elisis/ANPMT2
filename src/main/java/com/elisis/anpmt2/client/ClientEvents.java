package com.elisis.anpmt2.client;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.client.render.mesh.GeneralItemMeshDefinition;
import com.elisis.anpmt2.util.ExtendedItem;
import com.elisis.anpmt2.util.ExtendedItemBlock;
import com.elisis.anpmt2.util.MaterialUtils;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value=Side.CLIENT, modid=ANPMT2.MODID)
public class ClientEvents {

	@SubscribeEvent
	public static void bakeModels(ModelRegistryEvent event) {
		for (ExtendedItem item : MaterialUtils.getItemsToRegisterArray()) {
			
			String type = item.getTypeName().replace(" ", "");
			ANPMT2.LOGGER.warn("type type " + type);
			GeneralItemMeshDefinition definition = new GeneralItemMeshDefinition(type);
			ModelLoader.setCustomMeshDefinition(item, definition);
			ANPMT2.LOGGER.warn("Added modellocation " + definition.getModelLocation(null).toString() + " to item " + item.getRegistryName());
			
		}
		
		for (ExtendedItemBlock itemBlock : MaterialUtils.getItemBlocksToRegisterArray()) {
			
			String type = itemBlock.getTypeName().replace(" ", "");
			ANPMT2.LOGGER.warn("type type " + type);
			GeneralItemMeshDefinition definition = new GeneralItemMeshDefinition(type);
			ModelLoader.setCustomMeshDefinition(itemBlock, definition);
			ANPMT2.LOGGER.warn("Added modellocation " + definition.getModelLocation(null).toString() + " to item " + itemBlock.getRegistryName());
			
		}
		
	}
	
}
