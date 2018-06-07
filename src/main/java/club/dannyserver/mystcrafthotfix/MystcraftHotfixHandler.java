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
            player.dimension = MystcraftHotfixConfig.respawnDimension;
            player.posX = MystcraftHotfixConfig.respawnPosX;
            player.posY = MystcraftHotfixConfig.respawnPosY;
            player.posZ = MystcraftHotfixConfig.respawnPosZ;

            MystcraftHotfix.logger.info(
                    String.format("Set player to (%f, %f, %f) (dim: %d)",
                            player.posX,
                            player.posY,
                            player.posZ,
                            player.dimension
                    )
            );
        }
    }

}
