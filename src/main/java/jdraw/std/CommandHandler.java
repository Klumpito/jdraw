package jdraw.std;

import jdraw.framework.DrawCommand;
import jdraw.framework.DrawCommandHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tobias Wilcke
 */
public class CommandHandler implements DrawCommandHandler {
  private List<DrawCommand> cmds;
  private List<DrawCommand> scriptCmds;
  private int position;

  public CommandHandler() {
    cmds = new ArrayList<>();
    position = -1;
  }

  @Override
  public void addCommand(DrawCommand cmd) {
    if (scriptCmds == null) {
      if(position < 0)
        position = 0;
      cmds.add(position, cmd);
      for (int i = position+1; i < cmds.size(); i++)
        cmds.remove(i);
    } else {
      scriptCmds.add(cmd);
    }
  }

  @Override
  public void undo() {
    cmds.get(position).undo();
    position--;
  }

  @Override
  public void redo() {
    position++;
    cmds.get(position).redo();
  }

  @Override
  public boolean undoPossible() {
    return position >= 0;
  }

  @Override
  public boolean redoPossible() {
    return position < cmds.size();
  }

  @Override
  public void beginScript() {
    scriptCmds = new ArrayList<>();
  }

  @Override
  public void endScript() {
    position++;
    MacroCommand cc = new MacroCommand(scriptCmds);
    scriptCmds = null;
    addCommand(cc);
  }

  @Override
  public void clearHistory() {
    cmds = new ArrayList<>();
    position = 0;
  }
}
