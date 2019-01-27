/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import jdraw.figures.handlers.Handle;
import jdraw.figures.handlers.locations.*;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Represents Line in JDraw. It is a special litle kid. As it requires only a start and end point which must not be in correspondence of the boundary of the rectangle.
 *
 * @author Tobias Wilcke
 */
public class Line extends AbstractFigure {
  private Point startPoint;
  private Point endPoint;

  /**
   * Create a new rectangle of the given dimension.
   *
   * @param x1 the x-coordinate of the upper left corner of the line
   * @param y1 the y-coordinate of the upper left corner of the line
   * @param x2 the x-coordinate of the lower right corner of the line
   * @param y2 the y-coordinate of the lower right corner of the line
   */
  public Line(int x1, int y1, int x2, int y2) {
    super(x1, y1, x2, y2);
    startPoint = new Point(x1, y1);
    // x2 and y2 are set to 0 and therefore are problematic
    endPoint = new Point(x1, y1);
    // recall handle adding to use start and end point parameters
    addHandles();
  }

  /**
   * Draw the rectangle to the given graphics context.
   *
   * @param g the graphics context to use for drawing.
   */
  @Override
  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
  }

  @Override
  public void move(int dx, int dy) {
    if (dx != 0 || dy != 0) {
      startPoint.x += dx;
      startPoint.y += dy;
      endPoint.x += dx;
      endPoint.y += dy;
      bounds.setLocation(bounds.x + dx, bounds.y + dy);
      super.notifyAllFigureListners();
    }
  }

  @Override
  public boolean contains(int x, int y) {
    Line2D line = new BoundLine();

    return line.contains(x, y);
  }

  @Override
  protected void addHandles() {
    if (startPoint != null) {
      handles.add(new Handle(this, new LineStart()));
      handles.add(new Handle(this, new LineEnd()));
    }
  }

  @Override
  public Figure clone() {
    return new Line(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
  }

  @Override
  public void setBounds(Point origin, Point corner) {
    Point original_origin = new Point(bounds.x, bounds.y);
    Point original_corner = new Point(bounds.x + bounds.width, bounds.y + bounds.height);
    if (!origin.equals(original_origin) || !corner.equals(original_corner)) {
      bounds.setFrameFromDiagonal(origin, corner);
      startPoint = origin;
      endPoint = corner;
      notifyAllFigureListners();
    }
  }

  public Point getStartPoint() {
    return startPoint;
  }

  public Point getEndPoint() {
    return endPoint;
  }

  public void setStartPoint(Point startPoint) {
    this.startPoint = startPoint;
    setBounds(startPoint, endPoint);
  }

  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
    setBounds(startPoint, endPoint);
  }

  class BoundLine extends Line2D {
    @Override
    public double getX1() {
      return startPoint.x;
    }

    @Override
    public double getY1() {
      return startPoint.y;
    }

    @Override
    public Point2D getP1() {
      return startPoint;
    }

    @Override
    public double getX2() {
      return endPoint.x;
    }

    @Override
    public double getY2() {
      return endPoint.y;
    }

    @Override
    public Point2D getP2() {
      return endPoint;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {

    }

    @Override
    public Rectangle2D getBounds2D() {
      return null;
    }
  }
}