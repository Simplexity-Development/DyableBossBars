package adhdmc.dyablebossbars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DyableBossBars extends JavaPlugin {
    public static boolean isPaper;
    public static DyableBossBars plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new DyeEvent(), this);
        getServer().getPluginManager().registerEvents(new LoadEvent(), this);
        try {
            Class.forName("com.destroystokyo.paper.VersionHistoryManager$VersionData");
            isPaper = true;
        } catch (ClassNotFoundException e) {
            isPaper = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "This plugin depends on Paper methods and will not work on spigot. Sorry for the inconvenience");
            getServer().getPluginManager().disablePlugin(DyableBossBars.plugin);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
