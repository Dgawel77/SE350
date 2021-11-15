package controller.command;

import controller.interfaces.Command;
import java.util.ArrayList;
import model.interfaces.IComponent;
import view.gui.Frame;

public class ClipBoard implements Command {
  public static final ArrayList<IComponent> currentClipBoard = new ArrayList<>();
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
