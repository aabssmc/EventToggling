package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.Commands.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {

    private final EventToggling plugin;
    public Move(EventToggling plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (MainCommand.DisabledEvents.contains("move")) {
            if (!p.hasPermission("eventtoggling.move.bypass")) {
                event.setCancelled(true);
                String eventcancelmsg = this.plugin.getConfig().getString("eventcancelmsg");
                String prefix = this.plugin.getConfig().getString("prefix");
                if (eventcancelmsg != null) {
                    assert prefix != null;
                    eventcancelmsg = eventcancelmsg.replace("%prefix%", prefix);
                    eventcancelmsg = eventcancelmsg.replace("%event%", "Move");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventcancelmsg));
                }
            }
        }
    }

}
