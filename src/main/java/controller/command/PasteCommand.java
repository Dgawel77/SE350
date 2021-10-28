package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import model.interfaces.IShape;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  Selection Select;

  public PasteCommand(Selection _Select){
    this.Select = _Select;
  }

  @Override
  public void run(){
    for (IShape s : Select.SelectionList){
      Frame.addToFrame(s);
    }
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }

}
