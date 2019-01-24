package jdraw.figures.handlers.locations;

import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class North implements Location{
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x + (f.getBounds().width/2), f.getBounds().y);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f) {
    Rectangle r = f.getBounds();
    f.setBounds(new Point(r.x, y), new Point(r.x + r.width, r.y + r.height));
  }

  @Override
  public String toString() {
    return "North";
  }
}
