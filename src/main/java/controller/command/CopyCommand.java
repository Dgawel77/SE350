package controller.command;

import controller.interfaces.Command;
import controller.selection.Selection;
import controller.selection.StandardContainers;
import model.interfaces.IShape;
import model.shapes.Shape;

public class CopyCommand implements Command {
  public static Selection currentCopySelection;
  public static int offset;

  public CopyCommand(Selection _Select){
    currentCopySelection = _Select;
    offset = 25;
  }

  @Override
  public void run(){
  }

  public static void changeOffset(int x){
    offset += x;
  }

}
