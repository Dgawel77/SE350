package model.interfaces;

public interface IShape {
    int getWidth();
    int getHeight();
    int getX();
    int getY();
    void setDrawOutline(IStrategy drawOutline);
    void setDrawFilled(IStrategy drawFilled);
    void setDrawSelection(IStrategy drawSelection);
}
