package controller.command;

import controller.interfaces.Command;
import controller.selection.Selection;

public class SelectionCommand implements Command {
    public static Selection Select = new Selection(0, 0, 0, 0);
    private int x;
    private int y;
    private int width;
    private int height;

    public SelectionCommand(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void run(){
        Select = new Selection(x, y, width, height);
    }

}
