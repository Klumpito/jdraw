package jdraw.figures.handlers.directions;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;

import java.awt.*;
import java.io.Serializable;

/**
 * The Direction Interface defines each of the states a figure handle can possess.
 *
 * @author Tobias Wilcke
 */
public interface Direction extends Serializable {
  Point getPoint(Figure f);
  Cursor getCursor();
  void resize(int x, int y, Figure f, HandelContext ctx);
}
