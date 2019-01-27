package jdraw.figures.handlers.directions;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class SouthWest implements Direction {
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x, f.getBounds().y + f.getBounds().height);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();
    if (r.y > y + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof NorthWest)
          hCtx.setDirection(new SouthWest());
      }
      ctx.setDirection(new NorthWest());
    }
    if (r.x + r.width < x + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof SouthEast)
          hCtx.setDirection(new SouthWest());
      }
      ctx.setDirection(new SouthEast());
    }
    f.setBounds(new Point(x, r.y), new Point(r.x + r.width, y));
  }

  @Override
  public String toString() {
    return "SouthWest";
  }
}
