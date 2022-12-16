package adhdmc.dyablebossbars.utils;

import net.kyori.adventure.bossbar.BossBar;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;

public enum Dyes {
    BLACK_DYE(Material.BLACK_DYE, null, null, null),
    BROWN_DYE(Material.BROWN_DYE, null, null, null),
    CYAN_DYE(Material.CYAN_DYE, null, null, null),
    GRAY_DYE(Material.GRAY_DYE, null, null, null),
    LIGHT_BLUE_DYE(Material.LIGHT_BLUE_DYE, null, null, null),
    LIGHT_GRAY_DYE(Material.LIGHT_GRAY_DYE, null, null, null),
    LIME_DYE(Material.LIME_DYE, null, null, null),
    MAGENTA_DYE(Material.MAGENTA_DYE, null, null, null),
    ORANGE_DYE(Material.ORANGE_DYE, null, null, null),
    BLUE_DYE(Material.BLUE_DYE, BarColor.BLUE, "BLUE", "dyablebossbars.dye.blue"),
    GREEN_DYE(Material.GREEN_DYE, BarColor.GREEN, "GREEN", "dyablebossbars.dye.green"),
    YELLOW_DYE(Material.YELLOW_DYE, BarColor.YELLOW, "YELLOW", "dyablebossbars.dye.yellow"),
    PINK_DYE(Material.PINK_DYE, BarColor.PINK, "PINK", "dyablebossbars.dye.pink"),
    PURPLE_DYE(Material.PURPLE_DYE, BarColor.PURPLE, "PURPLE", "dyablebossbars.dye.purple"),
    RED_DYE(Material.RED_DYE, BarColor.RED, "RED", "dyablebossbars.dye.red"),
    WHITE_DYE(Material.WHITE_DYE, BarColor.WHITE, "WHITE", "dyablebossbars.dye.white");

    private final Material dye;
    private final org.bukkit.boss.BarColor bossbarColor;
    private final String colorToSave;
    private final String permission;


    Dyes(Material dye, BarColor bossbarColor, String colorToSave, String permission) {
        this.dye = dye;
        this.bossbarColor = bossbarColor;
        this.colorToSave = colorToSave;
        this.permission = permission;
    }

    public Material getDye() {
        return dye;
    }

    public BarColor getBossbarColor() {
        return bossbarColor;
    }

    public String getColorToSave() {
        return colorToSave;
    }

    public String getPermission() {
        return permission;
    }
}
