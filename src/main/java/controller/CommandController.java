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

  public void drawAt(int _startX, int _startY, int _endX, int _endY){
    int[] nP = MouseCoordinateNormalizer.normalizeCords(_startX, _startY, _endX, _endY);
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
