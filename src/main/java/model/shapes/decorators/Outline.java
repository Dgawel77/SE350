package model.shapes.decorators;

import model.interfaces.IShape;

public class Outline extends DecoratorImpl{
  public Outline(IShape Shape){
    super(Shape);
  }

}
