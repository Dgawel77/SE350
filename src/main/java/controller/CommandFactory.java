package controller;

import controller.command.*;
import controller.interfaces.Command;
import model.ShapeFactory;
import model.persistence.UserChoicesImpl;
import model.region.Region;

public class CommandFactory {
  private final ShapeFactory ShapeMaker;
  private final UserChoicesImpl Choices;

  public CommandFactory(ShapeFactory _ShapeFactory, UserChoicesImpl _Choices){
    this.ShapeMaker = _ShapeFactory;
    this.Choices = _Choices;
  }

  public Command MakeCommand(Point Start, Point End){
    int xChange = End.x-Start.x;
    int yChange = End.y-Start.y;
    MouseCoordinateNormalizer.normalizeCords(Start, End);
    Region region = new Region(Start, End);
    switch(Choices.getActiveMouseMode()){
      case DRAW:
        return MakeDrawCommand(region);
      case MOVE:
        return MakeMoveCommand(xChange, yChange);
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

  public Command MakeGroupCommand(){ return new GroupCommand(); }

  public Command MakeUnGroupCommand(){ return new UnGroupCommand(); }

}
