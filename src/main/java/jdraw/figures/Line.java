/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import jdraw.figures.handlers.Handle;
import jdraw.figures.handlers.locations.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Represents rectangles in JDraw.
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
    endPoint = new Point(x1, y1);
    addHandels();
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
    if (dx != 0 && dy != 0) {
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
    Line2D line = new Line2D() {
      @Override
      public double getX1() {
        return getX1();
      }

      @Override
      public double getY1() {
        return getY1();
      }

      @Override
      public Point2D getP1() {
        return null;
      }

      @Override
      public double getX2() {
        return getX2();
      }

      @Override
      public double getY2() {
        return getY2();
      }

      @Override
      public Point2D getP2() {
        return null;
      }

      @Override
      public void setLine(double x1, double y1, double x2, double y2) {

      }

      @Override
      public Rectangle2D getBounds2D() {
        return null;
      }
    };

    return line.contains(x, y);
  }

  @Override
  void addHandels() {
    handles.add(new Handle(this, new LineStart()));
    handles.add(new Handle(this, new LineEnd()));
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
}