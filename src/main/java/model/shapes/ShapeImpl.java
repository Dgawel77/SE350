package model.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import model.interfaces.IStrategy;
import model.region.Region;
import model.shapes.strategies.*;

public class ShapeImpl {
  public Color pColor;
  public Color sColor;
  public Region region;
  public java.awt.Shape awtShape;
  private IStrategy drawOutline;
  private IStrategy drawFilled;
  private IStrategy drawSelection;

  public ShapeImpl(Region _Region, Color _pColor, Color _sColor){
    this.pColor = _pColor;
    this.sColor = _sColor;
    this.region = _Region;
    this.awtShape = null;
    this.drawOutline = new nullShapeDrawer();
    this.drawFilled = new nullShapeDrawer();
    this.drawSelection = new nullShapeDrawer();
  }

  public ShapeImpl(ShapeImpl r){
    this.pColor = r.getPrimaryColor();
    this.sColor = r.getSecondaryColor();
    this.region = new Region(r.getRegion());
    this.drawOutline = new nullShapeDrawer();
    this.drawFilled = new nullShapeDrawer();
    this.drawSelection = new nullShapeDrawer();
  }

  public void draw(Graphics2D graphics){
    drawOutline.draw(graphics, this);
    drawFilled.draw(graphics, this);
  }

  public void drawSelection(Graphics2D graphics){
    drawSelection.draw(graphics, this);
  }

  public Color getPrimaryColor(){
    return this.pColor;
  }

  public Color getSecondaryColor(){
    return this.sColor;
  }

  public Color getOutlineColor(){
    if (drawOutline instanceof nullShapeDrawer ||
        drawFilled instanceof nullShapeDrawer){
      return pColor;
    }
    return sColor;
  }

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

  public Region getRegion(){
    return this.region;
  }

  public void move(int xChange, int yChange){
    this.region.move(xChange, yChange);
  }

  public void setAwtShape(java.awt.Shape _Shape) {
    this.awtShape = _Shape;
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

}
