package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.groups.GroupImpl;
import model.interfaces.IComponent;
import view.gui.Frame;

public class GroupCommand implements Command, Undoable {
  ArrayList<IComponent> GroupedObjects = new ArrayList<>();
  GroupImpl Group;

  public GroupCommand(){
    GroupedObjects.addAll(Frame.SelectionStack);
  }

  @Override
  public void run(){
    if (GroupedObjects.isEmpty()) return;
    CommandHistory.add(this);
    Group = new GroupImpl(GroupedObjects);
    Frame.addToFrame(Group);
    for(IComponent component : GroupedObjects){
      Frame.removeFromFrame(component);
    }
  }

  @Override
  public void undo() {
    Frame.removeFromFrame(Group);
    for(IComponent component : GroupedObjects){
      Frame.addToFrame(component);
    }
  }

  @Override
  public void redo() {
    Frame.addToFrame(Group);
    for(IComponent component : GroupedObjects){
      Frame.removeFromFrame(component);
    }
  }
}
