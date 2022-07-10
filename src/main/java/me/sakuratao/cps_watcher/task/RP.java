package me.sakuratao.cps_watcher.task;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.api.API;
import me.sakuratao.cps_watcher.api.APIProvide;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RP extends BukkitRunnable {

    protected final CPS_Watcher watcher;

    public RP(CPS_Watcher watcher){
        this.watcher = watcher;
    }

    @Override
    public void run() {

        for (PlayerData p : watcher.getPlayerDataManager().getAllData()){

            if (p.getWatcher() == null) continue;
            if (!p.getWatcher().isOnline()) {
                p.setWatcher(null);
                continue;
            }

            PlayerData w = watcher.getPlayerDataManager().getPlayerData(p.getWatcher());

            p.getPlayer().sendMessage(watcher.getMessageManager().getPREFIX() + watcher.getMessageManager().getWATCHING().replace("%player%", w.getPlayer().getName()).replace("%r_cps%", w.getRight_average_cps() + "").replace("%l_cps%", w.getLeft_average_cps() + ""));
            w.setRight_total_cps(0);
            w.setLeft_average_cps(0);
        }

    }
}
