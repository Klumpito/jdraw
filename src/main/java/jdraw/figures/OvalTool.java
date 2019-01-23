/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author  Christoph Denzler
 */
public class OvalTool extends AbstractFigureTool {
	/**
	 * Create a new rectangle tool for the given context.
	 * @param context a context to use this tool in.
	 */
	public OvalTool(DrawContext context) {
		super(context, "Oval", "oval.png");
	}

	@Override
	public void mouseDown(int x, int y, MouseEvent e) {
		mouseDown(x, y, new Oval(x, y, 0, 0));
	}
}
