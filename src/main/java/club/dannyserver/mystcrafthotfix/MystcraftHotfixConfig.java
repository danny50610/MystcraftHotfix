package club.dannyserver.mystcrafthotfix;

import net.minecraftforge.common.config.Config;

@Config(modid = "mystcraft_hotfix", name = "mystcraftHotfix")
public class MystcraftHotfixConfig {
    public static boolean enable = true;

    public static int respawnDimension = 0;

    public static double respawnPosX = 0;

    public static double respawnPosY = 100;

    public static double respawnPosZ = 0;

    public static boolean teleportToOriginalDimension = true;
}
