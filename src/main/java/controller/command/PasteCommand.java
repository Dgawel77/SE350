package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.Stack;
import model.groups.GroupImpl;
import model.interfaces.IComponent;
import model.interfaces.IGroup;
import model.interfaces.IShape;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private final Stack<IComponent> additionList = new Stack<>();

  public PasteCommand(){
    for (IComponent s : ClipBoard.currentClipBoard){
      IComponent newShape = null;
      if (s instanceof IGroup){
        newShape = new GroupImpl((GroupImpl)s);
      }else if (s instanceof IShape ){
        newShape = new ShapeImpl((ShapeImpl)s);
      }
      int offset = ClipBoard.offset;
      newShape.move(offset, offset);
      additionList.add(newShape);
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
