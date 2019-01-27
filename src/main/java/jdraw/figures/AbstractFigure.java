package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Standard implementation for the Figure.
 *
 * @author Tobias Wilcke
 */
public abstract class AbstractFigure implements Figure {
  /**
   * Use the java.awt.Rectangle in order to save/reuse code.
   */
  final Rectangle bounds;
  private List<FigureListener> listeners;
  List<FigureHandle> handles;

  /**
   * Create a new figure of the given dimension.
   *
   * @param x the x-coordinate of the upper left corner of the figure
   * @param y the y-coordinate of the upper left corner of the figure
   * @param w the figure's width
   * @param h the figure's height
   */
  AbstractFigure(int x, int y, int w, int h) {
    this.bounds = new Rectangle(x, y, w, h);
    this.listeners = new ArrayList<>();
    this.handles = new ArrayList<>();
    addHandles();
  }

  AbstractFigure(Point p1, Point p2) {
    this(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
  }

  @Override
  abstract public void draw(Graphics g);

  @Override
  public void setBounds(Point origin, Point corner) {
    Point original_origin = new Point(bounds.x, bounds.y);
    Point original_corner = new Point(bounds.x + bounds.width, bounds.y + bounds.height);
    if (!origin.equals(original_origin) || !corner.equals(original_corner)) {
      bounds.setFrameFromDiagonal(origin, corner);
      notifyAllFigureListners();
    }
  }

  @Override
  public void move(int dx, int dy) {
    if (dx != 0 || dy != 0) {
      bounds.setLocation(bounds.x + dx, bounds.y + dy);
      notifyAllFigureListners();
    }
  }

  @Override
  abstract public boolean contains(int x, int y);

  abstract void addHandles();

  @Override
  public Rectangle getBounds() {
    return bounds.getBounds();
  }

  /**
   * Returns a list of 8 handles for this Oval.
   *
   * @return all handles that are attached to the targeted figure.
   * @see jdraw.framework.Figure#getHandles()
   */@Override
  public List<FigureHandle> getHandles() {
    return new ArrayList<>(handles);
  }

  @Override
  public void addFigureListener(FigureListener listener) {
    listeners.add(listener);
  }

  @Override
  public void removeFigureListener(FigureListener listener) {
    listeners.remove(listener);
  }

  @Override
  public Figure clone() {
    return null;
  }

  /**
   * Notifies all currently registered FigureListeners.
   */
  void notifyAllFigureListners() {
    List<FigureListener> ls = new ArrayList<>(listeners);
    ls.forEach(l -> l.figureChanged(new FigureEvent(this)));
  }
}
