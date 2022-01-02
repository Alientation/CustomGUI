package me.alientation.customgui.api;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGUIManager {
	
	/*
	 * Stores CustomGUI mappings
	 */
	private Map<String,CustomGUI> GUI_MAP; 
	private Map<Inventory,CustomGUI> INVENTORY_MAP;
	private JavaPlugin plugin;
	
	public CustomGUIManager(JavaPlugin plugin) {
		this.plugin = plugin;
		this.GUI_MAP = new HashMap<>();
		this.INVENTORY_MAP = new HashMap<>();
	}
	
	/*
	 * Loads in a specified GUI from server save file to prevent having to waste resources maintaining inventories
	 */
	public void load() {
		
	}
	
	/*
	 * 
	 */
	public void save() {
		
	}
	
	
	public void addInventory(CustomGUI inventory, String id) {
		this.GUI_MAP.put(id, inventory);
		this.INVENTORY_MAP.put(inventory.getInventory(), inventory);
	}
	
	public JavaPlugin getPlugin() {
		return this.plugin;
	}
	
	public CustomGUI getGUI(String id) {
		return this.GUI_MAP.get(id);
	}
	
	public CustomGUI getGUI(Inventory inv) {
		return this.INVENTORY_MAP.get(inv);
	}
}
