package com.twimba.cgl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class World {
	private final int width;
	private final int height;

	private final Map<Coordinate, Cell> aliveCells = new HashMap<>();

	public World(int width, int height, List<Coordinate> seedCoordinates) {
		this.width = width;
		this.height = height;

		for (Coordinate coord : seedCoordinates) {
			Cell seedCell = new Cell(coord, this);
			seedCell.makeAlive();
			aliveCells.put(coord, seedCell);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Cell getCell(int x, int y) {
		Coordinate coord = new Coordinate(x, y);
		return getCell(coord);
	}

	public Cell getCell(Coordinate coord) {
		return aliveCells.get(coord);
	}

	public void computeNewStatus() {

		Set<Coordinate> coordinatesToCheck = computeCoordinatesToCheck();

		Map<Coordinate, Cell> newAliveCells = computeNewAliveCells(coordinatesToCheck);

		commitNewWorldStatus(newAliveCells);
	}

	private Map<Coordinate, Cell> computeNewAliveCells(Set<Coordinate> coordinatesToCheck) {
		Map<Coordinate, Cell> newAliveCells = new HashMap<>();
		for (Coordinate coord : coordinatesToCheck) {
			Cell cell = getCell(coord);
			if (cell == null) {
				cell = new Cell(coord, this);
			} else {
				cell = new Cell(cell);
			}
			cell.computeNewStatus();
			if (cell.isAlive()) {
				newAliveCells.put(coord, cell);
			}
		}
		return newAliveCells;
	}

	private Set<Coordinate> computeCoordinatesToCheck() {
		Set<Coordinate> coordinatesToCheck = new HashSet<>();
		for (Coordinate coord : aliveCells.keySet()) {
			int x = coord.getX();
			int y = coord.getY();
			// we need to check all the adjacent cells to any living cell.
			// other cells do not need to be checked
			for (int ox = x - 1; ox <= x + 1; ox++) {
				for (int oy = y - 1; oy <= y + 1; oy++) {
					coordinatesToCheck.add(new Coordinate(ox, oy));
				}
			}
		}
		return coordinatesToCheck;
	}

	public void commitNewWorldStatus(Map<Coordinate, Cell> newAliveCells) {
		aliveCells.clear();
		aliveCells.putAll(newAliveCells);
	}

}
