package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.awt.Shape;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class DrawCommand implements Undoable, Command {
  private ShapeImpl shape;
  public DrawCommand(ShapeImpl _shape){
    this.shape = _shape;
  }

  public ShapeImpl getIShape(){
    return this.shape;
  }

  @Override
  public void undo(){
    Frame.removeFromFrame();
  }

  @Override
  public void redo(){
    Frame.addToFrame(this.shape);
  }

  @Override
  public void run(){
    Frame.addToFrame(this.shape);
    CommandHistory.add(this);
  }
}
