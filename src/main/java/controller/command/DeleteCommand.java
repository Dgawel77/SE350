package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.Stack;
import model.interfaces.IComponent;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class DeleteCommand implements Undoable, Command {
  private final Stack<IComponent> deleteList = new Stack<>();

  public DeleteCommand(){
    this.deleteList.addAll(Frame.SelectionStack);
  }

  @Override
  public void run() {
    CommandHistory.add(this);
    for (IComponent s: deleteList){
      Frame.ShapeStack.remove(s);
    }
  }

  @Override
  public void undo() {
    Frame.ShapeStack.addAll(deleteList);
  }

  @Override
  public void redo() {
    for (IComponent s: deleteList){
      Frame.ShapeStack.remove(s);
    }
  }
}
