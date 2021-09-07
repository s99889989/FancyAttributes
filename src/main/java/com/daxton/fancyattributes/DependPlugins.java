package com.daxton.fancyattributes;

import com.daxton.fancyattributes.config.FileConfig;
import org.bukkit.Bukkit;

import static com.daxton.fancyattributes.config.FileConfig.languageConfig;

public class DependPlugins {

    public static boolean depend(){

        FancyAttributes fancyAttributes = FancyAttributes.fancyAttributes;

        if (Bukkit.getServer().getPluginManager().getPlugin("FancyCore") != null && Bukkit.getPluginManager().isPluginEnabled("FancyCore")){
            //設定檔
            FileConfig.execute();
            fancyAttributes.getLogger().info(languageConfig.getString("LogMessage.LoadFancyCore"));
        }else {
            fancyAttributes.getLogger().severe("*** FancyCore is not installed or not enabled. ***");
            fancyAttributes.getLogger().severe("*** FancyMarket will be disabled. ***");
            return false;
        }

        return true;
    }

}
