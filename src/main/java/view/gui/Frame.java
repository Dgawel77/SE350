package view.gui;

import controller.command.SelectionCommand;
import java.util.Stack;
import model.shapes.ShapeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
  public static final Stack<ShapeImpl> IShapeStack = new Stack<>();
  private static final Logger log = LoggerFactory.getLogger(Frame.class);

  public static boolean addToFrame(ShapeImpl _shape){
    IShapeStack.push(_shape);
    return true;
  }

  public static boolean removeFromFrame(){
    boolean result = !IShapeStack.empty();
    if (result) {
      ShapeImpl removed = IShapeStack.pop();
      SelectionCommand.currentSelect.SelectionList.remove(removed);
    }
    return result;
  }

}
