package jdraw.figures.handlers.locations;

import jdraw.figures.handlers.HandelContext;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

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
  public void resize(int x, int y, Figure f, HandelContext ctx) {
    Rectangle r = f.getBounds();
    if (r.x > x + 1) {
      for (FigureHandle fh : f.getHandles()) {
        HandelContext hCtx = (HandelContext) fh;
        if (hCtx.getDirection() instanceof West)
          hCtx.setDirection(new East());
      }
      ctx.setDirection(new West());
    }
    f.setBounds(new Point(r.x, r.y), new Point(x, r.y + r.height));
  }

  @Override
  public String toString() {
    return "East";
  }
}
