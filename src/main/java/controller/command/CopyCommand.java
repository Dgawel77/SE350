package controller.command;

import controller.interfaces.Command;
import controller.selection.Selection;

public class CopyCommand implements Command {
  public static Selection currentCopySelection;
  public static int offset;
  private final static int step = 25;

  public CopyCommand(Selection _Select){
    currentCopySelection = _Select;
  }

  @Override
  public void run(){
    offset = 25;
  }

  public static void incOffset(){
    offset += step;
  }

  public static void decOffset(){
    offset -= step;
  }

}
