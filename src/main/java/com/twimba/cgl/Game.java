package com.twimba.cgl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private World world;
	private int tick;

	public Game(int worldWidth, int worldheight, List<Coordinate> seedCoordinates) {
		world = new World(worldWidth, worldheight, seedCoordinates);
		tick = 0;
	}

	public void start() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WorldConsolePrinter printer = new WorldConsolePrinter(world, '#', ' ');
		while (true) {
			System.out.println("-: " + tick);
			printer.print();
			world.computeNewStatus();
			tick++;
			try {
				br.readLine();
			} catch (IOException e) {
				// nop
			}
		}
	}

	public static void main(String[] args) {
		int worldWidth = Integer.parseInt(args[0]);
		int worldheight = Integer.parseInt(args[1]);

		List<Coordinate> seedCoordinates = new ArrayList<>();
		for (String seedCoordinate : Arrays.copyOfRange(args, 2, args.length)) {
			String[] coordinateTokens = seedCoordinate.split(",");
			Coordinate coord = new Coordinate(Integer.parseInt(coordinateTokens[0]), Integer.parseInt(coordinateTokens[1]));
			seedCoordinates.add(coord);
		}
		new Game(worldWidth, worldheight, seedCoordinates).start();
	}

}
