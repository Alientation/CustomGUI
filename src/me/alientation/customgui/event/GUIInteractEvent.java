package me.alientation.customgui.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.alientation.customgui.api.CustomGUI;

public class GUIInteractEvent extends Event implements Cancellable {
	
	//create a way to make events using annotations
	
	private static final HandlerList HANDLERS = new HandlerList();
	private boolean isCancelled;
	
	private CustomGUI customGUI;
	private InventoryClickEvent event;
	
	
	public GUIInteractEvent(CustomGUI customGUI, InventoryClickEvent e) {
		this.customGUI = customGUI;
		this.event = e;
	}
	
	public CustomGUI getCustomGUI() {
		return this.customGUI;
	}
	
	public InventoryClickEvent getEvent() {
		return this.event;
	}
	
	
	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
		this.event.setCancelled(isCancelled);
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
}