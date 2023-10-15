package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public class IntentBuilder {
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
  
  private IntentBuilder(@NonNull Context paramContext, @Nullable ComponentName paramComponentName) {
    this.mContext = (Context)Preconditions.checkNotNull(paramContext);
    this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
    this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
    this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", (Parcelable)paramComponentName);
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", (Parcelable)paramComponentName);
    this.mIntent.addFlags(524288);
  }
  
  private void combineArrayExtra(String paramString, ArrayList<String> paramArrayList) {
    byte b;
    String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
    if (arrayOfString1 != null) {
      b = arrayOfString1.length;
    } else {
      b = 0;
    } 
    String[] arrayOfString2 = new String[paramArrayList.size() + b];
    paramArrayList.toArray(arrayOfString2);
    if (arrayOfString1 != null)
      System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), b); 
    this.mIntent.putExtra(paramString, arrayOfString2);
  }
  
  private void combineArrayExtra(@Nullable String paramString, @NonNull String[] paramArrayOfString) {
    byte b;
    Intent intent = getIntent();
    String[] arrayOfString1 = intent.getStringArrayExtra(paramString);
    if (arrayOfString1 != null) {
      b = arrayOfString1.length;
    } else {
      b = 0;
    } 
    String[] arrayOfString2 = new String[paramArrayOfString.length + b];
    if (arrayOfString1 != null)
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, b); 
    System.arraycopy(paramArrayOfString, 0, arrayOfString2, b, paramArrayOfString.length);
    intent.putExtra(paramString, arrayOfString2);
  }
  
  @NonNull
  public static IntentBuilder from(@NonNull Activity paramActivity) {
    return from((Context)Preconditions.checkNotNull(paramActivity), paramActivity.getComponentName());
  }
  
  @NonNull
  private static IntentBuilder from(@NonNull Context paramContext, @Nullable ComponentName paramComponentName) {
    return new IntentBuilder(paramContext, paramComponentName);
  }
  
  @NonNull
  public IntentBuilder addEmailBcc(@NonNull String paramString) {
    if (this.mBccAddresses == null)
      this.mBccAddresses = new ArrayList<String>(); 
    this.mBccAddresses.add(paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailBcc(@NonNull String[] paramArrayOfString) {
    combineArrayExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailCc(@NonNull String paramString) {
    if (this.mCcAddresses == null)
      this.mCcAddresses = new ArrayList<String>(); 
    this.mCcAddresses.add(paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailCc(@NonNull String[] paramArrayOfString) {
    combineArrayExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailTo(@NonNull String paramString) {
    if (this.mToAddresses == null)
      this.mToAddresses = new ArrayList<String>(); 
    this.mToAddresses.add(paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailTo(@NonNull String[] paramArrayOfString) {
    combineArrayExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addStream(@NonNull Uri paramUri) {
    Uri uri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    if (this.mStreams == null && uri == null)
      return setStream(paramUri); 
    if (this.mStreams == null)
      this.mStreams = new ArrayList<Uri>(); 
    if (uri != null) {
      this.mIntent.removeExtra("android.intent.extra.STREAM");
      this.mStreams.add(uri);
    } 
    this.mStreams.add(paramUri);
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
  public IntentBuilder setChooserTitle(@StringRes int paramInt) {
    return setChooserTitle(this.mContext.getText(paramInt));
  }
  
  @NonNull
  public IntentBuilder setChooserTitle(@Nullable CharSequence paramCharSequence) {
    this.mChooserTitle = paramCharSequence;
    return this;
  }
  
  @NonNull
  public IntentBuilder setEmailBcc(@Nullable String[] paramArrayOfString) {
    this.mIntent.putExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setEmailCc(@Nullable String[] paramArrayOfString) {
    this.mIntent.putExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setEmailTo(@Nullable String[] paramArrayOfString) {
    if (this.mToAddresses != null)
      this.mToAddresses = null; 
    this.mIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setHtmlText(@Nullable String paramString) {
    this.mIntent.putExtra("android.intent.extra.HTML_TEXT", paramString);
    if (!this.mIntent.hasExtra("android.intent.extra.TEXT"))
      setText((CharSequence)Html.fromHtml(paramString)); 
    return this;
  }
  
  @NonNull
  public IntentBuilder setStream(@Nullable Uri paramUri) {
    if (!"android.intent.action.SEND".equals(this.mIntent.getAction()))
      this.mIntent.setAction("android.intent.action.SEND"); 
    this.mStreams = null;
    this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)paramUri);
    return this;
  }
  
  @NonNull
  public IntentBuilder setSubject(@Nullable String paramString) {
    this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setText(@Nullable CharSequence paramCharSequence) {
    this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
    return this;
  }
  
  @NonNull
  public IntentBuilder setType(@Nullable String paramString) {
    this.mIntent.setType(paramString);
    return this;
  }
  
  public void startChooser() {
    this.mContext.startActivity(createChooserIntent());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ShareCompat$IntentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */