package me.sakuratao.cps_watcher.listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PacketListener extends PacketAdapter {

    protected final CPS_Watcher watcher;

    public PacketListener(CPS_Watcher watcher, Plugin plugin, PacketType... types) {
        super(plugin, types);
        this.watcher = watcher;
    }

    /*
        发包接受
     */
    @Override
    public void onPacketReceiving(PacketEvent event) {

        if (event.getPacketType() != PacketType.Play.Client.ARM_ANIMATION){
            return;
        }

        PlayerData playerData = watcher.getPlayerDataManager().getPlayerData(event.getPlayer());

        playerData.setTotal_cps(playerData.getTotal_cps() + 1);

    }

}
