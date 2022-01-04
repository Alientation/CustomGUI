package me.alientation.customgui.api.listeners;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.event.Event;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.inventory.TradeSelectEvent;


import me.alientation.customgui.annotation.EventHandler;
import me.alientation.customgui.annotation.ParameterFlagAnnotation;
import me.alientation.customgui.api.CustomGUI;
import me.alientation.customgui.exception.InvalidMethodException;
import me.alientation.customgui.exception.UnflaggedParameterException;

public class GUIListener {
	
	//reflection
	
	private Map<Class<?>,List<Method>> methodMap = new HashMap<>();
	private Map<Method,List<ParameterFlagAnnotation>> methodParameters = new HashMap<>();
	
	public GUIListener() {
		registerMethods();
	}
	
	public void registerMethods() {
		for (Method method : this.getClass().getMethods()) {
			if (method.isAnnotationPresent(EventHandler.class)) {
				boolean isEventParamFound = false;
				for (Parameter parameter : method.getParameters()) {
					if (parameter.isAnnotationPresent(ParameterFlagAnnotation.class)) {
						List<ParameterFlagAnnotation> annotations = this.methodParameters.getOrDefault(method, new ArrayList<ParameterFlagAnnotation>());
						annotations.add(parameter.getAnnotation(ParameterFlagAnnotation.class));
						this.methodParameters.put(method,annotations);
					} else if (parameter.getParameterizedType() instanceof Event) {
						if (isEventParamFound)
							throw new InvalidMethodException();
						List<Method> methods = this.methodMap.getOrDefault(parameter.getType(), new ArrayList<Method>());
						methods.add(method);
						this.methodMap.put(parameter.getType(), methods);
					} else {
						throw new UnflaggedParameterException();
					}
				}
			}
		}
	}
	
	public void callMethod(Event e) {
		/*
		 * TODO: Add a parameters builder so that specific parameters can be passed along at the user's discretion
		 */
	}
	
	public Map<Class<?>,List<Method>> getMethodMap() {
		return this.methodMap;
	}
	
	public void onPlayerInventoryClick(CustomGUI gui, InventoryClickEvent e) {
		
	}
	
	public void onGUIClick(CustomGUI gui, InventoryClickEvent e) {
		
	}
	
	public void onOpen(CustomGUI gui, InventoryOpenEvent e) {
		
	}
	
	public void onClose(CustomGUI gui, InventoryCloseEvent e) {
		
	}
	
	public void onBrewComplete(CustomGUI gui, BrewEvent e) {
		
	}
	
	public void onCraftItem(CustomGUI gui, CraftItemEvent e) {
		
	}
	
	public void onFurnaceExtract(CustomGUI gui, FurnaceExtractEvent e) {
		
	}
	
	public void onInventoryDrag(CustomGUI gui, InventoryDragEvent e) {
		
	}
	
	public void onPlayerAction(CustomGUI gui, InventoryEvent e) {
		
	}
	
	public void onInventoryInteract(CustomGUI gui, InventoryInteractEvent e) {
		
	}
	
	public void onInventoryItemExit(CustomGUI gui, InventoryMoveItemEvent e) {
		
	}
	
	public void onInventoryItemEnter(CustomGUI gui, InventoryMoveItemEvent e) {
		
	}
	
	public void onInventoryItemMoveInitated(CustomGUI gui, InventoryMoveItemEvent e) {
		
	}
	
	public void onInventoryPickupItem(CustomGUI gui, InventoryPickupItemEvent e) {
		
	}
	
	public void onAnvilInsert(CustomGUI gui, PrepareAnvilEvent e) {
		
	}
	
	public void onCraftInsert(CustomGUI gui, PrepareItemCraftEvent e) {
		
	}
	
	public void onSmithingInsert(CustomGUI gui, PrepareSmithingEvent e) {
		
	}
	
	public void onSmithItem(CustomGUI gui, SmithItemEvent e) {
		
	}
	
	public void onTradeSelect(CustomGUI gui, TradeSelectEvent e) {
		
	}
	
}
