package androidx.core.view.accessibility;

public final class MoveWindowArguments extends AccessibilityViewCommand.CommandArguments {
  public int getX() {
    return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
  }
  
  public int getY() {
    return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$MoveWindowArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */