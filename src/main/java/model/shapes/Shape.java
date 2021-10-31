package model.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import model.interfaces.IShape;
import model.interfaces.IStrategy;
import model.region.Region;
import model.shapes.strategies.nullShapeDrawer;

public class Shape implements IShape {
  public Color pColor;
  public Color sColor;
  public Region region;
  public IStrategy outlineStrategy;
  public IStrategy fillStrategy;
  public IStrategy selectionStrategy;

  private int numStrategies = 0;

  public Shape(Region _Region, Color _pColor, Color _sColor){
    this.pColor = _pColor;
    this.sColor = _sColor;
    this.region = _Region;
    outlineStrategy = new nullShapeDrawer();
    fillStrategy = new nullShapeDrawer();
    selectionStrategy = new nullShapeDrawer();
  }

  public Shape(IShape r){
    this.pColor = r.getPrimaryColor();
    this.sColor = r.getSecondaryColor();
    this.region = new Region(r.getRegion());
    outlineStrategy = new nullShapeDrawer();
    fillStrategy = new nullShapeDrawer();
    selectionStrategy = new nullShapeDrawer();
  }

  @Override
  public void draw(Graphics2D graphics){
    outlineStrategy.draw(graphics, this);
    fillStrategy.draw(graphics, this);
  }

  @Override
  public void drawSelection(Graphics2D graphics){
    selectionStrategy.draw(graphics, this);
  }

  @Override
  public Color getPrimaryColor(){
    return this.pColor;
  }

  @Override
  public Color getSecondaryColor(){
    return this.sColor;
  }

  public Color getOutlineColor(){
    if (numStrategies == 1)
      return pColor;
    return sColor;
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
  public Region getRegion(){
    return this.region;
  }

  @Override
  public void move(int xChange, int yChange){
    this.region.move(xChange, yChange);
  }

  @Override
  public void setOutlineStrategy(IStrategy outlineStrategy) {
    this.outlineStrategy = outlineStrategy;
    numStrategies++;
  }

  @Override
  public void setFillStrategy(IStrategy fillStrategy) {
    this.fillStrategy = fillStrategy;
    numStrategies++;
  }

  @Override
  public void setSelectionStrategy(IStrategy selectionStrategy) {
    this.selectionStrategy = selectionStrategy;
  }
}
