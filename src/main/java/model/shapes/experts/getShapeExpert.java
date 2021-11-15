package model.shapes.experts;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import model.shapes.ShapeImpl;

public class getShapeExpert {
  public static java.awt.Shape getRectangle(ShapeImpl Shape){
    return new Rectangle(Shape.getX(), Shape.getY(), Shape.getWidth(), Shape.getHeight());
  }

  public static java.awt.Shape getPolygon(ShapeImpl Shape){
    int x = Shape.getX();
    int y = Shape.getY();
    int width = Shape.getWidth();
    int height = Shape.getHeight();

    return new Polygon(new int[]{x+(width/2), x+width, x},
        new int[]{y, y+height, y+height}, 3);
  }

  public static java.awt.Shape getEllipse(ShapeImpl Shape){
    return new Ellipse2D.Float((float)Shape.getX(), (float)Shape.getY(), (float)Shape.getWidth(), (float)Shape.getHeight());
  }
}
