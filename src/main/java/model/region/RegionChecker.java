package model.region;

public class RegionChecker {
  private static boolean between(int start, int middle, int end){
    return ((start <= middle) && (middle <= end));
  }

  public static boolean areIntersecting(Region a, Region b){
    boolean withinX = between(b.sx, a.sx, b.ex) || between(b.sx, a.ex, b.ex);
    boolean withinY = between(b.sy, a.sy, b.ey) || between(b.sy, a.ey, b.ey);
    return withinX && withinY;
  }
}
