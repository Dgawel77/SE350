package view.gui;

import java.util.Stack;
import model.shapes.ShapeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
  public static final Stack<ShapeImpl> ShapeStack = new Stack<>();
  public static final Stack<ShapeImpl> SelectionStack = new Stack<>();

  private static final Logger log = LoggerFactory.getLogger(Frame.class);

  public static boolean addToFrame(ShapeImpl _shape){
    ShapeStack.push(_shape);
    return true;
  }

  public static boolean removeFromFrame(){
    boolean result = !ShapeStack.empty();
    if (result) {
      ShapeImpl removed = ShapeStack.pop();
      SelectionStack.remove(removed);
    }
    return result;
  }

}
