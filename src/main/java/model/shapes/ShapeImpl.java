package model.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.function.Function;
import model.interfaces.*;
import model.region.Region;

public class ShapeImpl implements IComponent, IShape {
  private final colorHolder colorHolder;
  private final Region region;
  public Function<ShapeImpl, java.awt.Shape> getShapeFunction;
  private drawStrategyHolder drawHolder;

  public ShapeImpl(Region _Region, colorHolder colorHolder){
    this.colorHolder = colorHolder;
    this.region = _Region;
    this.getShapeFunction = null;
    this.drawHolder = new drawStrategyHolder();
  }

  public IComponent copy(){
    ShapeImpl shape =  new ShapeImpl(new Region(region), this.colorHolder);
    shape.getShapeFunction = this.getShapeFunction;
    shape.drawHolder = this.drawHolder;
    return shape;
  }

  public void draw(Graphics2D graphics){
    drawHolder.drawOutline.draw(graphics, this);
    drawHolder.drawFilled.draw(graphics, this);
  }

  public void drawSelection(Graphics2D graphics){
    drawHolder.drawSelection.draw(graphics, this);
  }

  public Color getOutlineColor(){
    if (drawHolder.isValid()) return colorHolder.sColor;
    return colorHolder.pColor;
  }

  public Color getPrimaryColor(){
    return colorHolder.pColor;
  }

  public void unwind() {}

  public void rewind() {}

  public int getWidth(){
    return this.region.End.x - this.region.Start.x;
  }

  public int getHeight(){
    return this.region.End.y - this.region.Start.y;
  }

  public int getX(){
    return this.region.Start.x;
  }

  public int getY(){
    return this.region.Start.y;
  }

  public void move(int xChange, int yChange){
    this.region.move(xChange, yChange);
  }

  public void setDrawOutline(IStrategy drawOutline) {
    drawHolder.drawOutline = drawOutline;
  }

  public void setDrawFilled(IStrategy drawFilled) {
    drawHolder.drawFilled = drawFilled;
  }

  public void setDrawSelection(IStrategy drawSelection) {
    drawHolder.drawSelection = drawSelection;
  }

  public boolean intersects(Region r) {return r.intersects(this.region);}

}
