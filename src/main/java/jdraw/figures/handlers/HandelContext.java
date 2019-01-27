package jdraw.figures.handlers;

import jdraw.figures.handlers.directions.Direction;

/**
 * @author Tobias Wilcke
 */
public interface HandelContext {
  void setDirection(Direction direction);
  Direction getDirection();
}
