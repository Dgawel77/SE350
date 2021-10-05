package model;

import controller.DrawCommand;
import controller.command.CommandHistory;
import model.interfaces.IShape;
import model.persistence.UserChoicesImpl;
import model.shapes.*;

public class ShapeFactory {
  private UserChoicesImpl choices;

  public ShapeFactory(UserChoicesImpl _choices){
    choices = _choices;
  }

  public void makeShape(int x, int y, int width, int height){
    IShape shape = new Rectangle(x, y, width, height, choices.getActivePrimaryColor().AWTcolor);
    CommandHistory.add(new DrawCommand(shape));
    view.gui.Frame.addToFrame(shape);
  }
}
