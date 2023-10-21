package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.Commands.MainCommand;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.block.BlockExplodeEvent;

public class Explosions implements Listener {

    private final EventToggling plugin;
    public Explosions(EventToggling plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityExplosion(EntityExplodeEvent event) {
        if (MainCommand.DisabledEvents.contains("explosions")) {
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockExplosion(BlockExplodeEvent event) {
        if (MainCommand.DisabledEvents.contains("explosions")) {
            event.setCancelled(true);
        }
    }

}