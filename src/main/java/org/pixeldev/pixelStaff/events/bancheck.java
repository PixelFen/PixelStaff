package org.pixeldev.pixelStaff.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.pixeldev.pixelStaff.PixelStaff;
import org.pixeldev.pixelStaff.utils.colorize;

public class bancheck implements Listener {
    private String prefix = PixelStaff.getInstance().getConfig().getString("prefix");

    // Gonna have this to check if a player is banned. For now, just gonna kick a player if they join.
    @EventHandler(priority = EventPriority.HIGH)
    public void onConnect(AsyncPlayerPreLoginEvent event) {
        // check if player is banned

        String exampleUUID = "89616f0e-a9f5-4b4b-9bc6-589d1b1cac6b";
        String exampleReason = "Banned for griefing";
        String banType = "perm";

        if (event.getUniqueId().toString().equals(exampleUUID)){
            if (banType.equalsIgnoreCase("perm")) {
                String formatter = PixelStaff.getInstance().getConfig()
                        .getString("formats.disconnect.userban");

                if (formatter.equals(null) || formatter.equals("")) {
                    formatter = PixelStaff.getInstance().getConfig()
                            .getString("formats.disconnect.universal");
                }

                final String formatted = formatter.replace("{{prefix}}", prefix)
                                .replace("{{reason}}", exampleReason)
                                .replace("{{duration}}", "Permanent")
                                .replace("{{punishment}}", "banned");

                event.disallow(
                        AsyncPlayerPreLoginEvent.Result.KICK_BANNED,
                        new colorize().colorize(formatted)
                );
            }
        }





        // Simulating that they are
        //event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, "Get banned bro");

    }
}
