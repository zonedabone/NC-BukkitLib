package com.nodinchan.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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

/**
 * CommandInfo - Additional information
 * 
 * @author NodinChan
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {
	
	/**
	 * Gets the description of the Command
	 * 
	 * @return The Command description
	 */
	String description();
	
	/**
	 * Gets the usage of the command
	 * 
	 * @return The Command usage
	 */
	String usage();
}