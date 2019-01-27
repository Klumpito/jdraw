package jdraw.figures.handlers.directions;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class West implements Direction {
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x, f.getBounds().y + (f.getBounds().height / 2));
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();
    if (r.x + r.width < x + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof East)
          hCtx.setDirection(new West());
      }
      ctx.setDirection(new East());
    }
    f.setBounds(new Point(x, r.y), new Point(r.x + r.width, r.y + r.height));
  }

  @Override
  public String toString() {
    return "West";
  }
}
