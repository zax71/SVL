package me.zax71.svl.events;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import me.zax71.svl.SVL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class vote implements Listener {

    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {

        // Getting variables
        Vote vote = event.getVote();
        String playerName = vote.getUsername();
        String voteSite = vote.getServiceName();
        // Turn the player name in to a Player type
        Player player = Bukkit.getServer().getPlayer(playerName);

        // Get the command from config
        String command = SVL.plugin.getConfig().getString("command");
        // Phrase it with PAPI
        String papiCommand = PlaceholderAPI.setPlaceholders(player, command);



        // Check if player that voted is online
        if(Bukkit.getPlayer(playerName) != null) {
            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + playerName + " voted on " + voteSite + "!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), papiCommand);
        }
    }
}
