package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortcutManagerCompat {
  @VisibleForTesting
  static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
  
  public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
  
  @VisibleForTesting
  static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
  
  private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;
  
  public static boolean addDynamicShortcuts(@NonNull Context paramContext, @NonNull List<ShortcutInfoCompat> paramList) {
    if (Build.VERSION.SDK_INT >= 25) {
      ArrayList<ShortcutInfo> arrayList = new ArrayList();
      Iterator<ShortcutInfoCompat> iterator = paramList.iterator();
      while (iterator.hasNext())
        arrayList.add(((ShortcutInfoCompat)iterator.next()).toShortcutInfo()); 
      if (!((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList))
        return false; 
    } 
    getShortcutInfoSaverInstance(paramContext).addShortcuts(paramList);
    return true;
  }
  
  @NonNull
  public static Intent createShortcutResultIntent(@NonNull Context paramContext, @NonNull ShortcutInfoCompat paramShortcutInfoCompat) {
    Intent intent;
    if (Build.VERSION.SDK_INT >= 26) {
      Intent intent1 = ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).createShortcutResultIntent(paramShortcutInfoCompat.toShortcutInfo());
    } else {
      paramContext = null;
    } 
    Context context = paramContext;
    if (paramContext == null)
      intent = new Intent(); 
    return paramShortcutInfoCompat.addToIntent(intent);
  }
  
  @NonNull
  public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context paramContext) {
    if (Build.VERSION.SDK_INT >= 25) {
      List list = ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
      ArrayList<ShortcutInfoCompat> arrayList = new ArrayList(list.size());
      Iterator<ShortcutInfo> iterator = list.iterator();
      while (iterator.hasNext())
        arrayList.add((new ShortcutInfoCompat.Builder(paramContext, iterator.next())).build()); 
      return arrayList;
    } 
    try {
      return getShortcutInfoSaverInstance(paramContext).getShortcuts();
    } catch (Exception exception) {
      return new ArrayList<ShortcutInfoCompat>();
    } 
  }
  
  public static int getMaxShortcutCountPerActivity(@NonNull Context paramContext) {
    return (Build.VERSION.SDK_INT >= 25) ? ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity() : 0;
  }
  
  private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context paramContext) {
    if (sShortcutInfoCompatSaver == null) {
      if (Build.VERSION.SDK_INT >= 23)
        try {
          sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver)Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
        } catch (Exception exception) {} 
      if (sShortcutInfoCompatSaver == null)
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl(); 
    } 
    return sShortcutInfoCompatSaver;
  }
  
  public static boolean isRequestPinShortcutSupported(@NonNull Context paramContext) {
    if (Build.VERSION.SDK_INT >= 26)
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported(); 
    if (ContextCompat.checkSelfPermission(paramContext, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0)
      return false; 
    Iterator iterator = paramContext.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
    while (iterator.hasNext()) {
      String str = ((ResolveInfo)iterator.next()).activityInfo.permission;
      if (TextUtils.isEmpty(str) || "com.android.launcher.permission.INSTALL_SHORTCUT".equals(str))
        return true; 
    } 
    return false;
  }
  
  public static void removeAllDynamicShortcuts(@NonNull Context paramContext) {
    if (Build.VERSION.SDK_INT >= 25)
      ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts(); 
    getShortcutInfoSaverInstance(paramContext).removeAllShortcuts();
  }
  
  public static void removeDynamicShortcuts(@NonNull Context paramContext, @NonNull List<String> paramList) {
    if (Build.VERSION.SDK_INT >= 25)
      ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(paramList); 
    getShortcutInfoSaverInstance(paramContext).removeShortcuts(paramList);
  }
  
  public static boolean requestPinShortcut(@NonNull Context paramContext, @NonNull ShortcutInfoCompat paramShortcutInfoCompat, @Nullable final IntentSender callback) {
    if (Build.VERSION.SDK_INT >= 26)
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).requestPinShortcut(paramShortcutInfoCompat.toShortcutInfo(), callback); 
    if (!isRequestPinShortcutSupported(paramContext))
      return false; 
    Intent intent = paramShortcutInfoCompat.addToIntent(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
    if (callback == null) {
      paramContext.sendBroadcast(intent);
      return true;
    } 
    paramContext.sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
          public void onReceive(Context param1Context, Intent param1Intent) {
            try {
              callback.sendIntent(param1Context, 0, null, null, null);
            } catch (android.content.IntentSender.SendIntentException sendIntentException) {}
          }
        }null, -1, null, null);
    return true;
  }
  
  public static boolean updateShortcuts(@NonNull Context paramContext, @NonNull List<ShortcutInfoCompat> paramList) {
    if (Build.VERSION.SDK_INT >= 25) {
      ArrayList<ShortcutInfo> arrayList = new ArrayList();
      Iterator<ShortcutInfoCompat> iterator = paramList.iterator();
      while (iterator.hasNext())
        arrayList.add(((ShortcutInfoCompat)iterator.next()).toShortcutInfo()); 
      if (!((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList))
        return false; 
    } 
    getShortcutInfoSaverInstance(paramContext).addShortcuts(paramList);
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\ShortcutManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */