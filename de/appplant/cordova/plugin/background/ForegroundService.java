package de.appplant.cordova.plugin.background;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import org.json.JSONObject;

public class ForegroundService extends Service {
  private static final String NOTIFICATION_ICON = "icon";
  
  public static final int NOTIFICATION_ID = -574543954;
  
  private static final String NOTIFICATION_TEXT = "Doing heavy tasks.";
  
  private static final String NOTIFICATION_TITLE = "App is running in background";
  
  private final IBinder binder = (IBinder)new ForegroundBinder();
  
  private PowerManager.WakeLock wakeLock;
  
  private int getIconResId(String paramString1, String paramString2) {
    Resources resources = getResources();
    String str = getPackageName();
    int i = resources.getIdentifier(paramString1, paramString2, str);
    int j = i;
    if (i == 0)
      j = resources.getIdentifier("icon", paramString2, str); 
    return j;
  }
  
  private int getIconResId(JSONObject paramJSONObject) {
    String str = paramJSONObject.optString("icon", "icon");
    int i = getIconResId(str, "mipmap");
    int j = i;
    if (i == 0)
      j = getIconResId(str, "drawable"); 
    return j;
  }
  
  private NotificationManager getNotificationManager() {
    return (NotificationManager)getSystemService("notification");
  }
  
  @SuppressLint({"WakelockTimeout"})
  private void keepAwake() {
    if (!BackgroundMode.getSettings().optBoolean("silent", false))
      startForeground(-574543954, makeNotification()); 
    this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, "backgroundmode:wakelock");
    this.wakeLock.acquire();
  }
  
  private Notification makeNotification() {
    return makeNotification(BackgroundMode.getSettings());
  }
  
  private Notification makeNotification(JSONObject paramJSONObject) {
    if (Build.VERSION.SDK_INT >= 26) {
      NotificationChannel notificationChannel = new NotificationChannel("cordova-plugin-background-mode-id", "Фоновий режим", 2);
      notificationChannel.setDescription("Сповіщення про роботу додатка у фоновому режимі");
      getNotificationManager().createNotificationChannel(notificationChannel);
    } 
    String str2 = paramJSONObject.optString("title", "App is running in background");
    String str1 = paramJSONObject.optString("text", "Doing heavy tasks.");
    boolean bool = paramJSONObject.optBoolean("bigText", false);
    Context context = getApplicationContext();
    String str3 = context.getPackageName();
    Intent intent = context.getPackageManager().getLaunchIntentForPackage(str3);
    Notification.Builder builder = (new Notification.Builder(context)).setContentTitle(str2).setContentText(str1).setOngoing(true).setSmallIcon(getIconResId(paramJSONObject));
    if (Build.VERSION.SDK_INT >= 26)
      builder.setChannelId("cordova-plugin-background-mode-id"); 
    if (paramJSONObject.optBoolean("hidden", true))
      builder.setPriority(-2); 
    if (bool || str1.contains("\n"))
      builder.setStyle((Notification.Style)(new Notification.BigTextStyle()).bigText(str1)); 
    setColor(builder, paramJSONObject);
    if (intent != null && paramJSONObject.optBoolean("resume")) {
      int i = 134217728;
      if (Build.VERSION.SDK_INT >= 31)
        i = 201326592; 
      intent.addFlags(603979776);
      builder.setContentIntent(PendingIntent.getActivity(context, -574543954, intent, i));
    } 
    return builder.build();
  }
  
  @TargetApi(21)
  private void setColor(Notification.Builder paramBuilder, JSONObject paramJSONObject) {
    String str = paramJSONObject.optString("color", null);
    if (Build.VERSION.SDK_INT < 21 || str == null)
      return; 
    try {
      paramBuilder.setColor(Integer.parseInt(str, 16) - 16777216);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void sleepWell() {
    stopForeground(true);
    getNotificationManager().cancel(-574543954);
    PowerManager.WakeLock wakeLock = this.wakeLock;
    if (wakeLock != null) {
      wakeLock.release();
      this.wakeLock = null;
    } 
  }
  
  public IBinder onBind(Intent paramIntent) {
    return this.binder;
  }
  
  public void onCreate() {
    super.onCreate();
    keepAwake();
  }
  
  public void onDestroy() {
    super.onDestroy();
    sleepWell();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    return 1;
  }
  
  protected void updateNotification(JSONObject paramJSONObject) {
    if (paramJSONObject.optBoolean("silent", false)) {
      stopForeground(true);
      return;
    } 
    Notification notification = makeNotification(paramJSONObject);
    getNotificationManager().notify(-574543954, notification);
  }
  
  class ForegroundBinder extends Binder {
    ForegroundService getService() {
      return ForegroundService.this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\de\appplant\cordova\plugin\background\ForegroundService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */