package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import java.util.List;
import model.interfaces.IShape;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private List<IShape> copyList;

  public PasteCommand(List<IShape> list){
    this.copyList = list;
  }

  @Override
  public void run(){
    System.out.println("hello");
    System.out.println(copyList);
    for (IShape s : copyList){
      s.move(CopyCommand.offset, CopyCommand.offset);
      Frame.addToFrame(s);
    }
    CopyCommand.increaseOffset();;
  }

  @Override
  public void undo() {
    for (IShape s : copyList){
      Frame.removeFromFrame();
    }
    CopyCommand.offset = 0;
  }

  @Override
  public void redo() {
    for (IShape s : copyList){
      Frame.addToFrame(s);
    }
  }

}
