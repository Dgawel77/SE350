package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IComponent;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private final ArrayList<IComponent> additionList = new ArrayList<>();

  public PasteCommand(){
    for (IComponent s : ClipBoard.currentClipBoard){
      IComponent newComponent = s.copy();
      int offset = ClipBoard.offset;
      newComponent.move(offset, offset);
      additionList.add(newComponent);
    }
  }

  @Override
  public void run(){
    CommandHistory.add(this);
    for (IComponent s : additionList){
      Frame.addToFrame(s);
    }
    ClipBoard.incOffset();
  }

  @Override
  public void undo() {
    for (IComponent s : additionList){
      Frame.removeFromFrame(s);
    }
    ClipBoard.decOffset();
  }

  @Override
  public void redo() {
    for (IComponent s : additionList) {
      Frame.addToFrame(s);
    }
    ClipBoard.incOffset();
  }

}
