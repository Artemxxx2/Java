package androidx.core.app;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;

public abstract class Style {
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
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (paramFloat1 >= paramFloat2) {
      paramFloat2 = paramFloat1;
      if (paramFloat1 > paramFloat3)
        paramFloat2 = paramFloat3; 
    } 
    return paramFloat2;
  }
  
  private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3) {
    return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, paramInt1), paramInt2, paramInt3);
  }
  
  private Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt1, int paramInt2) {
    int i;
    Drawable drawable = paramIconCompat.loadDrawable(this.mBuilder.mContext);
    if (paramInt2 == 0) {
      i = drawable.getIntrinsicWidth();
    } else {
      i = paramInt2;
    } 
    int j = paramInt2;
    if (paramInt2 == 0)
      j = drawable.getIntrinsicHeight(); 
    Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    drawable.setBounds(0, 0, i, j);
    if (paramInt1 != 0)
      drawable.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(paramInt1, PorterDuff.Mode.SRC_IN)); 
    drawable.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = R.drawable.notification_icon_background;
    int j = paramInt4;
    if (paramInt4 == 0)
      j = 0; 
    Bitmap bitmap = createColoredBitmap(i, j, paramInt2);
    Canvas canvas = new Canvas(bitmap);
    Drawable drawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
    drawable.setFilterBitmap(true);
    paramInt1 = (paramInt2 - paramInt3) / 2;
    paramInt2 = paramInt3 + paramInt1;
    drawable.setBounds(paramInt1, paramInt1, paramInt2, paramInt2);
    drawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    drawable.draw(canvas);
    return bitmap;
  }
  
  private void hideNormalContent(RemoteViews paramRemoteViews) {
    paramRemoteViews.setViewVisibility(R.id.title, 8);
    paramRemoteViews.setViewVisibility(R.id.text2, 8);
    paramRemoteViews.setViewVisibility(R.id.text, 8);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void addCompatExtras(Bundle paramBundle) {}
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {}
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    boolean bool2;
    Resources resources = this.mBuilder.mContext.getResources();
    RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), paramInt);
    paramInt = this.mBuilder.getPriority();
    boolean bool1 = false;
    if (paramInt < -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21)
      if (paramInt != 0) {
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
      if (paramBoolean1 && this.mBuilder.mNotification.icon != 0) {
        paramInt = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
        bool2 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
        if (Build.VERSION.SDK_INT >= 21) {
          Bitmap bitmap = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - bool2 * 2, this.mBuilder.getColor());
          remoteViews.setImageViewBitmap(R.id.right_icon, bitmap);
        } else {
          remoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        } 
        remoteViews.setViewVisibility(R.id.right_icon, 0);
      } 
    } else if (paramBoolean1 && this.mBuilder.mNotification.icon != 0) {
      remoteViews.setViewVisibility(R.id.icon, 0);
      if (Build.VERSION.SDK_INT >= 21) {
        paramInt = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width);
        int i = resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
        bool2 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
        Bitmap bitmap = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, bool2, this.mBuilder.getColor());
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
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (this.mBuilder.mContentInfo != null) {
      remoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
      remoteViews.setViewVisibility(R.id.info, 0);
      bool2 = true;
      paramInt = 1;
    } else if (this.mBuilder.mNumber > 0) {
      paramInt = resources.getInteger(R.integer.status_bar_notification_info_maxnum);
      if (this.mBuilder.mNumber > paramInt) {
        remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
      } else {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        remoteViews.setTextViewText(R.id.info, numberFormat.format(this.mBuilder.mNumber));
      } 
      remoteViews.setViewVisibility(R.id.info, 0);
      bool2 = true;
      paramInt = 1;
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
        if (paramBoolean2) {
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
        paramInt = 1;
      } 
      int i = R.id.right_side;
      if (paramInt != 0) {
        paramInt = 0;
      } else {
        paramInt = 8;
      } 
      remoteViews.setViewVisibility(i, paramInt);
      i = R.id.line3;
      if (bool2) {
        paramInt = bool1;
      } else {
        paramInt = 8;
      } 
      remoteViews.setViewVisibility(i, paramInt);
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
  public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2) {
    hideNormalContent(paramRemoteViews1);
    paramRemoteViews1.removeAllViews(R.id.notification_main_column);
    paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
    if (Build.VERSION.SDK_INT >= 21)
      paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Bitmap createColoredBitmap(int paramInt1, int paramInt2) {
    return createColoredBitmap(paramInt1, paramInt2, 0);
  }
  
  Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt) {
    return createColoredBitmap(paramIconCompat, paramInt, 0);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    return null;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    return null;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    return null;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void restoreFromCompatExtras(Bundle paramBundle) {}
  
  public void setBuilder(NotificationCompat.Builder paramBuilder) {
    if (this.mBuilder != paramBuilder) {
      this.mBuilder = paramBuilder;
      paramBuilder = this.mBuilder;
      if (paramBuilder != null)
        paramBuilder.setStyle(this); 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$Style.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */