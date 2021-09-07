package com.daxton.fancyattributes.api;

import com.daxton.fancyattributes.FancyAttributes;
import com.daxton.fancyattributes.config.FileConfig;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.LivingEntity;

import java.io.File;
import java.util.List;

public class CheckAttribute {

	public static void all(LivingEntity livingEntity){
		show(livingEntity, "GENERIC_MAX_HEALTH");
		show(livingEntity, "GENERIC_KNOCKBACK_RESISTANCE");
		show(livingEntity, "GENERIC_MOVEMENT_SPEED");
		show(livingEntity, "GENERIC_ATTACK_DAMAGE");
		show(livingEntity, "GENERIC_ATTACK_SPEED");
		show(livingEntity, "GENERIC_ARMOR");
		show(livingEntity, "GENERIC_ARMOR_TOUGHNESS");
		show(livingEntity, "GENERIC_LUCK");
	}
	public static void show(LivingEntity livingEntity, String inherit){
//		File file = new File(FancyAttributes.fancyAttributes.getDataFolder(), "/config.yml");
//		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		FileConfiguration config = FileConfig.config_Map.get("config.yml");
		boolean showDetection = config.getBoolean("DetectionMessage");
		boolean showDelete = config.getBoolean("DeleteMessage");
		List<String> deleteList = config.getStringList("DeleteKeywords");



		AttributeInstance attributeInstance = livingEntity.getAttribute(Enum.valueOf(Attribute.class, inherit));
		if(attributeInstance != null){
			if(attributeInstance.getModifiers().size() > 0){
				if(showDetection){
					FancyAttributes.fancyAttributes.getLogger().info("Detect: "+inherit);
				}
			}

			for(AttributeModifier attributeModifier : attributeInstance.getModifiers()){
				String attrName = attributeModifier.getName();
				double amount = attributeModifier.getAmount();
				String operation =  attributeModifier.getOperation().toString();
				if(showDetection){
					FancyAttributes.fancyAttributes.getLogger().info("§6Label: §4"+attrName+" §3Amount: "+amount+" §2Operation: "+operation);
				}
				for(String key : deleteList){
					//FancyAttributes.fancyAttributes.getLogger().info("§e"+key);
					if(attrName.contains(key)){
						if(showDelete){
							FancyAttributes.fancyAttributes.getLogger().info("§bDelete: §6Label: §4"+attrName+" §aAttributes: §4"+inherit+" §3Amount: "+amount);
						}
						attributeInstance.removeModifier(attributeModifier);
					}
				}

			}
		}

	}


}
