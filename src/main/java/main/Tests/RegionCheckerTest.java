package main.Tests;

import static org.junit.jupiter.api.Assertions.*;

import model.region.Region;
import org.junit.jupiter.api.Test;

class RegionCheckerTest {

  @Test
  void areIntersecting() {
    Region Region1 = new Region(100, 100, 100, 100);
    Region Region2 = new Region(100, 100, 100, 100);
    assertTrue(Region1.intersects(Region2));
    assertTrue(Region2.intersects(Region1));

    Region Region3 = new Region(210, 210, 100, 100);
    assertFalse(Region1.intersects(Region3));
    assertFalse(Region3.intersects(Region1));

    Region Region4 = new Region(10, 10, 100, 100);
    assertTrue(Region1.intersects(Region4));
    assertTrue(Region4.intersects(Region1));

    Region Region5 = new Region(110, 110, 100, 100);
    assertTrue(Region1.intersects(Region5));
    assertTrue(Region5.intersects(Region1));

    Region Region6 = new Region(100, 10, 100, 100);
    assertTrue(Region1.intersects(Region6));
    assertTrue(Region6.intersects(Region1));

    Region Region7 = new Region(150, 150, 100, 100);
    assertTrue(Region1.intersects(Region7));
    assertTrue(Region7.intersects(Region1));

    Region Region8 = new Region(0, 0, 500, 10);
    assertFalse(Region1.intersects(Region8));
    assertFalse(Region8.intersects(Region1));

    Region Region9 = new Region(150, 0, 20, 200);
    assertTrue(Region1.intersects(Region9));
    assertTrue(Region9.intersects(Region1));
  }
}
