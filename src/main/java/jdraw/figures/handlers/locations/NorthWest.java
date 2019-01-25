package jdraw.figures.handlers.locations;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

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
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();

    if (r.x + r.width < x + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof NorthEast)
          hCtx.setDirection(new NorthWest());
      }
      ctx.setDirection(new NorthEast());
    }

    if (r.y + r.height < y + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof SouthWest)
          hCtx.setDirection(new NorthWest());
      }
      ctx.setDirection(new SouthWest());
    }
    f.setBounds(new Point(x, y), new Point(r.x + r.width, r.y + r.height));
  }

  @Override
  public String toString() {
    return "NorthWest";
  }
}
