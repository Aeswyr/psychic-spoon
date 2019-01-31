package runtime;

import entities.Entity;
import game.Screen;

public class Camera {
	

	  private static final int WIDTH = (int) Screen.dim.getWidth();
	  private static final int HEIGHT = (int) Screen.dim.getHeight();

	  private int xOffset, yOffset;
	  private Handler handler;

	  public Camera(Handler handler) {
	    this.xOffset = 0;
	    this.yOffset = 0;

	    this.handler = handler;
	  }

	  public void centerOnEntity(Entity e) {
	    xOffset = e.getXPos() - WIDTH / 2;
	    if (xOffset > handler.getWorld().getWidth() - WIDTH)
	      xOffset = handler.getWorld().getWidth() - WIDTH;
	    if (xOffset < 0)
	      xOffset = 0;

	    yOffset = e.getYPos() - HEIGHT + 128;
	    if (yOffset > handler.getWorld().getHeight() - HEIGHT)
	      yOffset = handler.getWorld().getHeight() - HEIGHT;
	  }

	  public int xOffset() {
	    return xOffset;
	  }

	  public int yOffset() {
	    return yOffset;
	  }
}
