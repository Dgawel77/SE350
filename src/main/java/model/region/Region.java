package model.region;

import controller.Point;

public class Region {
  Point Start;
  Point End;

  public Region(int x, int y, int width, int height) {
    this.Start = new Point(x, y);
    this.End = new Point(x+width, y+height);
  }

  public boolean intersects(Region r){
    if (this.Start.x > r.End.x || r.Start.x > this.End.x)
      return false;
    if (this.End.y < r.Start.y || r.End.y < this.Start.y)
      return false;
    return true;
  }
}
