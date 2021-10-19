package controller;
import controller.command.CommandHistory;
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
    int[] nP = MouseCoordinateNormalizer.normalizeCords(Start.x, Start.y, End.x, End.y);
    switch(Choices.getActiveMouseMode()){
      case DRAW:
        drawAt(nP);
        break;
      case MOVE:
        moveSelection(End.x-Start.x, End.y-Start.y);
        break;
      case SELECT:
        selectAt(nP);
        break;
    }
  }

  public void drawAt(int[] nP){
    CommandMaker.MakeDrawCommand(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
    Canvas.repaint();
  }

  public void selectAt(int[] nP){
    this.currentSelection = new Selection(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
  }

  public void moveSelection(int xChange, int yChange){
    if (currentSelection.SelectionList.isEmpty()) return;
    CommandMaker.MakeMoveCommand(xChange, yChange, currentSelection);
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
