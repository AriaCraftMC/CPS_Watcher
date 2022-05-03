package me.sakuratao.cps_watcher.task;

import me.sakuratao.cps_watcher.CPS_Watcher;
import org.bukkit.scheduler.BukkitRunnable;

public class TA extends BukkitRunnable {

    protected final CPS_Watcher watcher;

    public TA(final CPS_Watcher watcher){
        this.watcher = watcher;
    }

    @Override
    public void run() {

        watcher.getPlayerDataManager().getAllData().forEach(playerData -> {

            if (playerData.getTotal_cps() == 0) return;

            playerData.setAverage_cps(playerData.getTotal_cps());
            playerData.setTotal_cps(0);

        });

    }

}
