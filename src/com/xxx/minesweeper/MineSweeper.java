package com.xxx.minesweeper;

public class MineSweeper {

	/** Default constructor */
	public MineSweeper(){}

	/** Starts game */
	public void run() {
		String err;
		// For first input, generate frame
		FrameGenerator fg = new FrameGenerator();
		err = fg.process();
		if (err != null) {
			exception(err);
		}
		// For each subsequent input, generate mines
		MinesGenerator mg = new MinesGenerator();
		mg.setLine(fg.getLine());
		mg.setColumn(fg.getColumn());
		err = mg.process();
		if (err != null) {
			exception(err);
		}
		// Generate hint and if succeed then print
		HintGenerator hg = new HintGenerator();
		hg.setLine(fg.getLine());
		hg.setColumn(fg.getColumn());
		hg.setMine(mg.getMine());
		err = hg.process();
		if (err != null) {
			exception(err);
		}
		hg.output();
	}

	/** Deals with runtime errors */
	public void exception(String err) {
		System.out.println(err);
		System.exit(0);
	}

	public static void main(String[] args) {
		MineSweeper ms = new MineSweeper();
		ms.run();
	}
}

