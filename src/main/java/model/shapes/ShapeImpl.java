package model.shapes;

import java.awt.Color;
import java.awt.Graphics;
import model.interfaces.IShape;
import model.region.Region;

abstract class ShapeImpl implements IShape {
  public Color sColor;
  public Region region;

  public ShapeImpl(int _x, int _y, int _width, int _height, Color _sColor){
    this.sColor = _sColor;
    this.region = new Region(_x, _y, _width, _height);
  }

  public void draw(Graphics graphics){}

  public Color getColor(){return this.sColor;}
  public int getWidth(){return this.region.End.x - this.region.Start.x;}
  public int getHeight(){return this.region.End.y - this.region.Start.y;}
  public int getX(){return this.region.Start.x;}
  public int getY(){return this.region.Start.y;}
  public Region getRegion(){return this.region;}

  public void move(int xChange, int yChange){
    this.region.move(xChange, yChange);
  }
}
