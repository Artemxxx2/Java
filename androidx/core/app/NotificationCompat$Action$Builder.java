package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;

public final class Builder {
  private boolean mAllowGeneratedReplies;
  
  private final Bundle mExtras;
  
  private final IconCompat mIcon;
  
  private final PendingIntent mIntent;
  
  private boolean mIsContextual;
  
  private ArrayList<RemoteInput> mRemoteInputs;
  
  private int mSemanticAction;
  
  private boolean mShowsUserInterface;
  
  private final CharSequence mTitle;
  
  public Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {
    this(iconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, true, 0, true, false);
  }
  
  public Builder(NotificationCompat.Action paramAction) {
    this(paramAction.getIconCompat(), paramAction.title, paramAction.actionIntent, new Bundle(paramAction.mExtras), paramAction.getRemoteInputs(), paramAction.getAllowGeneratedReplies(), paramAction.getSemanticAction(), paramAction.mShowsUserInterface, paramAction.isContextual());
  }
  
  public Builder(@Nullable IconCompat paramIconCompat, @Nullable CharSequence paramCharSequence, @Nullable PendingIntent paramPendingIntent) {
    this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, true, 0, true, false);
  }
  
  private Builder(@Nullable IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3) {
    ArrayList<RemoteInput> arrayList;
    this.mAllowGeneratedReplies = true;
    this.mShowsUserInterface = true;
    this.mIcon = paramIconCompat;
    this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mIntent = paramPendingIntent;
    this.mExtras = paramBundle;
    if (paramArrayOfRemoteInput == null) {
      paramIconCompat = null;
    } else {
      arrayList = new ArrayList(Arrays.asList((Object[])paramArrayOfRemoteInput));
    } 
    this.mRemoteInputs = arrayList;
    this.mAllowGeneratedReplies = paramBoolean1;
    this.mSemanticAction = paramInt;
    this.mShowsUserInterface = paramBoolean2;
    this.mIsContextual = paramBoolean3;
  }
  
  private void checkContextualActionNullFields() {
    if (!this.mIsContextual)
      return; 
    if (this.mIntent != null)
      return; 
    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
  }
  
  public Builder addExtras(Bundle paramBundle) {
    if (paramBundle != null)
      this.mExtras.putAll(paramBundle); 
    return this;
  }
  
  public Builder addRemoteInput(RemoteInput paramRemoteInput) {
    if (this.mRemoteInputs == null)
      this.mRemoteInputs = new ArrayList<RemoteInput>(); 
    this.mRemoteInputs.add(paramRemoteInput);
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
  
  public Builder extend(NotificationCompat.Action.Extender paramExtender) {
    paramExtender.extend(this);
    return this;
  }
  
  public Bundle getExtras() {
    return this.mExtras;
  }
  
  public Builder setAllowGeneratedReplies(boolean paramBoolean) {
    this.mAllowGeneratedReplies = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setContextual(boolean paramBoolean) {
    this.mIsContextual = paramBoolean;
    return this;
  }
  
  public Builder setSemanticAction(int paramInt) {
    this.mSemanticAction = paramInt;
    return this;
  }
  
  public Builder setShowsUserInterface(boolean paramBoolean) {
    this.mShowsUserInterface = paramBoolean;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$Action$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */