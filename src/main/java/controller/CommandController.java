package controller;

import controller.command.CommandHistory;
import controller.interfaces.Command;
import view.gui.PaintCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandController {
  private static final Logger log = LoggerFactory.getLogger(CommandController.class);
  private final CommandFactory CommandMaker;
  private final PaintCanvas Canvas;

  public CommandController(CommandFactory _CommandFactory, PaintCanvas _Canvas){
    this.CommandMaker = _CommandFactory;
    this.Canvas = _Canvas;
  }

  public void pressedAt(Point Start, Point End){
    Command cmd = CommandMaker.MakeCommand(Start, End);
    cmd.run();
    Canvas.repaint();
  }

  public void undo(){
    if(CommandHistory.undo()){
      Canvas.repaint();
    }
  }

  public void redo(){
    if(CommandHistory.redo()){
      Canvas.repaint();
    }
  }

}
