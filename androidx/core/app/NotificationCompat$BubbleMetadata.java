package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;

public final class BubbleMetadata {
  private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
  
  private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
  
  private PendingIntent mDeleteIntent;
  
  private int mDesiredHeight;
  
  @DimenRes
  private int mDesiredHeightResId;
  
  private int mFlags;
  
  private IconCompat mIcon;
  
  private PendingIntent mPendingIntent;
  
  private BubbleMetadata(PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, IconCompat paramIconCompat, int paramInt1, @DimenRes int paramInt2, int paramInt3) {
    this.mPendingIntent = paramPendingIntent1;
    this.mIcon = paramIconCompat;
    this.mDesiredHeight = paramInt1;
    this.mDesiredHeightResId = paramInt2;
    this.mDeleteIntent = paramPendingIntent2;
    this.mFlags = paramInt3;
  }
  
  @Nullable
  @RequiresApi(29)
  public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata paramBubbleMetadata) {
    if (paramBubbleMetadata == null)
      return null; 
    Builder builder = (new Builder()).setAutoExpandBubble(paramBubbleMetadata.getAutoExpandBubble()).setDeleteIntent(paramBubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(paramBubbleMetadata.getIcon())).setIntent(paramBubbleMetadata.getIntent()).setSuppressNotification(paramBubbleMetadata.isNotificationSuppressed());
    if (paramBubbleMetadata.getDesiredHeight() != 0)
      builder.setDesiredHeight(paramBubbleMetadata.getDesiredHeight()); 
    if (paramBubbleMetadata.getDesiredHeightResId() != 0)
      builder.setDesiredHeightResId(paramBubbleMetadata.getDesiredHeightResId()); 
    return builder.build();
  }
  
  private void setFlags(int paramInt) {
    this.mFlags = paramInt;
  }
  
  @Nullable
  @RequiresApi(29)
  public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata paramBubbleMetadata) {
    if (paramBubbleMetadata == null)
      return null; 
    Notification.BubbleMetadata.Builder builder = (new Notification.BubbleMetadata.Builder()).setAutoExpandBubble(paramBubbleMetadata.getAutoExpandBubble()).setDeleteIntent(paramBubbleMetadata.getDeleteIntent()).setIcon(paramBubbleMetadata.getIcon().toIcon()).setIntent(paramBubbleMetadata.getIntent()).setSuppressNotification(paramBubbleMetadata.isNotificationSuppressed());
    if (paramBubbleMetadata.getDesiredHeight() != 0)
      builder.setDesiredHeight(paramBubbleMetadata.getDesiredHeight()); 
    if (paramBubbleMetadata.getDesiredHeightResId() != 0)
      builder.setDesiredHeightResId(paramBubbleMetadata.getDesiredHeightResId()); 
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$BubbleMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */