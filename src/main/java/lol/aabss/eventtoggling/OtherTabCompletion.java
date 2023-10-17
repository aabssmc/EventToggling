package lol.aabss.eventtoggling;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class OtherTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            List<String> tabs = new ArrayList<>();
            tabs.add(0, "reload");
            return tabs;
        }
        return null;
    }
}
