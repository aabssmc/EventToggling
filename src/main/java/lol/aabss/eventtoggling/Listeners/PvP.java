package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvP implements Listener {

    private final EventToggling plugin;
        public PvP(EventToggling plugin) {
            this.plugin = plugin;
        }

    @EventHandler
    public void onPvP(EntityDamageByEntityEvent event) {
        Entity a = event.getDamager();
        Entity v = event.getEntity();
        if (MainCommand.DisabledEvents.contains("pvp")) {
            if (a instanceof Player) {
                if (v instanceof Player) {
                    if (!a.hasPermission("eventtoggling.pvp.bypass")) {
                        event.setCancelled(true);
                        String eventcancelmsg = this.plugin.getConfig().getString("eventcancelmsg");
                        String prefix = this.plugin.getConfig().getString("prefix");
                        if (eventcancelmsg != null) {
                            assert prefix != null;
                            eventcancelmsg = eventcancelmsg.replace("%prefix%", prefix);
                            eventcancelmsg = eventcancelmsg.replace("%event%", "PvP");
                            a.sendMessage(ChatColor.translateAlternateColorCodes('&', eventcancelmsg));
                        }
                    }
                }
            }
        }
    }
}
