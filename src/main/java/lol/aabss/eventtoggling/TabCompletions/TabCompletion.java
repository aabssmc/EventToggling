package lol.aabss.eventtoggling.TabCompletions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            List<String> tabs = new ArrayList<>();
            tabs.add(0, "break");
            tabs.add(1, "build");
            tabs.add(2, "falldamage");
            tabs.add(3, "pvp");
            tabs.add(4, "chat");
            tabs.add(5, "drop");
            tabs.add(6, "pickup");
            tabs.add(7, "tnt");
            tabs.add(8, "explosions");
            tabs.add(9, "craft");
            tabs.add(10, "enchant");
            tabs.add(10, "move");
            return tabs;
        }
        return null;
    }
}
