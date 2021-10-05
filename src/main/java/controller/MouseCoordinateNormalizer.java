package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MouseCoordinateNormalizer {
  private static final Logger log = LoggerFactory.getLogger(MouseCoordinateNormalizer.class);
  //0 nTopX
  //1 nTopY
  //2 nBottomX
  //3 nBottomY

  public static int[] normalizeCords(int _startX, int _startY, int _endX, int _endY){
    int[] returnArray = new int[4];
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
    }
    return returnArray;
  }

}