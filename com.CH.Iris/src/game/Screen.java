package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import input.KeyHandler;
import sfx.Sound;

public class Screen extends Canvas { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Dimension dim;
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
    
    frame.addWindowListener(new WindowAdapter()
    {
        public void windowClosing(WindowEvent we) {
        Sound.shutdown();
        System.out.println("Game Closed");
        }
    });
    frame.pack();
    
    
    
	}
	
	public void addListener(KeyHandler listener) {
		frame.addKeyListener(listener);
	}
	
}
