package androidx.core.view.accessibility;

public final class ScrollToPositionArguments extends AccessibilityViewCommand.CommandArguments {
  public int getColumn() {
    return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
  }
  
  public int getRow() {
    return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$ScrollToPositionArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */