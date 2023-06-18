package elocindev.prominent.fabric_quilt.registry;

import elocindev.prominent.fabric_quilt.ProminentLoader;
import elocindev.prominent.fabric_quilt.item.MainMenuDisc;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemRegistry {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProminentLoader.MODID);

    
    private static Item.Settings discSettings = new Item.Settings().rarity(Rarity.RARE).maxCount(1);
    public static final Item MAINMENU_DISC = reg(new MainMenuDisc(14, SoundRegistry.CONIFERUS_FOREST, discSettings, 128), "music_disc_coniferus_forest");
    
    
    public static final Item ICON = reg(new Item(new Item.Settings()), "icon");


    public static Item reg(Item instance, String id) {
        
        return Registry.register(Registries.ITEM, new Identifier(ProminentLoader.MODID, id), instance);
    }

    public static void registerItems() {
        LOGGER.info("Registered Prominent Items");
    }
}
