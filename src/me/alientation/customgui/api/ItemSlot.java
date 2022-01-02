package me.alientation.customgui.api;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.alientation.customgui.api.actions.Action;

public abstract class ItemSlot {
	private ItemStack item;
	private Action action;
	
	public ItemSlot(ItemStack item, Action action) {
		this.item = item;
		this.action = action;
	}
	
	public void onItemClick(CustomGUI gui, InventoryClickEvent e) {
		this.action.doAction(gui, e);
	}
	
	public ItemStack getItem() { return this.item; }
	public Action getAction() { return this.action; }
}
