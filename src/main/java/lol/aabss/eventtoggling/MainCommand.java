package lol.aabss.eventtoggling;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;


public class MainCommand implements CommandExecutor {
    // Defines list of disabled events
    public static ArrayList<String> DisabledEvents = new ArrayList<>();

    private final EventToggling plugin;

    public MainCommand(EventToggling plugin) {
        this.plugin = plugin;
    }


    // Defines command /toggle
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandSender s = sender;
        if (sender.hasPermission("eventtoggling.use")) {
            String isdisabled = this.plugin.getConfig().getString("isdisabled");
            String prefix = this.plugin.getConfig().getString("prefix");
            String isenabled = this.plugin.getConfig().getString("isenabled");
            String nopermmsg = this.plugin.getConfig().getString("nopermmsg");
            String noargmsg = this.plugin.getConfig().getString("noargmsg");
            if (args.length == 0) {
                if (noargmsg != null) {
                    if (prefix == null) {
                        noargmsg = noargmsg.replace("%prefix%", "");
                    } else {
                        noargmsg = noargmsg.replace("%prefix%", prefix);
                    }
                    noargmsg = noargmsg.replace("%event%", "Build");
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', noargmsg));
                }
            } else {
                // Build Toggling -------------------
                if (args[0].equals("build") || args[0].equals("place")) {
                    if (sender.hasPermission("eventtoggling.build.use")) {
                        if (DisabledEvents.contains("build")) {
                            DisabledEvents.remove("build");
                            if (isenabled != null) {
                                if (prefix == null) {
                                    isenabled = isenabled.replace("%prefix%", "");
                                } else {
                                    isenabled = isenabled.replace("%prefix%", prefix);
                                }
                                isenabled = isenabled.replace("%event%", "Build");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                            }
                        } else if (!DisabledEvents.contains("build")) {
                            DisabledEvents.add("build");
                            if (isdisabled != null) {
                                if (prefix == null) {
                                    isdisabled = isdisabled.replace("%prefix%", "");
                                } else {
                                    isdisabled = isdisabled.replace("%prefix%", prefix);
                                }
                                isdisabled = isdisabled.replace("%event%", "Build");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                            }
                        }
                    } else {
                        if (nopermmsg != null) {
                            if (prefix == null) {
                                nopermmsg = nopermmsg.replace("%prefix%", "");
                            } else {
                                nopermmsg = nopermmsg.replace("%prefix%", prefix);
                            }
                            nopermmsg = nopermmsg.replace("%event%", "Build");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                        }
                    }
                }

                // Break Toggling -------------------

                else if (args[0].equals("break") || args[0].equals("destroy")) {
                    if (sender.hasPermission("eventtoggling.break.use")) {
                        if (DisabledEvents.contains("break")) {
                            DisabledEvents.remove("break");
                            if (isenabled != null) {
                                if (prefix == null) {
                                    isenabled = isenabled.replace("%prefix%", "");
                                } else {
                                    isenabled = isenabled.replace("%prefix%", prefix);
                                }
                                isenabled = isenabled.replace("%event%", "Break");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                            }
                        } else if (!DisabledEvents.contains("break")) {
                            DisabledEvents.add("break");
                            if (isdisabled != null) {
                                if (prefix == null) {
                                    isdisabled = isdisabled.replace("%prefix%", "");
                                } else {
                                    isdisabled = isdisabled.replace("%prefix%", prefix);
                                }
                                isdisabled = isdisabled.replace("%event%", "Break");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                            }
                        }
                    } else {
                        if (nopermmsg != null) {
                            if (prefix == null) {
                                nopermmsg = nopermmsg.replace("%prefix%", "");
                            } else {
                                nopermmsg = nopermmsg.replace("%prefix%", prefix);
                            }
                            nopermmsg = nopermmsg.replace("%event%", "Break");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                        }
                    }
                }

                // PvP Toggling -------------------

                else if (args[0].equals("pvp")) {
                    if (sender.hasPermission("eventtoggling.pvp.use")) {
                        if (DisabledEvents.contains("pvp")) {
                            DisabledEvents.remove("pvp");
                            if (isenabled != null) {
                                if (prefix == null) {
                                    isenabled = isenabled.replace("%prefix%", "");
                                } else {
                                    isenabled = isenabled.replace("%prefix%", prefix);
                                }
                                isenabled = isenabled.replace("%event%", "PvP");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                            }
                        } else if (!DisabledEvents.contains("pvp")) {
                            DisabledEvents.add("pvp");
                            if (isdisabled != null) {
                                if (prefix == null) {
                                    isdisabled = isdisabled.replace("%prefix%", "");
                                } else {
                                    isdisabled = isdisabled.replace("%prefix%", prefix);
                                }
                                isdisabled = isdisabled.replace("%event%", "PvP");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                            }
                        }
                    } else {
                        if (nopermmsg != null) {
                            if (prefix == null) {
                                nopermmsg = nopermmsg.replace("%prefix%", "");
                            } else {
                                nopermmsg = nopermmsg.replace("%prefix%", prefix);
                            }
                            nopermmsg = nopermmsg.replace("%event%", "PvP");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                        }
                    }
                }

                else if (args[0].equals("falldamage") || args[0].equals("fd")) {
                    if (sender.hasPermission("eventtoggling.falldamage.use")) {
                        if (DisabledEvents.contains("fd")) {
                            DisabledEvents.remove("fd");
                            if (isenabled != null) {
                                if (prefix == null) {
                                    isenabled = isenabled.replace("%prefix%", "");
                                } else {
                                    isenabled = isenabled.replace("%prefix%", prefix);
                                }
                                isenabled = isenabled.replace("%event%", "Fall Damage");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                            }
                        } else if (!DisabledEvents.contains("fd")) {
                            DisabledEvents.add("fd");
                            if (isdisabled != null) {
                                if (prefix == null) {
                                    isdisabled = isdisabled.replace("%prefix%", "");
                                } else {
                                    isdisabled = isdisabled.replace("%prefix%", prefix);
                                }
                                isdisabled = isdisabled.replace("%event%", "Fall Damage");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                            }
                        }
                    } else {
                        if (nopermmsg != null) {
                            if (prefix == null) {
                                nopermmsg = nopermmsg.replace("%prefix%", "");
                            } else {
                                nopermmsg = nopermmsg.replace("%prefix%", prefix);
                            }
                            nopermmsg = nopermmsg.replace("%event%", "Fall Damage");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                        }
                    }
                }

                else if (args[0].equals("chat") || args[0].equals("chat")) {
                    if (sender.hasPermission("eventtoggling.chat.use")) {
                        if (DisabledEvents.contains("chat")) {
                            DisabledEvents.remove("chat");
                            if (isenabled != null) {
                                if (prefix == null) {
                                    isenabled = isenabled.replace("%prefix%", "");
                                } else {
                                    isenabled = isenabled.replace("%prefix%", prefix);
                                }
                                isenabled = isenabled.replace("%event%", "Chat");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                            }
                        } else if (!DisabledEvents.contains("chat")) {
                            DisabledEvents.add("chat");
                            if (isdisabled != null) {
                                if (prefix == null) {
                                    isdisabled = isdisabled.replace("%prefix%", "");
                                } else {
                                    isdisabled = isdisabled.replace("%prefix%", prefix);
                                }
                                isdisabled = isdisabled.replace("%event%", "Chat");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                            }
                        }
                    } else {
                        if (nopermmsg != null) {
                            if (prefix == null) {
                                nopermmsg = nopermmsg.replace("%prefix%", "");
                            } else {
                                nopermmsg = nopermmsg.replace("%prefix%", prefix);
                            }
                            nopermmsg = nopermmsg.replace("%event%", "Chat");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                        }
                    }
                }

                else if (args[0].equals("drop")) {
                    if (sender.hasPermission("eventtoggling.drop.use")) {
                        if (DisabledEvents.contains("drop")) {
                            DisabledEvents.remove("drop");
                            if (isenabled != null) {
                                if (prefix == null) {
                                    isenabled = isenabled.replace("%prefix%", "");
                                } else {
                                    isenabled = isenabled.replace("%prefix%", prefix);
                                }
                                isenabled = isenabled.replace("%event%", "Drop");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                            }
                        } else if (!DisabledEvents.contains("drop")) {
                            DisabledEvents.add("drop");
                            if (isdisabled != null) {
                                if (prefix == null) {
                                    isdisabled = isdisabled.replace("%prefix%", "");
                                } else {
                                    isdisabled = isdisabled.replace("%prefix%", prefix);
                                }
                                isdisabled = isdisabled.replace("%event%", "Drop");
                                s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                            }
                        }
                    } else {
                        if (nopermmsg != null) {
                            if (prefix == null) {
                                nopermmsg = nopermmsg.replace("%prefix%", "");
                            } else {
                                nopermmsg = nopermmsg.replace("%prefix%", prefix);
                            }
                            nopermmsg = nopermmsg.replace("%event%", "Drop");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                        }
                    }
                }
                else if (args[0].equals("pickup")) {
                if (sender.hasPermission("eventtoggling.pickup.use")) {
                    if (DisabledEvents.contains("pickup")) {
                        DisabledEvents.remove("pickup");
                        if (isenabled != null) {
                            if (prefix == null) {
                                isenabled = isenabled.replace("%prefix%", "");
                            } else {
                                isenabled = isenabled.replace("%prefix%", prefix);
                            }
                            isenabled = isenabled.replace("%event%", "Pick Up");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', isenabled));
                        }
                    } else if (!DisabledEvents.contains("pickup")) {
                        DisabledEvents.add("pickup");
                        if (isdisabled != null) {
                            if (prefix == null) {
                                isdisabled = isdisabled.replace("%prefix%", "");
                            } else {
                                isdisabled = isdisabled.replace("%prefix%", prefix);
                            }
                            isdisabled = isdisabled.replace("%event%", "Pick Up");
                            s.sendMessage(ChatColor.translateAlternateColorCodes('&', isdisabled));
                        }
                    }
                } else {
                    if (nopermmsg != null) {
                        if (prefix == null) {
                            nopermmsg = nopermmsg.replace("%prefix%", "");
                        } else {
                            nopermmsg = nopermmsg.replace("%prefix%", prefix);
                        }
                        nopermmsg = nopermmsg.replace("%event%", "Pick Up");
                        s.sendMessage(ChatColor.translateAlternateColorCodes('&', nopermmsg));
                    }
                }
            }
        }


        //No command permission sending

        } else{
            String nocommandpermmsg = this.plugin.getConfig().getString("nocommandpermmsg");
            String prefix = this.plugin.getConfig().getString("prefix");
            if (nocommandpermmsg != null) {
                if (prefix == null){
                    nocommandpermmsg = nocommandpermmsg.replace("%prefix%", "");
                }
                else {
                    nocommandpermmsg = nocommandpermmsg.replace("%prefix%", prefix);
                }
                nocommandpermmsg = nocommandpermmsg.replace("%event%", "command");
                s.sendMessage(ChatColor.translateAlternateColorCodes('&', nocommandpermmsg));
            }
        }
        return true;
    }
}