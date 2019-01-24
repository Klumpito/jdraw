package jdraw.figures.handlers.locations;

import jdraw.figures.Line;
import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class LineEnd implements Location {
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
  public void resize(int x, int y, Figure f) {
    Rectangle r = f.getBounds();
    f.setBounds(new Point(r.x, r.y), new Point(x, y));
  }

  @Override
  public String toString() {
    return "LineEnd";
  }
}
