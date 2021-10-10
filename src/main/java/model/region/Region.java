package model.region;

import controller.Point;

public class Region {
  Point Start;
  Point End;

  public Region(int x, int y, int width, int height) {
    this.Start = new Point(x, y);
    this.End = new Point(x+width, y+height);
  }
}
