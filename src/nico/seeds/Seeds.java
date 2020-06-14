package nico.seeds;

import javax.swing.Timer;

import nico.seeds.gui.Window;

public class Seeds {

	private Window window;
	private SeedsSimulation simulation;
	private Timer timer;
	
	private void start() {
		this.init();
		this.loop();
	}
	
	private void init() {
		this.window = new Window();
		this.simulation = new SeedsSimulation();
		this.window.add(simulation);
		this.window.setVisible(true);
	}
	
	private void loop() {
		this.timer = new Timer(100, simulation);
		this.timer.start();
	}
	
	public static void main(String[] args) {
		new Seeds().start();
	}
}
