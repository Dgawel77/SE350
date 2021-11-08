package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private final ArrayList<IShape> additionList = new ArrayList<>();

  public PasteCommand(Selection _Select){
    for (IShape s : _Select.SelectionList){
      ShapeImpl newShape = new ShapeImpl(s);
      int offset = CopyCommand.offset;
      newShape.move(offset, offset);
      additionList.add(newShape);
    }
  }

  @Override
  public void run(){
    CommandHistory.add(this);
    for (IShape s : additionList){
      Frame.addToFrame(s);
    }
    CopyCommand.incOffset();
  }

  @Override
  public void undo() {
    for (IShape s : additionList){
      Frame.removeFromFrame();
    }
    CopyCommand.decOffset();
  }

  @Override
  public void redo() {
    for (IShape s : additionList) {
      Frame.addToFrame(s);
    }
    CopyCommand.incOffset();
  }

}
