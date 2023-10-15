package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;

public final class zzn {
  private static final Uri zza = (new Uri.Builder()).scheme("content").authority("com.google.android.gms.chimera").build();
  
  @Nullable
  private final String zzb;
  
  @Nullable
  private final String zzc;
  
  @Nullable
  private final ComponentName zzd;
  
  private final int zze;
  
  private final boolean zzf;
  
  public zzn(ComponentName paramComponentName, int paramInt) {
    this.zzb = null;
    this.zzc = null;
    Preconditions.checkNotNull(paramComponentName);
    this.zzd = paramComponentName;
    this.zze = paramInt;
    this.zzf = false;
  }
  
  public zzn(String paramString, int paramInt, boolean paramBoolean) {
    this(paramString, "com.google.android.gms", paramInt, false);
  }
  
  public zzn(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
    Preconditions.checkNotEmpty(paramString1);
    this.zzb = paramString1;
    Preconditions.checkNotEmpty(paramString2);
    this.zzc = paramString2;
    this.zzd = null;
    this.zze = paramInt;
    this.zzf = paramBoolean;
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzn))
      return false; 
    paramObject = paramObject;
    return (Objects.equal(this.zzb, ((zzn)paramObject).zzb) && Objects.equal(this.zzc, ((zzn)paramObject).zzc) && Objects.equal(this.zzd, ((zzn)paramObject).zzd) && this.zze == ((zzn)paramObject).zze && this.zzf == ((zzn)paramObject).zzf);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Boolean.valueOf(this.zzf) });
  }
  
  public final String toString() {
    String str1 = this.zzb;
    String str2 = str1;
    if (str1 == null) {
      Preconditions.checkNotNull(this.zzd);
      str2 = this.zzd.flattenToString();
    } 
    return str2;
  }
  
  public final int zza() {
    return this.zze;
  }
  
  @Nullable
  public final ComponentName zzb() {
    return this.zzd;
  }
  
  public final Intent zzc(Context paramContext) {
    Intent intent;
    if (this.zzb != null) {
      boolean bool = this.zzf;
      Bundle bundle = null;
      IllegalArgumentException illegalArgumentException = null;
      if (bool) {
        Intent intent1;
        bundle = new Bundle();
        bundle.putString("serviceActionBundleKey", this.zzb);
        try {
          Bundle bundle1 = paramContext.getContentResolver().call(zza, "serviceIntentCall", null, bundle);
        } catch (IllegalArgumentException illegalArgumentException1) {
          Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(illegalArgumentException1.toString()));
          illegalArgumentException1 = null;
        } 
        if (illegalArgumentException1 == null) {
          illegalArgumentException1 = illegalArgumentException;
        } else {
          intent1 = (Intent)illegalArgumentException1.getParcelable("serviceResponseIntentKey");
        } 
        intent = intent1;
        if (intent1 == null) {
          Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.zzb)));
          intent = intent1;
        } 
      } 
      if (intent == null)
        return (new Intent(this.zzb)).setPackage(this.zzc); 
    } else {
      intent = (new Intent()).setComponent(this.zzd);
    } 
    return intent;
  }
  
  @Nullable
  public final String zzd() {
    return this.zzc;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */