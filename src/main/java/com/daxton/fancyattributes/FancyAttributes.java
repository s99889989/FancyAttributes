package com.daxton.fancyattributes;

import com.daxton.fancyattributes.command.MainCommand;
import com.daxton.fancyattributes.command.TabCommand;
import com.daxton.fancyattributes.listener.PlayerListener;
import com.daxton.fancyattributes.task.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FancyAttributes extends JavaPlugin {

	public static FancyAttributes fancyAttributes;

	@Override
	public void onEnable() {
		fancyAttributes = this;
		//前置插件
		if(!DependPlugins.depend()){
			fancyAttributes.setEnabled(false);
			return;
		}
		//指令
		Objects.requireNonNull(Bukkit.getPluginCommand("fancyattributes")).setExecutor(new MainCommand());
		Objects.requireNonNull(Bukkit.getPluginCommand("fancyattributes")).setTabCompleter(new TabCommand());
		//玩家監聽
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), fancyAttributes);
		//執行任務
		Start.execute();
	}

	@Override
	public void onDisable() {
		FancyAttributes.fancyAttributes.getLogger().info("§4FancyGui uninstall.");
	}
}
