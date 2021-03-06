package com.nodinchan.ncbukkit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/*     Copyright (C) 2012  Nodin Chan <nodinchan@live.com>
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class PluginCommand extends Command {
	
	private final JavaPlugin plugin;
	private CommandExecutor executor;
	
	protected PluginCommand(String name, JavaPlugin plugin) {
		super(name);
		this.plugin = plugin;
		this.executor = plugin;
	}
	
	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		boolean success = false;
		
		if (!plugin.isEnabled())
			return false;
		
		if (!testPermission(sender))
			return true;
		
		try {
			success = executor.onCommand(sender, this, label, args);
		} catch (Throwable ex) {
			throw new CommandException("Unhandled exception executing command '" + label + "' in plugin " + plugin.getDescription().getFullName(), ex);
		}
		
		if (!success && usageMessage.length() > 0) {
			for (String line : usageMessage.replace("<command>", label).split("\n"))
				sender.sendMessage(line);
		}
		
		return success;
	}
	
	/**
	 * Gets the executor of the command
	 * 
	 * @return The command executor
	 */
	public CommandExecutor getExecutor() {
		return executor;
	}
	
	/**
	 * Gets the plugin that owns the command
	 * 
	 * @return The plugin that owns the command
	 */
	public Plugin getPlugin() {
		return plugin;
	}
	
	/**
	 * Sets executor of the command
	 * 
	 * @param executor The command executor to set to
	 */
	public void setExecutor(CommandExecutor executor) {
		this.executor = executor;
	}
}