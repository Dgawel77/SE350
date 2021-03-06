package model.region;

import controller.Point;

public class Region {
  public Point Start;
  public Point End;

  public Region(Point Start, Point End){
    this.Start = Start;
    this.End = End;
  }

  public Region(Region r) {
    this.Start = new Point(r.Start);
    this.End = new Point(r.End);
  }

  public boolean intersects(Region r){
    if (this.Start.x > r.End.x || r.Start.x > this.End.x)
      return false;
    if (this.End.y < r.Start.y || r.End.y < this.Start.y)
      return false;
    return true;
  }

  public void move(int xChange, int yChange){
    Start.x += xChange;
    Start.y += yChange;
    End.x += xChange;
    End.y += yChange;
  }

}
