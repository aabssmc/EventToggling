package lol.aabss.eventtoggling.Listeners;

import lol.aabss.eventtoggling.Commands.MainCommand;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamage implements Listener {

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL){
                if(MainCommand.DisabledEvents.contains("fd")){
                    event.setCancelled(true);
                }
            }
        }
    }
}
