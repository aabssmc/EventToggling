package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Break implements Listener {

    private final EventToggling plugin;
        public Break(EventToggling plugin) {
            this.plugin = plugin;
        }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        if(MainCommand.DisabledEvents.contains("break")){
            if (!p.hasPermission("eventtoggling.break.bypass")){
                event.setCancelled(true);
                String eventcancelmsg = this.plugin.getConfig().getString("eventcancelmsg");
                String prefix = this.plugin.getConfig().getString("prefix");
                if (eventcancelmsg != null) {
                    assert prefix != null;
                    eventcancelmsg = eventcancelmsg.replace("%prefix%", prefix);
                    eventcancelmsg = eventcancelmsg.replace("%event%", "Break");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventcancelmsg));
                }
            }
        }

    }
}
