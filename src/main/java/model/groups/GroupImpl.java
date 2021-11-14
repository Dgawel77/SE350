package model.groups;

import model.interfaces.IComponent;
import model.region.Region;

import java.awt.*;
import java.util.ArrayList;

public class GroupImpl implements IComponent{
    private ArrayList<IComponent> ComponentList = new ArrayList<>();

    public GroupImpl(){

    }

    @Override
    public void draw(Graphics2D graphics) {

    }

    @Override
    public void drawSelection(Graphics2D graphics) {

    }

    @Override
    public void move(int xChange, int yChange) {

    }

    @Override
    public boolean intersects(Region r) {
        return false;
    }
}
