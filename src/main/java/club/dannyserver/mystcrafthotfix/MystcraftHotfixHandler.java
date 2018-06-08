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
            ILogoutPos logoutPos = player.getCapability(LogoutPosProvider.LOGOUT_POS_CAP, null);
            logoutPos.setDimension(player.dimension);
            logoutPos.setPosX(player.posX);
            logoutPos.setPosY(player.posY);
            logoutPos.setPosZ(player.posZ);
            logoutPos.setNeedTeleport(true);

            MystcraftHotfix.logger.info(String.format("Save player(%s) logout pos. (%f, %f, %f) (dim: %d)", player.getName(),
                    player.posX,
                    player.posY,
                    player.posZ,
                    player.dimension
            ));

            player.dimension = MystcraftHotfixConfig.respawnDimension;
            player.posX = MystcraftHotfixConfig.respawnPosX;
            player.posY = MystcraftHotfixConfig.respawnPosY;
            player.posZ = MystcraftHotfixConfig.respawnPosZ;

            MystcraftHotfix.logger.info(String.format("Set player(%s) to (%f, %f, %f) (dim: %d).",
                    player.getName(),
                    player.posX,
                    player.posY,
                    player.posZ,
                    player.dimension
            ));
        }
    }

    @SubscribeEvent
    public void PlayerLoggedOutEvent(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        ILogoutPos logoutPos = player.getCapability(LogoutPosProvider.LOGOUT_POS_CAP, null);
        if (MystcraftHotfixConfig.teleportToOriginalDimension && logoutPos.isNeedTeleport()) {
            logoutPos.setNeedTeleport(false);
            player.changeDimension(logoutPos.getDimension(), (world, entity, yaw) -> {
                entity.posX = logoutPos.getPosX();
                entity.posY = logoutPos.getPosY();
                entity.posZ = logoutPos.getPosZ();
            });

            MystcraftHotfix.logger.info(String.format("Teleport player(%s) to (%f, %f, %f) (dim: %d).",
                    player.getName(),
                    player.posX,
                    player.posY,
                    player.posZ,
                    player.dimension
            ));
        }
    }
}
