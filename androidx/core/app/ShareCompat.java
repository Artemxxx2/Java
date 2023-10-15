package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class ShareCompat {
  public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
  
  public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  
  public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
  
  public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  
  private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
  
  public static void configureMenuItem(@NonNull Menu paramMenu, @IdRes int paramInt, @NonNull IntentBuilder paramIntentBuilder) {
    MenuItem menuItem = paramMenu.findItem(paramInt);
    if (menuItem != null) {
      configureMenuItem(menuItem, paramIntentBuilder);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find menu item with id ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" in the supplied menu");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static void configureMenuItem(@NonNull MenuItem paramMenuItem, @NonNull IntentBuilder paramIntentBuilder) {
    ShareActionProvider shareActionProvider;
    ActionProvider actionProvider = paramMenuItem.getActionProvider();
    if (!(actionProvider instanceof ShareActionProvider)) {
      shareActionProvider = new ShareActionProvider(paramIntentBuilder.getContext());
    } else {
      shareActionProvider = shareActionProvider;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(".sharecompat_");
    stringBuilder.append(paramIntentBuilder.getContext().getClass().getName());
    shareActionProvider.setShareHistoryFileName(stringBuilder.toString());
    shareActionProvider.setShareIntent(paramIntentBuilder.getIntent());
    paramMenuItem.setActionProvider((ActionProvider)shareActionProvider);
    if (Build.VERSION.SDK_INT < 16 && !paramMenuItem.hasSubMenu())
      paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent()); 
  }
  
  @Nullable
  public static ComponentName getCallingActivity(@NonNull Activity paramActivity) {
    Intent intent = paramActivity.getIntent();
    ComponentName componentName2 = paramActivity.getCallingActivity();
    ComponentName componentName1 = componentName2;
    if (componentName2 == null)
      componentName1 = getCallingActivity(intent); 
    return componentName1;
  }
  
  @Nullable
  static ComponentName getCallingActivity(@NonNull Intent paramIntent) {
    ComponentName componentName1 = (ComponentName)paramIntent.getParcelableExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY");
    ComponentName componentName2 = componentName1;
    if (componentName1 == null)
      componentName2 = (ComponentName)paramIntent.getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY"); 
    return componentName2;
  }
  
  @Nullable
  public static String getCallingPackage(@NonNull Activity paramActivity) {
    Intent intent = paramActivity.getIntent();
    String str2 = paramActivity.getCallingPackage();
    String str1 = str2;
    if (str2 == null) {
      str1 = str2;
      if (intent != null)
        str1 = getCallingPackage(intent); 
    } 
    return str1;
  }
  
  @Nullable
  static String getCallingPackage(@NonNull Intent paramIntent) {
    String str1 = paramIntent.getStringExtra("androidx.core.app.EXTRA_CALLING_PACKAGE");
    String str2 = str1;
    if (str1 == null)
      str2 = paramIntent.getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE"); 
    return str2;
  }
  
  public static class IntentBuilder {
    @Nullable
    private ArrayList<String> mBccAddresses;
    
    @Nullable
    private ArrayList<String> mCcAddresses;
    
    @Nullable
    private CharSequence mChooserTitle;
    
    @NonNull
    private final Context mContext;
    
    @NonNull
    private final Intent mIntent;
    
    @Nullable
    private ArrayList<Uri> mStreams;
    
    @Nullable
    private ArrayList<String> mToAddresses;
    
    private IntentBuilder(@NonNull Context param1Context, @Nullable ComponentName param1ComponentName) {
      this.mContext = (Context)Preconditions.checkNotNull(param1Context);
      this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
      this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", param1Context.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", param1Context.getPackageName());
      this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", (Parcelable)param1ComponentName);
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", (Parcelable)param1ComponentName);
      this.mIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(String param1String, ArrayList<String> param1ArrayList) {
      byte b;
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(param1String);
      if (arrayOfString1 != null) {
        b = arrayOfString1.length;
      } else {
        b = 0;
      } 
      String[] arrayOfString2 = new String[param1ArrayList.size() + b];
      param1ArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null)
        System.arraycopy(arrayOfString1, 0, arrayOfString2, param1ArrayList.size(), b); 
      this.mIntent.putExtra(param1String, arrayOfString2);
    }
    
    private void combineArrayExtra(@Nullable String param1String, @NonNull String[] param1ArrayOfString) {
      byte b;
      Intent intent = getIntent();
      String[] arrayOfString1 = intent.getStringArrayExtra(param1String);
      if (arrayOfString1 != null) {
        b = arrayOfString1.length;
      } else {
        b = 0;
      } 
      String[] arrayOfString2 = new String[param1ArrayOfString.length + b];
      if (arrayOfString1 != null)
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, b); 
      System.arraycopy(param1ArrayOfString, 0, arrayOfString2, b, param1ArrayOfString.length);
      intent.putExtra(param1String, arrayOfString2);
    }
    
    @NonNull
    public static IntentBuilder from(@NonNull Activity param1Activity) {
      return from((Context)Preconditions.checkNotNull(param1Activity), param1Activity.getComponentName());
    }
    
    @NonNull
    private static IntentBuilder from(@NonNull Context param1Context, @Nullable ComponentName param1ComponentName) {
      return new IntentBuilder(param1Context, param1ComponentName);
    }
    
    @NonNull
    public IntentBuilder addEmailBcc(@NonNull String param1String) {
      if (this.mBccAddresses == null)
        this.mBccAddresses = new ArrayList<String>(); 
      this.mBccAddresses.add(param1String);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailBcc(@NonNull String[] param1ArrayOfString) {
      combineArrayExtra("android.intent.extra.BCC", param1ArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailCc(@NonNull String param1String) {
      if (this.mCcAddresses == null)
        this.mCcAddresses = new ArrayList<String>(); 
      this.mCcAddresses.add(param1String);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailCc(@NonNull String[] param1ArrayOfString) {
      combineArrayExtra("android.intent.extra.CC", param1ArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailTo(@NonNull String param1String) {
      if (this.mToAddresses == null)
        this.mToAddresses = new ArrayList<String>(); 
      this.mToAddresses.add(param1String);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailTo(@NonNull String[] param1ArrayOfString) {
      combineArrayExtra("android.intent.extra.EMAIL", param1ArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addStream(@NonNull Uri param1Uri) {
      Uri uri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (this.mStreams == null && uri == null)
        return setStream(param1Uri); 
      if (this.mStreams == null)
        this.mStreams = new ArrayList<Uri>(); 
      if (uri != null) {
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        this.mStreams.add(uri);
      } 
      this.mStreams.add(param1Uri);
      return this;
    }
    
    @NonNull
    public Intent createChooserIntent() {
      return Intent.createChooser(getIntent(), this.mChooserTitle);
    }
    
    @NonNull
    Context getContext() {
      return this.mContext;
    }
    
    @NonNull
    public Intent getIntent() {
      ArrayList<String> arrayList1 = this.mToAddresses;
      if (arrayList1 != null) {
        combineArrayExtra("android.intent.extra.EMAIL", arrayList1);
        this.mToAddresses = null;
      } 
      arrayList1 = this.mCcAddresses;
      if (arrayList1 != null) {
        combineArrayExtra("android.intent.extra.CC", arrayList1);
        this.mCcAddresses = null;
      } 
      arrayList1 = this.mBccAddresses;
      if (arrayList1 != null) {
        combineArrayExtra("android.intent.extra.BCC", arrayList1);
        this.mBccAddresses = null;
      } 
      ArrayList<Uri> arrayList = this.mStreams;
      boolean bool = true;
      if (arrayList == null || arrayList.size() <= 1)
        bool = false; 
      boolean bool1 = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
      if (!bool && bool1) {
        this.mIntent.setAction("android.intent.action.SEND");
        arrayList = this.mStreams;
        if (arrayList != null && !arrayList.isEmpty()) {
          this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
        } else {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } 
        this.mStreams = null;
      } 
      if (bool && !bool1) {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        arrayList = this.mStreams;
        if (arrayList != null && !arrayList.isEmpty()) {
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
        } else {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } 
      } 
      return this.mIntent;
    }
    
    @NonNull
    public IntentBuilder setChooserTitle(@StringRes int param1Int) {
      return setChooserTitle(this.mContext.getText(param1Int));
    }
    
    @NonNull
    public IntentBuilder setChooserTitle(@Nullable CharSequence param1CharSequence) {
      this.mChooserTitle = param1CharSequence;
      return this;
    }
    
    @NonNull
    public IntentBuilder setEmailBcc(@Nullable String[] param1ArrayOfString) {
      this.mIntent.putExtra("android.intent.extra.BCC", param1ArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setEmailCc(@Nullable String[] param1ArrayOfString) {
      this.mIntent.putExtra("android.intent.extra.CC", param1ArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setEmailTo(@Nullable String[] param1ArrayOfString) {
      if (this.mToAddresses != null)
        this.mToAddresses = null; 
      this.mIntent.putExtra("android.intent.extra.EMAIL", param1ArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setHtmlText(@Nullable String param1String) {
      this.mIntent.putExtra("android.intent.extra.HTML_TEXT", param1String);
      if (!this.mIntent.hasExtra("android.intent.extra.TEXT"))
        setText((CharSequence)Html.fromHtml(param1String)); 
      return this;
    }
    
    @NonNull
    public IntentBuilder setStream(@Nullable Uri param1Uri) {
      if (!"android.intent.action.SEND".equals(this.mIntent.getAction()))
        this.mIntent.setAction("android.intent.action.SEND"); 
      this.mStreams = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)param1Uri);
      return this;
    }
    
    @NonNull
    public IntentBuilder setSubject(@Nullable String param1String) {
      this.mIntent.putExtra("android.intent.extra.SUBJECT", param1String);
      return this;
    }
    
    @NonNull
    public IntentBuilder setText(@Nullable CharSequence param1CharSequence) {
      this.mIntent.putExtra("android.intent.extra.TEXT", param1CharSequence);
      return this;
    }
    
    @NonNull
    public IntentBuilder setType(@Nullable String param1String) {
      this.mIntent.setType(param1String);
      return this;
    }
    
    public void startChooser() {
      this.mContext.startActivity(createChooserIntent());
    }
  }
  
  public static class IntentReader {
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
    
    private IntentReader(@NonNull Context param1Context, @NonNull Intent param1Intent) {
      this.mContext = (Context)Preconditions.checkNotNull(param1Context);
      this.mIntent = (Intent)Preconditions.checkNotNull(param1Intent);
      this.mCallingPackage = ShareCompat.getCallingPackage(param1Intent);
      this.mCallingActivity = ShareCompat.getCallingActivity(param1Intent);
    }
    
    @NonNull
    public static IntentReader from(@NonNull Activity param1Activity) {
      return from((Context)Preconditions.checkNotNull(param1Activity), param1Activity.getIntent());
    }
    
    @NonNull
    private static IntentReader from(@NonNull Context param1Context, @NonNull Intent param1Intent) {
      return new IntentReader(param1Context, param1Intent);
    }
    
    private static void withinStyle(StringBuilder param1StringBuilder, CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1CharSequence.charAt(param1Int1);
        if (c == '<') {
          param1StringBuilder.append("&lt;");
        } else if (c == '>') {
          param1StringBuilder.append("&gt;");
        } else if (c == '&') {
          param1StringBuilder.append("&amp;");
        } else if (c > '~' || c < ' ') {
          param1StringBuilder.append("&#");
          param1StringBuilder.append(c);
          param1StringBuilder.append(";");
        } else if (c == ' ') {
          while (true) {
            int i = param1Int1 + 1;
            if (i < param1Int2 && param1CharSequence.charAt(i) == ' ') {
              param1StringBuilder.append("&nbsp;");
              param1Int1 = i;
              continue;
            } 
            break;
          } 
          param1StringBuilder.append(' ');
        } else {
          param1StringBuilder.append(c);
        } 
        param1Int1++;
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
    public Uri getStream(int param1Int) {
      if (this.mStreams == null && isMultipleShare())
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM"); 
      ArrayList<Uri> arrayList = this.mStreams;
      if (arrayList != null)
        return arrayList.get(param1Int); 
      if (param1Int == 0)
        return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM"); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Stream items available: ");
      stringBuilder.append(getStreamCount());
      stringBuilder.append(" index requested: ");
      stringBuilder.append(param1Int);
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
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ShareCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */