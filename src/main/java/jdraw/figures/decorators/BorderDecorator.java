package jdraw.figures.decorators;

import jdraw.figures.AbstractFigure;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.List;

/**
 * @author Tobias Wilcke
 */
public class BorderDecorator extends Decorator {

  public BorderDecorator(Figure f) {
    super(f);
  }

  @Override
  public void draw(Graphics g) {
    figure.draw(g);
    Rectangle bounds = figure.getBounds();

    g.setColor(Color.WHITE);
    g.drawLine(bounds.x-1, bounds.y-1, (int) bounds.getMaxX()+1, bounds.y-1);
    g.drawLine(bounds.x-1, bounds.y-1, bounds.x-1, (int) bounds.getMaxY()+1);
    g.setColor(Color.LIGHT_GRAY);
    g.drawLine((int) bounds.getMaxX()+1, bounds.y-1, (int) bounds.getMaxX()+1, (int) bounds.getMaxY()+1);
    g.drawLine(bounds.x-1, (int) bounds.getMaxY()+1, (int) bounds.getMaxX()+1, (int) bounds.getMaxY()+1);
  }

  @Override
  public void move(int dx, int dy) {
    figure.move(dx, dy);
  }

  @Override
  public boolean contains(int x, int y) {
    return figure.contains(x, y);
  }

  @Override
  public void setBounds(Point origin, Point corner) {
    figure.setBounds(origin, corner);
  }

  @Override
  public Rectangle getBounds() {
    return figure.getBounds();
  }

  @Override
  public List<FigureHandle> getHandles() {
    return figure.getHandles();
  }

  @Override
  public void addFigureListener(FigureListener listener) {
    figure.addFigureListener(listener);
  }

  @Override
  public void removeFigureListener(FigureListener listener) {
    figure.removeFigureListener(listener);
  }

  @Override
  public Figure clone() {
    return new BorderDecorator(figure.clone());
  }
}
