package com.nodinchan.ncloader;

/**
 * Loadable - Base for loadable classes
 * 
 * @author NodinChan
 *
 */
public class Loadable implements Cloneable {
	
	private final String name;
	
	public Loadable(String name) {
		this.name = name;
	}
	
	/**
	 * Called when the Loadable is loaded by the Loader
	 */
	public void init() {}
	
	/**
	 * Gets the name of the Loadable
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}
}