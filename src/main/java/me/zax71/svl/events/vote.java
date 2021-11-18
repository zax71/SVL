package me.zax71.svl.events;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import me.zax71.svl.SVL;
import me.zax71.svl.config.config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class vote implements Listener {

    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {

        // Getting variables
        Vote vote = event.getVote();
        String player = vote.getUsername();
        String voteSite = vote.getServiceName();
        String command = SVL.getConfig("command");

        // Check if player that voted is online
        if(Bukkit.getPlayer(player) != null) {
            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player + " voted on " + voteSite + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }
}
