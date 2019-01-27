package jdraw.figures.handlers.directions;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * @author Tobias Wilcke
 */
public class North implements Direction {
  @Override
  public Point getPoint(Figure f) {
    return new Point(f.getBounds().x + (f.getBounds().width / 2), f.getBounds().y);
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
  }

  @Override
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();
    if (r.y + r.height < y + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof South)
          hCtx.setDirection(new North());
      }
      ctx.setDirection(new South());
    }
    f.setBounds(new Point(r.x, y), new Point(r.x + r.width, r.y + r.height));
  }

  @Override
  public String toString() {
    return "North";
  }
}
