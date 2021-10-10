package model;

import model.interfaces.IShape;
import model.persistence.UserChoicesImpl;
import model.shapes.*;

public class ShapeFactory {
  private UserChoicesImpl choices;

  public ShapeFactory(UserChoicesImpl _choices){
    choices = _choices;
  }

  public IShape makeShape(int x, int y, int width, int height){
    switch (choices.getActiveShapeType()){
      case ELLIPSE:
        return new Ellipse(x, y, width, height, choices.getActivePrimaryColor().AWTcolor);
      case TRIANGLE:
        return new Triangle(x, y, width, height, choices.getActivePrimaryColor().AWTcolor);
      case RECTANGLE:
        return new Rectangle(x, y, width, height, choices.getActivePrimaryColor().AWTcolor);
    }
    return null;
  }
}
