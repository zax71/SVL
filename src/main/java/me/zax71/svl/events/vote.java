package me.zax71.svl.events;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class vote implements VoteListener {

    @EventHandler
    public void voteevent(VotifierEvent event){

        // Getting variables
        Vote v = event.getVote();
        String player = v.getUsername();
        String voteSite = v.getServiceName();

        // Broadcast message saying someone voted
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player + " voted on " + voteSite + "!");
    }
}
