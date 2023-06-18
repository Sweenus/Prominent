package elocindev.prominent.fabric_quilt;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import elocindev.prominent.fabric_quilt.commands.CommandRegistry;
import elocindev.prominent.fabric_quilt.config.ServerConfig;
import elocindev.prominent.fabric_quilt.config.ServerEntries;
import elocindev.prominent.fabric_quilt.registry.ItemRegistry;
import elocindev.prominent.fabric_quilt.registry.SoundRegistry;

public class ProminentLoader implements ModInitializer {
	public static final String MODID = "prominent";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	
	public static ServerEntries Config = ServerConfig.loadConfig();

	public static final ItemGroup ProminentTab = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemRegistry.ICON))
        .displayName(Text.translatable("itemGroup.prominent.tab"))
		.build();


	@Override
	public void onInitialize() {
		ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, success)
		-> Config = ServerConfig.loadConfig());
		LOGGER.info("Loaded Prominent Config");

		SoundRegistry.registerSounds();
		ItemRegistry.registerItems();	
		Registry.register(Registries.ITEM_GROUP, new Identifier(MODID, "tab"), ProminentTab);	
		CommandRegistry.register();
	}
}
