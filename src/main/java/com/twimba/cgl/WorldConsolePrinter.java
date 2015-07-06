package com.twimba.cgl;

import java.io.PrintStream;

public class WorldConsolePrinter {

	private World world;

	private Character aliveMarker;
	private Character deadCharacter;

	public WorldConsolePrinter(World world, Character aliveMarker, Character deadCharacter) {
		super();
		this.world = world;
		this.aliveMarker = aliveMarker;
		this.deadCharacter = deadCharacter;
	}

	public void print() {
		PrintStream out = System.out;
		int height = world.getHeight();
		int width = world.getWidth();
		out.print("   |");
		for (int y = 0; y < height; y++) {
			out.print(String.format("%3d", y));
		}
		out.println();
		for (int y = 0; y < width; y++) {
			out.print(String.format("%2d | ", y));
			for (int x = 0; x < height; x++) {
				Cell cell = world.getCell(x, y);
				if (cell != null && cell.isAlive()) {
					out.print(" " + aliveMarker + " ");
				} else {
					out.print(" " + deadCharacter + " ");
				}
			}
			out.println();
		}
	}
}
