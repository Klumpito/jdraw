package jdraw.figures.handlers.locations;

import jdraw.figures.Rect;
import jdraw.framework.Figure;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class East implements Location{
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x + f.getBounds().width, f.getBounds().y + (f.getBounds().height / 2));
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f) {
    Rectangle r = f.getBounds();
    f.setBounds(new Point(r.x, r.y), new Point(x, r.y + r.height));
  }

  @Override
  public String toString() {
    return "East";
  }
}
