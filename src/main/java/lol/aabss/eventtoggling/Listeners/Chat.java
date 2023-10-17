package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    private final EventToggling plugin;
    public Chat(EventToggling plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        if(MainCommand.DisabledEvents.contains("chat")){
            if (!p.hasPermission("eventtoggling.chat.bypass")){
                event.setCancelled(true);
                String eventcancelmsg = this.plugin.getConfig().getString("eventcancelmsg");
                String prefix = this.plugin.getConfig().getString("prefix");
                if (eventcancelmsg != null) {
                    assert prefix != null;
                    eventcancelmsg = eventcancelmsg.replace("%prefix%", prefix);
                    eventcancelmsg = eventcancelmsg.replace("%event%", "Chat");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventcancelmsg));
                }
            }
        }
    }
}