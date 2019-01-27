package jdraw.figures;

import jdraw.figures.handlers.Handle;
import jdraw.figures.handlers.locations.NorthEast;
import jdraw.figures.handlers.locations.NorthWest;
import jdraw.figures.handlers.locations.SouthEast;
import jdraw.figures.handlers.locations.SouthWest;
import jdraw.framework.Figure;

import java.awt.*;
import java.util.List;

/**
 * @author Tobias Wilcke
 */
public class CompositeFigureImpl extends AbstractFigure implements CompositeFigure {
  private final List<Figure> figures;

  public CompositeFigureImpl(List<Figure> figures) {
    super(calcTopLeft(figures), calcBottomRight(figures));
    this.figures = figures;
  }

  @Override
  public void draw(Graphics g) {
    figures.forEach(figure -> figure.draw(g));
  }

  @Override
  public boolean contains(int x, int y) {
    return bounds.contains(x, y);
  }

  @Override
  public void setBounds(Point origin, Point corner) {
    // won't be changed
  }

  @Override
  public void move(int dx, int dy) {
    if (dx != 0 || dy != 0) {
      bounds.setLocation(bounds.x + dx, bounds.y + dy);
      figures.forEach(f -> f.move(dx, dy));
      notifyAllFigureListners();
    }
  }

  @Override
  void addHandles() {
    handles.add(new Handle(this, new NorthWest(), Color.GRAY));
    handles.add(new Handle(this, new NorthEast(), Color.GRAY));
    handles.add(new Handle(this, new SouthWest(), Color.GRAY));
    handles.add(new Handle(this, new SouthEast(), Color.GRAY));
  }

  /**
   * Loops through all figures and finds the top left corner point.
   *
   * @param figures
   * @return the point closest to the top left corner.
   */
  private static Point calcTopLeft(List<Figure> figures) {
    int x = Integer.MAX_VALUE;
    int y = Integer.MAX_VALUE;
    for (Figure f : figures) {
      Rectangle b = f.getBounds();
      if (x > b.getMinX())
        x = (int) b.getMinX();
      if (y > b.getMinY())
        y = (int) b.getMinY();
    }

    return new Point(x, y);
  }

  private static Point calcBottomRight(List<Figure> figures) {
    int x = Integer.MIN_VALUE;
    int y = Integer.MIN_VALUE;
    for (Figure f : figures) {
      Rectangle b = f.getBounds();
      if (x < b.getMaxX())
        x = (int) b.getMaxX();
      if (y < b.getMaxY())
        y = (int) b.getMaxY();
    }

    return new Point(x, y);
  }

  @Override
  public List<Figure> getFigures() {
    return figures;
  }
}
