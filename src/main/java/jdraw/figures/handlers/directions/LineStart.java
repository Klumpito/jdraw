package jdraw.figures.handlers.directions;

import jdraw.figures.Line;
import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class LineStart implements Direction {
  @Override
  public Point getPoint(Figure f) {
    if (f instanceof Line)
      return new Point(((Line) f).getStartPoint().x, ((Line) f).getStartPoint().y);
    return new Point(f.getBounds().x, f.getBounds().y);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    ((Line) f).setStartPoint(new Point(x, y));
  }

  @Override
  public String toString() {
    return "LineStart";
  }
}
