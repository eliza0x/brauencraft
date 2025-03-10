package brauencraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import brauencraft.common.Proxy;

@Mod(
        modid = Brauencraft.MOD_ID,
        name = Brauencraft.MOD_NAME,
        version = Brauencraft.VERSION
)

public class Brauencraft {

    public static final String MOD_ID = "brauencraft";
    public static final String MOD_NAME = "Brauencraft";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Brauencraft INSTANCE;

    @SidedProxy(clientSide = "brauencraft.client.Proxy", serverSide = "brauencraft.server.Proxy")
    public static Proxy proxy;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
           proxy.registerItem(event);
        }

        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
           proxy.registerTileEntitiy(event);
        }
    }
}
