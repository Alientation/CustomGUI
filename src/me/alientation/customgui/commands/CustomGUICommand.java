package me.alientation.customgui.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.alientation.customcommand.annotation.CommandAnnotation;
import me.alientation.customcommand.annotation.CommandDescriptionAnnotation;
import me.alientation.customcommand.annotation.PermissionAnnotation;
import me.alientation.customcommand.api.CustomCommandAPI;
import me.alientation.customgui.api.CustomGUIManager;

public class CustomGUICommand extends CustomCommandAPI{
	
	private CustomGUIManager guiManager;
	
	public CustomGUICommand(CustomGUIManager guiManager) {
		this.guiManager = guiManager;
	}
	
	@CommandAnnotation(commandID = "customgui.show", commandName = "show")
	@CommandDescriptionAnnotation("Shows a test gui")
	@PermissionAnnotation(permission = "customgui", required = true)
	public boolean showGUICommand(CommandSender sender) {
		if (sender instanceof Player) {
			this.guiManager.getGUI("test.gui");
			return true;
		}
		sender.sendMessage("A nonliving entity can not access this command");
		return false;
	}
}
