package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {
  public static final int BADGE_ICON_LARGE = 2;
  
  public static final int BADGE_ICON_NONE = 0;
  
  public static final int BADGE_ICON_SMALL = 1;
  
  public static final String CATEGORY_ALARM = "alarm";
  
  public static final String CATEGORY_CALL = "call";
  
  public static final String CATEGORY_EMAIL = "email";
  
  public static final String CATEGORY_ERROR = "err";
  
  public static final String CATEGORY_EVENT = "event";
  
  public static final String CATEGORY_MESSAGE = "msg";
  
  public static final String CATEGORY_NAVIGATION = "navigation";
  
  public static final String CATEGORY_PROGRESS = "progress";
  
  public static final String CATEGORY_PROMO = "promo";
  
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  
  public static final String CATEGORY_REMINDER = "reminder";
  
  public static final String CATEGORY_SERVICE = "service";
  
  public static final String CATEGORY_SOCIAL = "social";
  
  public static final String CATEGORY_STATUS = "status";
  
  public static final String CATEGORY_SYSTEM = "sys";
  
  public static final String CATEGORY_TRANSPORT = "transport";
  
  @ColorInt
  public static final int COLOR_DEFAULT = 0;
  
  public static final int DEFAULT_ALL = -1;
  
  public static final int DEFAULT_LIGHTS = 4;
  
  public static final int DEFAULT_SOUND = 1;
  
  public static final int DEFAULT_VIBRATE = 2;
  
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  
  public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
  
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  
  public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
  
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  
  public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
  
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  
  public static final String EXTRA_MESSAGES = "android.messages";
  
  public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
  
  public static final String EXTRA_PEOPLE = "android.people";
  
  public static final String EXTRA_PICTURE = "android.picture";
  
  public static final String EXTRA_PROGRESS = "android.progress";
  
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  
  public static final String EXTRA_SMALL_ICON = "android.icon";
  
  public static final String EXTRA_SUB_TEXT = "android.subText";
  
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  
  public static final String EXTRA_TEMPLATE = "android.template";
  
  public static final String EXTRA_TEXT = "android.text";
  
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  
  public static final String EXTRA_TITLE = "android.title";
  
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  
  public static final int FLAG_AUTO_CANCEL = 16;
  
  public static final int FLAG_BUBBLE = 4096;
  
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  
  public static final int FLAG_GROUP_SUMMARY = 512;
  
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  
  public static final int FLAG_INSISTENT = 4;
  
  public static final int FLAG_LOCAL_ONLY = 256;
  
  public static final int FLAG_NO_CLEAR = 32;
  
  public static final int FLAG_ONGOING_EVENT = 2;
  
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  
  public static final int FLAG_SHOW_LIGHTS = 1;
  
  public static final int GROUP_ALERT_ALL = 0;
  
  public static final int GROUP_ALERT_CHILDREN = 2;
  
  public static final int GROUP_ALERT_SUMMARY = 1;
  
  public static final int PRIORITY_DEFAULT = 0;
  
  public static final int PRIORITY_HIGH = 1;
  
  public static final int PRIORITY_LOW = -1;
  
  public static final int PRIORITY_MAX = 2;
  
  public static final int PRIORITY_MIN = -2;
  
  public static final int STREAM_DEFAULT = -1;
  
  public static final int VISIBILITY_PRIVATE = 0;
  
  public static final int VISIBILITY_PUBLIC = 1;
  
  public static final int VISIBILITY_SECRET = -1;
  
  public static Action getAction(Notification paramNotification, int paramInt) {
    Bundle bundle;
    if (Build.VERSION.SDK_INT >= 20)
      return getActionCompatFromAction(paramNotification.actions[paramInt]); 
    int i = Build.VERSION.SDK_INT;
    Notification notification = null;
    if (i >= 19) {
      Notification.Action action = paramNotification.actions[paramInt];
      SparseArray sparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
      paramNotification = notification;
      if (sparseArray != null)
        bundle = (Bundle)sparseArray.get(paramInt); 
      return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, bundle);
    } 
    return (Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getAction((Notification)bundle, paramInt) : null;
  }
  
  @RequiresApi(20)
  static Action getActionCompatFromAction(Notification.Action paramAction) {
    RemoteInput[] arrayOfRemoteInput1;
    int i;
    boolean bool1;
    boolean bool;
    RemoteInput[] arrayOfRemoteInput = paramAction.getRemoteInputs();
    if (arrayOfRemoteInput == null) {
      arrayOfRemoteInput1 = null;
    } else {
      arrayOfRemoteInput1 = new RemoteInput[arrayOfRemoteInput.length];
      for (i = 0; i < arrayOfRemoteInput.length; i++) {
        boolean bool3;
        RemoteInput remoteInput = arrayOfRemoteInput[i];
        String str = remoteInput.getResultKey();
        CharSequence charSequence = remoteInput.getLabel();
        CharSequence[] arrayOfCharSequence = remoteInput.getChoices();
        bool1 = remoteInput.getAllowFreeFormInput();
        if (Build.VERSION.SDK_INT >= 29) {
          bool3 = remoteInput.getEditChoicesBeforeSending();
        } else {
          bool3 = false;
        } 
        arrayOfRemoteInput1[i] = new RemoteInput(str, charSequence, arrayOfCharSequence, bool1, bool3, remoteInput.getExtras(), null);
      } 
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      if (paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies") || paramAction.getAllowGeneratedReplies()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } else {
      bool1 = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
    } 
    boolean bool2 = paramAction.getExtras().getBoolean("android.support.action.showsUserInterface", true);
    if (Build.VERSION.SDK_INT >= 28) {
      i = paramAction.getSemanticAction();
    } else {
      i = paramAction.getExtras().getInt("android.support.action.semanticAction", 0);
    } 
    if (Build.VERSION.SDK_INT >= 29) {
      bool = paramAction.isContextual();
    } else {
      bool = false;
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      IconCompat iconCompat;
      if (paramAction.getIcon() == null && paramAction.icon != 0)
        return new Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput1, null, bool1, i, bool2, bool); 
      if (paramAction.getIcon() == null) {
        iconCompat = null;
      } else {
        iconCompat = IconCompat.createFromIconOrNullIfZeroResId(paramAction.getIcon());
      } 
      return new Action(iconCompat, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput1, null, bool1, i, bool2, bool);
    } 
    return new Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput1, null, bool1, i, bool2, bool);
  }
  
  public static int getActionCount(Notification paramNotification) {
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i >= 19) {
      if (paramNotification.actions != null)
        j = paramNotification.actions.length; 
      return j;
    } 
    return (Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getActionCount(paramNotification) : 0;
  }
  
  public static boolean getAllowSystemGeneratedContextualActions(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 29) ? paramNotification.getAllowSystemGeneratedContextualActions() : false;
  }
  
  public static int getBadgeIconType(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getBadgeIconType() : 0;
  }
  
  @Nullable
  public static BubbleMetadata getBubbleMetadata(@NonNull Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 29) ? BubbleMetadata.fromPlatform(paramNotification.getBubbleMetadata()) : null;
  }
  
  public static String getCategory(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 21) ? paramNotification.category : null;
  }
  
  public static String getChannelId(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getChannelId() : null;
  }
  
  @RequiresApi(19)
  public static CharSequence getContentTitle(Notification paramNotification) {
    return paramNotification.extras.getCharSequence("android.title");
  }
  
  @Nullable
  public static Bundle getExtras(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification) : null);
  }
  
  public static String getGroup(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 20) ? paramNotification.getGroup() : ((Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getString("android.support.groupKey") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey") : null));
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getGroupAlertBehavior() : 0;
  }
  
  @RequiresApi(21)
  public static List<Action> getInvisibleActions(Notification paramNotification) {
    ArrayList<Action> arrayList = new ArrayList();
    Bundle bundle = paramNotification.extras.getBundle("android.car.EXTENSIONS");
    if (bundle == null)
      return arrayList; 
    bundle = bundle.getBundle("invisible_actions");
    if (bundle != null)
      for (byte b = 0; b < bundle.size(); b++)
        arrayList.add(NotificationCompatJellybean.getActionFromBundle(bundle.getBundle(Integer.toString(b))));  
    return arrayList;
  }
  
  public static boolean getLocalOnly(Notification paramNotification) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 20) {
      if ((paramNotification.flags & 0x100) != 0)
        bool = true; 
      return bool;
    } 
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getBoolean("android.support.localOnly") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly") : false);
  }
  
  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString) {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (arrayOfParcelable instanceof Notification[] || arrayOfParcelable == null)
      return (Notification[])arrayOfParcelable; 
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    for (byte b = 0; b < arrayOfParcelable.length; b++)
      arrayOfNotification[b] = (Notification)arrayOfParcelable[b]; 
    paramBundle.putParcelableArray(paramString, (Parcelable[])arrayOfNotification);
    return arrayOfNotification;
  }
  
  public static String getShortcutId(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getShortcutId() : null;
  }
  
  public static String getSortKey(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 20) ? paramNotification.getSortKey() : ((Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getString("android.support.sortKey") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey") : null));
  }
  
  public static long getTimeoutAfter(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getTimeoutAfter() : 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 20) {
      if ((paramNotification.flags & 0x200) != 0)
        bool = true; 
      return bool;
    } 
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getBoolean("android.support.isGroupSummary") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary") : false);
  }
  
  public static class Action {
    static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
    
    static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
    
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    
    public static final int SEMANTIC_ACTION_CALL = 10;
    
    public static final int SEMANTIC_ACTION_DELETE = 4;
    
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    
    public static final int SEMANTIC_ACTION_MUTE = 6;
    
    public static final int SEMANTIC_ACTION_NONE = 0;
    
    public static final int SEMANTIC_ACTION_REPLY = 1;
    
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    
    public PendingIntent actionIntent;
    
    @Deprecated
    public int icon;
    
    private boolean mAllowGeneratedReplies;
    
    private final RemoteInput[] mDataOnlyRemoteInputs;
    
    final Bundle mExtras;
    
    @Nullable
    private IconCompat mIcon;
    
    private final boolean mIsContextual;
    
    private final RemoteInput[] mRemoteInputs;
    
    private final int mSemanticAction;
    
    boolean mShowsUserInterface = true;
    
    public CharSequence title;
    
    public Action(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(iconCompat, param1CharSequence, param1PendingIntent);
    }
    
    Action(int param1Int1, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput1, RemoteInput[] param1ArrayOfRemoteInput2, boolean param1Boolean1, int param1Int2, boolean param1Boolean2, boolean param1Boolean3) {
      this(iconCompat, param1CharSequence, param1PendingIntent, param1Bundle, param1ArrayOfRemoteInput1, param1ArrayOfRemoteInput2, param1Boolean1, param1Int2, param1Boolean2, param1Boolean3);
    }
    
    public Action(@Nullable IconCompat param1IconCompat, @Nullable CharSequence param1CharSequence, @Nullable PendingIntent param1PendingIntent) {
      this(param1IconCompat, param1CharSequence, param1PendingIntent, new Bundle(), (RemoteInput[])null, (RemoteInput[])null, true, 0, true, false);
    }
    
    Action(@Nullable IconCompat param1IconCompat, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput1, RemoteInput[] param1ArrayOfRemoteInput2, boolean param1Boolean1, int param1Int, boolean param1Boolean2, boolean param1Boolean3) {
      this.mIcon = param1IconCompat;
      if (param1IconCompat != null && param1IconCompat.getType() == 2)
        this.icon = param1IconCompat.getResId(); 
      this.title = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.actionIntent = param1PendingIntent;
      if (param1Bundle == null)
        param1Bundle = new Bundle(); 
      this.mExtras = param1Bundle;
      this.mRemoteInputs = param1ArrayOfRemoteInput1;
      this.mDataOnlyRemoteInputs = param1ArrayOfRemoteInput2;
      this.mAllowGeneratedReplies = param1Boolean1;
      this.mSemanticAction = param1Int;
      this.mShowsUserInterface = param1Boolean2;
      this.mIsContextual = param1Boolean3;
    }
    
    public PendingIntent getActionIntent() {
      return this.actionIntent;
    }
    
    public boolean getAllowGeneratedReplies() {
      return this.mAllowGeneratedReplies;
    }
    
    public RemoteInput[] getDataOnlyRemoteInputs() {
      return this.mDataOnlyRemoteInputs;
    }
    
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    @Deprecated
    public int getIcon() {
      return this.icon;
    }
    
    @Nullable
    public IconCompat getIconCompat() {
      if (this.mIcon == null) {
        int i = this.icon;
        if (i != 0)
          this.mIcon = IconCompat.createWithResource(null, "", i); 
      } 
      return this.mIcon;
    }
    
    public RemoteInput[] getRemoteInputs() {
      return this.mRemoteInputs;
    }
    
    public int getSemanticAction() {
      return this.mSemanticAction;
    }
    
    public boolean getShowsUserInterface() {
      return this.mShowsUserInterface;
    }
    
    public CharSequence getTitle() {
      return this.title;
    }
    
    public boolean isContextual() {
      return this.mIsContextual;
    }
    
    public static final class Builder {
      private boolean mAllowGeneratedReplies;
      
      private final Bundle mExtras;
      
      private final IconCompat mIcon;
      
      private final PendingIntent mIntent;
      
      private boolean mIsContextual;
      
      private ArrayList<RemoteInput> mRemoteInputs;
      
      private int mSemanticAction;
      
      private boolean mShowsUserInterface;
      
      private final CharSequence mTitle;
      
      public Builder(int param2Int, CharSequence param2CharSequence, PendingIntent param2PendingIntent) {
        this(iconCompat, param2CharSequence, param2PendingIntent, new Bundle(), null, true, 0, true, false);
      }
      
      public Builder(NotificationCompat.Action param2Action) {
        this(param2Action.getIconCompat(), param2Action.title, param2Action.actionIntent, new Bundle(param2Action.mExtras), param2Action.getRemoteInputs(), param2Action.getAllowGeneratedReplies(), param2Action.getSemanticAction(), param2Action.mShowsUserInterface, param2Action.isContextual());
      }
      
      public Builder(@Nullable IconCompat param2IconCompat, @Nullable CharSequence param2CharSequence, @Nullable PendingIntent param2PendingIntent) {
        this(param2IconCompat, param2CharSequence, param2PendingIntent, new Bundle(), null, true, 0, true, false);
      }
      
      private Builder(@Nullable IconCompat param2IconCompat, CharSequence param2CharSequence, PendingIntent param2PendingIntent, Bundle param2Bundle, RemoteInput[] param2ArrayOfRemoteInput, boolean param2Boolean1, int param2Int, boolean param2Boolean2, boolean param2Boolean3) {
        ArrayList<RemoteInput> arrayList;
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
        this.mIcon = param2IconCompat;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(param2CharSequence);
        this.mIntent = param2PendingIntent;
        this.mExtras = param2Bundle;
        if (param2ArrayOfRemoteInput == null) {
          param2IconCompat = null;
        } else {
          arrayList = new ArrayList(Arrays.asList((Object[])param2ArrayOfRemoteInput));
        } 
        this.mRemoteInputs = arrayList;
        this.mAllowGeneratedReplies = param2Boolean1;
        this.mSemanticAction = param2Int;
        this.mShowsUserInterface = param2Boolean2;
        this.mIsContextual = param2Boolean3;
      }
      
      private void checkContextualActionNullFields() {
        if (!this.mIsContextual)
          return; 
        if (this.mIntent != null)
          return; 
        throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
      }
      
      public Builder addExtras(Bundle param2Bundle) {
        if (param2Bundle != null)
          this.mExtras.putAll(param2Bundle); 
        return this;
      }
      
      public Builder addRemoteInput(RemoteInput param2RemoteInput) {
        if (this.mRemoteInputs == null)
          this.mRemoteInputs = new ArrayList<RemoteInput>(); 
        this.mRemoteInputs.add(param2RemoteInput);
        return this;
      }
      
      public NotificationCompat.Action build() {
        RemoteInput[] arrayOfRemoteInput1;
        RemoteInput[] arrayOfRemoteInput2;
        checkContextualActionNullFields();
        ArrayList<RemoteInput> arrayList1 = new ArrayList();
        ArrayList<RemoteInput> arrayList2 = new ArrayList();
        ArrayList<RemoteInput> arrayList3 = this.mRemoteInputs;
        if (arrayList3 != null)
          for (RemoteInput remoteInput : arrayList3) {
            if (remoteInput.isDataOnly()) {
              arrayList1.add(remoteInput);
              continue;
            } 
            arrayList2.add(remoteInput);
          }  
        if (arrayList1.isEmpty()) {
          arrayList1 = null;
        } else {
          arrayOfRemoteInput1 = arrayList1.<RemoteInput>toArray(new RemoteInput[arrayList1.size()]);
        } 
        if (arrayList2.isEmpty()) {
          arrayList2 = null;
        } else {
          arrayOfRemoteInput2 = arrayList2.<RemoteInput>toArray(new RemoteInput[arrayList2.size()]);
        } 
        return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput2, arrayOfRemoteInput1, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
      }
      
      public Builder extend(NotificationCompat.Action.Extender param2Extender) {
        param2Extender.extend(this);
        return this;
      }
      
      public Bundle getExtras() {
        return this.mExtras;
      }
      
      public Builder setAllowGeneratedReplies(boolean param2Boolean) {
        this.mAllowGeneratedReplies = param2Boolean;
        return this;
      }
      
      @NonNull
      public Builder setContextual(boolean param2Boolean) {
        this.mIsContextual = param2Boolean;
        return this;
      }
      
      public Builder setSemanticAction(int param2Int) {
        this.mSemanticAction = param2Int;
        return this;
      }
      
      public Builder setShowsUserInterface(boolean param2Boolean) {
        this.mShowsUserInterface = param2Boolean;
        return this;
      }
    }
    
    public static interface Extender {
      NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param2Builder);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface SemanticAction {}
    
    public static final class WearableExtender implements Extender {
      private static final int DEFAULT_FLAGS = 1;
      
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      
      private static final int FLAG_AVAILABLE_OFFLINE = 1;
      
      private static final int FLAG_HINT_DISPLAY_INLINE = 4;
      
      private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
      
      private static final String KEY_CANCEL_LABEL = "cancelLabel";
      
      private static final String KEY_CONFIRM_LABEL = "confirmLabel";
      
      private static final String KEY_FLAGS = "flags";
      
      private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      
      private CharSequence mCancelLabel;
      
      private CharSequence mConfirmLabel;
      
      private int mFlags = 1;
      
      private CharSequence mInProgressLabel;
      
      public WearableExtender() {}
      
      public WearableExtender(NotificationCompat.Action param2Action) {
        Bundle bundle = param2Action.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (bundle != null) {
          this.mFlags = bundle.getInt("flags", 1);
          this.mInProgressLabel = bundle.getCharSequence("inProgressLabel");
          this.mConfirmLabel = bundle.getCharSequence("confirmLabel");
          this.mCancelLabel = bundle.getCharSequence("cancelLabel");
        } 
      }
      
      private void setFlag(int param2Int, boolean param2Boolean) {
        if (param2Boolean) {
          this.mFlags = param2Int | this.mFlags;
        } else {
          this.mFlags = (param2Int ^ 0xFFFFFFFF) & this.mFlags;
        } 
      }
      
      public WearableExtender clone() {
        WearableExtender wearableExtender = new WearableExtender();
        wearableExtender.mFlags = this.mFlags;
        wearableExtender.mInProgressLabel = this.mInProgressLabel;
        wearableExtender.mConfirmLabel = this.mConfirmLabel;
        wearableExtender.mCancelLabel = this.mCancelLabel;
        return wearableExtender;
      }
      
      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param2Builder) {
        Bundle bundle = new Bundle();
        int i = this.mFlags;
        if (i != 1)
          bundle.putInt("flags", i); 
        CharSequence charSequence = this.mInProgressLabel;
        if (charSequence != null)
          bundle.putCharSequence("inProgressLabel", charSequence); 
        charSequence = this.mConfirmLabel;
        if (charSequence != null)
          bundle.putCharSequence("confirmLabel", charSequence); 
        charSequence = this.mCancelLabel;
        if (charSequence != null)
          bundle.putCharSequence("cancelLabel", charSequence); 
        param2Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return param2Builder;
      }
      
      @Deprecated
      public CharSequence getCancelLabel() {
        return this.mCancelLabel;
      }
      
      @Deprecated
      public CharSequence getConfirmLabel() {
        return this.mConfirmLabel;
      }
      
      public boolean getHintDisplayActionInline() {
        boolean bool;
        if ((this.mFlags & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean getHintLaunchesActivity() {
        boolean bool;
        if ((this.mFlags & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      @Deprecated
      public CharSequence getInProgressLabel() {
        return this.mInProgressLabel;
      }
      
      public boolean isAvailableOffline() {
        int i = this.mFlags;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        return bool;
      }
      
      public WearableExtender setAvailableOffline(boolean param2Boolean) {
        setFlag(1, param2Boolean);
        return this;
      }
      
      @Deprecated
      public WearableExtender setCancelLabel(CharSequence param2CharSequence) {
        this.mCancelLabel = param2CharSequence;
        return this;
      }
      
      @Deprecated
      public WearableExtender setConfirmLabel(CharSequence param2CharSequence) {
        this.mConfirmLabel = param2CharSequence;
        return this;
      }
      
      public WearableExtender setHintDisplayActionInline(boolean param2Boolean) {
        setFlag(4, param2Boolean);
        return this;
      }
      
      public WearableExtender setHintLaunchesActivity(boolean param2Boolean) {
        setFlag(2, param2Boolean);
        return this;
      }
      
      @Deprecated
      public WearableExtender setInProgressLabel(CharSequence param2CharSequence) {
        this.mInProgressLabel = param2CharSequence;
        return this;
      }
    }
  }
  
  public static final class Builder {
    private boolean mAllowGeneratedReplies;
    
    private final Bundle mExtras;
    
    private final IconCompat mIcon;
    
    private final PendingIntent mIntent;
    
    private boolean mIsContextual;
    
    private ArrayList<RemoteInput> mRemoteInputs;
    
    private int mSemanticAction;
    
    private boolean mShowsUserInterface;
    
    private final CharSequence mTitle;
    
    public Builder(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(iconCompat, param1CharSequence, param1PendingIntent, new Bundle(), null, true, 0, true, false);
    }
    
    public Builder(NotificationCompat.Action param1Action) {
      this(param1Action.getIconCompat(), param1Action.title, param1Action.actionIntent, new Bundle(param1Action.mExtras), param1Action.getRemoteInputs(), param1Action.getAllowGeneratedReplies(), param1Action.getSemanticAction(), param1Action.mShowsUserInterface, param1Action.isContextual());
    }
    
    public Builder(@Nullable IconCompat param1IconCompat, @Nullable CharSequence param1CharSequence, @Nullable PendingIntent param1PendingIntent) {
      this(param1IconCompat, param1CharSequence, param1PendingIntent, new Bundle(), null, true, 0, true, false);
    }
    
    private Builder(@Nullable IconCompat param1IconCompat, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput, boolean param1Boolean1, int param1Int, boolean param1Boolean2, boolean param1Boolean3) {
      ArrayList<RemoteInput> arrayList;
      this.mAllowGeneratedReplies = true;
      this.mShowsUserInterface = true;
      this.mIcon = param1IconCompat;
      this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mIntent = param1PendingIntent;
      this.mExtras = param1Bundle;
      if (param1ArrayOfRemoteInput == null) {
        param1IconCompat = null;
      } else {
        arrayList = new ArrayList(Arrays.asList((Object[])param1ArrayOfRemoteInput));
      } 
      this.mRemoteInputs = arrayList;
      this.mAllowGeneratedReplies = param1Boolean1;
      this.mSemanticAction = param1Int;
      this.mShowsUserInterface = param1Boolean2;
      this.mIsContextual = param1Boolean3;
    }
    
    private void checkContextualActionNullFields() {
      if (!this.mIsContextual)
        return; 
      if (this.mIntent != null)
        return; 
      throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      return this;
    }
    
    public Builder addRemoteInput(RemoteInput param1RemoteInput) {
      if (this.mRemoteInputs == null)
        this.mRemoteInputs = new ArrayList<RemoteInput>(); 
      this.mRemoteInputs.add(param1RemoteInput);
      return this;
    }
    
    public NotificationCompat.Action build() {
      RemoteInput[] arrayOfRemoteInput1;
      RemoteInput[] arrayOfRemoteInput2;
      checkContextualActionNullFields();
      ArrayList<RemoteInput> arrayList1 = new ArrayList();
      ArrayList<RemoteInput> arrayList2 = new ArrayList();
      ArrayList<RemoteInput> arrayList3 = this.mRemoteInputs;
      if (arrayList3 != null)
        for (RemoteInput remoteInput : arrayList3) {
          if (remoteInput.isDataOnly()) {
            arrayList1.add(remoteInput);
            continue;
          } 
          arrayList2.add(remoteInput);
        }  
      if (arrayList1.isEmpty()) {
        arrayList1 = null;
      } else {
        arrayOfRemoteInput1 = arrayList1.<RemoteInput>toArray(new RemoteInput[arrayList1.size()]);
      } 
      if (arrayList2.isEmpty()) {
        arrayList2 = null;
      } else {
        arrayOfRemoteInput2 = arrayList2.<RemoteInput>toArray(new RemoteInput[arrayList2.size()]);
      } 
      return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput2, arrayOfRemoteInput1, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
    }
    
    public Builder extend(NotificationCompat.Action.Extender param1Extender) {
      param1Extender.extend(this);
      return this;
    }
    
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    public Builder setAllowGeneratedReplies(boolean param1Boolean) {
      this.mAllowGeneratedReplies = param1Boolean;
      return this;
    }
    
    @NonNull
    public Builder setContextual(boolean param1Boolean) {
      this.mIsContextual = param1Boolean;
      return this;
    }
    
    public Builder setSemanticAction(int param1Int) {
      this.mSemanticAction = param1Int;
      return this;
    }
    
    public Builder setShowsUserInterface(boolean param1Boolean) {
      this.mShowsUserInterface = param1Boolean;
      return this;
    }
  }
  
  public static interface Extender {
    NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param1Builder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SemanticAction {}
  
  public static final class WearableExtender implements Action.Extender {
    private static final int DEFAULT_FLAGS = 1;
    
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    
    private static final int FLAG_HINT_DISPLAY_INLINE = 4;
    
    private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
    
    private static final String KEY_CANCEL_LABEL = "cancelLabel";
    
    private static final String KEY_CONFIRM_LABEL = "confirmLabel";
    
    private static final String KEY_FLAGS = "flags";
    
    private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
    
    private CharSequence mCancelLabel;
    
    private CharSequence mConfirmLabel;
    
    private int mFlags = 1;
    
    private CharSequence mInProgressLabel;
    
    public WearableExtender() {}
    
    public WearableExtender(NotificationCompat.Action param1Action) {
      Bundle bundle = param1Action.getExtras().getBundle("android.wearable.EXTENSIONS");
      if (bundle != null) {
        this.mFlags = bundle.getInt("flags", 1);
        this.mInProgressLabel = bundle.getCharSequence("inProgressLabel");
        this.mConfirmLabel = bundle.getCharSequence("confirmLabel");
        this.mCancelLabel = bundle.getCharSequence("cancelLabel");
      } 
    }
    
    private void setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.mFlags = param1Int | this.mFlags;
      } else {
        this.mFlags = (param1Int ^ 0xFFFFFFFF) & this.mFlags;
      } 
    }
    
    public WearableExtender clone() {
      WearableExtender wearableExtender = new WearableExtender();
      wearableExtender.mFlags = this.mFlags;
      wearableExtender.mInProgressLabel = this.mInProgressLabel;
      wearableExtender.mConfirmLabel = this.mConfirmLabel;
      wearableExtender.mCancelLabel = this.mCancelLabel;
      return wearableExtender;
    }
    
    public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param1Builder) {
      Bundle bundle = new Bundle();
      int i = this.mFlags;
      if (i != 1)
        bundle.putInt("flags", i); 
      CharSequence charSequence = this.mInProgressLabel;
      if (charSequence != null)
        bundle.putCharSequence("inProgressLabel", charSequence); 
      charSequence = this.mConfirmLabel;
      if (charSequence != null)
        bundle.putCharSequence("confirmLabel", charSequence); 
      charSequence = this.mCancelLabel;
      if (charSequence != null)
        bundle.putCharSequence("cancelLabel", charSequence); 
      param1Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    @Deprecated
    public CharSequence getCancelLabel() {
      return this.mCancelLabel;
    }
    
    @Deprecated
    public CharSequence getConfirmLabel() {
      return this.mConfirmLabel;
    }
    
    public boolean getHintDisplayActionInline() {
      boolean bool;
      if ((this.mFlags & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean getHintLaunchesActivity() {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @Deprecated
    public CharSequence getInProgressLabel() {
      return this.mInProgressLabel;
    }
    
    public boolean isAvailableOffline() {
      int i = this.mFlags;
      boolean bool = true;
      if ((i & 0x1) == 0)
        bool = false; 
      return bool;
    }
    
    public WearableExtender setAvailableOffline(boolean param1Boolean) {
      setFlag(1, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setCancelLabel(CharSequence param1CharSequence) {
      this.mCancelLabel = param1CharSequence;
      return this;
    }
    
    @Deprecated
    public WearableExtender setConfirmLabel(CharSequence param1CharSequence) {
      this.mConfirmLabel = param1CharSequence;
      return this;
    }
    
    public WearableExtender setHintDisplayActionInline(boolean param1Boolean) {
      setFlag(4, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintLaunchesActivity(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setInProgressLabel(CharSequence param1CharSequence) {
      this.mInProgressLabel = param1CharSequence;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface BadgeIconType {}
  
  public static class BigPictureStyle extends Style {
    private Bitmap mBigLargeIcon;
    
    private boolean mBigLargeIconSet;
    
    private Bitmap mPicture;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.BigPictureStyle bigPictureStyle = (new Notification.BigPictureStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
        if (this.mBigLargeIconSet)
          bigPictureStyle.bigLargeIcon(this.mBigLargeIcon); 
        if (this.mSummaryTextSet)
          bigPictureStyle.setSummaryText(this.mSummaryText); 
      } 
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap param1Bitmap) {
      this.mBigLargeIcon = param1Bitmap;
      this.mBigLargeIconSet = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap param1Bitmap) {
      this.mPicture = param1Bitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence param1CharSequence) {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class BigTextStyle extends Style {
    private CharSequence mBigText;
    
    public BigTextStyle() {}
    
    public BigTextStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.BigTextStyle bigTextStyle = (new Notification.BigTextStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
        if (this.mSummaryTextSet)
          bigTextStyle.setSummaryText(this.mSummaryText); 
      } 
    }
    
    public BigTextStyle bigText(CharSequence param1CharSequence) {
      this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence param1CharSequence) {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static final class BubbleMetadata {
    private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
    
    private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
    
    private PendingIntent mDeleteIntent;
    
    private int mDesiredHeight;
    
    @DimenRes
    private int mDesiredHeightResId;
    
    private int mFlags;
    
    private IconCompat mIcon;
    
    private PendingIntent mPendingIntent;
    
    private BubbleMetadata(PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, IconCompat param1IconCompat, int param1Int1, @DimenRes int param1Int2, int param1Int3) {
      this.mPendingIntent = param1PendingIntent1;
      this.mIcon = param1IconCompat;
      this.mDesiredHeight = param1Int1;
      this.mDesiredHeightResId = param1Int2;
      this.mDeleteIntent = param1PendingIntent2;
      this.mFlags = param1Int3;
    }
    
    @Nullable
    @RequiresApi(29)
    public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata param1BubbleMetadata) {
      if (param1BubbleMetadata == null)
        return null; 
      Builder builder = (new Builder()).setAutoExpandBubble(param1BubbleMetadata.getAutoExpandBubble()).setDeleteIntent(param1BubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(param1BubbleMetadata.getIcon())).setIntent(param1BubbleMetadata.getIntent()).setSuppressNotification(param1BubbleMetadata.isNotificationSuppressed());
      if (param1BubbleMetadata.getDesiredHeight() != 0)
        builder.setDesiredHeight(param1BubbleMetadata.getDesiredHeight()); 
      if (param1BubbleMetadata.getDesiredHeightResId() != 0)
        builder.setDesiredHeightResId(param1BubbleMetadata.getDesiredHeightResId()); 
      return builder.build();
    }
    
    private void setFlags(int param1Int) {
      this.mFlags = param1Int;
    }
    
    @Nullable
    @RequiresApi(29)
    public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata param1BubbleMetadata) {
      if (param1BubbleMetadata == null)
        return null; 
      Notification.BubbleMetadata.Builder builder = (new Notification.BubbleMetadata.Builder()).setAutoExpandBubble(param1BubbleMetadata.getAutoExpandBubble()).setDeleteIntent(param1BubbleMetadata.getDeleteIntent()).setIcon(param1BubbleMetadata.getIcon().toIcon()).setIntent(param1BubbleMetadata.getIntent()).setSuppressNotification(param1BubbleMetadata.isNotificationSuppressed());
      if (param1BubbleMetadata.getDesiredHeight() != 0)
        builder.setDesiredHeight(param1BubbleMetadata.getDesiredHeight()); 
      if (param1BubbleMetadata.getDesiredHeightResId() != 0)
        builder.setDesiredHeightResId(param1BubbleMetadata.getDesiredHeightResId()); 
      return builder.build();
    }
    
    public boolean getAutoExpandBubble() {
      int i = this.mFlags;
      boolean bool = true;
      if ((i & 0x1) == 0)
        bool = false; 
      return bool;
    }
    
    @Nullable
    public PendingIntent getDeleteIntent() {
      return this.mDeleteIntent;
    }
    
    @Dimension(unit = 0)
    public int getDesiredHeight() {
      return this.mDesiredHeight;
    }
    
    @DimenRes
    public int getDesiredHeightResId() {
      return this.mDesiredHeightResId;
    }
    
    @NonNull
    public IconCompat getIcon() {
      return this.mIcon;
    }
    
    @NonNull
    public PendingIntent getIntent() {
      return this.mPendingIntent;
    }
    
    public boolean isNotificationSuppressed() {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public static final class Builder {
      private PendingIntent mDeleteIntent;
      
      private int mDesiredHeight;
      
      @DimenRes
      private int mDesiredHeightResId;
      
      private int mFlags;
      
      private IconCompat mIcon;
      
      private PendingIntent mPendingIntent;
      
      private Builder setFlag(int param2Int, boolean param2Boolean) {
        if (param2Boolean) {
          this.mFlags = param2Int | this.mFlags;
        } else {
          this.mFlags = (param2Int ^ 0xFFFFFFFF) & this.mFlags;
        } 
        return this;
      }
      
      @SuppressLint({"SyntheticAccessor"})
      @NonNull
      public NotificationCompat.BubbleMetadata build() {
        PendingIntent pendingIntent = this.mPendingIntent;
        if (pendingIntent != null) {
          IconCompat iconCompat = this.mIcon;
          if (iconCompat != null)
            return new NotificationCompat.BubbleMetadata(pendingIntent, this.mDeleteIntent, iconCompat, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags); 
          throw new IllegalStateException("Must supply an icon for the bubble");
        } 
        throw new IllegalStateException("Must supply pending intent to bubble");
      }
      
      @NonNull
      public Builder setAutoExpandBubble(boolean param2Boolean) {
        setFlag(1, param2Boolean);
        return this;
      }
      
      @NonNull
      public Builder setDeleteIntent(@Nullable PendingIntent param2PendingIntent) {
        this.mDeleteIntent = param2PendingIntent;
        return this;
      }
      
      @NonNull
      public Builder setDesiredHeight(@Dimension(unit = 0) int param2Int) {
        this.mDesiredHeight = Math.max(param2Int, 0);
        this.mDesiredHeightResId = 0;
        return this;
      }
      
      @NonNull
      public Builder setDesiredHeightResId(@DimenRes int param2Int) {
        this.mDesiredHeightResId = param2Int;
        this.mDesiredHeight = 0;
        return this;
      }
      
      @NonNull
      public Builder setIcon(@NonNull IconCompat param2IconCompat) {
        if (param2IconCompat != null) {
          if (param2IconCompat.getType() != 1) {
            this.mIcon = param2IconCompat;
            return this;
          } 
          throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
        } 
        throw new IllegalArgumentException("Bubbles require non-null icon");
      }
      
      @NonNull
      public Builder setIntent(@NonNull PendingIntent param2PendingIntent) {
        if (param2PendingIntent != null) {
          this.mPendingIntent = param2PendingIntent;
          return this;
        } 
        throw new IllegalArgumentException("Bubble requires non-null pending intent");
      }
      
      @NonNull
      public Builder setSuppressNotification(boolean param2Boolean) {
        setFlag(2, param2Boolean);
        return this;
      }
    }
  }
  
  public static final class Builder {
    private PendingIntent mDeleteIntent;
    
    private int mDesiredHeight;
    
    @DimenRes
    private int mDesiredHeightResId;
    
    private int mFlags;
    
    private IconCompat mIcon;
    
    private PendingIntent mPendingIntent;
    
    private Builder setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.mFlags = param1Int | this.mFlags;
      } else {
        this.mFlags = (param1Int ^ 0xFFFFFFFF) & this.mFlags;
      } 
      return this;
    }
    
    @SuppressLint({"SyntheticAccessor"})
    @NonNull
    public NotificationCompat.BubbleMetadata build() {
      PendingIntent pendingIntent = this.mPendingIntent;
      if (pendingIntent != null) {
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null)
          return new NotificationCompat.BubbleMetadata(pendingIntent, this.mDeleteIntent, iconCompat, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags); 
        throw new IllegalStateException("Must supply an icon for the bubble");
      } 
      throw new IllegalStateException("Must supply pending intent to bubble");
    }
    
    @NonNull
    public Builder setAutoExpandBubble(boolean param1Boolean) {
      setFlag(1, param1Boolean);
      return this;
    }
    
    @NonNull
    public Builder setDeleteIntent(@Nullable PendingIntent param1PendingIntent) {
      this.mDeleteIntent = param1PendingIntent;
      return this;
    }
    
    @NonNull
    public Builder setDesiredHeight(@Dimension(unit = 0) int param1Int) {
      this.mDesiredHeight = Math.max(param1Int, 0);
      this.mDesiredHeightResId = 0;
      return this;
    }
    
    @NonNull
    public Builder setDesiredHeightResId(@DimenRes int param1Int) {
      this.mDesiredHeightResId = param1Int;
      this.mDesiredHeight = 0;
      return this;
    }
    
    @NonNull
    public Builder setIcon(@NonNull IconCompat param1IconCompat) {
      if (param1IconCompat != null) {
        if (param1IconCompat.getType() != 1) {
          this.mIcon = param1IconCompat;
          return this;
        } 
        throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
      } 
      throw new IllegalArgumentException("Bubbles require non-null icon");
    }
    
    @NonNull
    public Builder setIntent(@NonNull PendingIntent param1PendingIntent) {
      if (param1PendingIntent != null) {
        this.mPendingIntent = param1PendingIntent;
        return this;
      } 
      throw new IllegalArgumentException("Bubble requires non-null pending intent");
    }
    
    @NonNull
    public Builder setSuppressNotification(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
  }
  
  public static class Builder {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList<NotificationCompat.Action>();
    
    boolean mAllowSystemGeneratedContextualActions;
    
    int mBadgeIcon = 0;
    
    RemoteViews mBigContentView;
    
    NotificationCompat.BubbleMetadata mBubbleMetadata;
    
    String mCategory;
    
    String mChannelId;
    
    boolean mChronometerCountDown;
    
    int mColor = 0;
    
    boolean mColorized;
    
    boolean mColorizedSet;
    
    CharSequence mContentInfo;
    
    PendingIntent mContentIntent;
    
    CharSequence mContentText;
    
    CharSequence mContentTitle;
    
    RemoteViews mContentView;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Context mContext;
    
    Bundle mExtras;
    
    PendingIntent mFullScreenIntent;
    
    int mGroupAlertBehavior = 0;
    
    String mGroupKey;
    
    boolean mGroupSummary;
    
    RemoteViews mHeadsUpContentView;
    
    ArrayList<NotificationCompat.Action> mInvisibleActions = new ArrayList<NotificationCompat.Action>();
    
    Bitmap mLargeIcon;
    
    boolean mLocalOnly = false;
    
    Notification mNotification = new Notification();
    
    int mNumber;
    
    @Deprecated
    public ArrayList<String> mPeople;
    
    int mPriority;
    
    int mProgress;
    
    boolean mProgressIndeterminate;
    
    int mProgressMax;
    
    Notification mPublicVersion;
    
    CharSequence[] mRemoteInputHistory;
    
    String mShortcutId;
    
    boolean mShowWhen = true;
    
    String mSortKey;
    
    NotificationCompat.Style mStyle;
    
    CharSequence mSubText;
    
    RemoteViews mTickerView;
    
    long mTimeout;
    
    boolean mUseChronometer;
    
    int mVisibility = 0;
    
    @Deprecated
    public Builder(Context param1Context) {
      this(param1Context, null);
    }
    
    public Builder(@NonNull Context param1Context, @NonNull String param1String) {
      this.mContext = param1Context;
      this.mChannelId = param1String;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
      this.mPeople = new ArrayList<String>();
      this.mAllowSystemGeneratedContextualActions = true;
    }
    
    protected static CharSequence limitCharSequenceLength(CharSequence param1CharSequence) {
      if (param1CharSequence == null)
        return param1CharSequence; 
      CharSequence charSequence = param1CharSequence;
      if (param1CharSequence.length() > 5120)
        charSequence = param1CharSequence.subSequence(0, 5120); 
      return charSequence;
    }
    
    private Bitmap reduceLargeIconSize(Bitmap param1Bitmap) {
      if (param1Bitmap == null || Build.VERSION.SDK_INT >= 27)
        return param1Bitmap; 
      Resources resources = this.mContext.getResources();
      int i = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
      int j = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
      if (param1Bitmap.getWidth() <= i && param1Bitmap.getHeight() <= j)
        return param1Bitmap; 
      double d1 = i;
      double d2 = Math.max(1, param1Bitmap.getWidth());
      Double.isNaN(d1);
      Double.isNaN(d2);
      d2 = d1 / d2;
      d1 = j;
      double d3 = Math.max(1, param1Bitmap.getHeight());
      Double.isNaN(d1);
      Double.isNaN(d3);
      d1 = Math.min(d2, d1 / d3);
      d2 = param1Bitmap.getWidth();
      Double.isNaN(d2);
      i = (int)Math.ceil(d2 * d1);
      d2 = param1Bitmap.getHeight();
      Double.isNaN(d2);
      return Bitmap.createScaledBitmap(param1Bitmap, i, (int)Math.ceil(d2 * d1), true);
    }
    
    private void setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        Notification notification = this.mNotification;
        notification.flags = param1Int | notification.flags;
      } else {
        Notification notification = this.mNotification;
        notification.flags = (param1Int ^ 0xFFFFFFFF) & notification.flags;
      } 
    }
    
    public Builder addAction(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this.mActions.add(new NotificationCompat.Action(param1Int, param1CharSequence, param1PendingIntent));
      return this;
    }
    
    public Builder addAction(NotificationCompat.Action param1Action) {
      this.mActions.add(param1Action);
      return this;
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null) {
        Bundle bundle = this.mExtras;
        if (bundle == null) {
          this.mExtras = new Bundle(param1Bundle);
        } else {
          bundle.putAll(param1Bundle);
        } 
      } 
      return this;
    }
    
    @RequiresApi(21)
    public Builder addInvisibleAction(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      return addInvisibleAction(new NotificationCompat.Action(param1Int, param1CharSequence, param1PendingIntent));
    }
    
    @RequiresApi(21)
    public Builder addInvisibleAction(NotificationCompat.Action param1Action) {
      this.mInvisibleActions.add(param1Action);
      return this;
    }
    
    public Builder addPerson(String param1String) {
      this.mPeople.add(param1String);
      return this;
    }
    
    public Notification build() {
      return (new NotificationCompatBuilder(this)).build();
    }
    
    public Builder extend(NotificationCompat.Extender param1Extender) {
      param1Extender.extend(this);
      return this;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews getBigContentView() {
      return this.mBigContentView;
    }
    
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public NotificationCompat.BubbleMetadata getBubbleMetadata() {
      return this.mBubbleMetadata;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getColor() {
      return this.mColor;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews getContentView() {
      return this.mContentView;
    }
    
    public Bundle getExtras() {
      if (this.mExtras == null)
        this.mExtras = new Bundle(); 
      return this.mExtras;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews getHeadsUpContentView() {
      return this.mHeadsUpContentView;
    }
    
    @Deprecated
    public Notification getNotification() {
      return build();
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getPriority() {
      return this.mPriority;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public long getWhenIfShowing() {
      long l;
      if (this.mShowWhen) {
        l = this.mNotification.when;
      } else {
        l = 0L;
      } 
      return l;
    }
    
    @NonNull
    public Builder setAllowSystemGeneratedContextualActions(boolean param1Boolean) {
      this.mAllowSystemGeneratedContextualActions = param1Boolean;
      return this;
    }
    
    public Builder setAutoCancel(boolean param1Boolean) {
      setFlag(16, param1Boolean);
      return this;
    }
    
    public Builder setBadgeIconType(int param1Int) {
      this.mBadgeIcon = param1Int;
      return this;
    }
    
    @NonNull
    public Builder setBubbleMetadata(@Nullable NotificationCompat.BubbleMetadata param1BubbleMetadata) {
      this.mBubbleMetadata = param1BubbleMetadata;
      return this;
    }
    
    public Builder setCategory(String param1String) {
      this.mCategory = param1String;
      return this;
    }
    
    public Builder setChannelId(@NonNull String param1String) {
      this.mChannelId = param1String;
      return this;
    }
    
    @NonNull
    @RequiresApi(24)
    public Builder setChronometerCountDown(boolean param1Boolean) {
      this.mChronometerCountDown = param1Boolean;
      this.mExtras.putBoolean("android.chronometerCountDown", param1Boolean);
      return this;
    }
    
    public Builder setColor(@ColorInt int param1Int) {
      this.mColor = param1Int;
      return this;
    }
    
    public Builder setColorized(boolean param1Boolean) {
      this.mColorized = param1Boolean;
      this.mColorizedSet = true;
      return this;
    }
    
    public Builder setContent(RemoteViews param1RemoteViews) {
      this.mNotification.contentView = param1RemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence param1CharSequence) {
      this.mContentInfo = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setContentIntent(PendingIntent param1PendingIntent) {
      this.mContentIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence param1CharSequence) {
      this.mContentText = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setContentTitle(CharSequence param1CharSequence) {
      this.mContentTitle = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setCustomBigContentView(RemoteViews param1RemoteViews) {
      this.mBigContentView = param1RemoteViews;
      return this;
    }
    
    public Builder setCustomContentView(RemoteViews param1RemoteViews) {
      this.mContentView = param1RemoteViews;
      return this;
    }
    
    public Builder setCustomHeadsUpContentView(RemoteViews param1RemoteViews) {
      this.mHeadsUpContentView = param1RemoteViews;
      return this;
    }
    
    public Builder setDefaults(int param1Int) {
      Notification notification = this.mNotification;
      notification.defaults = param1Int;
      if ((param1Int & 0x4) != 0)
        notification.flags |= 0x1; 
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent param1PendingIntent) {
      this.mNotification.deleteIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setExtras(Bundle param1Bundle) {
      this.mExtras = param1Bundle;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent param1PendingIntent, boolean param1Boolean) {
      this.mFullScreenIntent = param1PendingIntent;
      setFlag(128, param1Boolean);
      return this;
    }
    
    public Builder setGroup(String param1String) {
      this.mGroupKey = param1String;
      return this;
    }
    
    public Builder setGroupAlertBehavior(int param1Int) {
      this.mGroupAlertBehavior = param1Int;
      return this;
    }
    
    public Builder setGroupSummary(boolean param1Boolean) {
      this.mGroupSummary = param1Boolean;
      return this;
    }
    
    public Builder setLargeIcon(Bitmap param1Bitmap) {
      this.mLargeIcon = reduceLargeIconSize(param1Bitmap);
      return this;
    }
    
    public Builder setLights(@ColorInt int param1Int1, int param1Int2, int param1Int3) {
      Notification notification = this.mNotification;
      notification.ledARGB = param1Int1;
      notification.ledOnMS = param1Int2;
      notification.ledOffMS = param1Int3;
      if (notification.ledOnMS != 0 && this.mNotification.ledOffMS != 0) {
        param1Int1 = 1;
      } else {
        param1Int1 = 0;
      } 
      notification = this.mNotification;
      notification.flags = param1Int1 | notification.flags & 0xFFFFFFFE;
      return this;
    }
    
    public Builder setLocalOnly(boolean param1Boolean) {
      this.mLocalOnly = param1Boolean;
      return this;
    }
    
    public Builder setNumber(int param1Int) {
      this.mNumber = param1Int;
      return this;
    }
    
    public Builder setOngoing(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean param1Boolean) {
      setFlag(8, param1Boolean);
      return this;
    }
    
    public Builder setPriority(int param1Int) {
      this.mPriority = param1Int;
      return this;
    }
    
    public Builder setProgress(int param1Int1, int param1Int2, boolean param1Boolean) {
      this.mProgressMax = param1Int1;
      this.mProgress = param1Int2;
      this.mProgressIndeterminate = param1Boolean;
      return this;
    }
    
    public Builder setPublicVersion(Notification param1Notification) {
      this.mPublicVersion = param1Notification;
      return this;
    }
    
    public Builder setRemoteInputHistory(CharSequence[] param1ArrayOfCharSequence) {
      this.mRemoteInputHistory = param1ArrayOfCharSequence;
      return this;
    }
    
    public Builder setShortcutId(String param1String) {
      this.mShortcutId = param1String;
      return this;
    }
    
    public Builder setShowWhen(boolean param1Boolean) {
      this.mShowWhen = param1Boolean;
      return this;
    }
    
    public Builder setSmallIcon(int param1Int) {
      this.mNotification.icon = param1Int;
      return this;
    }
    
    public Builder setSmallIcon(int param1Int1, int param1Int2) {
      Notification notification = this.mNotification;
      notification.icon = param1Int1;
      notification.iconLevel = param1Int2;
      return this;
    }
    
    public Builder setSortKey(String param1String) {
      this.mSortKey = param1String;
      return this;
    }
    
    public Builder setSound(Uri param1Uri) {
      Notification notification = this.mNotification;
      notification.sound = param1Uri;
      notification.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21)
        this.mNotification.audioAttributes = (new AudioAttributes.Builder()).setContentType(4).setUsage(5).build(); 
      return this;
    }
    
    public Builder setSound(Uri param1Uri, int param1Int) {
      Notification notification = this.mNotification;
      notification.sound = param1Uri;
      notification.audioStreamType = param1Int;
      if (Build.VERSION.SDK_INT >= 21)
        this.mNotification.audioAttributes = (new AudioAttributes.Builder()).setContentType(4).setLegacyStreamType(param1Int).build(); 
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style param1Style) {
      if (this.mStyle != param1Style) {
        this.mStyle = param1Style;
        param1Style = this.mStyle;
        if (param1Style != null)
          param1Style.setBuilder(this); 
      } 
      return this;
    }
    
    public Builder setSubText(CharSequence param1CharSequence) {
      this.mSubText = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence param1CharSequence) {
      this.mNotification.tickerText = limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence param1CharSequence, RemoteViews param1RemoteViews) {
      this.mNotification.tickerText = limitCharSequenceLength(param1CharSequence);
      this.mTickerView = param1RemoteViews;
      return this;
    }
    
    public Builder setTimeoutAfter(long param1Long) {
      this.mTimeout = param1Long;
      return this;
    }
    
    public Builder setUsesChronometer(boolean param1Boolean) {
      this.mUseChronometer = param1Boolean;
      return this;
    }
    
    public Builder setVibrate(long[] param1ArrayOflong) {
      this.mNotification.vibrate = param1ArrayOflong;
      return this;
    }
    
    public Builder setVisibility(int param1Int) {
      this.mVisibility = param1Int;
      return this;
    }
    
    public Builder setWhen(long param1Long) {
      this.mNotification.when = param1Long;
      return this;
    }
  }
  
  public static final class CarExtender implements Extender {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    
    private static final String EXTRA_COLOR = "app_color";
    
    private static final String EXTRA_CONVERSATION = "car_conversation";
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    
    private static final String EXTRA_LARGE_ICON = "large_icon";
    
    private static final String KEY_AUTHOR = "author";
    
    private static final String KEY_MESSAGES = "messages";
    
    private static final String KEY_ON_READ = "on_read";
    
    private static final String KEY_ON_REPLY = "on_reply";
    
    private static final String KEY_PARTICIPANTS = "participants";
    
    private static final String KEY_REMOTE_INPUT = "remote_input";
    
    private static final String KEY_TEXT = "text";
    
    private static final String KEY_TIMESTAMP = "timestamp";
    
    private int mColor;
    
    private Bitmap mLargeIcon;
    
    private UnreadConversation mUnreadConversation;
    
    public CarExtender() {
      this.mColor = 0;
    }
    
    public CarExtender(Notification param1Notification) {
      Bundle bundle;
      this.mColor = 0;
      if (Build.VERSION.SDK_INT < 21)
        return; 
      if (NotificationCompat.getExtras(param1Notification) == null) {
        param1Notification = null;
      } else {
        bundle = NotificationCompat.getExtras(param1Notification).getBundle("android.car.EXTENSIONS");
      } 
      if (bundle != null) {
        this.mLargeIcon = (Bitmap)bundle.getParcelable("large_icon");
        this.mColor = bundle.getInt("app_color", 0);
        this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle("car_conversation"));
      } 
    }
    
    @RequiresApi(21)
    private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation param1UnreadConversation) {
      Bundle bundle = new Bundle();
      String[] arrayOfString = param1UnreadConversation.getParticipants();
      byte b = 0;
      if (arrayOfString != null && (param1UnreadConversation.getParticipants()).length > 1) {
        String str = param1UnreadConversation.getParticipants()[0];
      } else {
        arrayOfString = null;
      } 
      Parcelable[] arrayOfParcelable = new Parcelable[(param1UnreadConversation.getMessages()).length];
      while (b < arrayOfParcelable.length) {
        Bundle bundle1 = new Bundle();
        bundle1.putString("text", param1UnreadConversation.getMessages()[b]);
        bundle1.putString("author", (String)arrayOfString);
        arrayOfParcelable[b] = (Parcelable)bundle1;
        b++;
      } 
      bundle.putParcelableArray("messages", arrayOfParcelable);
      RemoteInput remoteInput = param1UnreadConversation.getRemoteInput();
      if (remoteInput != null)
        bundle.putParcelable("remote_input", (Parcelable)(new RemoteInput.Builder(remoteInput.getResultKey())).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build()); 
      bundle.putParcelable("on_reply", (Parcelable)param1UnreadConversation.getReplyPendingIntent());
      bundle.putParcelable("on_read", (Parcelable)param1UnreadConversation.getReadPendingIntent());
      bundle.putStringArray("participants", param1UnreadConversation.getParticipants());
      bundle.putLong("timestamp", param1UnreadConversation.getLatestTimestamp());
      return bundle;
    }
    
    @RequiresApi(21)
    private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle param1Bundle) {
      RemoteInput remoteInput;
      String[] arrayOfString1;
      CharSequence charSequence = null;
      if (param1Bundle == null)
        return null; 
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("messages");
      if (arrayOfParcelable != null) {
        arrayOfString1 = new String[arrayOfParcelable.length];
        byte b = 0;
        while (true) {
          if (b < arrayOfString1.length) {
            if (!(arrayOfParcelable[b] instanceof Bundle)) {
              b = 0;
              break;
            } 
            arrayOfString1[b] = ((Bundle)arrayOfParcelable[b]).getString("text");
            if (arrayOfString1[b] == null) {
              b = 0;
              break;
            } 
            b++;
            continue;
          } 
          b = 1;
          break;
        } 
        if (b == 0)
          return null; 
      } else {
        arrayOfString1 = null;
      } 
      PendingIntent pendingIntent1 = (PendingIntent)param1Bundle.getParcelable("on_read");
      PendingIntent pendingIntent2 = (PendingIntent)param1Bundle.getParcelable("on_reply");
      RemoteInput remoteInput1 = (RemoteInput)param1Bundle.getParcelable("remote_input");
      String[] arrayOfString2 = param1Bundle.getStringArray("participants");
      if (arrayOfString2 == null || arrayOfString2.length != 1)
        return null; 
      if (remoteInput1 != null) {
        boolean bool;
        String str = remoteInput1.getResultKey();
        charSequence = remoteInput1.getLabel();
        CharSequence[] arrayOfCharSequence = remoteInput1.getChoices();
        boolean bool1 = remoteInput1.getAllowFreeFormInput();
        if (Build.VERSION.SDK_INT >= 29) {
          bool = remoteInput1.getEditChoicesBeforeSending();
        } else {
          bool = false;
        } 
        remoteInput = new RemoteInput(str, charSequence, arrayOfCharSequence, bool1, bool, remoteInput1.getExtras(), null);
      } 
      return new UnreadConversation(arrayOfString1, remoteInput, pendingIntent2, pendingIntent1, arrayOfString2, param1Bundle.getLong("timestamp"));
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder) {
      if (Build.VERSION.SDK_INT < 21)
        return param1Builder; 
      Bundle bundle = new Bundle();
      Bitmap bitmap = this.mLargeIcon;
      if (bitmap != null)
        bundle.putParcelable("large_icon", (Parcelable)bitmap); 
      int i = this.mColor;
      if (i != 0)
        bundle.putInt("app_color", i); 
      UnreadConversation unreadConversation = this.mUnreadConversation;
      if (unreadConversation != null)
        bundle.putBundle("car_conversation", getBundleForUnreadConversation(unreadConversation)); 
      param1Builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    @ColorInt
    public int getColor() {
      return this.mColor;
    }
    
    public Bitmap getLargeIcon() {
      return this.mLargeIcon;
    }
    
    public UnreadConversation getUnreadConversation() {
      return this.mUnreadConversation;
    }
    
    public CarExtender setColor(@ColorInt int param1Int) {
      this.mColor = param1Int;
      return this;
    }
    
    public CarExtender setLargeIcon(Bitmap param1Bitmap) {
      this.mLargeIcon = param1Bitmap;
      return this;
    }
    
    public CarExtender setUnreadConversation(UnreadConversation param1UnreadConversation) {
      this.mUnreadConversation = param1UnreadConversation;
      return this;
    }
    
    public static class UnreadConversation {
      private final long mLatestTimestamp;
      
      private final String[] mMessages;
      
      private final String[] mParticipants;
      
      private final PendingIntent mReadPendingIntent;
      
      private final RemoteInput mRemoteInput;
      
      private final PendingIntent mReplyPendingIntent;
      
      UnreadConversation(String[] param2ArrayOfString1, RemoteInput param2RemoteInput, PendingIntent param2PendingIntent1, PendingIntent param2PendingIntent2, String[] param2ArrayOfString2, long param2Long) {
        this.mMessages = param2ArrayOfString1;
        this.mRemoteInput = param2RemoteInput;
        this.mReadPendingIntent = param2PendingIntent2;
        this.mReplyPendingIntent = param2PendingIntent1;
        this.mParticipants = param2ArrayOfString2;
        this.mLatestTimestamp = param2Long;
      }
      
      public long getLatestTimestamp() {
        return this.mLatestTimestamp;
      }
      
      public String[] getMessages() {
        return this.mMessages;
      }
      
      public String getParticipant() {
        String[] arrayOfString = this.mParticipants;
        if (arrayOfString.length > 0) {
          String str = arrayOfString[0];
        } else {
          arrayOfString = null;
        } 
        return (String)arrayOfString;
      }
      
      public String[] getParticipants() {
        return this.mParticipants;
      }
      
      public PendingIntent getReadPendingIntent() {
        return this.mReadPendingIntent;
      }
      
      public RemoteInput getRemoteInput() {
        return this.mRemoteInput;
      }
      
      public PendingIntent getReplyPendingIntent() {
        return this.mReplyPendingIntent;
      }
      
      public static class Builder {
        private long mLatestTimestamp;
        
        private final List<String> mMessages = new ArrayList<String>();
        
        private final String mParticipant;
        
        private PendingIntent mReadPendingIntent;
        
        private RemoteInput mRemoteInput;
        
        private PendingIntent mReplyPendingIntent;
        
        public Builder(String param3String) {
          this.mParticipant = param3String;
        }
        
        public Builder addMessage(String param3String) {
          this.mMessages.add(param3String);
          return this;
        }
        
        public NotificationCompat.CarExtender.UnreadConversation build() {
          List<String> list = this.mMessages;
          String[] arrayOfString = list.<String>toArray(new String[list.size()]);
          String str = this.mParticipant;
          RemoteInput remoteInput = this.mRemoteInput;
          PendingIntent pendingIntent1 = this.mReplyPendingIntent;
          PendingIntent pendingIntent2 = this.mReadPendingIntent;
          long l = this.mLatestTimestamp;
          return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
        }
        
        public Builder setLatestTimestamp(long param3Long) {
          this.mLatestTimestamp = param3Long;
          return this;
        }
        
        public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
          this.mReadPendingIntent = param3PendingIntent;
          return this;
        }
        
        public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
          this.mRemoteInput = param3RemoteInput;
          this.mReplyPendingIntent = param3PendingIntent;
          return this;
        }
      }
    }
    
    public static class Builder {
      private long mLatestTimestamp;
      
      private final List<String> mMessages = new ArrayList<String>();
      
      private final String mParticipant;
      
      private PendingIntent mReadPendingIntent;
      
      private RemoteInput mRemoteInput;
      
      private PendingIntent mReplyPendingIntent;
      
      public Builder(String param2String) {
        this.mParticipant = param2String;
      }
      
      public Builder addMessage(String param2String) {
        this.mMessages.add(param2String);
        return this;
      }
      
      public NotificationCompat.CarExtender.UnreadConversation build() {
        List<String> list = this.mMessages;
        String[] arrayOfString = list.<String>toArray(new String[list.size()]);
        String str = this.mParticipant;
        RemoteInput remoteInput = this.mRemoteInput;
        PendingIntent pendingIntent1 = this.mReplyPendingIntent;
        PendingIntent pendingIntent2 = this.mReadPendingIntent;
        long l = this.mLatestTimestamp;
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
      }
      
      public Builder setLatestTimestamp(long param2Long) {
        this.mLatestTimestamp = param2Long;
        return this;
      }
      
      public Builder setReadPendingIntent(PendingIntent param2PendingIntent) {
        this.mReadPendingIntent = param2PendingIntent;
        return this;
      }
      
      public Builder setReplyAction(PendingIntent param2PendingIntent, RemoteInput param2RemoteInput) {
        this.mRemoteInput = param2RemoteInput;
        this.mReplyPendingIntent = param2PendingIntent;
        return this;
      }
    }
  }
  
  public static class UnreadConversation {
    private final long mLatestTimestamp;
    
    private final String[] mMessages;
    
    private final String[] mParticipants;
    
    private final PendingIntent mReadPendingIntent;
    
    private final RemoteInput mRemoteInput;
    
    private final PendingIntent mReplyPendingIntent;
    
    UnreadConversation(String[] param1ArrayOfString1, RemoteInput param1RemoteInput, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, String[] param1ArrayOfString2, long param1Long) {
      this.mMessages = param1ArrayOfString1;
      this.mRemoteInput = param1RemoteInput;
      this.mReadPendingIntent = param1PendingIntent2;
      this.mReplyPendingIntent = param1PendingIntent1;
      this.mParticipants = param1ArrayOfString2;
      this.mLatestTimestamp = param1Long;
    }
    
    public long getLatestTimestamp() {
      return this.mLatestTimestamp;
    }
    
    public String[] getMessages() {
      return this.mMessages;
    }
    
    public String getParticipant() {
      String[] arrayOfString = this.mParticipants;
      if (arrayOfString.length > 0) {
        String str = arrayOfString[0];
      } else {
        arrayOfString = null;
      } 
      return (String)arrayOfString;
    }
    
    public String[] getParticipants() {
      return this.mParticipants;
    }
    
    public PendingIntent getReadPendingIntent() {
      return this.mReadPendingIntent;
    }
    
    public RemoteInput getRemoteInput() {
      return this.mRemoteInput;
    }
    
    public PendingIntent getReplyPendingIntent() {
      return this.mReplyPendingIntent;
    }
    
    public static class Builder {
      private long mLatestTimestamp;
      
      private final List<String> mMessages = new ArrayList<String>();
      
      private final String mParticipant;
      
      private PendingIntent mReadPendingIntent;
      
      private RemoteInput mRemoteInput;
      
      private PendingIntent mReplyPendingIntent;
      
      public Builder(String param3String) {
        this.mParticipant = param3String;
      }
      
      public Builder addMessage(String param3String) {
        this.mMessages.add(param3String);
        return this;
      }
      
      public NotificationCompat.CarExtender.UnreadConversation build() {
        List<String> list = this.mMessages;
        String[] arrayOfString = list.<String>toArray(new String[list.size()]);
        String str = this.mParticipant;
        RemoteInput remoteInput = this.mRemoteInput;
        PendingIntent pendingIntent1 = this.mReplyPendingIntent;
        PendingIntent pendingIntent2 = this.mReadPendingIntent;
        long l = this.mLatestTimestamp;
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
      }
      
      public Builder setLatestTimestamp(long param3Long) {
        this.mLatestTimestamp = param3Long;
        return this;
      }
      
      public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
        this.mReadPendingIntent = param3PendingIntent;
        return this;
      }
      
      public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
        this.mRemoteInput = param3RemoteInput;
        this.mReplyPendingIntent = param3PendingIntent;
        return this;
      }
    }
  }
  
  public static class Builder {
    private long mLatestTimestamp;
    
    private final List<String> mMessages = new ArrayList<String>();
    
    private final String mParticipant;
    
    private PendingIntent mReadPendingIntent;
    
    private RemoteInput mRemoteInput;
    
    private PendingIntent mReplyPendingIntent;
    
    public Builder(String param1String) {
      this.mParticipant = param1String;
    }
    
    public Builder addMessage(String param1String) {
      this.mMessages.add(param1String);
      return this;
    }
    
    public NotificationCompat.CarExtender.UnreadConversation build() {
      List<String> list = this.mMessages;
      String[] arrayOfString = list.<String>toArray(new String[list.size()]);
      String str = this.mParticipant;
      RemoteInput remoteInput = this.mRemoteInput;
      PendingIntent pendingIntent1 = this.mReplyPendingIntent;
      PendingIntent pendingIntent2 = this.mReadPendingIntent;
      long l = this.mLatestTimestamp;
      return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
    }
    
    public Builder setLatestTimestamp(long param1Long) {
      this.mLatestTimestamp = param1Long;
      return this;
    }
    
    public Builder setReadPendingIntent(PendingIntent param1PendingIntent) {
      this.mReadPendingIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setReplyAction(PendingIntent param1PendingIntent, RemoteInput param1RemoteInput) {
      this.mRemoteInput = param1RemoteInput;
      this.mReplyPendingIntent = param1PendingIntent;
      return this;
    }
  }
  
  public static class DecoratedCustomViewStyle extends Style {
    private static final int MAX_ACTION_BUTTONS = 3;
    
    private RemoteViews createRemoteViews(RemoteViews param1RemoteViews, boolean param1Boolean) {
      // Byte code:
      //   0: getstatic androidx/core/R$layout.notification_template_custom_big : I
      //   3: istore_3
      //   4: iconst_1
      //   5: istore #4
      //   7: iconst_0
      //   8: istore #5
      //   10: aload_0
      //   11: iconst_1
      //   12: iload_3
      //   13: iconst_0
      //   14: invokevirtual applyStandardTemplate : (ZIZ)Landroid/widget/RemoteViews;
      //   17: astore #6
      //   19: aload #6
      //   21: getstatic androidx/core/R$id.actions : I
      //   24: invokevirtual removeAllViews : (I)V
      //   27: aload_0
      //   28: getfield mBuilder : Landroidx/core/app/NotificationCompat$Builder;
      //   31: getfield mActions : Ljava/util/ArrayList;
      //   34: invokestatic getNonContextualActions : (Ljava/util/List;)Ljava/util/List;
      //   37: astore #7
      //   39: iload_2
      //   40: ifeq -> 111
      //   43: aload #7
      //   45: ifnull -> 111
      //   48: aload #7
      //   50: invokeinterface size : ()I
      //   55: iconst_3
      //   56: invokestatic min : (II)I
      //   59: istore #8
      //   61: iload #8
      //   63: ifle -> 111
      //   66: iconst_0
      //   67: istore_3
      //   68: iload #4
      //   70: istore #9
      //   72: iload_3
      //   73: iload #8
      //   75: if_icmpge -> 114
      //   78: aload_0
      //   79: aload #7
      //   81: iload_3
      //   82: invokeinterface get : (I)Ljava/lang/Object;
      //   87: checkcast androidx/core/app/NotificationCompat$Action
      //   90: invokespecial generateActionButton : (Landroidx/core/app/NotificationCompat$Action;)Landroid/widget/RemoteViews;
      //   93: astore #10
      //   95: aload #6
      //   97: getstatic androidx/core/R$id.actions : I
      //   100: aload #10
      //   102: invokevirtual addView : (ILandroid/widget/RemoteViews;)V
      //   105: iinc #3, 1
      //   108: goto -> 68
      //   111: iconst_0
      //   112: istore #9
      //   114: iload #9
      //   116: ifeq -> 125
      //   119: iload #5
      //   121: istore_3
      //   122: goto -> 128
      //   125: bipush #8
      //   127: istore_3
      //   128: aload #6
      //   130: getstatic androidx/core/R$id.actions : I
      //   133: iload_3
      //   134: invokevirtual setViewVisibility : (II)V
      //   137: aload #6
      //   139: getstatic androidx/core/R$id.action_divider : I
      //   142: iload_3
      //   143: invokevirtual setViewVisibility : (II)V
      //   146: aload_0
      //   147: aload #6
      //   149: aload_1
      //   150: invokevirtual buildIntoRemoteViews : (Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V
      //   153: aload #6
      //   155: areturn
    }
    
    private RemoteViews generateActionButton(NotificationCompat.Action param1Action) {
      boolean bool;
      int i;
      if (param1Action.actionIntent == null) {
        bool = true;
      } else {
        bool = false;
      } 
      String str = this.mBuilder.mContext.getPackageName();
      if (bool) {
        i = R.layout.notification_action_tombstone;
      } else {
        i = R.layout.notification_action;
      } 
      RemoteViews remoteViews = new RemoteViews(str, i);
      remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(param1Action.getIconCompat(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
      remoteViews.setTextViewText(R.id.action_text, param1Action.title);
      if (!bool)
        remoteViews.setOnClickPendingIntent(R.id.action_container, param1Action.actionIntent); 
      if (Build.VERSION.SDK_INT >= 15)
        remoteViews.setContentDescription(R.id.action_container, param1Action.title); 
      return remoteViews;
    }
    
    private static List<NotificationCompat.Action> getNonContextualActions(List<NotificationCompat.Action> param1List) {
      if (param1List == null)
        return null; 
      ArrayList<NotificationCompat.Action> arrayList = new ArrayList();
      for (NotificationCompat.Action action : param1List) {
        if (!action.isContextual())
          arrayList.add(action); 
      } 
      return arrayList;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 24)
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)new Notification.DecoratedCustomViewStyle()); 
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      RemoteViews remoteViews = this.mBuilder.getBigContentView();
      if (remoteViews == null)
        remoteViews = this.mBuilder.getContentView(); 
      return (remoteViews == null) ? null : createRemoteViews(remoteViews, true);
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return (Build.VERSION.SDK_INT >= 24) ? null : ((this.mBuilder.getContentView() == null) ? null : createRemoteViews(this.mBuilder.getContentView(), false));
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews1;
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      RemoteViews remoteViews2 = this.mBuilder.getHeadsUpContentView();
      if (remoteViews2 != null) {
        remoteViews1 = remoteViews2;
      } else {
        remoteViews1 = this.mBuilder.getContentView();
      } 
      return (remoteViews2 == null) ? null : createRemoteViews(remoteViews1, true);
    }
  }
  
  public static interface Extender {
    NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface GroupAlertBehavior {}
  
  public static class InboxStyle extends Style {
    private ArrayList<CharSequence> mTexts = new ArrayList<CharSequence>();
    
    public InboxStyle() {}
    
    public InboxStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public InboxStyle addLine(CharSequence param1CharSequence) {
      this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence));
      return this;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.InboxStyle inboxStyle = (new Notification.InboxStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle);
        if (this.mSummaryTextSet)
          inboxStyle.setSummaryText(this.mSummaryText); 
        Iterator<CharSequence> iterator = this.mTexts.iterator();
        while (iterator.hasNext())
          inboxStyle.addLine(iterator.next()); 
      } 
    }
    
    public InboxStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence param1CharSequence) {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(param1CharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class MessagingStyle extends Style {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    
    @Nullable
    private CharSequence mConversationTitle;
    
    @Nullable
    private Boolean mIsGroupConversation;
    
    private final List<Message> mMessages = new ArrayList<Message>();
    
    private Person mUser;
    
    private MessagingStyle() {}
    
    public MessagingStyle(@NonNull Person param1Person) {
      if (!TextUtils.isEmpty(param1Person.getName())) {
        this.mUser = param1Person;
        return;
      } 
      throw new IllegalArgumentException("User's name must not be empty.");
    }
    
    @Deprecated
    public MessagingStyle(@NonNull CharSequence param1CharSequence) {
      this.mUser = (new Person.Builder()).setName(param1CharSequence).build();
    }
    
    @Nullable
    public static MessagingStyle extractMessagingStyleFromNotification(Notification param1Notification) {
      Bundle bundle = NotificationCompat.getExtras(param1Notification);
      if (bundle != null && !bundle.containsKey("android.selfDisplayName") && !bundle.containsKey("android.messagingStyleUser"))
        return null; 
      try {
        MessagingStyle messagingStyle = new MessagingStyle();
        this();
        messagingStyle.restoreFromCompatExtras(bundle);
        return messagingStyle;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    @Nullable
    private Message findLatestIncomingMessage() {
      for (int i = this.mMessages.size() - 1; i >= 0; i--) {
        Message message = this.mMessages.get(i);
        if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName()))
          return message; 
      } 
      if (!this.mMessages.isEmpty()) {
        List<Message> list = this.mMessages;
        return list.get(list.size() - 1);
      } 
      return null;
    }
    
    private boolean hasMessagesWithoutSender() {
      for (int i = this.mMessages.size() - 1; i >= 0; i--) {
        Message message = this.mMessages.get(i);
        if (message.getPerson() != null && message.getPerson().getName() == null)
          return true; 
      } 
      return false;
    }
    
    @NonNull
    private TextAppearanceSpan makeFontColorSpan(int param1Int) {
      return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(param1Int), null);
    }
    
    private CharSequence makeMessageLine(Message param1Message) {
      CharSequence charSequence1;
      boolean bool;
      byte b;
      BidiFormatter bidiFormatter = BidiFormatter.getInstance();
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
      if (Build.VERSION.SDK_INT >= 21) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        b = -16777216;
      } else {
        b = -1;
      } 
      if (param1Message.getPerson() == null) {
        charSequence2 = "";
      } else {
        charSequence2 = param1Message.getPerson().getName();
      } 
      int i = b;
      CharSequence charSequence3 = charSequence2;
      if (TextUtils.isEmpty(charSequence2)) {
        charSequence2 = this.mUser.getName();
        i = b;
        charSequence3 = charSequence2;
        if (bool) {
          i = b;
          charSequence3 = charSequence2;
          if (this.mBuilder.getColor() != 0) {
            i = this.mBuilder.getColor();
            charSequence3 = charSequence2;
          } 
        } 
      } 
      CharSequence charSequence2 = bidiFormatter.unicodeWrap(charSequence3);
      spannableStringBuilder.append(charSequence2);
      spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - charSequence2.length(), spannableStringBuilder.length(), 33);
      if (param1Message.getText() == null) {
        charSequence1 = "";
      } else {
        charSequence1 = charSequence1.getText();
      } 
      spannableStringBuilder.append("  ").append(bidiFormatter.unicodeWrap(charSequence1));
      return (CharSequence)spannableStringBuilder;
    }
    
    public void addCompatExtras(Bundle param1Bundle) {
      super.addCompatExtras(param1Bundle);
      param1Bundle.putCharSequence("android.selfDisplayName", this.mUser.getName());
      param1Bundle.putBundle("android.messagingStyleUser", this.mUser.toBundle());
      param1Bundle.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
      if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue())
        param1Bundle.putCharSequence("android.conversationTitle", this.mConversationTitle); 
      if (!this.mMessages.isEmpty())
        param1Bundle.putParcelableArray("android.messages", (Parcelable[])Message.getBundleArrayForMessages(this.mMessages)); 
      Boolean bool = this.mIsGroupConversation;
      if (bool != null)
        param1Bundle.putBoolean("android.isGroupConversation", bool.booleanValue()); 
    }
    
    public MessagingStyle addMessage(Message param1Message) {
      this.mMessages.add(param1Message);
      if (this.mMessages.size() > 25)
        this.mMessages.remove(0); 
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence param1CharSequence, long param1Long, Person param1Person) {
      addMessage(new Message(param1CharSequence, param1Long, param1Person));
      return this;
    }
    
    @Deprecated
    public MessagingStyle addMessage(CharSequence param1CharSequence1, long param1Long, CharSequence param1CharSequence2) {
      this.mMessages.add(new Message(param1CharSequence1, param1Long, (new Person.Builder()).setName(param1CharSequence2).build()));
      if (this.mMessages.size() > 25)
        this.mMessages.remove(0); 
      return this;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      setGroupConversation(isGroupConversation());
      if (Build.VERSION.SDK_INT >= 24) {
        Notification.MessagingStyle messagingStyle;
        if (Build.VERSION.SDK_INT >= 28) {
          messagingStyle = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
        } else {
          messagingStyle = new Notification.MessagingStyle(this.mUser.getName());
        } 
        if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28)
          messagingStyle.setConversationTitle(this.mConversationTitle); 
        if (Build.VERSION.SDK_INT >= 28)
          messagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue()); 
        for (Message message : this.mMessages) {
          Notification.MessagingStyle.Message message1;
          if (Build.VERSION.SDK_INT >= 28) {
            Person person;
            Person person1 = message.getPerson();
            CharSequence charSequence = message.getText();
            long l = message.getTimestamp();
            if (person1 == null) {
              person1 = null;
            } else {
              person = person1.toAndroidPerson();
            } 
            message1 = new Notification.MessagingStyle.Message(charSequence, l, person);
          } else {
            if (message.getPerson() != null) {
              message1 = (Notification.MessagingStyle.Message)message.getPerson().getName();
            } else {
              message1 = null;
            } 
            message1 = new Notification.MessagingStyle.Message(message.getText(), message.getTimestamp(), (CharSequence)message1);
          } 
          if (message.getDataMimeType() != null)
            message1.setData(message.getDataMimeType(), message.getDataUri()); 
          messagingStyle.addMessage(message1);
        } 
        messagingStyle.setBuilder(param1NotificationBuilderWithBuilderAccessor.getBuilder());
      } else {
        Message message = findLatestIncomingMessage();
        if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
          param1NotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
        } else if (message != null) {
          param1NotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
          if (message.getPerson() != null)
            param1NotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(message.getPerson().getName()); 
        } 
        if (message != null) {
          CharSequence charSequence;
          Notification.Builder builder = param1NotificationBuilderWithBuilderAccessor.getBuilder();
          if (this.mConversationTitle != null) {
            charSequence = makeMessageLine(message);
          } else {
            charSequence = charSequence.getText();
          } 
          builder.setContentText(charSequence);
        } 
        if (Build.VERSION.SDK_INT >= 16) {
          boolean bool;
          SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
          if (this.mConversationTitle != null || hasMessagesWithoutSender()) {
            bool = true;
          } else {
            bool = false;
          } 
          for (int i = this.mMessages.size() - 1; i >= 0; i--) {
            CharSequence charSequence;
            message = this.mMessages.get(i);
            if (bool) {
              charSequence = makeMessageLine(message);
            } else {
              charSequence = charSequence.getText();
            } 
            if (i != this.mMessages.size() - 1)
              spannableStringBuilder.insert(0, "\n"); 
            spannableStringBuilder.insert(0, charSequence);
          } 
          (new Notification.BigTextStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(null).bigText((CharSequence)spannableStringBuilder);
        } 
      } 
    }
    
    @Nullable
    public CharSequence getConversationTitle() {
      return this.mConversationTitle;
    }
    
    public List<Message> getMessages() {
      return this.mMessages;
    }
    
    public Person getUser() {
      return this.mUser;
    }
    
    @Deprecated
    public CharSequence getUserDisplayName() {
      return this.mUser.getName();
    }
    
    public boolean isGroupConversation() {
      NotificationCompat.Builder builder = this.mBuilder;
      boolean bool1 = false;
      boolean bool2 = false;
      if (builder != null && (this.mBuilder.mContext.getApplicationInfo()).targetSdkVersion < 28 && this.mIsGroupConversation == null) {
        if (this.mConversationTitle != null)
          bool2 = true; 
        return bool2;
      } 
      Boolean bool = this.mIsGroupConversation;
      bool2 = bool1;
      if (bool != null)
        bool2 = bool.booleanValue(); 
      return bool2;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void restoreFromCompatExtras(Bundle param1Bundle) {
      this.mMessages.clear();
      if (param1Bundle.containsKey("android.messagingStyleUser")) {
        this.mUser = Person.fromBundle(param1Bundle.getBundle("android.messagingStyleUser"));
      } else {
        this.mUser = (new Person.Builder()).setName(param1Bundle.getString("android.selfDisplayName")).build();
      } 
      this.mConversationTitle = param1Bundle.getCharSequence("android.conversationTitle");
      if (this.mConversationTitle == null)
        this.mConversationTitle = param1Bundle.getCharSequence("android.hiddenConversationTitle"); 
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("android.messages");
      if (arrayOfParcelable != null)
        this.mMessages.addAll(Message.getMessagesFromBundleArray(arrayOfParcelable)); 
      if (param1Bundle.containsKey("android.isGroupConversation"))
        this.mIsGroupConversation = Boolean.valueOf(param1Bundle.getBoolean("android.isGroupConversation")); 
    }
    
    public MessagingStyle setConversationTitle(@Nullable CharSequence param1CharSequence) {
      this.mConversationTitle = param1CharSequence;
      return this;
    }
    
    public MessagingStyle setGroupConversation(boolean param1Boolean) {
      this.mIsGroupConversation = Boolean.valueOf(param1Boolean);
      return this;
    }
    
    public static final class Message {
      static final String KEY_DATA_MIME_TYPE = "type";
      
      static final String KEY_DATA_URI = "uri";
      
      static final String KEY_EXTRAS_BUNDLE = "extras";
      
      static final String KEY_NOTIFICATION_PERSON = "sender_person";
      
      static final String KEY_PERSON = "person";
      
      static final String KEY_SENDER = "sender";
      
      static final String KEY_TEXT = "text";
      
      static final String KEY_TIMESTAMP = "time";
      
      @Nullable
      private String mDataMimeType;
      
      @Nullable
      private Uri mDataUri;
      
      private Bundle mExtras = new Bundle();
      
      @Nullable
      private final Person mPerson;
      
      private final CharSequence mText;
      
      private final long mTimestamp;
      
      public Message(CharSequence param2CharSequence, long param2Long, @Nullable Person param2Person) {
        this.mText = param2CharSequence;
        this.mTimestamp = param2Long;
        this.mPerson = param2Person;
      }
      
      @Deprecated
      public Message(CharSequence param2CharSequence1, long param2Long, CharSequence param2CharSequence2) {
        this(param2CharSequence1, param2Long, (new Person.Builder()).setName(param2CharSequence2).build());
      }
      
      @NonNull
      static Bundle[] getBundleArrayForMessages(List<Message> param2List) {
        Bundle[] arrayOfBundle = new Bundle[param2List.size()];
        int i = param2List.size();
        for (byte b = 0; b < i; b++)
          arrayOfBundle[b] = ((Message)param2List.get(b)).toBundle(); 
        return arrayOfBundle;
      }
      
      @Nullable
      static Message getMessageFromBundle(Bundle param2Bundle) {
        try {
          Person person;
          if (!param2Bundle.containsKey("text") || !param2Bundle.containsKey("time"))
            return null; 
          if (param2Bundle.containsKey("person")) {
            person = Person.fromBundle(param2Bundle.getBundle("person"));
          } else if (param2Bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
            person = Person.fromAndroidPerson((Person)param2Bundle.getParcelable("sender_person"));
          } else if (param2Bundle.containsKey("sender")) {
            Person.Builder builder = new Person.Builder();
            this();
            person = builder.setName(param2Bundle.getCharSequence("sender")).build();
          } else {
            person = null;
          } 
          Message message = new Message();
          this(param2Bundle.getCharSequence("text"), param2Bundle.getLong("time"), person);
          if (param2Bundle.containsKey("type") && param2Bundle.containsKey("uri"))
            message.setData(param2Bundle.getString("type"), (Uri)param2Bundle.getParcelable("uri")); 
          if (param2Bundle.containsKey("extras"))
            message.getExtras().putAll(param2Bundle.getBundle("extras")); 
          return message;
        } catch (ClassCastException classCastException) {
          return null;
        } 
      }
      
      @NonNull
      static List<Message> getMessagesFromBundleArray(Parcelable[] param2ArrayOfParcelable) {
        ArrayList<Message> arrayList = new ArrayList(param2ArrayOfParcelable.length);
        for (byte b = 0; b < param2ArrayOfParcelable.length; b++) {
          if (param2ArrayOfParcelable[b] instanceof Bundle) {
            Message message = getMessageFromBundle((Bundle)param2ArrayOfParcelable[b]);
            if (message != null)
              arrayList.add(message); 
          } 
        } 
        return arrayList;
      }
      
      private Bundle toBundle() {
        Bundle bundle1 = new Bundle();
        CharSequence charSequence = this.mText;
        if (charSequence != null)
          bundle1.putCharSequence("text", charSequence); 
        bundle1.putLong("time", this.mTimestamp);
        Person person = this.mPerson;
        if (person != null) {
          bundle1.putCharSequence("sender", person.getName());
          if (Build.VERSION.SDK_INT >= 28) {
            bundle1.putParcelable("sender_person", (Parcelable)this.mPerson.toAndroidPerson());
          } else {
            bundle1.putBundle("person", this.mPerson.toBundle());
          } 
        } 
        String str = this.mDataMimeType;
        if (str != null)
          bundle1.putString("type", str); 
        Uri uri = this.mDataUri;
        if (uri != null)
          bundle1.putParcelable("uri", (Parcelable)uri); 
        Bundle bundle2 = this.mExtras;
        if (bundle2 != null)
          bundle1.putBundle("extras", bundle2); 
        return bundle1;
      }
      
      @Nullable
      public String getDataMimeType() {
        return this.mDataMimeType;
      }
      
      @Nullable
      public Uri getDataUri() {
        return this.mDataUri;
      }
      
      @NonNull
      public Bundle getExtras() {
        return this.mExtras;
      }
      
      @Nullable
      public Person getPerson() {
        return this.mPerson;
      }
      
      @Deprecated
      @Nullable
      public CharSequence getSender() {
        CharSequence charSequence;
        Person person = this.mPerson;
        if (person == null) {
          person = null;
        } else {
          charSequence = person.getName();
        } 
        return charSequence;
      }
      
      @NonNull
      public CharSequence getText() {
        return this.mText;
      }
      
      public long getTimestamp() {
        return this.mTimestamp;
      }
      
      public Message setData(String param2String, Uri param2Uri) {
        this.mDataMimeType = param2String;
        this.mDataUri = param2Uri;
        return this;
      }
    }
  }
  
  public static final class Message {
    static final String KEY_DATA_MIME_TYPE = "type";
    
    static final String KEY_DATA_URI = "uri";
    
    static final String KEY_EXTRAS_BUNDLE = "extras";
    
    static final String KEY_NOTIFICATION_PERSON = "sender_person";
    
    static final String KEY_PERSON = "person";
    
    static final String KEY_SENDER = "sender";
    
    static final String KEY_TEXT = "text";
    
    static final String KEY_TIMESTAMP = "time";
    
    @Nullable
    private String mDataMimeType;
    
    @Nullable
    private Uri mDataUri;
    
    private Bundle mExtras = new Bundle();
    
    @Nullable
    private final Person mPerson;
    
    private final CharSequence mText;
    
    private final long mTimestamp;
    
    public Message(CharSequence param1CharSequence, long param1Long, @Nullable Person param1Person) {
      this.mText = param1CharSequence;
      this.mTimestamp = param1Long;
      this.mPerson = param1Person;
    }
    
    @Deprecated
    public Message(CharSequence param1CharSequence1, long param1Long, CharSequence param1CharSequence2) {
      this(param1CharSequence1, param1Long, (new Person.Builder()).setName(param1CharSequence2).build());
    }
    
    @NonNull
    static Bundle[] getBundleArrayForMessages(List<Message> param1List) {
      Bundle[] arrayOfBundle = new Bundle[param1List.size()];
      int i = param1List.size();
      for (byte b = 0; b < i; b++)
        arrayOfBundle[b] = ((Message)param1List.get(b)).toBundle(); 
      return arrayOfBundle;
    }
    
    @Nullable
    static Message getMessageFromBundle(Bundle param1Bundle) {
      try {
        Person person;
        if (!param1Bundle.containsKey("text") || !param1Bundle.containsKey("time"))
          return null; 
        if (param1Bundle.containsKey("person")) {
          person = Person.fromBundle(param1Bundle.getBundle("person"));
        } else if (param1Bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
          person = Person.fromAndroidPerson((Person)param1Bundle.getParcelable("sender_person"));
        } else if (param1Bundle.containsKey("sender")) {
          Person.Builder builder = new Person.Builder();
          this();
          person = builder.setName(param1Bundle.getCharSequence("sender")).build();
        } else {
          person = null;
        } 
        Message message = new Message();
        this(param1Bundle.getCharSequence("text"), param1Bundle.getLong("time"), person);
        if (param1Bundle.containsKey("type") && param1Bundle.containsKey("uri"))
          message.setData(param1Bundle.getString("type"), (Uri)param1Bundle.getParcelable("uri")); 
        if (param1Bundle.containsKey("extras"))
          message.getExtras().putAll(param1Bundle.getBundle("extras")); 
        return message;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    @NonNull
    static List<Message> getMessagesFromBundleArray(Parcelable[] param1ArrayOfParcelable) {
      ArrayList<Message> arrayList = new ArrayList(param1ArrayOfParcelable.length);
      for (byte b = 0; b < param1ArrayOfParcelable.length; b++) {
        if (param1ArrayOfParcelable[b] instanceof Bundle) {
          Message message = getMessageFromBundle((Bundle)param1ArrayOfParcelable[b]);
          if (message != null)
            arrayList.add(message); 
        } 
      } 
      return arrayList;
    }
    
    private Bundle toBundle() {
      Bundle bundle1 = new Bundle();
      CharSequence charSequence = this.mText;
      if (charSequence != null)
        bundle1.putCharSequence("text", charSequence); 
      bundle1.putLong("time", this.mTimestamp);
      Person person = this.mPerson;
      if (person != null) {
        bundle1.putCharSequence("sender", person.getName());
        if (Build.VERSION.SDK_INT >= 28) {
          bundle1.putParcelable("sender_person", (Parcelable)this.mPerson.toAndroidPerson());
        } else {
          bundle1.putBundle("person", this.mPerson.toBundle());
        } 
      } 
      String str = this.mDataMimeType;
      if (str != null)
        bundle1.putString("type", str); 
      Uri uri = this.mDataUri;
      if (uri != null)
        bundle1.putParcelable("uri", (Parcelable)uri); 
      Bundle bundle2 = this.mExtras;
      if (bundle2 != null)
        bundle1.putBundle("extras", bundle2); 
      return bundle1;
    }
    
    @Nullable
    public String getDataMimeType() {
      return this.mDataMimeType;
    }
    
    @Nullable
    public Uri getDataUri() {
      return this.mDataUri;
    }
    
    @NonNull
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    @Nullable
    public Person getPerson() {
      return this.mPerson;
    }
    
    @Deprecated
    @Nullable
    public CharSequence getSender() {
      CharSequence charSequence;
      Person person = this.mPerson;
      if (person == null) {
        person = null;
      } else {
        charSequence = person.getName();
      } 
      return charSequence;
    }
    
    @NonNull
    public CharSequence getText() {
      return this.mText;
    }
    
    public long getTimestamp() {
      return this.mTimestamp;
    }
    
    public Message setData(String param1String, Uri param1Uri) {
      this.mDataMimeType = param1String;
      this.mDataUri = param1Uri;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface NotificationVisibility {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface StreamType {}
  
  public static abstract class Style {
    CharSequence mBigContentTitle;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected NotificationCompat.Builder mBuilder;
    
    CharSequence mSummaryText;
    
    boolean mSummaryTextSet = false;
    
    private int calculateTopPadding() {
      Resources resources = this.mBuilder.mContext.getResources();
      int i = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
      int j = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
      float f = (constrain((resources.getConfiguration()).fontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
      return Math.round((1.0F - f) * i + f * j);
    }
    
    private static float constrain(float param1Float1, float param1Float2, float param1Float3) {
      if (param1Float1 >= param1Float2) {
        param1Float2 = param1Float1;
        if (param1Float1 > param1Float3)
          param1Float2 = param1Float3; 
      } 
      return param1Float2;
    }
    
    private Bitmap createColoredBitmap(int param1Int1, int param1Int2, int param1Int3) {
      return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, param1Int1), param1Int2, param1Int3);
    }
    
    private Bitmap createColoredBitmap(IconCompat param1IconCompat, int param1Int1, int param1Int2) {
      int i;
      Drawable drawable = param1IconCompat.loadDrawable(this.mBuilder.mContext);
      if (param1Int2 == 0) {
        i = drawable.getIntrinsicWidth();
      } else {
        i = param1Int2;
      } 
      int j = param1Int2;
      if (param1Int2 == 0)
        j = drawable.getIntrinsicHeight(); 
      Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      drawable.setBounds(0, 0, i, j);
      if (param1Int1 != 0)
        drawable.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(param1Int1, PorterDuff.Mode.SRC_IN)); 
      drawable.draw(new Canvas(bitmap));
      return bitmap;
    }
    
    private Bitmap createIconWithBackground(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      int i = R.drawable.notification_icon_background;
      int j = param1Int4;
      if (param1Int4 == 0)
        j = 0; 
      Bitmap bitmap = createColoredBitmap(i, j, param1Int2);
      Canvas canvas = new Canvas(bitmap);
      Drawable drawable = this.mBuilder.mContext.getResources().getDrawable(param1Int1).mutate();
      drawable.setFilterBitmap(true);
      param1Int1 = (param1Int2 - param1Int3) / 2;
      param1Int2 = param1Int3 + param1Int1;
      drawable.setBounds(param1Int1, param1Int1, param1Int2, param1Int2);
      drawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      drawable.draw(canvas);
      return bitmap;
    }
    
    private void hideNormalContent(RemoteViews param1RemoteViews) {
      param1RemoteViews.setViewVisibility(R.id.title, 8);
      param1RemoteViews.setViewVisibility(R.id.text2, 8);
      param1RemoteViews.setViewVisibility(R.id.text, 8);
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addCompatExtras(Bundle param1Bundle) {}
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {}
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews applyStandardTemplate(boolean param1Boolean1, int param1Int, boolean param1Boolean2) {
      boolean bool2;
      Resources resources = this.mBuilder.mContext.getResources();
      RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), param1Int);
      param1Int = this.mBuilder.getPriority();
      boolean bool1 = false;
      if (param1Int < -1) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21)
        if (param1Int != 0) {
          remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
          remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
        } else {
          remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
          remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
        }  
      if (this.mBuilder.mLargeIcon != null) {
        if (Build.VERSION.SDK_INT >= 16) {
          remoteViews.setViewVisibility(R.id.icon, 0);
          remoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
        } else {
          remoteViews.setViewVisibility(R.id.icon, 8);
        } 
        if (param1Boolean1 && this.mBuilder.mNotification.icon != 0) {
          param1Int = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
          bool2 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
          if (Build.VERSION.SDK_INT >= 21) {
            Bitmap bitmap = createIconWithBackground(this.mBuilder.mNotification.icon, param1Int, param1Int - bool2 * 2, this.mBuilder.getColor());
            remoteViews.setImageViewBitmap(R.id.right_icon, bitmap);
          } else {
            remoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
          } 
          remoteViews.setViewVisibility(R.id.right_icon, 0);
        } 
      } else if (param1Boolean1 && this.mBuilder.mNotification.icon != 0) {
        remoteViews.setViewVisibility(R.id.icon, 0);
        if (Build.VERSION.SDK_INT >= 21) {
          param1Int = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width);
          int i = resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
          bool2 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
          Bitmap bitmap = createIconWithBackground(this.mBuilder.mNotification.icon, param1Int - i, bool2, this.mBuilder.getColor());
          remoteViews.setImageViewBitmap(R.id.icon, bitmap);
        } else {
          remoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        } 
      } 
      if (this.mBuilder.mContentTitle != null)
        remoteViews.setTextViewText(R.id.title, this.mBuilder.mContentTitle); 
      if (this.mBuilder.mContentText != null) {
        remoteViews.setTextViewText(R.id.text, this.mBuilder.mContentText);
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (Build.VERSION.SDK_INT < 21 && this.mBuilder.mLargeIcon != null) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      if (this.mBuilder.mContentInfo != null) {
        remoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
        remoteViews.setViewVisibility(R.id.info, 0);
        bool2 = true;
        param1Int = 1;
      } else if (this.mBuilder.mNumber > 0) {
        param1Int = resources.getInteger(R.integer.status_bar_notification_info_maxnum);
        if (this.mBuilder.mNumber > param1Int) {
          remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
        } else {
          NumberFormat numberFormat = NumberFormat.getIntegerInstance();
          remoteViews.setTextViewText(R.id.info, numberFormat.format(this.mBuilder.mNumber));
        } 
        remoteViews.setViewVisibility(R.id.info, 0);
        bool2 = true;
        param1Int = 1;
      } else {
        remoteViews.setViewVisibility(R.id.info, 8);
      } 
      if (this.mBuilder.mSubText != null && Build.VERSION.SDK_INT >= 16) {
        remoteViews.setTextViewText(R.id.text, this.mBuilder.mSubText);
        if (this.mBuilder.mContentText != null) {
          remoteViews.setTextViewText(R.id.text2, this.mBuilder.mContentText);
          remoteViews.setViewVisibility(R.id.text2, 0);
          i = 1;
        } else {
          remoteViews.setViewVisibility(R.id.text2, 8);
          i = 0;
        } 
        if (i && Build.VERSION.SDK_INT >= 16) {
          if (param1Boolean2) {
            float f = resources.getDimensionPixelSize(R.dimen.notification_subtext_size);
            remoteViews.setTextViewTextSize(R.id.text, 0, f);
          } 
          remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
        } 
        if (this.mBuilder.getWhenIfShowing() != 0L) {
          if (this.mBuilder.mUseChronometer && Build.VERSION.SDK_INT >= 16) {
            remoteViews.setViewVisibility(R.id.chronometer, 0);
            remoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + SystemClock.elapsedRealtime() - System.currentTimeMillis());
            remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
            if (this.mBuilder.mChronometerCountDown && Build.VERSION.SDK_INT >= 24)
              remoteViews.setChronometerCountDown(R.id.chronometer, this.mBuilder.mChronometerCountDown); 
          } else {
            remoteViews.setViewVisibility(R.id.time, 0);
            remoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
          } 
          param1Int = 1;
        } 
        int i = R.id.right_side;
        if (param1Int != 0) {
          param1Int = 0;
        } else {
          param1Int = 8;
        } 
        remoteViews.setViewVisibility(i, param1Int);
        i = R.id.line3;
        if (bool2) {
          param1Int = bool1;
        } else {
          param1Int = 8;
        } 
        remoteViews.setViewVisibility(i, param1Int);
        return remoteViews;
      } 
      boolean bool3 = false;
    }
    
    public Notification build() {
      NotificationCompat.Builder builder = this.mBuilder;
      if (builder != null) {
        Notification notification = builder.build();
      } else {
        builder = null;
      } 
      return (Notification)builder;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void buildIntoRemoteViews(RemoteViews param1RemoteViews1, RemoteViews param1RemoteViews2) {
      hideNormalContent(param1RemoteViews1);
      param1RemoteViews1.removeAllViews(R.id.notification_main_column);
      param1RemoteViews1.addView(R.id.notification_main_column, param1RemoteViews2.clone());
      param1RemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
      if (Build.VERSION.SDK_INT >= 21)
        param1RemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0); 
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap createColoredBitmap(int param1Int1, int param1Int2) {
      return createColoredBitmap(param1Int1, param1Int2, 0);
    }
    
    Bitmap createColoredBitmap(IconCompat param1IconCompat, int param1Int) {
      return createColoredBitmap(param1IconCompat, param1Int, 0);
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return null;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return null;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return null;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void restoreFromCompatExtras(Bundle param1Bundle) {}
    
    public void setBuilder(NotificationCompat.Builder param1Builder) {
      if (this.mBuilder != param1Builder) {
        this.mBuilder = param1Builder;
        param1Builder = this.mBuilder;
        if (param1Builder != null)
          param1Builder.setStyle(this); 
      } 
    }
  }
  
  public static final class WearableExtender implements Extender {
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
    
    public WearableExtender(Notification param1Notification) {
      Bundle bundle = NotificationCompat.getExtras(param1Notification);
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
    private static Notification.Action getActionFromActionCompat(NotificationCompat.Action param1Action) {
      Notification.Action.Builder builder;
      Bundle bundle;
      if (Build.VERSION.SDK_INT >= 23) {
        Icon icon;
        IconCompat iconCompat = param1Action.getIconCompat();
        if (iconCompat == null) {
          iconCompat = null;
        } else {
          icon = iconCompat.toIcon();
        } 
        builder = new Notification.Action.Builder(icon, param1Action.getTitle(), param1Action.getActionIntent());
      } else {
        builder = new Notification.Action.Builder(param1Action.getIcon(), param1Action.getTitle(), param1Action.getActionIntent());
      } 
      if (param1Action.getExtras() != null) {
        bundle = new Bundle(param1Action.getExtras());
      } else {
        bundle = new Bundle();
      } 
      bundle.putBoolean("android.support.allowGeneratedReplies", param1Action.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24)
        builder.setAllowGeneratedReplies(param1Action.getAllowGeneratedReplies()); 
      builder.addExtras(bundle);
      RemoteInput[] arrayOfRemoteInput = param1Action.getRemoteInputs();
      if (arrayOfRemoteInput != null) {
        RemoteInput[] arrayOfRemoteInput1 = RemoteInput.fromCompat(arrayOfRemoteInput);
        int i = arrayOfRemoteInput1.length;
        for (byte b = 0; b < i; b++)
          builder.addRemoteInput(arrayOfRemoteInput1[b]); 
      } 
      return builder.build();
    }
    
    private void setFlag(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.mFlags = param1Int | this.mFlags;
      } else {
        this.mFlags = (param1Int ^ 0xFFFFFFFF) & this.mFlags;
      } 
    }
    
    public WearableExtender addAction(NotificationCompat.Action param1Action) {
      this.mActions.add(param1Action);
      return this;
    }
    
    public WearableExtender addActions(List<NotificationCompat.Action> param1List) {
      this.mActions.addAll(param1List);
      return this;
    }
    
    @Deprecated
    public WearableExtender addPage(Notification param1Notification) {
      this.mPages.add(param1Notification);
      return this;
    }
    
    @Deprecated
    public WearableExtender addPages(List<Notification> param1List) {
      this.mPages.addAll(param1List);
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
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder) {
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
      param1Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
      return param1Builder;
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
    public WearableExtender setBackground(Bitmap param1Bitmap) {
      this.mBackground = param1Bitmap;
      return this;
    }
    
    public WearableExtender setBridgeTag(String param1String) {
      this.mBridgeTag = param1String;
      return this;
    }
    
    public WearableExtender setContentAction(int param1Int) {
      this.mContentActionIndex = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setContentIcon(int param1Int) {
      this.mContentIcon = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setContentIconGravity(int param1Int) {
      this.mContentIconGravity = param1Int;
      return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(boolean param1Boolean) {
      setFlag(1, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setCustomContentHeight(int param1Int) {
      this.mCustomContentHeight = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setCustomSizePreset(int param1Int) {
      this.mCustomSizePreset = param1Int;
      return this;
    }
    
    public WearableExtender setDismissalId(String param1String) {
      this.mDismissalId = param1String;
      return this;
    }
    
    @Deprecated
    public WearableExtender setDisplayIntent(PendingIntent param1PendingIntent) {
      this.mDisplayIntent = param1PendingIntent;
      return this;
    }
    
    @Deprecated
    public WearableExtender setGravity(int param1Int) {
      this.mGravity = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintAmbientBigPicture(boolean param1Boolean) {
      setFlag(32, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintAvoidBackgroundClipping(boolean param1Boolean) {
      setFlag(16, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintContentIntentLaunchesActivity(boolean param1Boolean) {
      setFlag(64, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintHideIcon(boolean param1Boolean) {
      setFlag(2, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintScreenTimeout(int param1Int) {
      this.mHintScreenTimeout = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintShowBackgroundOnly(boolean param1Boolean) {
      setFlag(4, param1Boolean);
      return this;
    }
    
    public WearableExtender setStartScrollBottom(boolean param1Boolean) {
      setFlag(8, param1Boolean);
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */