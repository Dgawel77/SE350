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
  private final CommandController controller;
  private Point StartPoint;

  public MouseHandler(CommandController _controller){
    this.controller = _controller;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    StartPoint = new Point(e.getX(), e.getY());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point EndPoint = new Point(e.getX(), e.getY());
    controller.pressedAt(StartPoint, EndPoint);
  }

}
