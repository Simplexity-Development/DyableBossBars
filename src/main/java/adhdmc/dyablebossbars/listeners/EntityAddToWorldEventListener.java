package adhdmc.dyablebossbars.listeners;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class EntityAddToWorldEventListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL,ignoreCancelled = true)
    //TY @BillyGalbreath for the help w/ this <3
    public void onBossLoad(EntityAddToWorldEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Boss)) {
            return;
        }
        Boss boss = (Boss) event.getEntity();
        PersistentDataContainer pdc = boss.getPersistentDataContainer();
        if (!pdc.has(InteractEventListener.bossbarColor, PersistentDataType.STRING)){
            return;
        }
        String color = pdc.get(InteractEventListener.bossbarColor, PersistentDataType.STRING);
        boss.getBossBar().setColor(BarColor.valueOf(color));
    }
}
