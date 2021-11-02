package controller.selection;

import java.util.ArrayList;
import model.interfaces.IShape;
import model.region.Region;
import view.gui.Frame;

public class Selection {
  public ArrayList<IShape> SelectionList = new ArrayList<>();

  public Selection(Region region){
    for(IShape shape : Frame.IShapeStack){
      if (region.intersects(shape.getRegion())){
        SelectionList.add(shape);
      }
    }
  }

  public Selection(Selection select){
    this.SelectionList = new ArrayList<>(select.SelectionList);
  }

  public void print(){
    System.out.println("length is " + SelectionList.size());
    for(IShape shape : SelectionList){
      System.out.println(shape);
    }
  }

}
