package adhdmc.dyablebossbars.listeners;

import adhdmc.dyablebossbars.DyableBossBars;
import adhdmc.dyablebossbars.utils.Dyes;
import adhdmc.dyablebossbars.utils.Message;
import com.destroystokyo.paper.MaterialTags;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class InteractEventListener implements Listener {
    MiniMessage miniMessage = MiniMessage.miniMessage();
    public static NamespacedKey bossbarColor = new NamespacedKey(DyableBossBars.plugin, "changed_color");

    @EventHandler(priority = EventPriority.NORMAL,ignoreCancelled = true)
        public void onBossInteract(PlayerInteractEntityEvent event){
        if (event.getHand().equals(EquipmentSlot.OFF_HAND)) {
            return;
        }
        if (!(event.getRightClicked() instanceof Boss)) {
            return;
        }
        Player player = event.getPlayer();
        Boss bossClicked = (Boss) event.getRightClicked();
        Material heldItem = player.getInventory().getItemInMainHand().getType();
        dyeBossBar(player, bossClicked, heldItem);
    }

    private void dyeBossBar(Player player, Boss boss, Material heldItem){
        if (!MaterialTags.DYES.isTagged(heldItem)){
            return;
        }
        if (Dyes.valueOf(heldItem.name()).getBossbarColor() == null) {
            return;
        }
        if (!player.hasPermission(Dyes.valueOf(heldItem.name()).getPermission())) {
            player.sendMessage(miniMessage.deserialize(Message.NO_PERMISSION_COLOR.getMessage(),
                    Placeholder.parsed("colorperm", Dyes.valueOf(heldItem.name()).getColorToSave())));
            return;
        }
        boss.getBossBar().setColor(Dyes.valueOf(heldItem.name()).getBossbarColor());
        PersistentDataContainer bossPDC = boss.getPersistentDataContainer();
        bossPDC.set(bossbarColor, PersistentDataType.STRING, Dyes.valueOf(heldItem.name()).getColorToSave());
    }
}
