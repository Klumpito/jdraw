package jdraw.std.commands;

import jdraw.framework.DrawCommand;

import java.util.List;

/**
 * @author Tobias Wilcke
 */
public class MacroCommand implements DrawCommand {
  private List<DrawCommand> cmds;

  public MacroCommand(List<DrawCommand> cmds) {
    this.cmds = cmds;
  }

  @Override
  public void redo() {
    cmds.forEach(c -> c.redo());
  }

  @Override
  public void undo() {
    cmds.forEach(c ->c.undo());
  }
}
