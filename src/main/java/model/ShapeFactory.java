package model;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import model.persistence.UserChoicesImpl;
import model.region.Region;
import model.shapes.*;
import model.shapes.experts.drawExpert;
import model.shapes.strategies.ShapeDrawer;

public class ShapeFactory {
  private UserChoicesImpl choices;

  public ShapeFactory(UserChoicesImpl _choices){
    choices = _choices;
  }

  public ShapeImpl makeShape(Region region){
    ShapeImpl Shape = new ShapeImpl(
        region,
        choices.getActivePrimaryColor().AWTcolor,
        choices.getActiveSecondaryColor().AWTcolor);
    java.awt.Shape curAwtShape = null;
    switch (choices.getActiveShapeType()){
      case ELLIPSE:
        curAwtShape = getEllipse(Shape);
        break;
      case TRIANGLE:
        curAwtShape = getPolygon(Shape);
        break;
      case RECTANGLE:
        curAwtShape = getRectangle(Shape);
        break;
    }
    Shape.awtShape = curAwtShape;
    setChoices(Shape);
    return Shape;
  }

  private void setChoices(ShapeImpl Shape){
    switch (choices.getActiveShapeShadingType()){
      case OUTLINE_AND_FILLED_IN:
        Shape.setDrawFilled(drawExpert::drawFilled);
        Shape.setDrawOutline(drawExpert::drawOutline);
        break;
      case FILLED_IN:
        Shape.setDrawFilled(drawExpert::drawFilled);
        break;
      case OUTLINE:
        Shape.setDrawOutline(drawExpert::drawOutline);
        break;
    }
    Shape.setDrawSelection(drawExpert::drawSelection);
  }

  private java.awt.Shape getRectangle(ShapeImpl Shape){
    return new Rectangle(Shape.getX(), Shape.getY(), Shape.getWidth(), Shape.getHeight());
  }

  private java.awt.Shape getPolygon(ShapeImpl Shape){
    int x = Shape.getX();
    int y = Shape.getY();
    int width = Shape.getWidth();
    int height = Shape.getHeight();

    return new Polygon(new int[]{x+(width/2), x+width, x},
        new int[]{y, y+height, y+height}, 3);
  }

  private java.awt.Shape getEllipse(ShapeImpl Shape){
    return new Ellipse2D.Float((float)Shape.getX(), (float)Shape.getY(), (float)Shape.getWidth(), (float)Shape.getHeight());
  }

}
