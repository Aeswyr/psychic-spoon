package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean left, right, space;
	boolean[] keys = new boolean[256];

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void update() {
		
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right =  keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
		
	}
	
}
