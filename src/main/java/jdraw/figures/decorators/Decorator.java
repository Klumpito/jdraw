package jdraw.figures.decorators;

import jdraw.framework.Figure;

/**
 * @author Tobias Wilcke
 */
abstract class Decorator implements Figure {
  Figure figure;

  Decorator(Figure f){
    figure = f;
  }

  @Override
  abstract public Figure clone();
}