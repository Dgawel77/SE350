package controller;

import controller.command.ClipBoard;
import controller.command.DeleteCommand;
import controller.command.DrawCommand;
import controller.command.MoveCommand;
import controller.command.PasteCommand;
import controller.command.SelectionCommand;
import controller.interfaces.Command;
import model.ShapeFactory;
import model.persistence.UserChoicesImpl;
import model.region.Region;
import view.gui.Frame;

public class CommandFactory {
  private final ShapeFactory ShapeMaker;
  private final UserChoicesImpl Choices;

  public CommandFactory(ShapeFactory _ShapeFactory, UserChoicesImpl _Choices){
    this.ShapeMaker = _ShapeFactory;
    this.Choices = _Choices;
  }

  public Command MakeCommand(Point Start, Point End){
    int[] nP = MouseCoordinateNormalizer.normalizeCords(Start.x, Start.y, End.x, End.y);
    Region region = new Region(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
    switch(Choices.getActiveMouseMode()){
      case DRAW:
        return MakeDrawCommand(region);
      case MOVE:
        return MakeMoveCommand(End.x-Start.x, End.y-Start.y);
      case SELECT:
        return MakeSelectionCommand(region);
    }
    return null;
  }

  public Command MakeDrawCommand(Region region){
    return new DrawCommand(ShapeMaker.makeShape(region));
  }

  public Command MakeMoveCommand(int xChange, int yChange){
    return new MoveCommand(xChange, yChange);
  }

  public Command MakeSelectionCommand(Region region){
    return new SelectionCommand(region);
  }

  public Command MakeCopyCommand(){
    return new ClipBoard();
  }

  public Command MakePasteCommand(){
    return new PasteCommand();
  }

  public Command MakeDeleteCommand(){ return new DeleteCommand(); }

}
