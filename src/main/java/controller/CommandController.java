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
    drawAt(Start, End);
  }

  public void drawAt(Point Start, Point End){
    int[] nP = MouseCoordinateNormalizer.normalizeCords(Start.x, Start.y, End.x, End.y);
    CommandMaker.MakeDrawCommand(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
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
