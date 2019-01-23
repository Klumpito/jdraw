/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import java.awt.*;

/**
 * Represents Ovals in JDraw.
 *
 * @author Tobias Wilcke
 *
 */
public class Oval extends AbstractFigure {
  /**
   * Create a new oval of the given dimension.
   * @param x the x-coordinate of the upper left corner of the oval
   * @param y the y-coordinate of the upper left corner of the oval
   * @param w the oval's width
   * @param h the oval's height
   */
  public Oval(int x, int y, int w, int h) {
    super(x, y, w, h);
  }

  /**
   * Draw the oval to the given graphics context.
   * @param g the graphics context to use for drawing.
   */
  @Override
  public void draw(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
    g.setColor(Color.BLACK);
    g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
  }

}
