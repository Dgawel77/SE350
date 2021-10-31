package model.shapes.experts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import model.interfaces.IShape;

public class rectangleExpert{
  private static Rectangle getRectangle(IShape Shape){
    return new Rectangle(Shape.getX(), Shape.getY(), Shape.getWidth(), Shape.getHeight());
  }

  public static void drawFilled(Graphics2D graphics, IShape Shape){
    graphics.setColor(Shape.getPrimaryColor());
    graphics.fill(getRectangle(Shape));
  }

  public static void drawOutline(Graphics2D graphics, IShape Shape){
    graphics.setColor(Shape.getOutlineColor());
    graphics.setStroke(strokeHolder.base);
    graphics.draw(getRectangle(Shape));
  }

  public static void drawSelection(Graphics2D graphics, IShape Shape){
    graphics.setColor(Color.black);
    graphics.setStroke(strokeHolder.dashed);
    graphics.draw(getRectangle(Shape));
  }
}
