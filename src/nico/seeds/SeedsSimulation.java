package nico.seeds;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import nico.seeds.world.World;

public class SeedsSimulation extends JPanel implements ActionListener {

	private World world;
	
	public SeedsSimulation() {
		this.world = new World();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.world.update();
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		this.world.draw(graphics);
		super.repaint();
	}
}
