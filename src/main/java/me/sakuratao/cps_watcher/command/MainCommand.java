package me.sakuratao.cps_watcher.command;

import me.sakuratao.cps_watcher.CPS_Watcher;
import me.sakuratao.cps_watcher.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainCommand implements TabExecutor {

    protected final CPS_Watcher watcher;

    public MainCommand(CPS_Watcher watcher){
        this.watcher = watcher;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("cps.command") || !(sender instanceof Player)){
            return true;
        }
        if (args.length == 0){
            sender.sendMessage(watcher.getMessageManager().getPREFIX() + "请使用: /cps Player 监控一个玩家的CPS");
        } else {

            PlayerData playerData =  watcher.getPlayerDataManager().getPlayerData((Player) sender);

            if (args.length == 1){
                // 被观察者
                Player player = Bukkit.getPlayer(args[0]);

                if (!player.isOnline()){
                    sender.sendMessage(watcher.getMessageManager().getPREFIX() + "§c这名玩家不在线");
                }

                if (player == playerData.getWatcher()){
                    playerData.setWatcher(null);
                    sender.sendMessage(watcher.getMessageManager().getPREFIX() + watcher.getMessageManager().getEND_WATCH().replace("%player%", player.getName()));
                    return true;
                }

                playerData.setWatcher(player);
                sender.sendMessage(watcher.getMessageManager().getPREFIX() + watcher.getMessageManager().getSTART_WATCH().replace("%player%", player.getName()));

            }

        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> player = new ArrayList<>();
        getOnlinePlayer().forEach(s -> {
            if (s.toLowerCase(Locale.ROOT).startsWith(args[args.length-1].toLowerCase(Locale.ROOT))){
                player.add(s);
            }
        });
        return player;
    }


    public List<String> getOnlinePlayer(){
        List<String> arrayList = new ArrayList<>();
        Bukkit.getOnlinePlayers().forEach(p -> arrayList.add(p.getName()));
        return arrayList;
    }

}
