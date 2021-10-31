package controller.command;

import controller.interfaces.Command;
import controller.selection.Selection;
import java.util.List;
import model.interfaces.IShape;
import model.shapes.Shape;

public class CopyCommand implements Command {
  public static List<IShape> currentCopySelection;
  public Selection Select;
  public static int offset;

  public CopyCommand(Selection _Select){
    this.Select = _Select;
    this.offset = 0;
  }

  @Override
  public void run(){
    for(IShape s : Select.SelectionList) {
      currentCopySelection.add(new Shape(s));
    }
  }

  public static void increaseOffset(){
    offset += 25;
  }

}
