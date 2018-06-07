package club.dannyserver.mystcrafthotfix;

public interface ILogoutPos {

    public double getPosX();
    public double getPosY();
    public double getPosZ();
    public int getDimension();
    public boolean isNeedTeleport();

    public void setPosX(double posX);
    public void setPosY(double posY);
    public void setPosZ(double posZ);
    public void setDimension(int dimension);
    public void setNeedTeleport(boolean needTeleport);

}
