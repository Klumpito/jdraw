package jdraw.figures.handlers.locations;

import jdraw.figures.Line;
import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class LineStart implements Location {
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
  public void resize(int x, int y, Figure f) {
    Rectangle r = f.getBounds();
    f.setBounds(new Point(x, y), new Point(r.x + r.width, r.y + r.height));
  }

  @Override
  public String toString() {
    return "LineStart";
  }
}
