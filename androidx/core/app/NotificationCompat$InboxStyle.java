package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;

public class InboxStyle extends NotificationCompat.Style {
  private ArrayList<CharSequence> mTexts = new ArrayList<CharSequence>();
  
  public InboxStyle() {}
  
  public InboxStyle(NotificationCompat.Builder paramBuilder) {
    setBuilder(paramBuilder);
  }
  
  public InboxStyle addLine(CharSequence paramCharSequence) {
    this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
    return this;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    if (Build.VERSION.SDK_INT >= 16) {
      Notification.InboxStyle inboxStyle = (new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle);
      if (this.mSummaryTextSet)
        inboxStyle.setSummaryText(this.mSummaryText); 
      Iterator<CharSequence> iterator = this.mTexts.iterator();
      while (iterator.hasNext())
        inboxStyle.addLine(iterator.next()); 
    } 
  }
  
  public InboxStyle setBigContentTitle(CharSequence paramCharSequence) {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public InboxStyle setSummaryText(CharSequence paramCharSequence) {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$InboxStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */