package androidx.core.view.accessibility;

public final class SetTextArguments extends AccessibilityViewCommand.CommandArguments {
  public CharSequence getText() {
    return this.mBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$SetTextArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */