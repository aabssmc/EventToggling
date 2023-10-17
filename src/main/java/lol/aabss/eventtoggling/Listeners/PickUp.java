package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.EventToggling;
import lol.aabss.eventtoggling.MainCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class PickUp implements Listener {


    @EventHandler
    public void onPickUp(EntityPickupItemEvent event) {
        LivingEntity p = event.getEntity();
        if (p instanceof Player){
            if (MainCommand.DisabledEvents.contains("pickup")) {
                if (!p.hasPermission("eventtoggling.pickup.bypass")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}