package jdraw.figures.decorators;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.List;

/**
 * @author Tobias Wilcke
 */
public class LogDecorator extends Decorator {

  public LogDecorator(Figure f) {
    super(f);
    System.out.println("LogDecotrator: Adding Log Decorator Figure: " + figure.toString());
  }

  @Override
  public void draw(Graphics g) {
    System.out.println("LogDecotrator: Drawing Figure: " + figure.toString());
    figure.draw(g);
  }

  @Override
  public void move(int dx, int dy) {
    System.out.println("LogDecotrator: Moving Figure to " + dx + "/" + dy + ": " + figure.toString());
    figure.move(dx, dy);
  }

  @Override
  public boolean contains(int x, int y) {
    System.out.println("LogDecotrator: Checking if " + x + " " + y + " are containded in Figure: " + figure.toString());
    return figure.contains(x,y);
  }

  @Override
  public void setBounds(Point origin, Point corner) {
    System.out.println("LogDecotrator: Setting Bounds of Figure: " + figure.toString());
  }

  @Override
  public Rectangle getBounds() {
    System.out.println("LogDecotrator: Getting Bounds of Figure: " + figure.toString());
    return figure.getBounds();
  }

  @Override
  public List<FigureHandle> getHandles() {
    System.out.println("LogDecotrator: Getting Handles of Figure: " + figure.toString());
    return figure.getHandles();
  }

  @Override
  public void addFigureListener(FigureListener listener) {
    System.out.println("LogDecotrator: Adding a new listener to Figure: " + figure.toString());
    figure.addFigureListener(listener);
  }

  @Override
  public void removeFigureListener(FigureListener listener) {
    System.out.println("LogDecotrator: Removing a listener from Figure: " + figure.toString());
    figure.removeFigureListener(listener);
  }

  @Override
  public Figure clone() {
    System.out.println("LogDecotrator: Cloning Figure: " + figure.toString());
    return figure.clone();
  }
}
