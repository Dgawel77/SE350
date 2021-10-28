package controller.command;

import controller.interfaces.Command;
import controller.selection.Selection;

public class CopyCommand implements Command {
  public static Selection currentCopySelection;
  public Selection Select;
  public int offset;

  public CopyCommand(Selection _Select){
    this.Select = _Select;
    this.offset = 0;
  }

  @Override
  public void run(){
    currentCopySelection = this.Select;
  }
}
