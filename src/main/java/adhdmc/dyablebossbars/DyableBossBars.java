package adhdmc.dyablebossbars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DyableBossBars extends JavaPlugin {
    public static DyableBossBars plugin;

    @Override
    public void onEnable() {
        plugin = this;
        try {
            Class.forName("com.destroystokyo.paper.event.entity.EntityAddToWorldEvent");
        } catch (ClassNotFoundException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "This plugin depends on methods that are not present on your server. Sorry for the inconvenience");
            getServer().getPluginManager().disablePlugin(DyableBossBars.plugin);
            return;
        }
        getServer().getPluginManager().registerEvents(new DyeEvent(), this);
        getServer().getPluginManager().registerEvents(new LoadEvent(), this);
    }
}
