package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import java.util.ArrayList;
import model.interfaces.IShape;
import view.gui.Frame;

public class DeleteCommand implements Undoable, Command {
  private ArrayList<IShape> deleteList;

  public DeleteCommand(Selection _Select){
    this.deleteList = new ArrayList<>(_Select.SelectionList);
  }

  @Override
  public void run() {
    CommandHistory.add(this);
    for (IShape s: deleteList){
      Frame.IShapeStack.remove(s);
    }
  }

  @Override
  public void undo() {
    for (IShape s: deleteList){
      Frame.IShapeStack.add(s);
    }
  }

  @Override
  public void redo() {
    for (IShape s: deleteList){
      Frame.IShapeStack.remove(s);
    }
  }
}
