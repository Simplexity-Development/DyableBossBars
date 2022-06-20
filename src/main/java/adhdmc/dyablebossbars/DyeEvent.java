package adhdmc.dyablebossbars;

import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Boss;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class DyeEvent implements Listener {
    @EventHandler
        public void onBossInteract(PlayerInteractEntityEvent event){
        if (event.getHand().equals(EquipmentSlot.OFF_HAND)){
            return;
        }
        if(event.getPlayer().hasPermission("bossbars.dye"))
            if(!(event.getRightClicked() instanceof Boss)){
                return;
            }
        Player player = event.getPlayer();
        player.sendMessage(event.getRightClicked() + " RIGHT CLICKED");
        Boss bossClicked = (Boss) event.getRightClicked();
        String heldItem = player.getInventory().getItemInMainHand().getType().toString();
        if (!heldItem.contains("_DYE")){
            return;
        }
        int index = heldItem.indexOf("_DYE");
        String bossBarColor = heldItem.substring(0, index);
        try {
            BarColor.valueOf(bossBarColor);
        } catch (IllegalArgumentException e) {
            return;
        }
        bossClicked.getBossBar().setColor(BarColor.valueOf(bossBarColor));
        PersistentDataContainer pdc = bossClicked.getPersistentDataContainer();
        pdc.set(new NamespacedKey(DyableBossBars.plugin, "changed_color"), PersistentDataType.STRING, bossBarColor);
    }
}
