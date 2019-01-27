package jdraw.figures.handlers;

import jdraw.figures.handlers.locations.Location;
import jdraw.framework.*;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This represents the handles of the rect figure.
 *
 * @author Tobias Wilcke
 */
public class Handle implements FigureHandle, FigureListener, HandelContext {

  /**
   * Holds the central x-,y-coordinates of the handle.
   */
  Location direction;

  /**
   * Holds the owning figure.
   */
  final Figure OWNER;

  /**
   * Holds the color to display the handle.
   */
  private Color color;

  /**
   * Holds the the bounds of the handle.
   */
  private Rectangle bounds;

  public Handle(Figure owner, Location direction) {
    this.direction = direction;
    OWNER = owner;
    OWNER.addFigureListener(this);
    color = Color.white;
    setBounds(direction, owner);
  }

  public Handle(Figure owner, Location direction, Color color) {
    this(owner, direction);
    this.color = color;
  }

  @Override
  public Figure getOwner() {
    return OWNER;
  }

  @Override
  public Point getLocation() {
    return direction.getPoint(OWNER);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    g.setColor(Color.BLACK);
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

  }

  @Override
  public Cursor getCursor() {
    return direction.getCursor();
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
    direction.resize(x, y, OWNER, this);
  }

  @Override
  public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
  }

  @Override
  public void figureChanged(FigureEvent e) {
    setBounds(direction, OWNER);
  }

  /**
   * Setting the bounds based on direction on the owner.
   */
  private void setBounds(Location l, Figure f) {
    Point p = l.getPoint(f);
    bounds = new Rectangle(p.x - 4, p.y - 4, 8, 8);
  }

  @Override
  public void setDirection(Location direction) {
    this.direction = direction;
  }

  @Override
  public Location getDirection() {
    return direction;
  }
}
