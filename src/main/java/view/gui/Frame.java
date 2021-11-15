package view.gui;

import java.util.Stack;
import model.interfaces.IComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
  public static final Stack<IComponent> ShapeStack = new Stack<>();
  public static final Stack<IComponent> SelectionStack = new Stack<>();

  private static final Logger log = LoggerFactory.getLogger(Frame.class);

  public static void addToFrame(IComponent _shape){
    ShapeStack.push(_shape);
  }

  public static void removeFromFrame(IComponent component){
    boolean result = !ShapeStack.empty();
    if (result) {
      ShapeStack.remove(component);
      SelectionStack.remove(component);
    }
  }

}
