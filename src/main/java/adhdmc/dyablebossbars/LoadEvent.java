package adhdmc.dyablebossbars;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LoadEvent implements Listener {

    @EventHandler
    //TY Billy for the help w/ this <3
    public void onBossLoad(EntityAddToWorldEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Boss)) {
            return;
        }
        Boss boss = (Boss) event.getEntity();
        PersistentDataContainer pdc = boss.getPersistentDataContainer();
        if (!pdc.has(new NamespacedKey(DyableBossBars.plugin, "changed_color"), PersistentDataType.STRING)){
            return;
        }
        String color = pdc.get(new NamespacedKey(DyableBossBars.plugin, "changed_color"), PersistentDataType.STRING);
        boss.getBossBar().setColor(BarColor.valueOf(color));
    }
}
