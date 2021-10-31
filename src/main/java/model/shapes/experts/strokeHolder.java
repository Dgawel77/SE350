package model.shapes.experts;

import java.awt.BasicStroke;

public class strokeHolder {
  public final static BasicStroke dashed =
      new BasicStroke(5.0f,
          BasicStroke.CAP_BUTT,
          BasicStroke.JOIN_MITER,
          10.0f,
          new float[] {10.0f},
          0.0f);

  public final static BasicStroke base =
      new BasicStroke(10.0f,
          BasicStroke.CAP_BUTT,
          BasicStroke.JOIN_MITER,
          10.0f);
}
