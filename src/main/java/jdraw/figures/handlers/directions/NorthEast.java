package jdraw.figures.handlers.directions;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class NorthEast implements Direction {
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x + f.getBounds().width, f.getBounds().y);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();
    if (r.y + r.height < y + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof SouthEast)
          hCtx.setDirection(new NorthEast());
      }
      ctx.setDirection(new SouthEast());
    }
    if (r.x > x + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof NorthWest)
          hCtx.setDirection(new NorthEast());
      }
      ctx.setDirection(new NorthWest());
    }
    f.setBounds(new Point(r.x, y), new Point(x, r.y + r.height));
  }

  @Override
  public String toString() {
    return "NorthEast";
  }
}
