package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import input.KeyHandler;

public class Screen extends Canvas { 

	private Dimension dim;
	private JFrame frame;
	
	public Screen() {
		
		dim = new Dimension(800, 600);
		
    frame = new JFrame("Spaceship");
    frame.setSize(dim);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    this.setPreferredSize(dim);
    this.setMaximumSize(dim);
    this.setMinimumSize(dim);
    this.setFocusable(false);
    
    frame.add(this);
    frame.pack();
	}
	
	public void addListener(KeyHandler listener) {
		frame.addKeyListener(listener);
	}
	
}
