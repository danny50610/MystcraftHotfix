package club.dannyserver.mystcrafthotfix;

public class LogoutPos implements ILogoutPos {

    private int dimension;
    private double posX, posY, posZ;
    private boolean needTeleport;

    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    @Override
    public double getPosZ() {
        return posZ;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public void setPosX(double posX) {
        this.posX = posX;
    }

    @Override
    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    @Override
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean isNeedTeleport() {
        return needTeleport;
    }

    @Override
    public void setNeedTeleport(boolean needTeleport) {
        this.needTeleport = needTeleport;
    }
}
