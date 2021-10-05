package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.IShape;

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
    view.gui.Frame.removeFromFrame();
  }

  @Override
  public void redo(){
    view.gui.Frame.addToFrame(this.shape);
  }

  @Override
  public void run(){ view.gui.Frame.addToFrame(this.shape); }
}