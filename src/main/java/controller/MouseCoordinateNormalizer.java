package controller;

import controller.MouseHandler;
import java.awt.Color;
import java.awt.Graphics2D;
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
      returnArray[1] = _startY;
      returnArray[3] = _endY;
    }else{
      returnArray[1] = _endY;
      returnArray[3] = _startY;
    }
    if (_startX > _endX){
      returnArray[0] = _startX;
      returnArray[2] = _endX;
    }else{
      returnArray[0] = _endX;
      returnArray[2] = _startX;
    }
    return returnArray;
    //log.debug(nTopX +" "+ nTopY +" "+ nBottomX +" "+ nBottomY);
  }

}
//if (_startY > _endY){
//    nTopY = _startY;
//    nBottomY = _endY;
//    if (_startX > _endX){
//    nTopX = _startX;
//    nBottomX = _endX;
//    }else{
//    nTopX = _endX;
//    nBottomX = _startX;
//    }
//    }else{
//    nTopY = _endY;
//    nBottomY = _startY;
//    if (_startX > _endX){
//    nTopX = _startX;
//    nBottomX = _endX;
//    }else{
//    nTopX = _endX;
//    nBottomX = _startX;
//    }
//    }