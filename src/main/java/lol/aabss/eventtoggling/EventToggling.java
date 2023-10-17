package lol.aabss.eventtoggling;

import lol.aabss.eventtoggling.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class EventToggling extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("EventToggling config loading...");
        saveDefaultConfig();
        System.out.print("EventToggling config loaded!");
        System.out.print("EventToggling is now enabled!");

        // Registers command
        getCommand("toggle").setExecutor(new MainCommand(this));
        getCommand("eventtoggling").setExecutor(new OtherCommand(this));
        getCommand("toggle").setTabCompleter(new TabCompletion());
        getCommand("eventtoggling").setTabCompleter(new OtherTabCompletion());

        // Registers all the events
        getServer().getPluginManager().registerEvents(new Build(this), this);
        getServer().getPluginManager().registerEvents(new Break(this), this);
        getServer().getPluginManager().registerEvents(new PvP(this), this);
        getServer().getPluginManager().registerEvents(new FallDamage(), this);
        getServer().getPluginManager().registerEvents(new Chat(this), this);

        int pluginId = 20073;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        System.out.print("EventToggling is now disabled!");
    }
}
