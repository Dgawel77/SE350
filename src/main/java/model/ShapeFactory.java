package model;

import model.interfaces.IShape;
import model.interfaces.IStrategy;
import model.persistence.UserChoicesImpl;
import model.shapes.*;
import model.shapes.decorators.Fill;
import model.shapes.decorators.Outline;
import model.shapes.strategies.ellipseStrategy;
import model.shapes.strategies.rectangleStrategy;
import model.shapes.strategies.triangleStrategy;

public class ShapeFactory {
  private UserChoicesImpl choices;

  public ShapeFactory(UserChoicesImpl _choices){
    choices = _choices;
  }

  public IShape makeShape(int x, int y, int width, int height){
    IStrategy strategy = null;
    switch (choices.getActiveShapeType()){
      case ELLIPSE:
        strategy = new ellipseStrategy();
        break;
      case TRIANGLE:
        strategy = new triangleStrategy();
        break;
      case RECTANGLE:
        strategy = new rectangleStrategy();
        break;
    }
    return decorateShape(new Shape(x, y, width, height, choices.getActivePrimaryColor().AWTcolor, strategy));
  }

  public IShape decorateShape(IShape shape){
    switch (choices.getActiveShapeShadingType()){
      case OUTLINE:
        return new Outline(shape);
      case FILLED_IN:
        return new Fill(shape);
      case OUTLINE_AND_FILLED_IN:
        return new Outline(new Fill(shape));
    }
    return shape;
  }
}
