package me.alientation.customgui;

import org.bukkit.plugin.java.JavaPlugin;

import me.alientation.customcommand.api.CustomCommandManager;
import me.alientation.customgui.api.CustomGUIManager;
import me.alientation.customgui.api.listeners.InventoryListener;
import me.alientation.customgui.commands.CustomGUICommand;

public class CustomGUIPlugin extends JavaPlugin {
	
	private CustomCommandManager manager;
	
	private CustomGUIManager guiManager;
	private InventoryListener inventoryListener;
	
	public CustomGUIPlugin() {
		this.manager = new CustomCommandManager(this);
	}
	
	@Override
	public void onEnable() {
		this.guiManager = new CustomGUIManager(this);
		
		
		
		this.manager.loadCommand(new CustomGUICommand(this.guiManager));
		this.manager.registerPlugin(this);
		this.manager.registerCommand();
		
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
