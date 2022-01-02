package me.alientation.customgui;

import org.bukkit.plugin.java.JavaPlugin;

import me.alientation.customgui.api.CustomGUIManager;
import me.alientation.customgui.api.listeners.InventoryListener;

public class CustomGUIPlugin extends JavaPlugin {
	
	private CustomGUIManager guiManager;
	private InventoryListener inventoryListener;
	
	@Override
	public void onEnable() {
		this.guiManager = new CustomGUIManager(this);
		this.inventoryListener = new InventoryListener(this,this.guiManager);
		getServer().getPluginManager().registerEvents(this.inventoryListener, this);
	}
	
	public CustomGUIManager getGUIManager() {
		return this.guiManager;
	}
	
	public InventoryListener getInventoryListener() {
		return this.inventoryListener;
	}
	
}
