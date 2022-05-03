package me.sakuratao.cps_watcher.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter @Setter
public class PlayerData {

    private Player player;

    // 被观察者
    private Player watcher = null;
    private double average_cps = 0;
    private double total_cps = 0;

    public PlayerData(Player player){
        this.player = player;
    }

}
