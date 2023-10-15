package androidx.core.app;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.RestrictTo;

public class BigPictureStyle extends NotificationCompat.Style {
  private Bitmap mBigLargeIcon;
  
  private boolean mBigLargeIconSet;
  
  private Bitmap mPicture;
  
  public BigPictureStyle() {}
  
  public BigPictureStyle(NotificationCompat.Builder paramBuilder) {
    setBuilder(paramBuilder);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    if (Build.VERSION.SDK_INT >= 16) {
      Notification.BigPictureStyle bigPictureStyle = (new Notification.BigPictureStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
      if (this.mBigLargeIconSet)
        bigPictureStyle.bigLargeIcon(this.mBigLargeIcon); 
      if (this.mSummaryTextSet)
        bigPictureStyle.setSummaryText(this.mSummaryText); 
    } 
  }
  
  public BigPictureStyle bigLargeIcon(Bitmap paramBitmap) {
    this.mBigLargeIcon = paramBitmap;
    this.mBigLargeIconSet = true;
    return this;
  }
  
  public BigPictureStyle bigPicture(Bitmap paramBitmap) {
    this.mPicture = paramBitmap;
    return this;
  }
  
  public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence) {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigPictureStyle setSummaryText(CharSequence paramCharSequence) {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$BigPictureStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */