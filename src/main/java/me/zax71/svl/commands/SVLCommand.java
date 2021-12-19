package me.zax71.svl.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.command.CommandSender;
import me.zax71.svl.SVL;

@CommandAlias("svl|simplevotelistener")
public class SVLCommand extends BaseCommand {

    @Subcommand("reload")
    @CommandPermission("SVL.reload")
    @Description("Reloads the configuration file")
    public static void onReload(CommandSender sender, String[] args) {
        SVL.reloadSVL();
    }
}