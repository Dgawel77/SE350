package model.shapes.experts;

import java.awt.Color;
import java.awt.Graphics2D;
import model.shapes.ShapeImpl;

public class drawExpert {
  public static void drawFilled(Graphics2D graphics, ShapeImpl Shape){
    graphics.setColor(Shape.pColor);
    graphics.fill(Shape.getShapeFunction.apply(Shape));
  }

  public static void drawOutline(Graphics2D graphics, ShapeImpl Shape){
    graphics.setColor(Shape.getOutlineColor());
    graphics.setStroke(strokeHolder.base);
    graphics.draw(Shape.getShapeFunction.apply(Shape));
  }

  public static void drawSelection(Graphics2D graphics, ShapeImpl Shape){
    graphics.setColor(Color.black);
    graphics.setStroke(strokeHolder.dashed);
    graphics.draw(Shape.getShapeFunction.apply(Shape));
  }
}
