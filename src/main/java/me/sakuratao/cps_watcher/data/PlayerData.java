package me.sakuratao.cps_watcher.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter @Setter
public class PlayerData {

    private Player player;

    // 被观察者
    private Player watcher = null;
    private double right_average_cps = 0;
    private double right_total_cps = 0;
    private double left_average_cps = 0;
    private double left_total_cps = 0;

    public PlayerData(Player player){
        this.player = player;
    }

}
