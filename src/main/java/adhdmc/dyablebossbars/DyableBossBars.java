package adhdmc.dyablebossbars;

import org.bukkit.plugin.java.JavaPlugin;

public final class DyableBossBars extends JavaPlugin {
    public static DyableBossBars plugin;

    @Override
    public void onEnable() {
        plugin = this;
        try {
            Class.forName("com.destroystokyo.paper.event.entity.EntityAddToWorldEvent");
            Class.forName("net.kyori.adventure.text.minimessage.MiniMessage");
            Class.forName("com.destroystokyo.paper.MaterialTags");
        } catch (ClassNotFoundException e) {
            this.getLogger().severe("[DYABLE BOSSBARS] This plugin depends on methods that are not present on your server. Plugin disabling.");
            getServer().getPluginManager().disablePlugin(DyableBossBars.plugin);
            return;
        }
        getServer().getPluginManager().registerEvents(new DyeEvent(), this);
        getServer().getPluginManager().registerEvents(new LoadEvent(), this);
    }
}
