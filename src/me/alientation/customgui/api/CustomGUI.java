package me.alientation.customgui.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import me.alientation.customgui.api.listeners.GUIListener;

public class CustomGUI {
	
	private final UUID id;
	
	private final Inventory inventory;
	private final String title;
	private final int size;
	private final InventoryType inventoryType;
	
	private final GUIListener guiListener;
	
	private final Map<Integer, ItemSlot> slotsMap = new HashMap<>();
	
	public CustomGUI(String name, InventoryType type, UUID id, GUIListener guiListener) {
		this.id = id;
		this.inventory = Bukkit.createInventory(null, type, name);
		this.title = name;
		this.size = 0;
		this.inventoryType = type;
		this.guiListener = guiListener;
	}
	
	public CustomGUI(String name, int size, UUID id, GUIListener guiListener) {
		this.id = id;
		this.inventory = Bukkit.createInventory(null, size, name);
		this.title = name;
		this.size = size;
		this.inventoryType = InventoryType.CHEST;
		this.guiListener = guiListener;
	}
	
	public void open(Player player) {
		player.openInventory(this.inventory);
	}
	

	public ItemSlot getSlot(int index) {
		return slotsMap.get(index);
	}
	
	public void setSlot(int index, ItemSlot item) {
		this.inventory.setItem(index, item.getItem());
		this.slotsMap.put(index, item);
	}
	
	public UUID getID() { return this.id; }
	public Inventory getInventory() { return this.inventory; }
	public String getName() { return this.title; }
	public int size() { return this.size; }
	public InventoryType type() { return this.inventoryType; }
	public GUIListener getGUIListener() { return this.guiListener; }
}
