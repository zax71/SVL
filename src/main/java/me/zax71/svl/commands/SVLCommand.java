package me.zax71.svl.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import me.zax71.svl.SVL;

@CommandAlias("svl|simplevotelistener")
public class SVLCommand extends BaseCommand {

    @Subcommand("reload")
    @CommandPermission("SVL.reload")
    @Description("Reloads the configuration file")
    public static void onReload(CommandSender sender, String[] args) {
        SVL.plugin.reloadConfig();
        sender.sendMessage(SVL.plugin.prefix + ChatColor.GREEN + "Successfully reloaded config.yml");
    }

    @Default
    @HelpCommand
    public static void onHelp(CommandSender sender, String[] args) {
        sender.sendMessage(SVL.plugin.prefix + ChatColor.GREEN + "--- /SVL usage ---");
        sender.sendMessage(SVL.plugin.prefix + ChatColor.GRAY + "/SVL help" + ChatColor.GREEN + " - This page");
        sender.sendMessage(SVL.plugin.prefix + ChatColor.GRAY + "/SVL reload" + ChatColor.GREEN + " - Reload config.yml");
    }
}