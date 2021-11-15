package controller;

import controller.command.CommandHistory;
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
    CommandMaker.MakeCommand(Start, End).run();
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

  public void copy(){
    CommandMaker.MakeCopyCommand().run();
  }

  public void paste(){
    CommandMaker.MakePasteCommand().run();
    Canvas.repaint();
  }

  public void delete(){
    CommandMaker.MakeDeleteCommand().run();
    Canvas.repaint();
  }

  public void group(){
    CommandMaker.MakeGroupCommand().run();
    Canvas.repaint();
  }

  public void ungroup(){
    CommandMaker.MakeUnGroupCommand().run();
    Canvas.repaint();
  }

}
