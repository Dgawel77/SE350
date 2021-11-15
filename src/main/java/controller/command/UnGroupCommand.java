package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IComponent;
import view.gui.Frame;

public class UnGroupCommand implements Command, Undoable {
  ArrayList<IComponent> GroupedObjects = new ArrayList<>();

  public UnGroupCommand(){
    GroupedObjects.addAll(Frame.SelectionStack);
  }

  @Override
  public void run() {
    if (GroupedObjects.isEmpty()) return;
    CommandHistory.add(this);
    for (IComponent component : GroupedObjects){
      component.unwind();
    }
  }

  @Override
  public void undo() {
    for (IComponent component : GroupedObjects){
      component.rewind();
    }
  }

  @Override
  public void redo() {
    for (IComponent component : GroupedObjects){
      component.unwind();
    }
  }
}
