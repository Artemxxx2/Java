package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;

public final class Builder {
  private PendingIntent mDeleteIntent;
  
  private int mDesiredHeight;
  
  @DimenRes
  private int mDesiredHeightResId;
  
  private int mFlags;
  
  private IconCompat mIcon;
  
  private PendingIntent mPendingIntent;
  
  private Builder setFlag(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags = paramInt | this.mFlags;
    } else {
      this.mFlags = (paramInt ^ 0xFFFFFFFF) & this.mFlags;
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
        return new NotificationCompat.BubbleMetadata(pendingIntent, this.mDeleteIntent, iconCompat, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, null); 
      throw new IllegalStateException("Must supply an icon for the bubble");
    } 
    throw new IllegalStateException("Must supply pending intent to bubble");
  }
  
  @NonNull
  public Builder setAutoExpandBubble(boolean paramBoolean) {
    setFlag(1, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder setDeleteIntent(@Nullable PendingIntent paramPendingIntent) {
    this.mDeleteIntent = paramPendingIntent;
    return this;
  }
  
  @NonNull
  public Builder setDesiredHeight(@Dimension(unit = 0) int paramInt) {
    this.mDesiredHeight = Math.max(paramInt, 0);
    this.mDesiredHeightResId = 0;
    return this;
  }
  
  @NonNull
  public Builder setDesiredHeightResId(@DimenRes int paramInt) {
    this.mDesiredHeightResId = paramInt;
    this.mDesiredHeight = 0;
    return this;
  }
  
  @NonNull
  public Builder setIcon(@NonNull IconCompat paramIconCompat) {
    if (paramIconCompat != null) {
      if (paramIconCompat.getType() != 1) {
        this.mIcon = paramIconCompat;
        return this;
      } 
      throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
    } 
    throw new IllegalArgumentException("Bubbles require non-null icon");
  }
  
  @NonNull
  public Builder setIntent(@NonNull PendingIntent paramPendingIntent) {
    if (paramPendingIntent != null) {
      this.mPendingIntent = paramPendingIntent;
      return this;
    } 
    throw new IllegalArgumentException("Bubble requires non-null pending intent");
  }
  
  @NonNull
  public Builder setSuppressNotification(boolean paramBoolean) {
    setFlag(2, paramBoolean);
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$BubbleMetadata$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */