package androidx.core.view.accessibility;

public final class MoveAtGranularityArguments extends AccessibilityViewCommand.CommandArguments {
  public boolean getExtendSelection() {
    return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
  }
  
  public int getGranularity() {
    return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$MoveAtGranularityArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */