package model.groups;

import java.awt.Graphics2D;
import model.interfaces.IComponent;
import model.interfaces.IGroup;
import model.region.Region;

import java.util.ArrayList;
import view.gui.Frame;

public class GroupImpl implements IComponent, IGroup {
    private final ArrayList<IComponent> ComponentList = new ArrayList<>();

    public GroupImpl(ArrayList<IComponent> list){
        ComponentList.addAll(list);
    }

    public IComponent copy(){
       GroupImpl Group = new GroupImpl(new ArrayList<>());
       for (IComponent component : ComponentList){
           Group.ComponentList.add(component.copy());
       }
       return Group;
    }

    public void unwind(){
        Frame.removeFromFrame(this);
        for (IComponent component : ComponentList){
            Frame.addToFrame(component);
        }
    }

    public void rewind(){
        Frame.addToFrame(this);
        for (IComponent component : ComponentList){
            Frame.removeFromFrame(component);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        for (IComponent component : ComponentList){
            component.draw(graphics);
        }
    }

    @Override
    public void drawSelection(Graphics2D graphics) {
        for (IComponent component : ComponentList){
            component.drawSelection(graphics);
        }
    }

    @Override
    public void move(int xChange, int yChange) {
        for (IComponent component : ComponentList){
            component.move(xChange, yChange);
        }
    }

    @Override
    public boolean intersects(Region r) {
        for (IComponent component : ComponentList){
            if (component.intersects(r)){
                return true;
            }
        }
        return false;
    }
}
