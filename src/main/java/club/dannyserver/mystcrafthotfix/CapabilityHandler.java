package club.dannyserver.mystcrafthotfix;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation LOGOUT_POS_CAP = new ResourceLocation("mystcraft_hotfix", "logout_pos");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) {
            return;
        }

        event.addCapability(LOGOUT_POS_CAP, new LogoutPosProvider());
    }
}
