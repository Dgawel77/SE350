package main.Tests;

import static org.junit.jupiter.api.Assertions.*;

import model.region.Region;
import model.region.RegionChecker;
import org.junit.jupiter.api.Test;

class RegionCheckerTest {

  @Test
  void areIntersecting() {
    Region Region1 = new Region(100, 100, 100, 100);
    Region Region2 = new Region(100, 100, 100, 100);
    assertTrue(RegionChecker.areIntersecting(Region1, Region2));
    assertTrue(RegionChecker.areIntersecting(Region2, Region1));

    Region Region3 = new Region(210, 210, 100, 100);
    assertFalse(RegionChecker.areIntersecting(Region1, Region3));
    assertFalse(RegionChecker.areIntersecting(Region3, Region1));

    Region Region4 = new Region(10, 10, 100, 100);
    assertTrue(RegionChecker.areIntersecting(Region1, Region4));
    assertTrue(RegionChecker.areIntersecting(Region4, Region1));

    Region Region5 = new Region(110, 110, 100, 100);
    assertTrue(RegionChecker.areIntersecting(Region1, Region5));
    assertTrue(RegionChecker.areIntersecting(Region5, Region1));

    Region Region6 = new Region(100, 10, 100, 100);
    assertTrue(RegionChecker.areIntersecting(Region1, Region6));
    assertTrue(RegionChecker.areIntersecting(Region6, Region1));

    Region Region7 = new Region(150, 150, 100, 100);
    assertTrue(RegionChecker.areIntersecting(Region1, Region7));
    assertTrue(RegionChecker.areIntersecting(Region7, Region1));

    Region Region8 = new Region(0, 0, 500, 10);
    assertFalse(RegionChecker.areIntersecting(Region1, Region8));
    assertFalse(RegionChecker.areIntersecting(Region8, Region1));
  }
}
