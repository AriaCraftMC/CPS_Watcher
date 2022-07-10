package me.sakuratao.cps_watcher.api;

import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.entity.Player;

public interface API {

    PlayerData playerData(Player player);

    double right_total_cps(PlayerData playerData);

    double right_average_cps(PlayerData playerData);

    double left_total_cps(PlayerData playerData);

    double left_average_cps(PlayerData playerData);

}
