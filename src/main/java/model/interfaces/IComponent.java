package model.interfaces;

import model.region.Region;
import java.awt.*;

public interface IComponent {
    boolean selected = false;
    void unwind();
    void rewind();
    IComponent copy();
    void draw(Graphics2D graphics);
    void drawSelection(Graphics2D graphics);
    void move(int xChange, int yChange);
    boolean intersects(Region r);
}
