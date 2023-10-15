package androidx.core.view.accessibility;

public final class SetProgressArguments extends AccessibilityViewCommand.CommandArguments {
  public float getProgress() {
    return this.mBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$SetProgressArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */