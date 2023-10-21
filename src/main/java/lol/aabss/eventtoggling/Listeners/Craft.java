package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.Commands.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class Craft implements Listener {

    private final EventToggling plugin;
    public Craft(EventToggling plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrop(CraftItemEvent event) {
        HumanEntity p = event.getWhoClicked();
        if (MainCommand.DisabledEvents.contains("craft")) {
            if (!p.hasPermission("eventtoggling.craft.bypass")) {
                event.setCancelled(true);
                String eventcancelmsg = this.plugin.getConfig().getString("eventcancelmsg");
                String prefix = this.plugin.getConfig().getString("prefix");
                if (eventcancelmsg != null) {
                    assert prefix != null;
                    eventcancelmsg = eventcancelmsg.replace("%prefix%", prefix);
                    eventcancelmsg = eventcancelmsg.replace("%event%", "Craft");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventcancelmsg));
                }
            }
        }
    }
}