package com.xxx.minesweeper.generator;

public class FrameGenerator extends MapGenerator {

	/** default constructor */
	public FrameGenerator(){
		init();
	}

	/** Initialize the generator */
	@Override
	public void init() {
		line = 0;
		column = 0;
	}

	/** Process the generator */
	@Override
	public String process() {
		String input = sc.nextLine();
		String[] frame = input.split("\\s+");
		// Ignores space between two numbers as well as on both sides
		if (frame.length != 2 && !frame[0].equals("")) {
			sc.close();
			return ("Sorry, please input two numbers.");
		}
		if (frame[0].equals("")) {
			frame[0] = frame[1];
			frame[1] = frame[2];
		}
		// Checks whether input are integers
		try {
			line = Integer.parseInt(frame[0]);
		} catch (NumberFormatException e) {
			sc.close();
			return ("Sorry, please input integers.");
		}
		try {
			column = Integer.parseInt(frame[1]);
		} catch (NumberFormatException e) {
			sc.close();
			return ("Sorry, please input integers.");
		}
		// checks whether numbers are non-negative
		if (line <= 1 || column <= 1) {
			sc.close();
			return ("Sorry, please input integers greater than 2.");
		}
		return null;
	}

	/** Output the product */
	@Override
	public void output() {
		System.out.println("There are " + line + " lines.");
		System.out.println("There are " + column + " columns.");
	}

}
