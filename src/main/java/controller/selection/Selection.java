package controller.selection;

import java.util.ArrayList;
import model.region.Region;
import model.shapes.ShapeImpl;
import view.gui.Frame;

public class Selection {
  public ArrayList<ShapeImpl> SelectionList = new ArrayList<>();

  public Selection(Region region){
    for(ShapeImpl shape : Frame.IShapeStack){
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
    for(ShapeImpl shape : SelectionList){
      System.out.println(shape);
    }
  }

}
