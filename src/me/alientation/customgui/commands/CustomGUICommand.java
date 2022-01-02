package me.alientation.customgui.commands;

import java.util.Collection;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.alientation.customcommand.api.CustomCommand;

public class CustomGUICommand extends CustomCommand{

	public CustomGUICommand(String id, String commandName, Collection<String> permissions) throws Exception {
		super(id, commandName, permissions,null);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		
		return null;
	}

	@Override
	public void invalidCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
	}
	
}
