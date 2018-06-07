package club.dannyserver.mystcrafthotfix;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class MystcraftHotfixHandler {

    @SubscribeEvent
    public void PlayerLoggedOutEvent(PlayerEvent.PlayerLoggedOutEvent event) {
        EntityPlayer player = event.player;
        DimensionType dimensionType = player.world.provider.getDimensionType();

        if (dimensionType != null && dimensionType.getName().equals("Mystcraft")) {
            player.dimension = 0;
            player.posX = 0;
            player.posY = 100;
            player.posZ = 0;
        }
    }

}
