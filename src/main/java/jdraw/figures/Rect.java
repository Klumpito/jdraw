/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import java.awt.*;

/**
 * Represents rectangles in JDraw.
 *
 * @author Christoph Denzler
 */
public class Rect extends AbstractFigure {
  /**
   * Create a new rectangle of the given dimension.
   *
   * @param x the x-coordinate of the upper left corner of the rectangle
   * @param y the y-coordinate of the upper left corner of the rectangle
   * @param w the rectangle's width
   * @param h the rectangle's height
   */
  public Rect(int x, int y, int w, int h) {
    super(x, y, w, h);
  }

  /**
   * Draw the rectangle to the given graphics context.
   *
   * @param g the graphics context to use for drawing.
   */
  @Override
  public void draw(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    g.setColor(Color.BLACK);
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
  }
}