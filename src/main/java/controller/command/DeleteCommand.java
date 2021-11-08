package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import java.util.ArrayList;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class DeleteCommand implements Undoable, Command {
  private ArrayList<ShapeImpl> deleteList;

  public DeleteCommand(Selection _Select){
    this.deleteList = new ArrayList<ShapeImpl>(_Select.SelectionList);
  }

  @Override
  public void run() {
    CommandHistory.add(this);
    for (ShapeImpl s: deleteList){
      Frame.IShapeStack.remove(s);
    }
  }

  @Override
  public void undo() {
    for (ShapeImpl s: deleteList){
      Frame.IShapeStack.add(s);
    }
  }

  @Override
  public void redo() {
    for (ShapeImpl s: deleteList){
      Frame.IShapeStack.remove(s);
    }
  }
}
