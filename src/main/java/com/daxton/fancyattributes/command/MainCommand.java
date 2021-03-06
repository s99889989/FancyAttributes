package com.daxton.fancyattributes.command;

import com.daxton.fancyattributes.FancyAttributes;

import com.daxton.fancyattributes.task.Reload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.daxton.fancyattributes.config.FileConfig.languageConfig;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args){
        if(sender instanceof Player && !sender.isOp()){
            return true;
        }
        //重新讀取設定
        if(args.length == 1) {

            if(args[0].equalsIgnoreCase("reload")){
                //重新讀取的一些程序
                Reload.execute();

                if(sender instanceof Player){
                    Player player = (Player) sender;
                    player.sendMessage(languageConfig.getString("OpMessage.Reload")+"");
                }
                FancyAttributes.fancyAttributes.getLogger().info(languageConfig.getString("LogMessage.Reload"));
            }

        }

        return true;
    }

}
