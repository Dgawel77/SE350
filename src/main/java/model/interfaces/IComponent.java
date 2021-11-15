package model.interfaces;

import model.region.Region;
import java.awt.*;

public interface IComponent {
    void unwind();
    void rewind();
    IComponent copy();
    void draw(Graphics2D graphics);
    void drawSelection(Graphics2D graphics);
    void move(int xChange, int yChange);
    boolean intersects(Region r);
}
