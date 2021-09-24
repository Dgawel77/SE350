package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {
  private static final Logger log = LoggerFactory.getLogger(MouseHandler.class);
  private CommandController controller;
  public int startX;
  public int startY;
  public int endX;
  public int endY;

  public MouseHandler(CommandController _controller){
    this.controller = _controller;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    startX = e.getX();
    startY = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    endX = e.getX();
    endY = e.getY();
    controller.drawAt(startX, startY, endX, endY);
  }

}
