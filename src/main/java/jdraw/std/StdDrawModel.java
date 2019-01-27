/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.ArrayList;
import java.util.List;

import jdraw.framework.*;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author Tobias Wilcke
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {
	private List<Figure> figures;
	private List<DrawModelListener> listeners;

	public StdDrawModel() {
	  this.figures = new ArrayList<>();
	  this.listeners = new ArrayList<>();
  }

	@Override
	public void addFigure(Figure f) {
	  if (f != null && !figures.contains(f)) {
      figures.add(f);
      f.addFigureListener(this);
      notifyAllModelListeners(f, DrawModelEvent.Type.FIGURE_ADDED);
    }
	}

	@Override
	public Iterable<Figure> getFigures() {
		return new ArrayList<>(figures);
	}

	@Override
	public void removeFigure(Figure f) {
    if (f != null && figures.contains(f)) {
      f.removeFigureListener(this);
      figures.remove(f);
      notifyAllModelListeners(f, DrawModelEvent.Type.FIGURE_REMOVED);
    }
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
	  if (listener != null && !listeners.contains(listener))
		  listeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
    if (listener != null && !listeners.contains(listener))
		  listeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new CommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	@Override
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
	  if (f == null || !figures.contains(f))
	    throw new IllegalArgumentException("Figure cannot be null and must be be part of drawing!");
	  if (index < 0 || index >= figures.size())
	    throw new IndexOutOfBoundsException();
	  figures.remove(f);
    figures.add(index, f);
    notifyAllModelListeners(f, DrawModelEvent.Type.DRAWING_CHANGED);
	}

	@Override
	public void removeAllFigures() {
	  figures.forEach(f -> f.removeFigureListener(this));
		figures = new ArrayList<>();
    notifyAllModelListeners(null, DrawModelEvent.Type.DRAWING_CLEARED);
	}

  /**
   * Notify all ModelListeners currently registered.
   *
   * @param f the affected figure
   * @param t the event type
   */
	private void notifyAllModelListeners(Figure f, DrawModelEvent.Type t) {
	  List<DrawModelListener> ls = new ArrayList<>(listeners);
	  ls.forEach(l->l.modelChanged(new DrawModelEvent(this, f, t)));
  }

  @Override
  public void figureChanged(FigureEvent e) {
    notifyAllModelListeners(e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED);
  }
}
