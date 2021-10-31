package model.shapes.experts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.interfaces.IShape;

public class ellipseExpert {
  private static Ellipse2D.Float getEllipse(IShape Shape){
    return new Ellipse2D.Float((float)Shape.getX(), (float)Shape.getY(), (float)Shape.getWidth(), (float)Shape.getHeight());
  }

  public static void drawFilled(Graphics2D graphics, IShape Shape){
    graphics.setColor(Shape.getPrimaryColor());
    graphics.fill(getEllipse(Shape));
  }

  public static void drawOutline(Graphics2D graphics, IShape Shape){
    graphics.setColor(Shape.getOutlineColor());
    graphics.setStroke(strokeHolder.base);
    graphics.draw(getEllipse(Shape));
  }

  public static void drawSelection(Graphics2D graphics, IShape Shape){
    graphics.setColor(Color.black);
    graphics.setStroke(strokeHolder.dashed);
    graphics.draw(getEllipse(Shape));
  }
}
