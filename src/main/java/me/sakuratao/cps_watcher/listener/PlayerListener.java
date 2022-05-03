package me.sakuratao.cps_watcher.listener;

import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    protected final CPS_Watcher watcher;

    public PlayerListener(CPS_Watcher watcher){
        this.watcher = watcher;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        watcher.getPlayerDataManager().create(event.getPlayer());

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){

        watcher.getPlayerDataManager().remove(event.getPlayer());

    }

}
