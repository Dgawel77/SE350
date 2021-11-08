package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.Stack;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private final Stack<ShapeImpl> additionList = new Stack<>();

  public PasteCommand(){
    for (ShapeImpl s : ClipBoard.currentClipBoard){
      ShapeImpl newShape = new ShapeImpl(s);
      int offset = ClipBoard.offset;
      newShape.move(offset, offset);
      additionList.add(newShape);
    }
  }

  @Override
  public void run(){
    CommandHistory.add(this);
    for (ShapeImpl s : additionList){
      Frame.addToFrame(s);
    }
    ClipBoard.incOffset();
  }

  @Override
  public void undo() {
    for (ShapeImpl s : additionList){
      Frame.removeFromFrame();
    }
    ClipBoard.decOffset();
  }

  @Override
  public void redo() {
    for (ShapeImpl s : additionList) {
      Frame.addToFrame(s);
    }
    ClipBoard.incOffset();
  }

}
