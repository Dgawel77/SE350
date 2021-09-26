package controller;
import controller.command.CommandHistory;
import model.interfaces.IShape;
import view.gui.PaintCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.ShapeFactory;


public class CommandController {
  private static final Logger log = LoggerFactory.getLogger(CommandController.class);
  private final ShapeFactory ShapeMaker;
  private final PaintCanvas Canvas;

  public CommandController(ShapeFactory _ShapeFactory, PaintCanvas _Canvas){
    this.ShapeMaker = _ShapeFactory;
    this.Canvas = _Canvas;
  }

  public void drawAt(int _startX, int _startY, int _endX, int _endY){
    int[] nP = MouseCoordinateNormalizer.normalizeCords(_startX, _startY, _endX, _endY);
    IShape shape = ShapeMaker.makeShape(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
    CommandHistory.add(new DrawCommand(shape));
    view.gui.Frame.addToFrame(shape);
    Canvas.repaint();
  }

}
