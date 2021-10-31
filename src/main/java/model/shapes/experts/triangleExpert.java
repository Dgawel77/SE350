package model.shapes.experts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import model.interfaces.IShape;

public class triangleExpert {
  private static Polygon getPolygon(IShape Shape){
    int x = Shape.getX();
    int y = Shape.getY();
    int width = Shape.getWidth();
    int height = Shape.getHeight();

    return new Polygon(new int[]{x+(width/2), x+width, x},
                       new int[]{y, y+height, y+height}, 3);
  }

  public static void drawFilled(Graphics2D graphics, IShape Shape){
    graphics.setColor(Shape.getPrimaryColor());
    graphics.fillPolygon(getPolygon(Shape));
  }

  public static void drawOutline(Graphics2D graphics, IShape Shape){
    graphics.setColor(Shape.getOutlineColor());
    graphics.setStroke(strokeHolder.base);
    graphics.draw(getPolygon(Shape));
  }

  public static void drawSelection(Graphics2D graphics, IShape Shape){
    graphics.setColor(Color.black);
    graphics.setStroke(strokeHolder.dashed);
    graphics.draw(getPolygon(Shape));
  }

}
