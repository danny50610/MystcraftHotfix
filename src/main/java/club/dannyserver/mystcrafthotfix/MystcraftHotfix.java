package club.dannyserver.mystcrafthotfix;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "mystcraft_hotfix",
        name = "MystcraftHotfix",
        dependencies = "required-after:forge@[14.23.3.2702,);",
        acceptableRemoteVersions = "*",
        serverSideOnly = true
)
public class MystcraftHotfix {

    static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (MystcraftHotfixConfig.enable) {
            MinecraftForge.EVENT_BUS.register(new MystcraftHotfixHandler());
        }
    }

}
