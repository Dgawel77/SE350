package main.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import model.interfaces.IShape;
import model.region.Region;
import model.shapes.Shape;
import model.shapes.strategies.rectangleStrategy;
import org.junit.jupiter.api.Test;
import view.gui.Frame;

class FrameTest {
  @Test
  void Demo(){
    IShape draw = new Shape(new Region(10, 10, 10, 10), Color.BLACK, new rectangleStrategy());
    Frame.addToFrame(draw);
    assertEquals(Frame.IShapeStack.pop(), draw);
  }
}