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

import java.util.List;

public class vote implements Listener {

    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {

        // Getting variables
        Vote vote = event.getVote();
        String playerName = vote.getUsername();
        String voteSite = vote.getServiceName();
        // Turn the player name in to a Player type
        Player player = Bukkit.getServer().getPlayer(playerName);

        // Get the values from config
        List<?> command = SVL.plugin.getConfig().getList("commands");
        Boolean broadcast = SVL.plugin.getConfig().getBoolean("broadcast");

        // Iterate through the list
        if (command != null) {
            for (int i = 0; i < command.size(); i++) {

                // Get the current working command as a variable
                String currentCommand = String.valueOf(command.get(i));

                // Phrase it with PAPI
                String papiCommand = PlaceholderAPI.setPlaceholders(player, currentCommand);

                // Check if player that voted is online
                if(Bukkit.getPlayer(playerName) != null) {



                    // Send the commands
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), papiCommand);
                }

            }
        } else {
            SVL.plugin.getLogger().severe("No commands are in config.yml, add at least one!");
        }

        // Should we tell the whole server that someone voted?
        if (broadcast.equals(true)) {
            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + playerName + " voted on " + voteSite + "!");
        }






    }
}
