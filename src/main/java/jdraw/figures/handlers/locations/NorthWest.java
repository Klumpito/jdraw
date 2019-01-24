package jdraw.figures.handlers.locations;

import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class NorthWest implements Location{
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x, f.getBounds().y);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f) {
    Rectangle r = f.getBounds();
    f.setBounds(new Point(x, y), new Point(r.x + r.width, r.y + r.height));
  }

  @Override
  public String toString() {
    return "NorthWest";
  }
}
