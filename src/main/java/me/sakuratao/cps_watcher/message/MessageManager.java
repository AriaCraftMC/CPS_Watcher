package me.sakuratao.cps_watcher.message;

import lombok.Getter;
import lombok.Setter;
import me.sakuratao.cps_watcher.CPS_Watcher;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@Getter @Setter
public class MessageManager {

    private FileConfiguration message;

    private String PREFIX;
    private String START_WATCH;
    private String WATCHING;
    private String END_WATCH;

    public void init(CPS_Watcher watcher){
        File m = new File(watcher.getDataFolder(), "message.yml");
        if (!m.exists()){
            watcher.saveResource("message.yml", true);
        }

        message = YamlConfiguration.loadConfiguration(m);

        PREFIX = ChatColor.translateAlternateColorCodes('&', message.getString("PREFIX"));
        START_WATCH = ChatColor.translateAlternateColorCodes('&', message.getString("START_WATCH"));
        WATCHING = ChatColor.translateAlternateColorCodes('&', message.getString("WATCHING"));
        END_WATCH = ChatColor.translateAlternateColorCodes('&', message.getString("END_WATCH"));

    }

}
