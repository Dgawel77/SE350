package model.shapes.strategies;

import java.awt.Graphics2D;
import java.util.function.BiConsumer;
import model.interfaces.IStrategy;
import model.shapes.ShapeImpl;

public class ShapeDrawer implements IStrategy {
  BiConsumer<Graphics2D, ShapeImpl> consumer;
  public ShapeDrawer(BiConsumer<Graphics2D, ShapeImpl> _consumer){
    this.consumer = _consumer;
  }

  @Override
  public void draw(Graphics2D graphics, ShapeImpl Shape){
    System.out.println("hello");
    consumer.accept(graphics, Shape);
  }
}
