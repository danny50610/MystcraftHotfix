package club.dannyserver.mystcrafthotfix;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class LogoutPosStorage implements Capability.IStorage<ILogoutPos> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ILogoutPos> capability, ILogoutPos instance, EnumFacing side) {
        NBTTagCompound tagCompound = new NBTTagCompound();

        tagCompound.setDouble("x", instance.getPosX());
        tagCompound.setDouble("y", instance.getPosY());
        tagCompound.setDouble("z", instance.getPosZ());
        tagCompound.setInteger("dimension", instance.getDimension());
        tagCompound.setBoolean("needTeleport", instance.isNeedTeleport());

        return tagCompound;
    }

    @Override
    public void readNBT(Capability<ILogoutPos> capability, ILogoutPos instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tagCompound = (NBTTagCompound) nbt;

        instance.setPosX(tagCompound.getDouble("x"));
        instance.setPosY(tagCompound.getDouble("y"));
        instance.setPosZ(tagCompound.getDouble("z"));
        instance.setDimension(tagCompound.getInteger("dimension"));
        instance.setNeedTeleport(tagCompound.getBoolean("needTeleport"));
    }
}
