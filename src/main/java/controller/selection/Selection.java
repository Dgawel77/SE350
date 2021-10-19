package controller.selection;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.IShape;
import model.region.Region;
import view.gui.Frame;

public class Selection {
  public List<IShape> SelectionList = new ArrayList<>();

  public Selection(int x, int y, int width, int height){
    Region selectionRegion = new Region(x, y, width, height);
    for(IShape shape : Frame.IShapeStack){
      if (selectionRegion.intersects(shape.getRegion())){
        SelectionList.add(shape);
      }
    }
  }

  public void print(){
    System.out.println("length is " + SelectionList.size());
    for(IShape shape : SelectionList){
      System.out.println(shape);
    }
  }

}
