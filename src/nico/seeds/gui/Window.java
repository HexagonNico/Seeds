package nico.seeds.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import nico.seeds.SeedsSimulation;

public class Window extends JFrame {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 450;
	
	public Window() {
		super("Seeds Cellular Automaton");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(10, 10, 0, 0);
	}
	
	public void add(SeedsSimulation simulation) {
		simulation.setFocusable(true);
		simulation.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setContentPane(simulation);
		simulation.requestFocusInWindow();
		this.pack();
	}
}
