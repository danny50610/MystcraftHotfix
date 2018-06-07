package club.dannyserver.mystcrafthotfix;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LogoutPosProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(ILogoutPos.class)
    public static final Capability<ILogoutPos> LOGOUT_POS_CAP = null;

    private ILogoutPos instance = LOGOUT_POS_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == LOGOUT_POS_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == LOGOUT_POS_CAP ? LOGOUT_POS_CAP.<T>cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return LOGOUT_POS_CAP.getStorage().writeNBT(LOGOUT_POS_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        LOGOUT_POS_CAP.getStorage().readNBT(LOGOUT_POS_CAP, this.instance, null, nbt);
    }
}
