package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
@KeepForSdk
public final class GoogleServices {
  private static final Object zza = new Object();
  
  @Nullable
  @GuardedBy("sLock")
  private static GoogleServices zzb;
  
  @Nullable
  private final String zzc;
  
  private final Status zzd;
  
  private final boolean zze;
  
  private final boolean zzf;
  
  @KeepForSdk
  @VisibleForTesting
  GoogleServices(Context paramContext) {
    Resources resources = paramContext.getResources();
    int i = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool1 = true;
    boolean bool2 = true;
    if (i != 0) {
      i = resources.getInteger(i);
      if (i != 0) {
        bool1 = false;
      } else {
        bool1 = true;
      } 
      if (i == 0)
        bool2 = false; 
      this.zzf = bool1;
    } else {
      this.zzf = false;
      bool2 = bool1;
    } 
    this.zze = bool2;
    String str2 = zzag.zzb(paramContext);
    String str1 = str2;
    if (str2 == null)
      str1 = (new StringResourceValueReader(paramContext)).getString("google_app_id"); 
    if (TextUtils.isEmpty(str1)) {
      this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzc = null;
      return;
    } 
    this.zzc = str1;
    this.zzd = Status.RESULT_SUCCESS;
  }
  
  @KeepForSdk
  @VisibleForTesting
  GoogleServices(String paramString, boolean paramBoolean) {
    this.zzc = paramString;
    this.zzd = Status.RESULT_SUCCESS;
    this.zze = paramBoolean;
    this.zzf = paramBoolean ^ true;
  }
  
  @KeepForSdk
  private static GoogleServices checkInitialized(String paramString) {
    synchronized (zza) {
      GoogleServices googleServices = zzb;
      if (googleServices != null)
        return googleServices; 
      IllegalStateException illegalStateException = new IllegalStateException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Initialize must be called before ");
      stringBuilder.append(paramString);
      stringBuilder.append(".");
      this(stringBuilder.toString());
      throw illegalStateException;
    } 
  }
  
  @KeepForSdk
  @VisibleForTesting
  static void clearInstanceForTest() {
    synchronized (zza) {
      zzb = null;
      return;
    } 
  }
  
  @Nullable
  @KeepForSdk
  public static String getGoogleAppId() {
    return (checkInitialized("getGoogleAppId")).zzc;
  }
  
  @NonNull
  @KeepForSdk
  public static Status initialize(@NonNull Context paramContext) {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (zza) {
      if (zzb == null) {
        GoogleServices googleServices = new GoogleServices();
        this(paramContext);
        zzb = googleServices;
      } 
      return zzb.zzd;
    } 
  }
  
  @NonNull
  @KeepForSdk
  public static Status initialize(@NonNull Context paramContext, @NonNull String paramString, boolean paramBoolean) {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (zza) {
      GoogleServices googleServices = zzb;
      if (googleServices != null) {
        status = googleServices.checkGoogleAppId(paramString);
        return status;
      } 
      googleServices = new GoogleServices();
      this((String)status, paramBoolean);
      zzb = googleServices;
      Status status = zzb.zzd;
      return status;
    } 
  }
  
  @KeepForSdk
  public static boolean isMeasurementEnabled() {
    GoogleServices googleServices = checkInitialized("isMeasurementEnabled");
    return (googleServices.zzd.isSuccess() && googleServices.zze);
  }
  
  @KeepForSdk
  public static boolean isMeasurementExplicitlyDisabled() {
    return (checkInitialized("isMeasurementExplicitlyDisabled")).zzf;
  }
  
  @KeepForSdk
  @VisibleForTesting
  Status checkGoogleAppId(String paramString) {
    String str = this.zzc;
    if (str != null && !str.equals(paramString)) {
      paramString = this.zzc;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
      stringBuilder.append(paramString);
      stringBuilder.append("'.");
      return new Status(10, stringBuilder.toString());
    } 
    return Status.RESULT_SUCCESS;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\GoogleServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */