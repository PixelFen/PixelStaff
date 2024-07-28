package org.pixeldev.pixelStaff;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.pixeldev.pixelStaff.commands.getclient;
import org.pixeldev.pixelStaff.commands.reload;
import org.pixeldev.pixelStaff.commands.testban;
import org.pixeldev.pixelStaff.events.bancheck;

public final class PixelStaff extends JavaPlugin {

    private ProtocolManager protocolManager;


    private static PixelStaff instance;
    private static ViaAPI viaAPI;
    private String prefix;

    public static PixelStaff getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        this.prefix = this.getConfig().getString("prefix");


        instance = this;
        this.viaAPI = Via.getAPI();

        // Plugin startup logic
        protocolManager = ProtocolLibrary.getProtocolManager();

        // Checking for bans.
        Bukkit.getPluginManager().registerEvents(new bancheck(), this);
        this.getCommand("clientcheck").setExecutor((new getclient()));
        this.getCommand("testban").setExecutor((new testban()));
        this.getCommand("staffreload").setExecutor((new reload()));

        getLogger().info("A fen and a neko seems like a perfect pair.");
        getLogger().info("Why am I telling you this? idk. they just seem cute together.");

    }

    public static ViaAPI getViaAPI() { return viaAPI; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
