package jdraw.figures.handlers.locations;

import jdraw.framework.Figure;

import java.awt.*;

/**
 * The Location Interface defines each of the states a figure handle can possess.
 *
 * @author Tobias Wilcke
 */
public interface Location {
  Point getPoint(Figure f);
  Cursor getCursor();
  void resize(int x, int y, Figure f);
}
