package model.shapes;

import model.interfaces.IStrategy;
import model.shapes.strategies.*;

public class drawStrategyHolder {
  public IStrategy drawOutline;
  public IStrategy drawFilled;
  public IStrategy drawSelection;

  public drawStrategyHolder(){
    drawOutline = new nullShapeDrawer();
    drawFilled = new nullShapeDrawer();
    drawSelection = new nullShapeDrawer();
  }

  public boolean isValid(){
    return drawOutline.isValid() && drawFilled.isValid();
  }
}
