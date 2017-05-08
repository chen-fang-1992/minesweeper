package com.xxx.minesweeper;

public interface MapGenerator {
	/** Initialize the generator */
	public void init();
	/** Process the generator */
	public String process();
	/** Output the product */
	public void output();
}
