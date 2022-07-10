package me.sakuratao.cps_watcher.task;

import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.scheduler.BukkitRunnable;

public class AE extends BukkitRunnable {

    protected final CPS_Watcher watcher;

    public AE(final CPS_Watcher watcher){
        this.watcher = watcher;
    }

    @Override
    public void run() {

        for (PlayerData playerData : watcher.getPlayerDataManager().getAllData()){

            playerData.setRight_average_cps(playerData.getRight_total_cps());
            playerData.setRight_total_cps(0);

            playerData.setLeft_average_cps(playerData.getLeft_total_cps());
            playerData.setLeft_total_cps(0);

        }
    }

}
