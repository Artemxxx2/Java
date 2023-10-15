package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import androidx.annotation.RestrictTo;

public class BigTextStyle extends NotificationCompat.Style {
  private CharSequence mBigText;
  
  public BigTextStyle() {}
  
  public BigTextStyle(NotificationCompat.Builder paramBuilder) {
    setBuilder(paramBuilder);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    if (Build.VERSION.SDK_INT >= 16) {
      Notification.BigTextStyle bigTextStyle = (new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
      if (this.mSummaryTextSet)
        bigTextStyle.setSummaryText(this.mSummaryText); 
    } 
  }
  
  public BigTextStyle bigText(CharSequence paramCharSequence) {
    this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigTextStyle setBigContentTitle(CharSequence paramCharSequence) {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigTextStyle setSummaryText(CharSequence paramCharSequence) {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$BigTextStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */