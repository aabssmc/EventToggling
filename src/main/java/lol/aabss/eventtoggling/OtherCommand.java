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
        String noargmsg = this.plugin.getConfig().getString("noargmsg");
        String invalidargmsg = this.plugin.getConfig().getString("invalidargmsg");
        String nopermmsg = this.plugin.getConfig().getString("nopermmsg");
        if (sender.hasPermission("eventtoggling.command")) {
            if (args.length == 0) {
                if (noargmsg != null) {
                    String prefix = this.plugin.getConfig().getString("prefix");
                    if (prefix == null) {
                        noargmsg = noargmsg.replace("%prefix%", "");
                    } else {
                        noargmsg = noargmsg.replace("%prefix%", prefix);
                    }
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', noargmsg));
                }
            } else {
                if (args[0].equals("reload")){
                    this.plugin.saveConfig();
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
            if (nopermmsg != null) {
                if (prefix == null) {
                    nopermmsg = nopermmsg.replace("%prefix%", "");
                } else {
                    nopermmsg = nopermmsg.replace("%prefix%", prefix);
                }
                nopermmsg = nopermmsg.replace("%event%", "Build");
                s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
            }
        }return false;
    }
}

