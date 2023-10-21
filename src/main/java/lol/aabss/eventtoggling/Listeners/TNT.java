package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.Commands.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;

public class TNT implements Listener {

    private final EventToggling plugin;

    public TNT(EventToggling plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTNT(TNTPrimeEvent event) {
        Entity e = event.getPrimingEntity();
        if (MainCommand.DisabledEvents.contains("tnt")) {
            if (!e.hasPermission("eventtoggling.tnt.bypass")) {
                event.setCancelled(true);
                String eventcancelmsg = this.plugin.getConfig().getString("eventcancelmsg");
                String prefix = this.plugin.getConfig().getString("prefix");
                if (eventcancelmsg != null) {
                    assert prefix != null;
                    eventcancelmsg = eventcancelmsg.replace("%prefix%", prefix);
                    eventcancelmsg = eventcancelmsg.replace("%event%", "TNT");
                    if (e instanceof Player){
                        e.sendMessage(ChatColor.translateAlternateColorCodes('&', eventcancelmsg));
                    }
                }
            }
        }
    }
}