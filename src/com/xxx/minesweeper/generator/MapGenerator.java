package com.xxx.minesweeper.generator;

import java.util.Scanner;

public abstract class MapGenerator {

	protected int line;
	protected int column;
	protected Scanner sc = new Scanner(System.in);

	/** Encapsulate field */
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

	/** Initialize the generator */
	public abstract void init();

	/** Process the generator */
	public abstract String process();

	/** Output the product */
	public abstract void output();

}
