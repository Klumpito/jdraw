/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import jdraw.figures.handlers.Handle;
import jdraw.figures.handlers.locations.East;
import jdraw.figures.handlers.locations.North;
import jdraw.figures.handlers.locations.South;
import jdraw.figures.handlers.locations.West;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

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

  @Override
  public boolean contains(int x, int y) {
    Ellipse2D oval = new BoundOval() {
    };

    return oval.contains(x, y);
  }

  @Override
  void addHandles() {
    handles.add(new Handle(this, new North()));
    handles.add(new Handle(this, new East()));
    handles.add(new Handle(this, new South()));
    handles.add(new Handle(this, new West()));
  }

  @Override
  public Figure clone() {
    return new Oval(bounds.x, bounds.y, bounds.width, bounds.height);
  }

  class BoundOval extends Ellipse2D{
    @Override
    public double getX() {
      return bounds.x;
    }

    @Override
    public double getY() {
      return bounds.y;
    }

    @Override
    public double getWidth() {
      return bounds.width;
    }

    @Override
    public double getHeight() {
      return bounds.height;
    }

    @Override
    public boolean isEmpty() {
      return false;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {

    }

    @Override
    public Rectangle2D getBounds2D() {
      return null;
    }
  }
}
