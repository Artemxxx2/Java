package androidx.core.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(26)
class OreoCallback implements ActionMode.Callback {
  private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
  
  private final ActionMode.Callback mCallback;
  
  private boolean mCanUseMenuBuilderReferences;
  
  private boolean mInitializedMenuBuilderReferences;
  
  private Class<?> mMenuBuilderClass;
  
  private Method mMenuBuilderRemoveItemAtMethod;
  
  private final TextView mTextView;
  
  OreoCallback(ActionMode.Callback paramCallback, TextView paramTextView) {
    this.mCallback = paramCallback;
    this.mTextView = paramTextView;
    this.mInitializedMenuBuilderReferences = false;
  }
  
  private Intent createProcessTextIntent() {
    return (new Intent()).setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
  }
  
  private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramResolveInfo, TextView paramTextView) {
    return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", isEditable(paramTextView) ^ true).setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
  }
  
  private List<ResolveInfo> getSupportedActivities(Context paramContext, PackageManager paramPackageManager) {
    ArrayList<ResolveInfo> arrayList = new ArrayList();
    if (!(paramContext instanceof android.app.Activity))
      return arrayList; 
    for (ResolveInfo resolveInfo : paramPackageManager.queryIntentActivities(createProcessTextIntent(), 0)) {
      if (isSupportedActivity(resolveInfo, paramContext))
        arrayList.add(resolveInfo); 
    } 
    return arrayList;
  }
  
  private boolean isEditable(TextView paramTextView) {
    boolean bool;
    if (paramTextView instanceof android.text.Editable && paramTextView.onCheckIsTextEditor() && paramTextView.isEnabled()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean isSupportedActivity(ResolveInfo paramResolveInfo, Context paramContext) {
    boolean bool = paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName);
    boolean bool1 = true;
    if (bool)
      return true; 
    if (!paramResolveInfo.activityInfo.exported)
      return false; 
    bool = bool1;
    if (paramResolveInfo.activityInfo.permission != null)
      if (paramContext.checkSelfPermission(paramResolveInfo.activityInfo.permission) == 0) {
        bool = bool1;
      } else {
        bool = false;
      }  
    return bool;
  }
  
  private void recomputeProcessTextMenuItems(Menu paramMenu) {
    Context context = this.mTextView.getContext();
    PackageManager packageManager = context.getPackageManager();
    if (!this.mInitializedMenuBuilderReferences) {
      this.mInitializedMenuBuilderReferences = true;
      try {
        this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
        this.mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderClass.getDeclaredMethod("removeItemAt", new Class[] { int.class });
        this.mCanUseMenuBuilderReferences = true;
      } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
        this.mMenuBuilderClass = null;
        this.mMenuBuilderRemoveItemAtMethod = null;
        this.mCanUseMenuBuilderReferences = false;
      } 
    } 
    try {
      Method method;
      if (this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(paramMenu)) {
        method = this.mMenuBuilderRemoveItemAtMethod;
      } else {
        method = paramMenu.getClass().getDeclaredMethod("removeItemAt", new Class[] { int.class });
      } 
      int i;
      for (i = paramMenu.size() - 1; i >= 0; i--) {
        MenuItem menuItem = paramMenu.getItem(i);
        if (menuItem.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(menuItem.getIntent().getAction()))
          method.invoke(paramMenu, new Object[] { Integer.valueOf(i) }); 
      } 
      List<ResolveInfo> list = getSupportedActivities(context, packageManager);
      for (i = 0; i < list.size(); i++) {
        ResolveInfo resolveInfo = list.get(i);
        paramMenu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo, this.mTextView)).setShowAsAction(1);
      } 
      return;
    } catch (NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException noSuchMethodException) {
      return;
    } 
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {
    this.mCallback.onDestroyActionMode(paramActionMode);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    recomputeProcessTextMenuItems(paramMenu);
    return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\TextViewCompat$OreoCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */