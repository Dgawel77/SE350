package controller.command;

import controller.interfaces.Command;
import model.interfaces.IComponent;
import model.region.Region;
import view.gui.Frame;

public class SelectionCommand implements Command {
    private final Region region;

    public SelectionCommand(Region region){
        this.region = region;
    }

    public void run(){
        Frame.SelectionStack.clear();
        for(IComponent component : Frame.ShapeStack){
            if (component.intersects(region)){
                Frame.SelectionStack.add(component);
            }
        }
    }

}
