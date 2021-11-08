package controller.command;

import controller.interfaces.Command;
import model.region.Region;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class SelectionCommand implements Command {
    private Region region;

    public SelectionCommand(Region region){
        this.region = region;
    }

    public void run(){
        Frame.SelectionStack.clear();
        for(ShapeImpl shape : Frame.ShapeStack){
            if (region.intersects(shape.region)){
                Frame.SelectionStack.add(shape);
            }
        }
    }

}
