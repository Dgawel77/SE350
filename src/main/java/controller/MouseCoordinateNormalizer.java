package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MouseCoordinateNormalizer {
  private static final Logger log = LoggerFactory.getLogger(MouseCoordinateNormalizer.class);

  public static void normalizeCords(Point start, Point end){
    int tmp;
    if (start.y > end.y){
      tmp = start.y;
      start.y = end.y;
      end.y = tmp;
    }
    if (start.x > end.x){
      tmp = start.x;
      start.x = end.x;
      end.x = tmp;
    }
  }

}