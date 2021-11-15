package model.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.function.Function;

import model.interfaces.IComponent;
import model.interfaces.IShape;
import model.interfaces.IStrategy;
import model.region.Region;
import model.shapes.strategies.*;

public class ShapeImpl implements IComponent, IShape {
  public Color pColor;
  public Color sColor;
  public Region region;
  public Function<ShapeImpl, java.awt.Shape> getShapeFunction;
  private IStrategy drawOutline;
  private IStrategy drawFilled;
  private IStrategy drawSelection;

  public ShapeImpl(Region _Region, Color _pColor, Color _sColor){
    this.pColor = _pColor;
    this.sColor = _sColor;
    this.region = _Region;
    this.getShapeFunction = null;
    this.drawOutline = new nullShapeDrawer();
    this.drawFilled = new nullShapeDrawer();
    this.drawSelection = new nullShapeDrawer();
  }

  public ShapeImpl(ShapeImpl r){
    this.pColor = r.pColor;
    this.sColor = r.sColor;
    this.region = new Region(r.region);
    this.getShapeFunction = r.getShapeFunction;
    this.drawOutline = r.drawOutline;
    this.drawFilled = r.drawFilled;
    this.drawSelection = r.drawSelection;
  }

  public void draw(Graphics2D graphics){
    drawOutline.draw(graphics, this);
    drawFilled.draw(graphics, this);
  }

  public void drawSelection(Graphics2D graphics){
    drawSelection.draw(graphics, this);
  }

  public Color getOutlineColor(){
    if (drawOutline instanceof nullShapeDrawer ||
        drawFilled instanceof nullShapeDrawer){
      return pColor;
    }
    return sColor;
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
    this.drawOutline = drawOutline;
  }

  public void setDrawFilled(IStrategy drawFilled) {
    this.drawFilled = drawFilled;
  }

  public void setDrawSelection(IStrategy drawSelection) {
    this.drawSelection = drawSelection;
  }

  public boolean intersects(Region r) {return r.intersects(this.region);}

}
