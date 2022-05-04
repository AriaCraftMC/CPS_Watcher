package me.sakuratao.cps_watcher.task;

import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.api.API;
import me.sakuratao.cps_watcher.api.APIProvide;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TA extends BukkitRunnable {

    protected final CPS_Watcher watcher;

    public TA(final CPS_Watcher watcher){
        this.watcher = watcher;
    }

    @Override
    public void run() {

        for (PlayerData playerData : watcher.getPlayerDataManager().getAllData()){
            if (playerData.getTotal_cps() == 0) continue;

            playerData.setAverage_cps(playerData.getTotal_cps());

            playerData.setTotal_cps(0);
        }
    }

}
