package androidx.core.view.accessibility;

public final class SetSelectionArguments extends AccessibilityViewCommand.CommandArguments {
  public int getEnd() {
    return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
  }
  
  public int getStart() {
    return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$SetSelectionArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */