package com.daxton.fancyattributes.listener;


import com.daxton.fancyattributes.FancyAttributes;
import com.daxton.fancyattributes.api.CheckAttribute;
import com.daxton.fancycore.other.entity.BukkitAttributeSet;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)//當玩家登入
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                CheckAttribute.all(player);
            }
        }.runTaskLater(FancyAttributes.fancyAttributes, 5);

    }
    @EventHandler//當玩家登出
    public void onPlayerQuit(PlayerQuitEvent event){

    }




}
