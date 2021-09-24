package controller;
import view.gui.PaintCanvas;
import controller.MouseCoordinateNormalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommandController {
  private static final Logger log = LoggerFactory.getLogger(CommandController.class);
  private PaintCanvas canvas;

  public CommandController(PaintCanvas _paintCanvas){
    this.canvas = _paintCanvas;
  }

  public void drawAt(int _startX, int _startY, int _endX, int _endY){
    int[] nP = MouseCoordinateNormalizer.normalizeCords(_startX, _startY, _endX, _endY);
    log.debug(nP[0] + " " + nP[1] + " " + nP[2] + " " + nP[3]);
    canvas.repaint(nP[0], nP[1], nP[2]-nP[0], nP[3]-nP[1]);
    canvas.repaint();
  }

}
