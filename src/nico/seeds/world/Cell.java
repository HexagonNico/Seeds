package nico.seeds.world;

import java.awt.Color;

public enum Cell {
	
	ON(new Color(1.0f, 1.0f, 1.0f)),
	OFF(new Color(0.0f, 0.0f, 0.0f));
	
	public Color color;
	
	Cell(Color color) {
		this.color = color;
	}
}
