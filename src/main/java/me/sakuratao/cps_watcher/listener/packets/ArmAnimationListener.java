package me.sakuratao.cps_watcher.listener.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.plugin.Plugin;

public class ArmAnimationListener extends PacketAdapter {

    protected final CPS_Watcher watcher;

    public ArmAnimationListener(CPS_Watcher watcher, Plugin plugin, PacketType types) {
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
            playerData.setLeft_total_cps(playerData.getLeft_total_cps() + 1);

        }

    }
}
