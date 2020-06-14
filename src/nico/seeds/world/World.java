package nico.seeds.world;

import java.awt.Graphics;
import java.util.Random;

import nico.seeds.gui.Window;

public class World {

	public static final int CELL_SIZE = 2;
	
	private Cell[][] grid;
	
	public World() {
		Random random = new Random();
		this.grid = new Cell[Window.WIDTH/CELL_SIZE][Window.HEIGHT/CELL_SIZE];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(i > 197 && i < 203 && j > 97 && j < 103)
					this.grid[i][j] = random.nextBoolean() ? Cell.OFF : Cell.ON;
				else
					this.grid[i][j] = Cell.OFF;
			}
		}
	}
	
	public void update() {
		Cell[][] gridCopy = new Cell[Window.WIDTH/CELL_SIZE][Window.HEIGHT/CELL_SIZE];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				switch(grid[i][j]) {
				case OFF:
					gridCopy[i][j] = this.countNearby(i, j) == 2 ? Cell.ON : Cell.OFF;
					break;
				case ON:
					gridCopy[i][j] = Cell.OFF;
					break;
				}
			}
		}
		this.grid = gridCopy;
	}
	
	public void draw(Graphics graphics) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				graphics.setColor(grid[i][j].color);
				graphics.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
			}
		}
	}
	
	private int countNearby(int ic, int jc) {
		int count = 0;
		for(int i = ic - 1; i <= ic + 1; i++) {
			for(int j = jc - 1; j <= jc + 1; j++) {
				try {
					if(grid[i][j] == Cell.ON) count++;
				} catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		return count;
	}
}
