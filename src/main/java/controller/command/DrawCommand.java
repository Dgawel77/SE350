package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class DrawCommand implements Undoable, Command {
  private final ShapeImpl shape;
  public DrawCommand(ShapeImpl _shape){
    this.shape = _shape;
  }

  @Override
  public void undo(){
    Frame.removeFromFrame(shape);
  }

  @Override
  public void redo(){
    Frame.addToFrame(this.shape);
  }

  @Override
  public void run(){
    CommandHistory.add(this);
    Frame.addToFrame(this.shape);
  }
}
