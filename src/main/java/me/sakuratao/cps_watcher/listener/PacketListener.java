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

        if (event.getPacketType() == PacketType.Play.Client.USE_ENTITY){

            PlayerData playerData = watcher.getPlayerDataManager().getPlayerData(event.getPlayer());
            playerData.setRight_total_cps(playerData.getRight_total_cps() + 1);

        } else if (event.getPacketType() == PacketType.Play.Client.BLOCK_PLACE){

            PlayerData playerData = watcher.getPlayerDataManager().getPlayerData(event.getPlayer());
            playerData.setLeft_average_cps(playerData.getLeft_average_cps() + 1);

        }

    }
}
