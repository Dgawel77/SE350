package main.Tests;

import static org.junit.jupiter.api.Assertions.*;

import controller.MouseCoordinateNormalizer;
import org.junit.jupiter.api.Test;

class MouseCoordinateNormalizerTest {

  @Test
  void normalizeCords() {
    assertArrayEquals(new int[]{10, 10, 50, 50}, MouseCoordinateNormalizer.normalizeCords(10, 10, 50, 50));
    assertArrayEquals(new int[]{10, 10, 50, 50}, MouseCoordinateNormalizer.normalizeCords(50, 50, 10, 10));
    assertArrayEquals(new int[]{10, 10, 50, 50}, MouseCoordinateNormalizer.normalizeCords(10, 50, 50, 10));
    assertArrayEquals(new int[]{10, 10, 50, 50}, MouseCoordinateNormalizer.normalizeCords(50, 10, 10, 50));
  }
}
