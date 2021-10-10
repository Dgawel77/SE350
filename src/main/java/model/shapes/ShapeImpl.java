package model.shapes;

import java.awt.Color;
import java.awt.Graphics;
import model.interfaces.IShape;
import model.region.Region;

abstract class ShapeImpl implements IShape {
  public int x;
  public int y;
  public int width;
  public int height;
  public Color sColor;
  public Region region;

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

  public void move(int xChange, int yChange){
    this.x += xChange;
    this.y += yChange;
    this.region.move(xChange, yChange);
  }
}
