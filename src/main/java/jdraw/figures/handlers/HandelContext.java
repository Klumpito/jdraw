package jdraw.figures.handlers;

import jdraw.figures.handlers.locations.Location;

/**
 * @author Tobias Wilcke
 */
public interface HandelContext {
  void setDirection(Location direction);
  Location getDirection();
}
