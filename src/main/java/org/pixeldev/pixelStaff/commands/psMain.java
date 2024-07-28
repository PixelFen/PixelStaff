package org.pixeldev.pixelStaff.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.pixeldev.pixelStaff.PixelStaff;
import org.pixeldev.pixelStaff.utils.colorize;

public class psMain implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String prefixYml = PixelStaff.getInstance().getConfig().getString("prefix");
        String prefix = new colorize().colorize(prefixYml);
        String other = new colorize().colorize("fen");
        commandSender.sendMessage(prefix + other);


        return true;
    }
}
