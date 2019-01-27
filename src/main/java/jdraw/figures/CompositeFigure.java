package jdraw.figures;

import jdraw.framework.Figure;

import java.util.List;

/**
 * @author Tobias Wilcke
 */
public interface CompositeFigure extends Figure {
  List<Figure> getFigures();
}
