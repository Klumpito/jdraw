package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.std.commands.InsertFigureCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Standard implementation for the FigureTool.
 *
 * @author Tobias Wilcke
 */
public abstract class AbstractFigureTool implements DrawTool {

  /**
   * the image resource path.
   */
  private static final String IMAGES = "/images/";

  /**
   * defining the mode name
   */
  private static String NAME = "";
  /**
   * defining the image name
   */
  private static String IMAGE_NAME = "";

  /**
   * The context we use for drawing.
   */
  private DrawContext context;

  /**
   * The context's view. This variable can be used as a shortcut, i.e.
   * instead of calling context.getView().
   */
  protected DrawView view;

  /**
   * Temporary variable. During rectangle creation (during a
   * mouse down - mouse drag - mouse up cycle) this variable refers
   * to the new rectangle that is inserted.
   */
  Figure newFigure = null;

  /**
   * Temporary variable.
   * During rectangle creation this variable refers to the point the
   * mouse was first pressed.
   */
  Point anchor = null;

  /**
   * Create a new rectangle tool for the given context.
   * @param context a context to use this tool in.
   */
  private AbstractFigureTool(DrawContext context) {
    this.context = context;
    this.view = context.getView();
  }

  AbstractFigureTool(DrawContext context, String name, String imageName) {
    this(context);
    NAME = name;
    IMAGE_NAME = imageName;
  }

  /**
   * Deactivates the current mode by resetting the cursor
   * and clearing the status bar.
   * @see jdraw.framework.DrawTool#deactivate()
   */
  @Override
  public void deactivate() {
    this.context.showStatusText("");
  }

  /**
   * Activates the Figure Mode. There will be a
   * specific menu added to the menu bar that provides settings for
   * Figure attributes
   */
  @Override
  public void activate() {
    this.context.showStatusText(NAME + " Mode");
  }

  /**
   * Initializes a new Figure object by setting an anchor
   * point where the mouse was pressed. A new Figure is then
   * added to the model.
   * @param x x-coordinate of mouse
   * @param y y-coordinate of mouse
   * @param e event containing additional information about which keys were pressed.
   *
   * @see jdraw.framework.DrawTool#mouseDown(int, int, MouseEvent)
   */
  @Override
  public abstract void mouseDown(int x, int y, MouseEvent e);

  void mouseDown(int x, int y, Figure f) {
    if (newFigure != null) {
      throw new IllegalStateException();
    }
    anchor = new Point(x, y);
    newFigure = f;
    view.getModel().addFigure(newFigure);
  }

  /**
   * During a mouse drag, the Figure will be resized according to the mouse
   * position. The status bar shows the current size.
   *
   * @param x   x-coordinate of mouse
   * @param y   y-coordinate of mouse
   * @param e   event containing additional information about which keys were
   *            pressed.
   *
   * @see jdraw.framework.DrawTool#mouseDrag(int, int, MouseEvent)
   */
  @Override
  public void mouseDrag(int x, int y, MouseEvent e) {
    newFigure.setBounds(anchor, new Point(x, y));
    Rectangle r = newFigure.getBounds();
    this.context.showStatusText("w: " + r.width + ", h: " + r.height);
  }

  /**
   * When the user releases the mouse, the Figure object is updated
   * according to the color and fill status settings.
   *
   * @param x   x-coordinate of mouse
   * @param y   y-coordinate of mouse
   * @param e   event containing additional information about which keys were
   *            pressed.
   *
   * @see jdraw.framework.DrawTool#mouseUp(int, int, MouseEvent)
   */
  @Override
  public void mouseUp(int x, int y, MouseEvent e) {
    context.getModel().getDrawCommandHandler().addCommand(new InsertFigureCommand(context.getModel(), newFigure));
    newFigure = null;
    anchor = null;
    this.context.showStatusText(NAME + " Mode");
  }

  @Override
  public Cursor getCursor() {
    return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
  }

  @Override
  public Icon getIcon() {
    return new ImageIcon(getClass().getResource(IMAGES + IMAGE_NAME));
  }

  @Override
  public String getName() {
    return NAME;
  }
}
