package model.region;

public class RegionChecker {
  private static boolean between(int start, int middle, int end){
    return ((start <= middle) && (middle <= end));
  }

  public static boolean areIntersecting(Region a, Region b){
    boolean withinX = between(b.Start.x, a.Start.x, b.End.x) || between(b.Start.x, a.End.x, b.End.x);
    boolean withinY = between(b.Start.y, a.Start.y, b.End.y) || between(b.Start.y, a.End.y, b.End.y);
    return withinX && withinY;
  }
}
