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
  /*
  if (_startY > _endY){
    returnArray[1] = _endY;
    returnArray[3] = _startY;
  }else{
    returnArray[1] = _startY;
    returnArray[3] = _endY;
  }
    if (_startX > _endX){
    returnArray[0] = _endX;
    returnArray[2] = _startX;
  }else{
    returnArray[0] = _startX;
    returnArray[2] = _endX;
  }*/

}