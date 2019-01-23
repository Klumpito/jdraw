/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import java.awt.*;

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
}