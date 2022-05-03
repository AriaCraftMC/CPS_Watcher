package me.sakuratao.cps_watcher.task;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.Sound;
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

            if (w.getAverage_cps() <= 0) continue;

            p.getPlayer().sendMessage(watcher.getMessageManager().getPREFIX() + watcher.getMessageManager().getWATCHING().replace("%player%", w.getPlayer().getName()).replace("%cps%", w.getAverage_cps() + ""));
            w.setAverage_cps(0);
        }

    }
}
