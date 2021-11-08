package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.selection.Selection;
import model.shapes.ShapeImpl;

public class MoveCommand implements Command, Undoable{
  private Selection select;
  private final int xChange;
  private final int yChange;


  public MoveCommand(int xChange, int yChange, Selection select) {
    this.select = new Selection(select);
    this.xChange = xChange;
    this.yChange = yChange;
  }

  @Override
  public void run(){
    for(ShapeImpl Shape : select.SelectionList){
      Shape.move(xChange, yChange);
    }
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    for(ShapeImpl Shape : select.SelectionList){
      Shape.move(-xChange, -yChange);
    }
  }

  @Override
  public void redo() {
    for(ShapeImpl Shape : select.SelectionList){
      Shape.move(xChange, yChange);
    }
  }
}
