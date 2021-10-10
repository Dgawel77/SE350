package controller;

import controller.command.CommandHistory;
import controller.command.DrawCommand;
import controller.command.MoveCommand;
import controller.selection.Selection;
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

  public void MakeMoveCommand(int xChange, int yChange, Selection select){
    MoveCommand Move = new MoveCommand(xChange, yChange, select);
    CommandHistory.add(Move);
    Move.run();
  }
}
