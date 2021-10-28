package model.shapes.decorators;

import model.interfaces.IShape;

public class Fill extends DecoratorImpl{
  public Fill(IShape Shape){
    super(Shape);
  }
}
