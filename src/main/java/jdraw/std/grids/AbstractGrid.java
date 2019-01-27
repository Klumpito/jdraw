package jdraw.std.grids;

import jdraw.framework.DrawGrid;

import java.awt.*;

/**
 * Simply a boilerplate class to hold all the unused interface methods.
 *
 * @author Tobias Wilcke
 */
public abstract class AbstractGrid implements DrawGrid {
  @Override
  abstract public Point constrainPoint(Point p);

  @Override
  abstract public int getStepX(boolean right);

  @Override
  abstract public int getStepY(boolean down);

  @Override
  public void activate() {

  }

  @Override
  public void deactivate() {

  }

  @Override
  public void mouseDown() {

  }

  @Override
  public void mouseUp() {

  }
}
