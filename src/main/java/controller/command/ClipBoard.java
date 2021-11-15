package controller.command;

import controller.interfaces.Command;
import java.util.Stack;
import model.interfaces.IComponent;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class ClipBoard implements Command {
  public static final Stack<IComponent> currentClipBoard = new Stack<>();
  public static int offset;
  private final static int step = 25;

  public ClipBoard(){
    currentClipBoard.clear();
    currentClipBoard.addAll(Frame.SelectionStack);
  }

  @Override
  public void run(){
    offset = 25;
  }

  public static void incOffset(){
    offset += step;
  }

  public static void decOffset(){
    offset -= step;
  }

}
