package controller;

import controller.command.CommandHistory;
import controller.command.DrawCommand;
import model.ShapeFactory;

public class CommandFactory {
  private final ShapeFactory ShapeMaker;

  public CommandFactory(ShapeFactory _ShapeFactory){
    this.ShapeMaker = _ShapeFactory;
  }

  public void MakeDrawCommand(int x, int y, int width, int height){
    DrawCommand Draw = new DrawCommand(ShapeMaker.makeShape(x, y, width, height));
    CommandHistory.add(Draw);
    Draw.run();
  }
}
