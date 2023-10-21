package lol.aabss.eventtoggling;

import lol.aabss.eventtoggling.Commands.*;
import lol.aabss.eventtoggling.Listeners.*;
import lol.aabss.eventtoggling.TabCompletions.*;
import org.bukkit.plugin.java.JavaPlugin;

public class EventToggling extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("EventToggling config loading...");
        saveDefaultConfig();
        getLogger().info("EventToggling config loaded!");
        getLogger().info("EventToggling is now enabled!");

        // Registers command
        getCommand("toggle").setExecutor(new MainCommand(this));
        getCommand("eventtoggling").setExecutor(new OtherCommand(this));
        getCommand("toggle").setTabCompleter(new TabCompletion());
        getCommand("eventtoggling").setTabCompleter(new OtherTabCompletion());

        // Registers all the events
        getServer().getPluginManager().registerEvents(new Join(this), this);
        getServer().getPluginManager().registerEvents(new Build(this), this);
        getServer().getPluginManager().registerEvents(new Break(this), this);
        getServer().getPluginManager().registerEvents(new PvP(this), this);
        getServer().getPluginManager().registerEvents(new FallDamage(), this);
        getServer().getPluginManager().registerEvents(new Chat(this), this);
        getServer().getPluginManager().registerEvents(new Drop(this), this);
        getServer().getPluginManager().registerEvents(new PickUp(), this);
        getServer().getPluginManager().registerEvents(new TNT(this), this);
        getServer().getPluginManager().registerEvents(new Explosions(this), this);
        getServer().getPluginManager().registerEvents(new Craft(this), this);
        getServer().getPluginManager().registerEvents(new Enchant(this), this);
        getServer().getPluginManager().registerEvents(new Move(this), this);

        // Update checker
        new UpdateChecker(this, 113124).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                getLogger().info("You are on the latest version!.");
            } else {
                String prefix = this.getConfig().getString("prefix");
                getLogger().info("\n" + prefix + " There is a new update available at https://www.spigotmc.org/resources/113124/\n");
            }
        });

        // bStats registration
        int pluginId = 20073;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        getLogger().info("EventToggling is now disabled!");
    }
}
