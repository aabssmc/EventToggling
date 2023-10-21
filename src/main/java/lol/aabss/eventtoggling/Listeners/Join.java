//THIS IS NOT A TOGGLEABLE EVENT
//THIS IS NOT A TOGGLEABLE EVENT
//THIS IS NOT A TOGGLEABLE EVENT
//THIS IS NOT A TOGGLEABLE EVENT
//THIS IS NOT A TOGGLEABLE EVENT

package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.UpdateChecker;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.TimeUnit;

public class Join implements Listener {

    private final EventToggling plugin;

    public Join(EventToggling plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission("eventcore.admin")){
            String prefix = this.plugin.getConfig().getString("prefix");
            new UpdateChecker(plugin, 113124).getVersion(version -> {
                if (!this.plugin.getDescription().getVersion().equals(version)) {
                    TextComponent message = new TextComponent("\n" + prefix + ChatColor.GOLD + " Update " + version + " is out! Download it at" + ChatColor.YELLOW + " " + ChatColor.ITALIC + "https://www.spigotmc.org/resources/113124/\n");
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "spigotmc.org/resources/113124/")));
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/113124/"));
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    p.spigot().sendMessage(message);
                }
            });
        }
    }
}
