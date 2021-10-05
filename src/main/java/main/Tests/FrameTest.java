package main.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import model.interfaces.IShape;
import org.junit.jupiter.api.Test;
import view.gui.Frame;
import model.shapes.Rectangle;

class FrameTest {
  @Test
  void Demo(){
    IShape draw = new Rectangle(10, 10, 10, 10, Color.BLACK);
    Frame.addToFrame(draw);
    assertEquals(Frame.IShapeStack.pop(), draw);
  }
}