package adhdmc.dyablebossbars;

import com.destroystokyo.paper.MaterialTags;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Locale;

public class DyeEvent implements Listener {
    MiniMessage mM = MiniMessage.miniMessage();

    @EventHandler(priority = EventPriority.NORMAL,ignoreCancelled = true)
        public void onBossInteract(PlayerInteractEntityEvent event){
        if (event.getHand().equals(EquipmentSlot.OFF_HAND)){
            return;
        }
        if(!(event.getRightClicked() instanceof Boss)){
            return;
        }
        if(!(event.getPlayer().hasPermission("dyablebossbars.use"))){
            return;
        }
        Player player = event.getPlayer();
        Boss bossClicked = (Boss) event.getRightClicked();
        Material heldItem = player.getInventory().getItemInMainHand().getType();
        if (!MaterialTags.DYES.isTagged(heldItem)){
            return;
        }
        MaterialTags.DYES.isTagged(heldItem);
        String materialName = heldItem.toString();
        int index = materialName.indexOf("_DYE");
        String bossBarColor = materialName.substring(0, index);
        try {
            BarColor.valueOf(bossBarColor);
        } catch (IllegalArgumentException e) {
            return;
        }
        if(!player.hasPermission("dyablebossbars.dye."+bossBarColor.toLowerCase(Locale.ENGLISH))) {
            player.sendMessage(mM.deserialize("<red>You do not have permission to dye bossbars " + bossBarColor.toLowerCase(Locale.ENGLISH)));
            return;
        }
        bossClicked.getBossBar().setColor(BarColor.valueOf(bossBarColor));
        PersistentDataContainer pdc = bossClicked.getPersistentDataContainer();
        pdc.set(new NamespacedKey(DyableBossBars.plugin, "changed_color"), PersistentDataType.STRING, bossBarColor);
    }
}
