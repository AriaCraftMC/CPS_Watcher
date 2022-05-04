package me.sakuratao.cps_watcher.api;

import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.entity.Player;

public interface API {

    PlayerData playerData(Player player);

    double total_cps(PlayerData playerData);

    double average_cps(PlayerData playerData);

}
