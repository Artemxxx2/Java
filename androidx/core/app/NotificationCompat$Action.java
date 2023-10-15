package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;

public class Action {
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
  
  public Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {
    this(iconCompat, paramCharSequence, paramPendingIntent);
  }
  
  Action(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3) {
    this(iconCompat, paramCharSequence, paramPendingIntent, paramBundle, paramArrayOfRemoteInput1, paramArrayOfRemoteInput2, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3);
  }
  
  public Action(@Nullable IconCompat paramIconCompat, @Nullable CharSequence paramCharSequence, @Nullable PendingIntent paramPendingIntent) {
    this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), (RemoteInput[])null, (RemoteInput[])null, true, 0, true, false);
  }
  
  Action(@Nullable IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3) {
    this.mIcon = paramIconCompat;
    if (paramIconCompat != null && paramIconCompat.getType() == 2)
      this.icon = paramIconCompat.getResId(); 
    this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.actionIntent = paramPendingIntent;
    if (paramBundle == null)
      paramBundle = new Bundle(); 
    this.mExtras = paramBundle;
    this.mRemoteInputs = paramArrayOfRemoteInput1;
    this.mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
    this.mAllowGeneratedReplies = paramBoolean1;
    this.mSemanticAction = paramInt;
    this.mShowsUserInterface = paramBoolean2;
    this.mIsContextual = paramBoolean3;
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$Action.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */