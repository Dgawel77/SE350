package controller.command;

import controller.interfaces.Command;
import controller.selection.Selection;
import model.region.Region;

public class SelectionCommand implements Command {
    public static Selection currentSelect = new Selection(new Region(-100, -100, 0, 0));
    private Region region;

    public SelectionCommand(Region region){
        this.region = region;
    }

    public void run(){
        currentSelect = new Selection(region);
    }

}
