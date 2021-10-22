package controller;
import controller.command.CommandHistory;
import controller.interfaces.Command;
import controller.selection.Selection;
import model.persistence.UserChoicesImpl;
import view.gui.PaintCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandController {
  private static final Logger log = LoggerFactory.getLogger(CommandController.class);
  private final CommandFactory CommandMaker;
  private final PaintCanvas Canvas;
  private final UserChoicesImpl Choices;
  private Selection currentSelection;

  public CommandController(CommandFactory _CommandFactory, PaintCanvas _Canvas, UserChoicesImpl _Choices){
    this.CommandMaker = _CommandFactory;
    this.Canvas = _Canvas;
    this.Choices = _Choices;
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
