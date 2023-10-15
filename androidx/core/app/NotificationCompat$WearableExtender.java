package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WearableExtender implements NotificationCompat.Extender {
  private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
  
  private static final int DEFAULT_FLAGS = 1;
  
  private static final int DEFAULT_GRAVITY = 80;
  
  private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
  
  private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
  
  private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
  
  private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
  
  private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
  
  private static final int FLAG_HINT_HIDE_ICON = 2;
  
  private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
  
  private static final int FLAG_START_SCROLL_BOTTOM = 8;
  
  private static final String KEY_ACTIONS = "actions";
  
  private static final String KEY_BACKGROUND = "background";
  
  private static final String KEY_BRIDGE_TAG = "bridgeTag";
  
  private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
  
  private static final String KEY_CONTENT_ICON = "contentIcon";
  
  private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
  
  private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
  
  private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
  
  private static final String KEY_DISMISSAL_ID = "dismissalId";
  
  private static final String KEY_DISPLAY_INTENT = "displayIntent";
  
  private static final String KEY_FLAGS = "flags";
  
  private static final String KEY_GRAVITY = "gravity";
  
  private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
  
  private static final String KEY_PAGES = "pages";
  
  @Deprecated
  public static final int SCREEN_TIMEOUT_LONG = -1;
  
  @Deprecated
  public static final int SCREEN_TIMEOUT_SHORT = 0;
  
  @Deprecated
  public static final int SIZE_DEFAULT = 0;
  
  @Deprecated
  public static final int SIZE_FULL_SCREEN = 5;
  
  @Deprecated
  public static final int SIZE_LARGE = 4;
  
  @Deprecated
  public static final int SIZE_MEDIUM = 3;
  
  @Deprecated
  public static final int SIZE_SMALL = 2;
  
  @Deprecated
  public static final int SIZE_XSMALL = 1;
  
  public static final int UNSET_ACTION_INDEX = -1;
  
  private ArrayList<NotificationCompat.Action> mActions = new ArrayList<NotificationCompat.Action>();
  
  private Bitmap mBackground;
  
  private String mBridgeTag;
  
  private int mContentActionIndex = -1;
  
  private int mContentIcon;
  
  private int mContentIconGravity = 8388613;
  
  private int mCustomContentHeight;
  
  private int mCustomSizePreset = 0;
  
  private String mDismissalId;
  
  private PendingIntent mDisplayIntent;
  
  private int mFlags = 1;
  
  private int mGravity = 80;
  
  private int mHintScreenTimeout;
  
  private ArrayList<Notification> mPages = new ArrayList<Notification>();
  
  public WearableExtender() {}
  
  public WearableExtender(Notification paramNotification) {
    Bundle bundle = NotificationCompat.getExtras(paramNotification);
    if (bundle != null) {
      bundle = bundle.getBundle("android.wearable.EXTENSIONS");
    } else {
      bundle = null;
    } 
    if (bundle != null) {
      ArrayList<Notification.Action> arrayList = bundle.getParcelableArrayList("actions");
      if (Build.VERSION.SDK_INT >= 16 && arrayList != null) {
        NotificationCompat.Action[] arrayOfAction = new NotificationCompat.Action[arrayList.size()];
        for (byte b = 0; b < arrayOfAction.length; b++) {
          if (Build.VERSION.SDK_INT >= 20) {
            arrayOfAction[b] = NotificationCompat.getActionCompatFromAction(arrayList.get(b));
          } else if (Build.VERSION.SDK_INT >= 16) {
            arrayOfAction[b] = NotificationCompatJellybean.getActionFromBundle((Bundle)arrayList.get(b));
          } 
        } 
        Collections.addAll(this.mActions, arrayOfAction);
      } 
      this.mFlags = bundle.getInt("flags", 1);
      this.mDisplayIntent = (PendingIntent)bundle.getParcelable("displayIntent");
      Notification[] arrayOfNotification = NotificationCompat.getNotificationArrayFromBundle(bundle, "pages");
      if (arrayOfNotification != null)
        Collections.addAll(this.mPages, arrayOfNotification); 
      this.mBackground = (Bitmap)bundle.getParcelable("background");
      this.mContentIcon = bundle.getInt("contentIcon");
      this.mContentIconGravity = bundle.getInt("contentIconGravity", 8388613);
      this.mContentActionIndex = bundle.getInt("contentActionIndex", -1);
      this.mCustomSizePreset = bundle.getInt("customSizePreset", 0);
      this.mCustomContentHeight = bundle.getInt("customContentHeight");
      this.mGravity = bundle.getInt("gravity", 80);
      this.mHintScreenTimeout = bundle.getInt("hintScreenTimeout");
      this.mDismissalId = bundle.getString("dismissalId");
      this.mBridgeTag = bundle.getString("bridgeTag");
    } 
  }
  
  @RequiresApi(20)
  private static Notification.Action getActionFromActionCompat(NotificationCompat.Action paramAction) {
    Notification.Action.Builder builder;
    Bundle bundle;
    if (Build.VERSION.SDK_INT >= 23) {
      Icon icon;
      IconCompat iconCompat = paramAction.getIconCompat();
      if (iconCompat == null) {
        iconCompat = null;
      } else {
        icon = iconCompat.toIcon();
      } 
      builder = new Notification.Action.Builder(icon, paramAction.getTitle(), paramAction.getActionIntent());
    } else {
      builder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    } 
    if (paramAction.getExtras() != null) {
      bundle = new Bundle(paramAction.getExtras());
    } else {
      bundle = new Bundle();
    } 
    bundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    if (Build.VERSION.SDK_INT >= 24)
      builder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies()); 
    builder.addExtras(bundle);
    RemoteInput[] arrayOfRemoteInput = paramAction.getRemoteInputs();
    if (arrayOfRemoteInput != null) {
      RemoteInput[] arrayOfRemoteInput1 = RemoteInput.fromCompat(arrayOfRemoteInput);
      int i = arrayOfRemoteInput1.length;
      for (byte b = 0; b < i; b++)
        builder.addRemoteInput(arrayOfRemoteInput1[b]); 
    } 
    return builder.build();
  }
  
  private void setFlag(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags = paramInt | this.mFlags;
    } else {
      this.mFlags = (paramInt ^ 0xFFFFFFFF) & this.mFlags;
    } 
  }
  
  public WearableExtender addAction(NotificationCompat.Action paramAction) {
    this.mActions.add(paramAction);
    return this;
  }
  
  public WearableExtender addActions(List<NotificationCompat.Action> paramList) {
    this.mActions.addAll(paramList);
    return this;
  }
  
  @Deprecated
  public WearableExtender addPage(Notification paramNotification) {
    this.mPages.add(paramNotification);
    return this;
  }
  
  @Deprecated
  public WearableExtender addPages(List<Notification> paramList) {
    this.mPages.addAll(paramList);
    return this;
  }
  
  public WearableExtender clearActions() {
    this.mActions.clear();
    return this;
  }
  
  @Deprecated
  public WearableExtender clearPages() {
    this.mPages.clear();
    return this;
  }
  
  public WearableExtender clone() {
    WearableExtender wearableExtender = new WearableExtender();
    wearableExtender.mActions = new ArrayList<NotificationCompat.Action>(this.mActions);
    wearableExtender.mFlags = this.mFlags;
    wearableExtender.mDisplayIntent = this.mDisplayIntent;
    wearableExtender.mPages = new ArrayList<Notification>(this.mPages);
    wearableExtender.mBackground = this.mBackground;
    wearableExtender.mContentIcon = this.mContentIcon;
    wearableExtender.mContentIconGravity = this.mContentIconGravity;
    wearableExtender.mContentActionIndex = this.mContentActionIndex;
    wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
    wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
    wearableExtender.mGravity = this.mGravity;
    wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
    wearableExtender.mDismissalId = this.mDismissalId;
    wearableExtender.mBridgeTag = this.mBridgeTag;
    return wearableExtender;
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder) {
    Bundle bundle = new Bundle();
    if (!this.mActions.isEmpty())
      if (Build.VERSION.SDK_INT >= 16) {
        ArrayList<Notification.Action> arrayList = new ArrayList(this.mActions.size());
        for (NotificationCompat.Action action : this.mActions) {
          if (Build.VERSION.SDK_INT >= 20) {
            arrayList.add(getActionFromActionCompat(action));
            continue;
          } 
          if (Build.VERSION.SDK_INT >= 16)
            arrayList.add(NotificationCompatJellybean.getBundleForAction(action)); 
        } 
        bundle.putParcelableArrayList("actions", arrayList);
      } else {
        bundle.putParcelableArrayList("actions", null);
      }  
    int i = this.mFlags;
    if (i != 1)
      bundle.putInt("flags", i); 
    PendingIntent pendingIntent = this.mDisplayIntent;
    if (pendingIntent != null)
      bundle.putParcelable("displayIntent", (Parcelable)pendingIntent); 
    if (!this.mPages.isEmpty()) {
      ArrayList<Notification> arrayList = this.mPages;
      bundle.putParcelableArray("pages", (Parcelable[])arrayList.toArray((Object[])new Notification[arrayList.size()]));
    } 
    Bitmap bitmap = this.mBackground;
    if (bitmap != null)
      bundle.putParcelable("background", (Parcelable)bitmap); 
    i = this.mContentIcon;
    if (i != 0)
      bundle.putInt("contentIcon", i); 
    i = this.mContentIconGravity;
    if (i != 8388613)
      bundle.putInt("contentIconGravity", i); 
    i = this.mContentActionIndex;
    if (i != -1)
      bundle.putInt("contentActionIndex", i); 
    i = this.mCustomSizePreset;
    if (i != 0)
      bundle.putInt("customSizePreset", i); 
    i = this.mCustomContentHeight;
    if (i != 0)
      bundle.putInt("customContentHeight", i); 
    i = this.mGravity;
    if (i != 80)
      bundle.putInt("gravity", i); 
    i = this.mHintScreenTimeout;
    if (i != 0)
      bundle.putInt("hintScreenTimeout", i); 
    String str = this.mDismissalId;
    if (str != null)
      bundle.putString("dismissalId", str); 
    str = this.mBridgeTag;
    if (str != null)
      bundle.putString("bridgeTag", str); 
    paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
    return paramBuilder;
  }
  
  public List<NotificationCompat.Action> getActions() {
    return this.mActions;
  }
  
  @Deprecated
  public Bitmap getBackground() {
    return this.mBackground;
  }
  
  public String getBridgeTag() {
    return this.mBridgeTag;
  }
  
  public int getContentAction() {
    return this.mContentActionIndex;
  }
  
  @Deprecated
  public int getContentIcon() {
    return this.mContentIcon;
  }
  
  @Deprecated
  public int getContentIconGravity() {
    return this.mContentIconGravity;
  }
  
  public boolean getContentIntentAvailableOffline() {
    int i = this.mFlags;
    boolean bool = true;
    if ((i & 0x1) == 0)
      bool = false; 
    return bool;
  }
  
  @Deprecated
  public int getCustomContentHeight() {
    return this.mCustomContentHeight;
  }
  
  @Deprecated
  public int getCustomSizePreset() {
    return this.mCustomSizePreset;
  }
  
  public String getDismissalId() {
    return this.mDismissalId;
  }
  
  @Deprecated
  public PendingIntent getDisplayIntent() {
    return this.mDisplayIntent;
  }
  
  @Deprecated
  public int getGravity() {
    return this.mGravity;
  }
  
  @Deprecated
  public boolean getHintAmbientBigPicture() {
    boolean bool;
    if ((this.mFlags & 0x20) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Deprecated
  public boolean getHintAvoidBackgroundClipping() {
    boolean bool;
    if ((this.mFlags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean getHintContentIntentLaunchesActivity() {
    boolean bool;
    if ((this.mFlags & 0x40) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Deprecated
  public boolean getHintHideIcon() {
    boolean bool;
    if ((this.mFlags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Deprecated
  public int getHintScreenTimeout() {
    return this.mHintScreenTimeout;
  }
  
  @Deprecated
  public boolean getHintShowBackgroundOnly() {
    boolean bool;
    if ((this.mFlags & 0x4) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Deprecated
  public List<Notification> getPages() {
    return this.mPages;
  }
  
  public boolean getStartScrollBottom() {
    boolean bool;
    if ((this.mFlags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Deprecated
  public WearableExtender setBackground(Bitmap paramBitmap) {
    this.mBackground = paramBitmap;
    return this;
  }
  
  public WearableExtender setBridgeTag(String paramString) {
    this.mBridgeTag = paramString;
    return this;
  }
  
  public WearableExtender setContentAction(int paramInt) {
    this.mContentActionIndex = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setContentIcon(int paramInt) {
    this.mContentIcon = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setContentIconGravity(int paramInt) {
    this.mContentIconGravity = paramInt;
    return this;
  }
  
  public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean) {
    setFlag(1, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setCustomContentHeight(int paramInt) {
    this.mCustomContentHeight = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setCustomSizePreset(int paramInt) {
    this.mCustomSizePreset = paramInt;
    return this;
  }
  
  public WearableExtender setDismissalId(String paramString) {
    this.mDismissalId = paramString;
    return this;
  }
  
  @Deprecated
  public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent) {
    this.mDisplayIntent = paramPendingIntent;
    return this;
  }
  
  @Deprecated
  public WearableExtender setGravity(int paramInt) {
    this.mGravity = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintAmbientBigPicture(boolean paramBoolean) {
    setFlag(32, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean) {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean) {
    setFlag(64, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintHideIcon(boolean paramBoolean) {
    setFlag(2, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintScreenTimeout(int paramInt) {
    this.mHintScreenTimeout = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean) {
    setFlag(4, paramBoolean);
    return this;
  }
  
  public WearableExtender setStartScrollBottom(boolean paramBoolean) {
    setFlag(8, paramBoolean);
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$WearableExtender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */