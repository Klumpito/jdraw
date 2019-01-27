package jdraw.figures.handlers.locations;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;

import java.awt.*;
import java.io.Serializable;

/**
 * The Location Interface defines each of the states a figure handle can possess.
 *
 * @author Tobias Wilcke
 */
public interface Location extends Serializable {
  Point getPoint(Figure f);
  Cursor getCursor();
  void resize(int x, int y, Figure f, HandelContext ctx);
}
