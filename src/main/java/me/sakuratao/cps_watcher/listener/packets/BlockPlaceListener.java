package me.sakuratao.cps_watcher.listener.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.plugin.Plugin;

public class BlockPlaceListener extends PacketAdapter {

    protected final CPS_Watcher watcher;

    public BlockPlaceListener(CPS_Watcher watcher, Plugin plugin, PacketType types) {
        super(plugin, types);
        this.watcher = watcher;
    }

    /*
        发包接受
     */
    @Override
    public void onPacketReceiving(PacketEvent event) {

        if (event.getPacketType() == PacketType.Play.Client.ARM_ANIMATION){

            PlayerData playerData = watcher.getPlayerDataManager().getPlayerData(event.getPlayer());
            playerData.setRight_total_cps(playerData.getRight_total_cps() + 1);

        }

    }

}
