package org.pixeldev.pixelStaff.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.pixeldev.pixelStaff.PixelStaff;
import org.pixeldev.pixelStaff.utils.colorize;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;

        String prefix = colorize.colorize(PixelStaff.getInstance().getConfig().getString("prefix")) + " ";
        if (sender.hasPermission("pixelstaff.reload")) {
            player.sendMessage(prefix + colorize.colorize("&6Reloading..."));
            PixelStaff.getInstance().reloadConfig();
            player.sendMessage(prefix + colorize.colorize("&aReloaded."));
            return true;
        } else {
            player.sendMessage(prefix + colorize.colorize("&cYou require the permission &7pixelstaff.reload &cto do this!"));
        }
        return true;
    }
}
