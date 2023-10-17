package lol.aabss.eventtoggling;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OtherCommand implements CommandExecutor {

    private final EventToggling plugin;

    public OtherCommand(EventToggling plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandSender s = sender;
        String nocommandpermmsg = this.plugin.getConfig().getString("nopermmsg");
        if (sender.hasPermission("eventtoggling.command")) {
            if (args.length == 0) {
                String prefix = this.plugin.getConfig().getString("prefix");
                s.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.RED + " /eventtoggling <reload>"));
            } else {
                if (args[0].equals("reload")){
                    this.plugin.reloadConfig();
                    String prefix = this.plugin.getConfig().getString("prefix");
                    System.out.print(prefix + ChatColor.GREEN + "Config reloaded!");
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.GREEN + " Config reloaded!"));
                }
                else{
                    String prefix = this.plugin.getConfig().getString("prefix");
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.RED + " /eventtoggling <reload>"));
                }
            }
        } else{
            String prefix = this.plugin.getConfig().getString("prefix");
            if (nocommandpermmsg != null) {
                if (prefix == null) {
                    nocommandpermmsg = nocommandpermmsg.replace("%prefix%", "");
                } else {
                    nocommandpermmsg = nocommandpermmsg.replace("%prefix%", prefix);
                }
                nocommandpermmsg = nocommandpermmsg.replace("%event%", "Build");
                s.sendMessage(ChatColor.translateAlternateColorCodes('&', nocommandpermmsg));
            }
        }return false;
    }
}

