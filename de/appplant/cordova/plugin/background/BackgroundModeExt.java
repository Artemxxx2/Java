package de.appplant.cordova.plugin.background;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.view.View;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class BackgroundModeExt extends CordovaPlugin {
  private PowerManager.WakeLock wakeLock;
  
  private void acquireWakeLock() {
    PowerManager powerManager = (PowerManager)getService("power");
    releaseWakeLock();
    if (!isDimmed())
      return; 
    this.wakeLock = powerManager.newWakeLock(268435462, "backgroundmode:wakelock");
    this.wakeLock.setReferenceCounted(false);
    this.wakeLock.acquire(1000L);
  }
  
  private void addSreenAndKeyguardFlags() {
    getApp().runOnUiThread(new _$$Lambda$BackgroundModeExt$8opBXpb8qCacWv2tqu9xcHF59vc(this));
  }
  
  static void clearKeyguardFlags(Activity paramActivity) {
    paramActivity.runOnUiThread(new _$$Lambda$BackgroundModeExt$dhGWJsWDWa3mV1m10yf3_A_c9oE(paramActivity));
  }
  
  private void clearScreenAndKeyguardFlags() {
    getApp().runOnUiThread(new _$$Lambda$BackgroundModeExt$vbQiBHN_VJ1jzsz_Xh2Sq7RaEgo(this));
  }
  
  @SuppressLint({"BatteryLife"})
  private void disableBatteryOptimizations() {
    Activity activity = this.cordova.getActivity();
    Intent intent = new Intent();
    String str = activity.getPackageName();
    PowerManager powerManager = (PowerManager)getService("power");
    if (Build.VERSION.SDK_INT < 23)
      return; 
    if (powerManager.isIgnoringBatteryOptimizations(str))
      return; 
    intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("package:");
    stringBuilder.append(str);
    intent.setData(Uri.parse(stringBuilder.toString()));
    this.cordova.getActivity().startActivity(intent);
  }
  
  private void disableWebViewOptimizations() {
    (new Thread() {
        public void run() {
          try {
            Thread.sleep(1000L);
            Activity activity = BackgroundModeExt.this.getApp();
            _$$Lambda$BackgroundModeExt$1$G8BcCUGm1NdL43D3hx0oXWRmZqc _$$Lambda$BackgroundModeExt$1$G8BcCUGm1NdL43D3hx0oXWRmZqc = new _$$Lambda$BackgroundModeExt$1$G8BcCUGm1NdL43D3hx0oXWRmZqc();
            this(this);
            activity.runOnUiThread(_$$Lambda$BackgroundModeExt$1$G8BcCUGm1NdL43D3hx0oXWRmZqc);
          } catch (InterruptedException interruptedException) {}
        }
      }).start();
  }
  
  @TargetApi(21)
  private void excludeFromTaskList() {
    ActivityManager activityManager = (ActivityManager)getService("activity");
    if (activityManager == null || Build.VERSION.SDK_INT < 21)
      return; 
    List<ActivityManager.AppTask> list = activityManager.getAppTasks();
    if (list == null || list.isEmpty())
      return; 
    ((ActivityManager.AppTask)list.get(0)).setExcludeFromRecents(true);
  }
  
  private List<Intent> getAppStartIntents() {
    return Arrays.asList(new Intent[] { 
          (new Intent()).setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")), (new Intent()).setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")), (new Intent()).setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")), (new Intent()).setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")), (new Intent()).setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")), (new Intent()).setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")), (new Intent()).setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")), (new Intent()).setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")), (new Intent()).setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")), (new Intent()).setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")), 
          (new Intent()).setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity")), (new Intent()).setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity")).setData(Uri.parse("mobilemanager://function/entry/AutoStart")), (new Intent()).setAction("com.letv.android.permissionautoboot"), (new Intent()).setComponent(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.ram.AutoRunActivity")), (new Intent()).setComponent(ComponentName.unflattenFromString("com.iqoo.secure/.MainActivity")), (new Intent()).setComponent(ComponentName.unflattenFromString("com.meizu.safe/.permission.SmartBGActivity")), (new Intent()).setComponent(new ComponentName("com.yulong.android.coolsafe", ".ui.activity.autorun.AutoRunListActivity")), (new Intent()).setComponent(new ComponentName("cn.nubia.security2", "cn.nubia.security.appmanage.selfstart.ui.SelfStartActivity")), (new Intent()).setComponent(new ComponentName("com.zui.safecenter", "com.lenovo.safecenter.MainTab.LeSafeMainActivity")) });
  }
  
  private Intent getLaunchIntent() {
    Context context = getApp().getApplicationContext();
    String str = context.getPackageName();
    return context.getPackageManager().getLaunchIntentForPackage(str);
  }
  
  private Object getService(String paramString) {
    return getApp().getSystemService(paramString);
  }
  
  private void isDimmed(CallbackContext paramCallbackContext) {
    boolean bool = isDimmed();
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
  }
  
  private boolean isDimmed() {
    PowerManager powerManager = (PowerManager)getService("power");
    return (Build.VERSION.SDK_INT < 20) ? (powerManager.isScreenOn() ^ true) : (powerManager.isInteractive() ^ true);
  }
  
  private void moveToBackground() {
    Intent intent = new Intent("android.intent.action.MAIN");
    intent.addCategory("android.intent.category.HOME");
    getApp().startActivity(intent);
  }
  
  private void moveToForeground() {
    Activity activity = getApp();
    Intent intent = getLaunchIntent();
    intent.addFlags(604110848);
    clearScreenAndKeyguardFlags();
    activity.startActivity(intent);
  }
  
  private void openAppStart(Object paramObject) {
    Activity activity = this.cordova.getActivity();
    PackageManager packageManager = activity.getPackageManager();
    Iterator<Intent> iterator = getAppStartIntents().iterator();
    while (iterator.hasNext()) {
      Intent intent = iterator.next();
      if (packageManager.resolveActivity(intent, 65536) != null) {
        if (paramObject instanceof JSONObject) {
          JSONObject jSONObject = (JSONObject)paramObject;
        } else {
          iterator = null;
        } 
        intent.addFlags(268435456);
        if (paramObject instanceof Boolean && !((Boolean)paramObject).booleanValue()) {
          activity.startActivity(intent);
          break;
        } 
        paramObject = new AlertDialog.Builder((Context)activity, 16974130);
        paramObject.setPositiveButton(17039370, new _$$Lambda$BackgroundModeExt$ERKfr3wD6vup_JSOqk4oaG0vRD8(activity, intent));
        paramObject.setNegativeButton(17039360, (DialogInterface.OnClickListener)_$$Lambda$BackgroundModeExt$bUrtZtagSgT3rMs8xgk8HpHR0ic.INSTANCE);
        paramObject.setCancelable(true);
        if (iterator != null && iterator.has("title"))
          paramObject.setTitle(iterator.optString("title")); 
        if (iterator != null && iterator.has("text")) {
          paramObject.setMessage(iterator.optString("text"));
        } else {
          paramObject.setMessage("missing text");
        } 
        paramObject.getClass();
        activity.runOnUiThread(new _$$Lambda$3Qlr8fEzXfR35vEnzutL7VyLKKA((AlertDialog.Builder)paramObject));
        break;
      } 
    } 
  }
  
  private void releaseWakeLock() {
    PowerManager.WakeLock wakeLock = this.wakeLock;
    if (wakeLock != null && wakeLock.isHeld()) {
      this.wakeLock.release();
      this.wakeLock = null;
    } 
  }
  
  private void unlock() {
    addSreenAndKeyguardFlags();
    getApp().startActivity(getLaunchIntent());
  }
  
  private void wakeup() {
    try {
      acquireWakeLock();
    } catch (Exception exception) {
      releaseWakeLock();
    } 
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    int i = paramString.hashCode();
    boolean bool = true;
    switch (i) {
      default:
        i = -1;
        break;
      case 1984457027:
        if (paramString.equals("foreground")) {
          i = 4;
          break;
        } 
      case 1224424441:
        if (paramString.equals("webview")) {
          i = 1;
          break;
        } 
      case 1186297569:
        if (paramString.equals("appstart")) {
          i = 2;
          break;
        } 
      case -331239923:
        if (paramString.equals("battery")) {
          i = 0;
          break;
        } 
      case -409429085:
        if (paramString.equals("tasklist")) {
          i = 5;
          break;
        } 
      case -795228353:
        if (paramString.equals("wakeup")) {
          i = 7;
          break;
        } 
      case -840442044:
        if (paramString.equals("unlock")) {
          i = 8;
          break;
        } 
      case -1331727292:
        if (paramString.equals("dimmed")) {
          i = 6;
          break;
        } 
      case -1332194002:
        if (paramString.equals("background")) {
          i = 3;
          break;
        } 
    } 
    switch (i) {
      default:
        bool = false;
        break;
      case 8:
        wakeup();
        unlock();
        break;
      case 7:
        wakeup();
        break;
      case 6:
        isDimmed(paramCallbackContext);
        break;
      case 5:
        excludeFromTaskList();
        break;
      case 4:
        moveToForeground();
        break;
      case 3:
        moveToBackground();
        break;
      case 2:
        openAppStart(paramJSONArray.opt(0));
        break;
      case 1:
        disableWebViewOptimizations();
        break;
      case 0:
        disableBatteryOptimizations();
        break;
    } 
    if (bool) {
      paramCallbackContext.success();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid action: ");
      stringBuilder.append(paramString);
      paramCallbackContext.error(stringBuilder.toString());
    } 
    return bool;
  }
  
  Activity getApp() {
    return this.cordova.getActivity();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\de\appplant\cordova\plugin\background\BackgroundModeExt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */