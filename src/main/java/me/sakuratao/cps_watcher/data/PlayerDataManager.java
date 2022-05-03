package me.sakuratao.cps_watcher.data;

import com.google.common.collect.Maps;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private final Map<UUID, PlayerData> playerDataMap = Maps.newConcurrentMap();

    @Getter
    private static final PlayerDataManager instance = new PlayerDataManager();

    public PlayerData getPlayerData(final Player player) {
        return playerDataMap.get(player.getUniqueId());
    }

    public void create(final Player player) {
        playerDataMap.put(player.getUniqueId(), new PlayerData(player));
    }

    public void remove(final Player player) {
        playerDataMap.remove(player.getUniqueId());
    }

    public Collection<PlayerData> getAllData() {
        return playerDataMap.values();
    }

}
