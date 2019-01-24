package jdraw.figures.handlers.locations;

import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class SouthWest implements Location{
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x, f.getBounds().y + f.getBounds().height);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f) {
    Rectangle r = f.getBounds();
    f.setBounds(new Point(x, r.y), new Point(r.x + r.width, y));
  }

  @Override
  public String toString() {
    return "SouthWest";
  }
}
