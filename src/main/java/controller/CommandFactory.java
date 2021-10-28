package controller;

import controller.command.CopyCommand;
import controller.command.DrawCommand;
import controller.command.MoveCommand;
import controller.command.PasteCommand;
import controller.command.SelectionCommand;
import controller.interfaces.Command;
import model.ShapeFactory;
import model.persistence.UserChoicesImpl;

public class CommandFactory {
  private final ShapeFactory ShapeMaker;
  private final UserChoicesImpl Choices;

  public CommandFactory(ShapeFactory _ShapeFactory, UserChoicesImpl _Choices){
    this.ShapeMaker = _ShapeFactory;
    this.Choices = _Choices;
  }

  public Command MakeCommand(Point Start, Point End){
    int[] nP = MouseCoordinateNormalizer.normalizeCords(Start.x, Start.y, End.x, End.y);
    switch(Choices.getActiveMouseMode()){
      case DRAW:
        return MakeDrawCommand(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
      case MOVE:
        return MakeMoveCommand(End.x-Start.x, End.y-Start.y);
      case SELECT:
        return MakeSelectionCommand(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
    }
    return null;
  }

  public Command MakeDrawCommand(int x, int y, int width, int height){
    return new DrawCommand(ShapeMaker.makeShape(x, y, width, height));
  }

  public Command MakeMoveCommand(int xChange, int yChange){
    return new MoveCommand(xChange, yChange, SelectionCommand.Select);
  }

  public Command MakeSelectionCommand(int x, int y, int width, int height){
    return new SelectionCommand(x, y, width, height);
  }

  public Command MakeCopyCommand(){
    return new CopyCommand(SelectionCommand.Select);
  }

  public Command MakePasteCommand(){
    return new PasteCommand(CopyCommand.currentCopySelection);
  }

}
