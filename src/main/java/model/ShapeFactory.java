package model;

import model.interfaces.IShape;
import model.persistence.UserChoicesImpl;
import model.region.Region;
import model.shapes.*;
import model.shapes.experts.ellipseExpert;
import model.shapes.experts.rectangleExpert;
import model.shapes.experts.triangleExpert;

public class ShapeFactory {
  private UserChoicesImpl choices;

  public ShapeFactory(UserChoicesImpl _choices){
    choices = _choices;
  }

  public IShape makeShape(Region region){
    IShape Shape = new Shape(
        region,
        choices.getActivePrimaryColor().AWTcolor,
        choices.getActiveSecondaryColor().AWTcolor);

    switch (choices.getActiveShapeType()){
      case ELLIPSE:
        setEllipseStrategies(Shape);
        break;
      case TRIANGLE:
        setTriangleStrategies(Shape);
        break;
      case RECTANGLE:
        setRectangleStrategies(Shape);
        break;
    }
    return Shape;
  }

  public void setEllipseStrategies(IShape Shape){
    switch (choices.getActiveShapeShadingType()) {
      case OUTLINE:
        Shape.setOutlineStrategy(ellipseExpert::drawOutline);
        break;
      case FILLED_IN:
        Shape.setFillStrategy(ellipseExpert::drawFilled);
        break;
      case OUTLINE_AND_FILLED_IN:
        Shape.setOutlineStrategy(ellipseExpert::drawOutline);
        Shape.setFillStrategy(ellipseExpert::drawFilled);
        break;
    }
    Shape.setSelectionStrategy(ellipseExpert::drawSelection);
  }

  public void setTriangleStrategies(IShape Shape) {
    switch (choices.getActiveShapeShadingType()) {
      case OUTLINE:
        Shape.setOutlineStrategy(triangleExpert::drawOutline);
        break;
      case FILLED_IN:
        Shape.setFillStrategy(triangleExpert::drawFilled);
        break;
      case OUTLINE_AND_FILLED_IN:
        Shape.setOutlineStrategy(triangleExpert::drawOutline);
        Shape.setFillStrategy(triangleExpert::drawFilled);
        break;
    }
    Shape.setSelectionStrategy(triangleExpert::drawSelection);
  }

  public void setRectangleStrategies(IShape Shape){
    switch (choices.getActiveShapeShadingType()){
      case OUTLINE:
        Shape.setOutlineStrategy(rectangleExpert::drawOutline);
        break;
      case FILLED_IN:
        Shape.setFillStrategy(rectangleExpert::drawFilled);
        break;
      case OUTLINE_AND_FILLED_IN:
        Shape.setOutlineStrategy(rectangleExpert::drawOutline);
        Shape.setFillStrategy(rectangleExpert::drawFilled);
        break;
    }
    Shape.setSelectionStrategy(rectangleExpert::drawSelection);
  }

}
