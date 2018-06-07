package club.dannyserver.mystcrafthotfix;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "mystcraft_hotfix",
        name = "MystcraftHotfix",
        dependencies = "required-after:forge@[14.23.3.2702,);",
        acceptableRemoteVersions = "*",
        serverSideOnly = true
)
public class MystcraftHotfix {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new MystcraftHotfixHandler());
    }

}
