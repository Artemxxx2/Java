package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public class IntentReader {
  private static final String TAG = "IntentReader";
  
  @Nullable
  private final ComponentName mCallingActivity;
  
  @Nullable
  private final String mCallingPackage;
  
  @NonNull
  private final Context mContext;
  
  @NonNull
  private final Intent mIntent;
  
  @Nullable
  private ArrayList<Uri> mStreams;
  
  private IntentReader(@NonNull Context paramContext, @NonNull Intent paramIntent) {
    this.mContext = (Context)Preconditions.checkNotNull(paramContext);
    this.mIntent = (Intent)Preconditions.checkNotNull(paramIntent);
    this.mCallingPackage = ShareCompat.getCallingPackage(paramIntent);
    this.mCallingActivity = ShareCompat.getCallingActivity(paramIntent);
  }
  
  @NonNull
  public static IntentReader from(@NonNull Activity paramActivity) {
    return from((Context)Preconditions.checkNotNull(paramActivity), paramActivity.getIntent());
  }
  
  @NonNull
  private static IntentReader from(@NonNull Context paramContext, @NonNull Intent paramIntent) {
    return new IntentReader(paramContext, paramIntent);
  }
  
  private static void withinStyle(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      char c = paramCharSequence.charAt(paramInt1);
      if (c == '<') {
        paramStringBuilder.append("&lt;");
      } else if (c == '>') {
        paramStringBuilder.append("&gt;");
      } else if (c == '&') {
        paramStringBuilder.append("&amp;");
      } else if (c > '~' || c < ' ') {
        paramStringBuilder.append("&#");
        paramStringBuilder.append(c);
        paramStringBuilder.append(";");
      } else if (c == ' ') {
        while (true) {
          int i = paramInt1 + 1;
          if (i < paramInt2 && paramCharSequence.charAt(i) == ' ') {
            paramStringBuilder.append("&nbsp;");
            paramInt1 = i;
            continue;
          } 
          break;
        } 
        paramStringBuilder.append(' ');
      } else {
        paramStringBuilder.append(c);
      } 
      paramInt1++;
    } 
  }
  
  @Nullable
  public ComponentName getCallingActivity() {
    return this.mCallingActivity;
  }
  
  @Nullable
  public Drawable getCallingActivityIcon() {
    if (this.mCallingActivity == null)
      return null; 
    PackageManager packageManager = this.mContext.getPackageManager();
    try {
      return packageManager.getActivityIcon(this.mCallingActivity);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("IntentReader", "Could not retrieve icon for calling activity", (Throwable)nameNotFoundException);
      return null;
    } 
  }
  
  @Nullable
  public Drawable getCallingApplicationIcon() {
    if (this.mCallingPackage == null)
      return null; 
    PackageManager packageManager = this.mContext.getPackageManager();
    try {
      return packageManager.getApplicationIcon(this.mCallingPackage);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("IntentReader", "Could not retrieve icon for calling application", (Throwable)nameNotFoundException);
      return null;
    } 
  }
  
  @Nullable
  public CharSequence getCallingApplicationLabel() {
    if (this.mCallingPackage == null)
      return null; 
    PackageManager packageManager = this.mContext.getPackageManager();
    try {
      return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("IntentReader", "Could not retrieve label for calling application", (Throwable)nameNotFoundException);
      return null;
    } 
  }
  
  @Nullable
  public String getCallingPackage() {
    return this.mCallingPackage;
  }
  
  @Nullable
  public String[] getEmailBcc() {
    return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
  }
  
  @Nullable
  public String[] getEmailCc() {
    return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
  }
  
  @Nullable
  public String[] getEmailTo() {
    return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
  }
  
  @Nullable
  public String getHtmlText() {
    String str1 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
    String str2 = str1;
    if (str1 == null) {
      CharSequence charSequence = getText();
      if (charSequence instanceof Spanned) {
        str2 = Html.toHtml((Spanned)charSequence);
      } else {
        str2 = str1;
        if (charSequence != null)
          if (Build.VERSION.SDK_INT >= 16) {
            str2 = Html.escapeHtml(charSequence);
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            withinStyle(stringBuilder, charSequence, 0, charSequence.length());
            str2 = stringBuilder.toString();
          }  
      } 
    } 
    return str2;
  }
  
  @Nullable
  public Uri getStream() {
    return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
  }
  
  @Nullable
  public Uri getStream(int paramInt) {
    if (this.mStreams == null && isMultipleShare())
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM"); 
    ArrayList<Uri> arrayList = this.mStreams;
    if (arrayList != null)
      return arrayList.get(paramInt); 
    if (paramInt == 0)
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM"); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Stream items available: ");
    stringBuilder.append(getStreamCount());
    stringBuilder.append(" index requested: ");
    stringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  public int getStreamCount() {
    if (this.mStreams == null && isMultipleShare())
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM"); 
    ArrayList<Uri> arrayList = this.mStreams;
    return (arrayList != null) ? arrayList.size() : this.mIntent.hasExtra("android.intent.extra.STREAM");
  }
  
  @Nullable
  public String getSubject() {
    return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
  }
  
  @Nullable
  public CharSequence getText() {
    return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
  }
  
  @Nullable
  public String getType() {
    return this.mIntent.getType();
  }
  
  public boolean isMultipleShare() {
    return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
  }
  
  public boolean isShareIntent() {
    String str = this.mIntent.getAction();
    return ("android.intent.action.SEND".equals(str) || "android.intent.action.SEND_MULTIPLE".equals(str));
  }
  
  public boolean isSingleShare() {
    return "android.intent.action.SEND".equals(this.mIntent.getAction());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ShareCompat$IntentReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */