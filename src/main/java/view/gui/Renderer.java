package view.gui;

import controller.command.SelectionCommand;
import java.awt.Graphics2D;
import model.interfaces.IShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Renderer {
  private static final Logger log = LoggerFactory.getLogger(Renderer.class);

  public static void render(Graphics2D graphics){
    for(IShape shape: Frame.IShapeStack){
      shape.draw(graphics);
    }
    for(IShape shape: SelectionCommand.Select.SelectionList){
      System.out.println("draw outline");
      shape.drawSelection(graphics);
    }
  }
}
