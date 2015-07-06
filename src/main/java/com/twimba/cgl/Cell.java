package com.twimba.cgl;

import static com.twimba.cgl.Cell.Status.ALIVE;
import static com.twimba.cgl.Cell.Status.DEAD;

public class Cell {
	enum Status {
		DEAD, ALIVE
	}

	private int x;
	private int y;

	private Status status;

	private World world;

	public Cell(Coordinate coord, World world) {
		this(coord.getX(), coord.getY(), world, DEAD);
	}

	public Cell(int x, int y, World world, Status status) {
		this.x = x;
		this.y = y;
		this.world = world;
		this.status = status;
	}

	public Cell(Cell cell) {
		this(cell.getX(), cell.getY(), cell.getWorld(), cell.getStatus());
	}

	/**
	 * <ul>
	 * <li>Any live cell with fewer than two live neighbours dies, as if caused
	 * by under-population.</li>
	 * <li>Any live cell with two or three live neighbours lives on to the next
	 * generation.</li>
	 * <li>Any live cell with more than three live neighbours dies, as if by
	 * overcrowding.</li>
	 * <li>Any dead cell with exactly three live neighbours becomes a live cell,
	 * as if by reproduction.</li>
	 * </ul>
	 */
	public void computeNewStatus() {
		Status newStatus = DEAD;
		int aliveNeighbours = countAliveNeighbours();
		switch (aliveNeighbours) {
		case 0:
		case 1:
			newStatus = DEAD;
			break;
		case 2:
			if (status == ALIVE) {
				newStatus = ALIVE;
			}
			break;
		case 3:
			newStatus = ALIVE;
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			newStatus = DEAD;
			break;
		default:
			throw new RuntimeException("A cell can never have more than 8 neighbours...");
		}
		status = newStatus;

	}

	private int countAliveNeighbours() {
		int aliveNeighbours = 0;
		aliveNeighbours += (isNeighbourAlive(1, 0) ? 1 : 0); // e
		aliveNeighbours += (isNeighbourAlive(1, 1) ? 1 : 0); // se
		aliveNeighbours += (isNeighbourAlive(0, 1) ? 1 : 0); // s
		aliveNeighbours += (isNeighbourAlive(-1, 1) ? 1 : 0); // sw
		aliveNeighbours += (isNeighbourAlive(-1, 0) ? 1 : 0); // w
		aliveNeighbours += (isNeighbourAlive(-1, -1) ? 1 : 0); // w
		aliveNeighbours += (isNeighbourAlive(0, -1) ? 1 : 0); // n
		aliveNeighbours += (isNeighbourAlive(1, -1) ? 1 : 0); // ne
		return aliveNeighbours;
	}

	private boolean isNeighbourAlive(int deltaX, int deltaY) {
		Cell cell = world.getCell(x + deltaX, y + deltaY);
		return cell != null && cell.status == ALIVE;
	}

	public boolean isAlive() {
		return status == ALIVE;
	}

	public void makeAlive() {
		status = ALIVE;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", status=" + status + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
