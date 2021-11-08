package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import java.util.ArrayList;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private final ArrayList<ShapeImpl> additionList = new ArrayList<>();

  public PasteCommand(Selection _Select){
    for (ShapeImpl s : _Select.SelectionList){
      ShapeImpl newShape = new ShapeImpl(s);
      int offset = CopyCommand.offset;
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
    CopyCommand.incOffset();
  }

  @Override
  public void undo() {
    for (ShapeImpl s : additionList){
      Frame.removeFromFrame();
    }
    CopyCommand.decOffset();
  }

  @Override
  public void redo() {
    for (ShapeImpl s : additionList) {
      Frame.addToFrame(s);
    }
    CopyCommand.incOffset();
  }

}
