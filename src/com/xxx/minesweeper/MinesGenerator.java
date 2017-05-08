package com.xxx.minesweeper;

public class MinesGenerator extends FrameGenerator {

	protected char[][] mine;

	/** Encapsulate field */
	public char[][] getMine() {
		return mine;
	}
	public void setMine(char[][] mine) {
		this.mine = mine;
	}

	/** default constructor */
	public MinesGenerator(){
		init();
	}

	/** Initialize the generator */
	@Override
	public void init() {
		mine = null;
	}

	/** Process the generator */
	@Override
	public String process() {
		mine = new char[line][column];
		int n = 0;
		String input;
		while (n < line) {
			input = sc.nextLine();
			if (input.length() != column) {
				sc.close();
				return ("Sorry, please input " + column + " characters in one line.");
			}
			for (int m = 0; m < column; m++) {
				switch (input.charAt(m)) {
				case '*':
					mine[n][m] = '*';
					break;
				case '.':
					mine[n][m] = '.';
					break;
				default:
					sc.close();
					return ("Sorry, please only input . or *");
				}
			}
			n = n + 1;
		}
		sc.close();
		return null;
	}

	/** Output the product */
	@Override
	public void output() {
		for (int n = 0; n < line; n++) {
			for (int m = 0; m < column; m++) {
				System.out.print(mine[n][m]);
			}
			System.out.println();
		}
	}

}
