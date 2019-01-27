package jdraw.figures.handlers.directions;

import jdraw.figures.Line;
import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class LineEnd implements Direction {
  @Override
  public Point getPoint(Figure f) {
    if (f instanceof Line)
      return new Point(((Line) f).getEndPoint().x, ((Line) f).getEndPoint().y);
    return new Point(f.getBounds().x + f.getBounds().width, f.getBounds().y + f.getBounds().height);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    ((Line) f).setEndPoint(new Point(x, y));
  }

  @Override
  public String toString() {
    return "LineEnd";
  }
}
