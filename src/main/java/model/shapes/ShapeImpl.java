package model.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import model.interfaces.IShape;
import model.region.Region;

abstract class ShapeImpl implements IShape {
  int x;
  int y;
  int width;
  int height;
  Color sColor;
  Region region;

  public ShapeImpl(int _x, int _y, int _width, int _height, Color _sColor){
    this.x = _x;
    this.y = _y;
    this.width = _width;
    this.height = _height;
    this.sColor = _sColor;
    this.region = new Region(_x, _y, _width, _height);
  }

  public void draw(Graphics graphics){}

  public Color getColor(){return this.sColor;}
  public int getWidth(){return this.width;}
  public int getHeight(){return this.height;}
  public int getX(){return this.x;}
  public int getY(){return this.y;}
  public Region getRegion(){return this.region;}
}
