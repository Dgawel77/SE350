package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IComponent;
import view.gui.Frame;

public class MoveCommand implements Command, Undoable{
  private final ArrayList<IComponent> shapesToMove = new ArrayList<>();
  private final int xChange;
  private final int yChange;


  public MoveCommand(int xChange, int yChange) {
    this.xChange = xChange;
    this.yChange = yChange;
  }

  @Override
  public void run(){
    shapesToMove.addAll(Frame.SelectionStack);
    for(IComponent Shape : shapesToMove){
      Shape.move(xChange, yChange);
    }
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    for(IComponent Shape : shapesToMove){
      Shape.move(-xChange, -yChange);
    }
  }

  @Override
  public void redo() {
    for(IComponent Shape : shapesToMove){
      Shape.move(xChange, yChange);
    }
  }
}
