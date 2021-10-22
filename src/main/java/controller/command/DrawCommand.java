package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.IShape;
import view.gui.Frame;

public class DrawCommand implements Undoable, Command {
  private IShape shape;
  public DrawCommand(IShape _shape){
    this.shape = _shape;
  }

  public IShape getIShape(){
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
