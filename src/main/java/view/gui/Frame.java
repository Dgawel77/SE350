package view.gui;

import controller.command.SelectionCommand;
import java.util.Stack;
import model.interfaces.IShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
  public static final Stack<IShape> IShapeStack = new Stack<>();
  private static final Logger log = LoggerFactory.getLogger(Frame.class);

  public static boolean addToFrame(IShape _shape){
    IShapeStack.push(_shape);
    return true;
  }

  public static boolean removeFromFrame(){
    boolean result = !IShapeStack.empty();
    if (result) {
      IShape removed = IShapeStack.pop();
      SelectionCommand.Select.SelectionList.remove(removed);
    }
    return result;
  }

}
