package org.pixeldev.pixelStaff.commands;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pixeldev.pixelStaff.PixelStaff;
import org.pixeldev.pixelStaff.utils.colorize;

import java.net.ProtocolFamily;

public class getclient implements CommandExecutor {
    final ViaAPI vapi = PixelStaff.getViaAPI();
    MiniMessage mm = MiniMessage.miniMessage();
    LegacyComponentSerializer cereal = LegacyComponentSerializer.legacyAmpersand();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String pre = PixelStaff.getInstance().getConfig().getString("prefix");
        String pref = ChatColor.translateAlternateColorCodes('&', cereal.serialize(mm.deserialize(pre.replace('§', '&'))));
        String client = player.getClientBrandName();

        ViaAPI vapi = PixelStaff.getViaAPI();

        final int playerVersion = vapi.getPlayerVersion(player.getUniqueId());
        final String pv = String.format("%s", ProtocolVersion.getProtocol(playerVersion).getName());


        Component message = mm.deserialize(
                        " <gray>You are currently using the </gray><aqua>"
                        +
                        client
                        +
                        " </aqua><gray>client on version<gray/><aqua> "
                        +
                        pv
                        +
                        "</aqua><gray>.</gray>"
        );

        LegacyComponentSerializer cereal = LegacyComponentSerializer.legacyAmpersand();
        String ncontent = ChatColor.translateAlternateColorCodes('&', cereal.serialize(message).replace('§', '&'));



        player.sendMessage(pref + ncontent);




        return true;
    }
}
