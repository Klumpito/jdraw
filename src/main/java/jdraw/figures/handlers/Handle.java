package jdraw.figures.handlers;

import jdraw.figures.handlers.locations.Location;
import jdraw.framework.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * This represents the handles of the rect figure.
 *
 * @author Tobias Wilcke
 */
public class Handle implements FigureHandle, FigureListener {

  /**
   * Holds the central x-,y-coordinates of the handle.
   */
  final Location LOCATION;

  /**
   * Holds the owning figure.
   */
  final Figure OWNER;

  /**
   * Holds the the bounds of the handle.
   */
  private Rectangle bounds;

  public Handle(Figure owner, Location location) {
    LOCATION = location;
    OWNER = owner;
    OWNER.addFigureListener(this);
    setBounds(location, owner);
  }

  @Override
  public Figure getOwner() {
    return OWNER;
  }

  @Override
  public Point getLocation() {
    return LOCATION.getPoint(OWNER);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    g.setColor(Color.BLACK);
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

  }

  @Override
  public Cursor getCursor() {
    return LOCATION.getCursor();
  }

  @Override
  public boolean contains(int x, int y) {
    return bounds.contains(x, y);
  }

  @Override
  public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
  }

  @Override
  public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
    LOCATION.resize(x, y, OWNER);
  }

  @Override
  public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
  }

  @Override
  public void figureChanged(FigureEvent e) {
    setBounds(LOCATION, OWNER);
  }

  /**
   * Setting the bounds based on location on the owner.
   */
  private void setBounds(Location l, Figure f) {
    Point p = l.getPoint(f);
    bounds = new Rectangle(p.x - 3, p.y - 3, 6, 6);
  }
}
