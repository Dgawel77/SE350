package view.gui;

import controller.command.SelectionCommand;
import java.awt.Graphics2D;
import model.shapes.ShapeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Renderer {
  private static final Logger log = LoggerFactory.getLogger(Renderer.class);

  public static void render(Graphics2D graphics){
    for(ShapeImpl shape: Frame.IShapeStack){
      shape.draw(graphics);
      if (SelectionCommand.currentSelect.SelectionList.contains(shape)){
        shape.drawSelection(graphics);
      }
    }
  }
}
