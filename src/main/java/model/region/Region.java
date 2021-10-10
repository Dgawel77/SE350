package model.region;

public class Region {
  int sx;
  int sy;
  int ex;
  int ey;

  public Region(int x, int y, int width, int height) {
    this.sx = x;
    this.sy = y;
    this.ex = x + width;
    this.ey = y + height;
  }
}
