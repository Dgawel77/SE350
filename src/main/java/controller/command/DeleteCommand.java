package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IComponent;
import view.gui.Frame;

public class DeleteCommand implements Undoable, Command {
  private final ArrayList<IComponent> deleteList = new ArrayList<>();

  public DeleteCommand(){
    this.deleteList.addAll(Frame.SelectionStack);
  }

  @Override
  public void run() {
    CommandHistory.add(this);
    for (IComponent s: deleteList){
      Frame.removeFromFrame(s);
    }
  }

  @Override
  public void undo() {
    for (IComponent s: deleteList){
      Frame.addToFrame(s);
    }
  }

  @Override
  public void redo() {
    for (IComponent s: deleteList){
      Frame.removeFromFrame(s);
    }
  }
}
