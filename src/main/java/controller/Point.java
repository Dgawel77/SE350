package controller;

public class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o){
    return (this.x == ((Point)o).x) && (this.y == ((Point)o).y);
  }

}
