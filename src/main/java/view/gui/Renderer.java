package view.gui;

import java.awt.Graphics;
import model.interfaces.IShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Renderer {
  private static final Logger log = LoggerFactory.getLogger(Renderer.class);

  public static void render(Graphics graphics){
    for(IShape shape: Frame.IShapeStack){
      graphics.setColor(shape.getColor());
      shape.draw(graphics);
      //graphics.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }
  }
}
