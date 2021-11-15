package controller.command;

import controller.interfaces.Command;
import model.interfaces.IComponent;
import model.region.Region;
import view.gui.Frame;

public class SelectionCommand implements Command {
    private Region region;

    public SelectionCommand(Region region){
        this.region = region;
    }

    public void run(){
        Frame.SelectionStack.clear();
        for(IComponent shape : Frame.ShapeStack){
            if (shape.intersects(region)){
                Frame.SelectionStack.add(shape);
            }
        }
    }

}
