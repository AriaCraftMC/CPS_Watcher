package me.sakuratao.cps_watcher.utils;

import me.sakuratao.cps_watcher.CPS_Watcher;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class TaskUtil {

    protected static final CPS_Watcher watcher = CPS_Watcher.getWatcher();

    private TaskUtil() {
    }

    public static BukkitTask taskTimer(Runnable runnable, long delay, long interval) {
        return Bukkit.getScheduler().runTaskTimer(watcher, runnable, delay, interval);
    }

    public static BukkitTask taskTimerAsync(Runnable runnable, long delay, long interval) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(watcher, runnable, delay, interval);
    }

    public static BukkitTask task(Runnable runnable) {
        return Bukkit.getScheduler().runTask(watcher, runnable);
    }

    public static BukkitTask taskAsync(Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(watcher, runnable);
    }

    public static BukkitTask taskLater(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLater(watcher, runnable, delay);
    }

    public static BukkitTask taskLaterAsync(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(watcher, runnable, delay);
    }

}
