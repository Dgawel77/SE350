package model;

import java.util.function.Function;
import model.persistence.UserChoicesImpl;
import model.region.Region;
import model.shapes.ShapeImpl;
import model.shapes.colorHolder;
import model.shapes.experts.drawExpert;
import model.shapes.experts.getShapeExpert;
import model.shapes.strategies.ShapeDrawer;

public class ShapeFactory {
  private final UserChoicesImpl choices;

  public ShapeFactory(UserChoicesImpl _choices){
    choices = _choices;
  }

  public ShapeImpl makeShape(Region region){
    ShapeImpl Shape = new ShapeImpl(
        region,
        new colorHolder(
        choices.getActivePrimaryColor().AWTcolor,
        choices.getActiveSecondaryColor().AWTcolor));
    setGetFunction(Shape);
    setChoices(Shape);
    return Shape;
  }

  private void setGetFunction(ShapeImpl Shape){
    Function<ShapeImpl, java.awt.Shape> getFunction = null;
    switch (choices.getActiveShapeType()){
      case ELLIPSE:
        getFunction = getShapeExpert::getEllipse;
        break;
      case TRIANGLE:
        getFunction = getShapeExpert::getPolygon;
        break;
      case RECTANGLE:
        getFunction = getShapeExpert::getRectangle;
        break;
    }
    Shape.getShapeFunction = getFunction;
  }

  private void setChoices(ShapeImpl Shape){
    switch (choices.getActiveShapeShadingType()){
      case OUTLINE_AND_FILLED_IN:
        Shape.setDrawFilled(new ShapeDrawer(drawExpert::drawFilled));
        Shape.setDrawOutline(new ShapeDrawer(drawExpert::drawOutline));
        break;
      case FILLED_IN:
        Shape.setDrawFilled(new ShapeDrawer(drawExpert::drawFilled));
        break;
      case OUTLINE:
        Shape.setDrawOutline(new ShapeDrawer(drawExpert::drawOutline));
        break;
    }
    Shape.setDrawSelection(new ShapeDrawer(drawExpert::drawSelection));
  }

}
