package jdraw.std.grids;

import jdraw.framework.DrawGrid;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class SnapGrid extends AbstractGrid {
  private final int stepSize;

  public SnapGrid(int stepSize) {
    this.stepSize = stepSize;
  }

  @Override
  public Point constrainPoint(Point p) {
    return new Point((int) (stepSize * Math.floor(p.x / stepSize)), (int) (stepSize * Math.floor(p.y / stepSize)));
  }

  @Override
  public int getStepX(boolean right) {
    return stepSize;
  }

  @Override
  public int getStepY(boolean down) {
    return stepSize;
  }
}
