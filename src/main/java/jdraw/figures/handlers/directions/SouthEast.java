package jdraw.figures.handlers.directions;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class SouthEast implements Direction {
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x + f.getBounds().width, f.getBounds().y + f.getBounds().height);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();
    if (r.x > x + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof SouthWest)
          hCtx.setDirection(new SouthEast());
      }
      ctx.setDirection(new SouthWest());
    }
    if (r.y > y + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof NorthEast)
          hCtx.setDirection(new SouthEast());
      }
      ctx.setDirection(new NorthEast());
    }
    f.setBounds(new Point(r.x, r.y), new Point(x, y));
  }

  @Override
  public String toString() {
    return "SouthEast";
  }
}
