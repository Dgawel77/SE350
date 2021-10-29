package model.shapes;

import java.awt.Color;
import java.awt.Graphics;
import model.interfaces.IShape;
import model.interfaces.IStrategy;
import model.region.Region;

public class Shape implements IShape {
  public Color sColor;
  public Region region;
  public IStrategy strategy;

  public Shape(Region _Region, Color _sColor, IStrategy drawStrategy){
    this.sColor = _sColor;
    this.region = _Region;
    this.strategy = drawStrategy;
  }

  @Override
  public void draw(Graphics graphics){
    strategy.draw(graphics, this);
  }

  @Override
  public Color getColor(){
    return this.sColor;
  }

  @Override
  public int getWidth(){
    return this.region.End.x - this.region.Start.x;
  }

  @Override
  public int getHeight(){
    return this.region.End.y - this.region.Start.y;
  }

  @Override
  public int getX(){
    return this.region.Start.x;
  }

  @Override
  public int getY(){
    return this.region.Start.y;
  }

  @Override
  public IStrategy getStrategy(){
    return this.strategy;
  }

  @Override
  public Region getRegion(){
    return this.region;
  }

  @Override
  public void move(int xChange, int yChange){
    this.region.move(xChange, yChange);
  }
}
