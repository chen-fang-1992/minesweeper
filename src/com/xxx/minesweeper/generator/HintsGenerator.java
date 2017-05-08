package com.xxx.minesweeper.generator;

public class HintsGenerator extends MapGenerator {

	private char[][] mine;
	private char[][] hint;

	/** Encapsulate field */
	public char[][] getMine() {
		return mine;
	}
	public void setMine(char[][] mine) {
		this.mine = mine;
	}
	public char[][] getHint() {
		return hint;
	}
	public void setHint(char[][] hint) {
		this.hint = hint;
	}

	/** default constructor */
	public HintsGenerator(){
		init();
	}

	/** Initialize the generator */
	@Override
	public void init() {
		mine = null;
		hint = null;
	}

	/** Process the generator */
	@Override
	public String process() {
		hint = new char[line][column];
		for (int n = 0; n < line; n++) {
			for (int m = 0; m < column; m++) {
				if (mine[n][m] == '.') {
					hint[n][m] = mineStatics(n, m);
				} else {
					hint[n][m] = '*';
				}
			}
		}
		return null;
	}

	/** Compute the number of adjacent mines to this square */
	public char mineStatics(int n, int m) {
		char nMine = 0;
		if (n == 0 && m == 0) { // left top
			if (mine[0][1] == '*')
				nMine++;
			if (mine[1][0] == '*')
				nMine++;
			if (mine[1][1] == '*')
				nMine++;
		} else if (n == 0 && m == column-1) { // right top
			if (mine[0][m-1] == '*')
				nMine++;
			if (mine[1][m-1] == '*')
				nMine++;
			if (mine[1][m] == '*')
				nMine++;
		} else if (n == line-1 && m == 0) { // left bottom
			if (mine[n-1][0] == '*')
				nMine++;
			if (mine[n-1][1] == '*')
				nMine++;
			if (mine[n][1] == '*')
				nMine++;
		} else if (n == line-1 && m == column-1) { // right bottom
			if (mine[n-1][m-1] == '*')
				nMine++;
			if (mine[n-1][m] == '*')
				nMine++;
			if (mine[n][m-1] == '*')
				nMine++;
		} else if (n == 0) { // first line
			if (mine[0][m-1] == '*')
				nMine++;
			if (mine[0][m+1] == '*')
				nMine++;
			if (mine[1][m-1] == '*')
				nMine++;
			if (mine[1][m] == '*')
				nMine++;
			if (mine[1][m+1] == '*')
				nMine++;
		} else if (n == line-1) { // last line
			if (mine[n-1][m-1] == '*')
				nMine++;
			if (mine[n-1][m] == '*')
				nMine++;
			if (mine[n-1][m+1] == '*')
				nMine++;
			if (mine[n][m-1] == '*')
				nMine++;
			if (mine[n][m+1] == '*')
				nMine++;
		} else if (m == 0) { // first column
			if (mine[n-1][0] == '*')
				nMine++;
			if (mine[n-1][1] == '*')
				nMine++;
			if (mine[n][1] == '*')
				nMine++;
			if (mine[n+1][0] == '*')
				nMine++;
			if (mine[n+1][1] == '*')
				nMine++;
		} else if (m == column-1) { // last column
			if (mine[n-1][m-1] == '*')
				nMine++;
			if (mine[n-1][m] == '*')
				nMine++;
			if (mine[n][m-1] == '*')
				nMine++;
			if (mine[n+1][m-1] == '*')
				nMine++;
			if (mine[n+1][m] == '*')
				nMine++;
		} else { // inner
			if (mine[n-1][m-1] == '*')
				nMine++;
			if (mine[n-1][m] == '*')
				nMine++;
			if (mine[n-1][m+1] == '*')
				nMine++;
			if (mine[n][m-1] == '*')
				nMine++;
			if (mine[n][m+1] == '*')
				nMine++;
			if (mine[n+1][m-1] == '*')
				nMine++;
			if (mine[n+1][m] == '*')
				nMine++;
			if (mine[n+1][m+1] == '*')
				nMine++;
		}
		return nMine;
	}

	/** Output the product */
	@Override
	public void output() {
		for (int n = 0; n < line; n++) {
			for (int m = 0; m < column; m++) {
				if (hint[n][m] == '*') {
					System.out.print(hint[n][m]);
				} else {
					System.out.print((int)hint[n][m]);
				}
			}
			System.out.println();
		}
	}

}
