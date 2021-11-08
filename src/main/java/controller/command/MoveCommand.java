package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.Stack;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class MoveCommand implements Command, Undoable{
  private Stack<ShapeImpl> shapesToMove;
  private final int xChange;
  private final int yChange;


  public MoveCommand(int xChange, int yChange) {
    this.shapesToMove = new Stack<>();
    this.xChange = xChange;
    this.yChange = yChange;
  }

  @Override
  public void run(){
    shapesToMove.addAll(Frame.SelectionStack);
    for(ShapeImpl Shape : shapesToMove){
      Shape.move(xChange, yChange);
    }
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    for(ShapeImpl Shape : shapesToMove){
      Shape.move(-xChange, -yChange);
    }
  }

  @Override
  public void redo() {
    for(ShapeImpl Shape : shapesToMove){
      Shape.move(xChange, yChange);
    }
  }
}
