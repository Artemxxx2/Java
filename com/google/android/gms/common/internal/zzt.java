package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class zzt {
  private static final Uri zza = Uri.parse("https://plus.google.com/");
  
  private static final Uri zzb = zza.buildUpon().appendPath("circles").appendPath("find").build();
  
  public static Intent zza() {
    Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    intent.setPackage("com.google.android.wearable.app");
    return intent;
  }
  
  public static Intent zzb(String paramString1, @Nullable String paramString2) {
    Intent intent = new Intent("android.intent.action.VIEW");
    Uri.Builder builder = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
    if (!TextUtils.isEmpty(paramString2))
      builder.appendQueryParameter("pcampaignid", paramString2); 
    intent.setData(builder.build());
    intent.setPackage("com.android.vending");
    intent.addFlags(524288);
    return intent;
  }
  
  public static Intent zzc(String paramString) {
    Uri uri = Uri.fromParts("package", "com.google.android.gms", null);
    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    intent.setData(uri);
    return intent;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */