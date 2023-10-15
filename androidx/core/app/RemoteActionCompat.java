package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat implements VersionedParcelable {
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public PendingIntent mActionIntent;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public CharSequence mContentDescription;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean mEnabled;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public IconCompat mIcon;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public boolean mShouldShowIcon;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public CharSequence mTitle;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteActionCompat() {}
  
  public RemoteActionCompat(@NonNull RemoteActionCompat paramRemoteActionCompat) {
    Preconditions.checkNotNull(paramRemoteActionCompat);
    this.mIcon = paramRemoteActionCompat.mIcon;
    this.mTitle = paramRemoteActionCompat.mTitle;
    this.mContentDescription = paramRemoteActionCompat.mContentDescription;
    this.mActionIntent = paramRemoteActionCompat.mActionIntent;
    this.mEnabled = paramRemoteActionCompat.mEnabled;
    this.mShouldShowIcon = paramRemoteActionCompat.mShouldShowIcon;
  }
  
  public RemoteActionCompat(@NonNull IconCompat paramIconCompat, @NonNull CharSequence paramCharSequence1, @NonNull CharSequence paramCharSequence2, @NonNull PendingIntent paramPendingIntent) {
    this.mIcon = (IconCompat)Preconditions.checkNotNull(paramIconCompat);
    this.mTitle = (CharSequence)Preconditions.checkNotNull(paramCharSequence1);
    this.mContentDescription = (CharSequence)Preconditions.checkNotNull(paramCharSequence2);
    this.mActionIntent = (PendingIntent)Preconditions.checkNotNull(paramPendingIntent);
    this.mEnabled = true;
    this.mShouldShowIcon = true;
  }
  
  @NonNull
  @RequiresApi(26)
  public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction paramRemoteAction) {
    Preconditions.checkNotNull(paramRemoteAction);
    RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(paramRemoteAction.getIcon()), paramRemoteAction.getTitle(), paramRemoteAction.getContentDescription(), paramRemoteAction.getActionIntent());
    remoteActionCompat.setEnabled(paramRemoteAction.isEnabled());
    if (Build.VERSION.SDK_INT >= 28)
      remoteActionCompat.setShouldShowIcon(paramRemoteAction.shouldShowIcon()); 
    return remoteActionCompat;
  }
  
  @NonNull
  public PendingIntent getActionIntent() {
    return this.mActionIntent;
  }
  
  @NonNull
  public CharSequence getContentDescription() {
    return this.mContentDescription;
  }
  
  @NonNull
  public IconCompat getIcon() {
    return this.mIcon;
  }
  
  @NonNull
  public CharSequence getTitle() {
    return this.mTitle;
  }
  
  public boolean isEnabled() {
    return this.mEnabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.mEnabled = paramBoolean;
  }
  
  public void setShouldShowIcon(boolean paramBoolean) {
    this.mShouldShowIcon = paramBoolean;
  }
  
  public boolean shouldShowIcon() {
    return this.mShouldShowIcon;
  }
  
  @NonNull
  @RequiresApi(26)
  public RemoteAction toRemoteAction() {
    RemoteAction remoteAction = new RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
    remoteAction.setEnabled(isEnabled());
    if (Build.VERSION.SDK_INT >= 28)
      remoteAction.setShouldShowIcon(shouldShowIcon()); 
    return remoteAction;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\RemoteActionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */