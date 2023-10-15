package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class AccessibilityActionCompat {
  public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
  
  public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
  
  public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
  
  public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
  
  public static final AccessibilityActionCompat ACTION_CLICK;
  
  public static final AccessibilityActionCompat ACTION_COLLAPSE;
  
  public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
  
  public static final AccessibilityActionCompat ACTION_COPY;
  
  public static final AccessibilityActionCompat ACTION_CUT;
  
  public static final AccessibilityActionCompat ACTION_DISMISS;
  
  public static final AccessibilityActionCompat ACTION_EXPAND;
  
  public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
  
  public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
  
  public static final AccessibilityActionCompat ACTION_LONG_CLICK;
  
  public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
  
  public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
  
  public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
  
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
  
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
  
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
  
  @NonNull
  public static final AccessibilityActionCompat ACTION_PAGE_UP;
  
  public static final AccessibilityActionCompat ACTION_PASTE;
  
  public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
  
  public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
  
  public static final AccessibilityActionCompat ACTION_SCROLL_UP;
  
  public static final AccessibilityActionCompat ACTION_SELECT;
  
  public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
  
  public static final AccessibilityActionCompat ACTION_SET_SELECTION;
  
  public static final AccessibilityActionCompat ACTION_SET_TEXT;
  
  public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
  
  public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
  
  private static final String TAG = "A11yActionCompat";
  
  final Object mAction;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected final AccessibilityViewCommand mCommand;
  
  private final int mId;
  
  private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
  
  static {
    ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
    ACTION_SELECT = new AccessibilityActionCompat(4, null);
    ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
    ACTION_CLICK = new AccessibilityActionCompat(16, null);
    ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
    ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
    ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
    ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, (Class)AccessibilityViewCommand.MoveAtGranularityArguments.class);
    ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, (Class)AccessibilityViewCommand.MoveAtGranularityArguments.class);
    ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, (Class)AccessibilityViewCommand.MoveHtmlArguments.class);
    ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, (Class)AccessibilityViewCommand.MoveHtmlArguments.class);
    ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
    ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
    ACTION_COPY = new AccessibilityActionCompat(16384, null);
    ACTION_PASTE = new AccessibilityActionCompat(32768, null);
    ACTION_CUT = new AccessibilityActionCompat(65536, null);
    ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, (Class)AccessibilityViewCommand.SetSelectionArguments.class);
    ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
    ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
    ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
    ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null, (Class)AccessibilityViewCommand.SetTextArguments.class);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(accessibilityAction2, 16908342, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(accessibilityAction2, 16908343, null, null, (Class)AccessibilityViewCommand.ScrollToPositionArguments.class);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SCROLL_UP = new AccessibilityActionCompat(accessibilityAction2, 16908344, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SCROLL_LEFT = new AccessibilityActionCompat(accessibilityAction2, 16908345, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SCROLL_DOWN = new AccessibilityActionCompat(accessibilityAction2, 16908346, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(accessibilityAction2, 16908347, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_PAGE_UP = new AccessibilityActionCompat(accessibilityAction2, 16908358, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_PAGE_DOWN = new AccessibilityActionCompat(accessibilityAction2, 16908359, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_PAGE_LEFT = new AccessibilityActionCompat(accessibilityAction2, 16908360, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_PAGE_RIGHT = new AccessibilityActionCompat(accessibilityAction2, 16908361, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(accessibilityAction2, 16908348, null, null, null);
    if (Build.VERSION.SDK_INT >= 24) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SET_PROGRESS = new AccessibilityActionCompat(accessibilityAction2, 16908349, null, null, (Class)AccessibilityViewCommand.SetProgressArguments.class);
    if (Build.VERSION.SDK_INT >= 26) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_MOVE_WINDOW = new AccessibilityActionCompat(accessibilityAction2, 16908354, null, null, (Class)AccessibilityViewCommand.MoveWindowArguments.class);
    if (Build.VERSION.SDK_INT >= 28) {
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
    } else {
      accessibilityAction2 = null;
    } 
    ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(accessibilityAction2, 16908356, null, null, null);
    AccessibilityNodeInfo.AccessibilityAction accessibilityAction2 = accessibilityAction1;
    if (Build.VERSION.SDK_INT >= 28)
      accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP; 
    ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(accessibilityAction2, 16908357, null, null, null);
  }
  
  public AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence) {
    this(null, paramInt, paramCharSequence, null, null);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand) {
    this(null, paramInt, paramCharSequence, paramAccessibilityViewCommand, null);
  }
  
  private AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence, Class<? extends AccessibilityViewCommand.CommandArguments> paramClass) {
    this(null, paramInt, paramCharSequence, null, paramClass);
  }
  
  AccessibilityActionCompat(Object paramObject) {
    this(paramObject, 0, null, null, null);
  }
  
  AccessibilityActionCompat(Object paramObject, int paramInt, CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> paramClass) {
    this.mId = paramInt;
    this.mCommand = paramAccessibilityViewCommand;
    if (Build.VERSION.SDK_INT >= 21 && paramObject == null) {
      this.mAction = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);
    } else {
      this.mAction = paramObject;
    } 
    this.mViewCommandArgumentClass = paramClass;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public AccessibilityActionCompat createReplacementAction(CharSequence paramCharSequence, AccessibilityViewCommand paramAccessibilityViewCommand) {
    return new AccessibilityActionCompat(null, this.mId, paramCharSequence, paramAccessibilityViewCommand, this.mViewCommandArgumentClass);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof AccessibilityActionCompat))
      return false; 
    paramObject = paramObject;
    Object object = this.mAction;
    if (object == null) {
      if (((AccessibilityActionCompat)paramObject).mAction != null)
        return false; 
    } else if (!object.equals(((AccessibilityActionCompat)paramObject).mAction)) {
      return false;
    } 
    return true;
  }
  
  public int getId() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getId() : 0;
  }
  
  public CharSequence getLabel() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getLabel() : null;
  }
  
  public int hashCode() {
    boolean bool;
    Object object = this.mAction;
    if (object != null) {
      bool = object.hashCode();
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean perform(View paramView, Bundle paramBundle) {
    if (this.mCommand != null) {
      AccessibilityViewCommand.CommandArguments commandArguments = null;
      Object object = null;
      Class<? extends AccessibilityViewCommand.CommandArguments> clazz = this.mViewCommandArgumentClass;
      if (clazz != null) {
        Exception exception1;
        String str;
        try {
          commandArguments = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          try {
            commandArguments.setBundle(paramBundle);
          } catch (Exception exception2) {
            AccessibilityViewCommand.CommandArguments commandArguments1 = commandArguments;
            exception = exception2;
          } 
        } catch (Exception exception) {
          exception1 = exception2;
        } 
        Class<? extends AccessibilityViewCommand.CommandArguments> clazz1 = this.mViewCommandArgumentClass;
        if (clazz1 == null) {
          str = "null";
        } else {
          str = str.getName();
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to execute command with argument class ViewCommandArgument: ");
        stringBuilder.append(str);
        Log.e("A11yActionCompat", stringBuilder.toString(), exception);
        exception = exception1;
      } 
      return this.mCommand.perform(paramView, (AccessibilityViewCommand.CommandArguments)exception);
    } 
    return false;
  }
  
  static {
    AccessibilityNodeInfo.AccessibilityAction accessibilityAction1 = null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityNodeInfoCompat$AccessibilityActionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */