package controller.command;

import controller.Point;
import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import controller.selection.StandardContainers;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.IShape;
import model.region.Region;
import model.shapes.Shape;
import view.gui.Frame;

public class PasteCommand implements Command, Undoable {
  private ArrayList<IShape> copyList;

  public PasteCommand(Selection _Select){
    copyList = new ArrayList<>(_Select.SelectionList);
  }

  @Override
  public void run(){
    CommandHistory.add(this);
    for (IShape s : copyList){
      Shape toScreen = new Shape(s);
      toScreen.move(CopyCommand.offset, CopyCommand.offset);
      Frame.addToFrame(toScreen);
    }
    CopyCommand.changeOffset(25);
  }

  @Override
  public void undo() {
    for (IShape s : copyList){
      Frame.removeFromFrame();
    }
    CopyCommand.changeOffset(-25);
  }

  @Override
  public void redo() {
    for (IShape s : copyList) {
      Shape toScreen = new Shape(s);
      toScreen.move(CopyCommand.offset, CopyCommand.offset);
      Frame.addToFrame(toScreen);
    }
    CopyCommand.changeOffset(25);
  }

}
