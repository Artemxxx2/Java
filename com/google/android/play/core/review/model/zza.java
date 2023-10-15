package com.google.android.play.core.review.model;

import java.util.HashMap;
import java.util.Map;

public final class zza {
  private static final Map zza = new HashMap<Object, Object>();
  
  private static final Map zzb = new HashMap<Object, Object>();
  
  static {
    Map<Integer, String> map1 = zza;
    Integer integer2 = Integer.valueOf(-1);
    map1.put(integer2, "The Play Store app is either not installed or not the official version.");
    Map<Integer, String> map2 = zza;
    Integer integer1 = Integer.valueOf(-2);
    map2.put(integer1, "Call first requestReviewFlow to get the ReviewInfo.");
    Map<Integer, String> map3 = zza;
    Integer integer3 = Integer.valueOf(-100);
    map3.put(integer3, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
    zzb.put(integer2, "PLAY_STORE_NOT_FOUND");
    zzb.put(integer1, "INVALID_REQUEST");
    zzb.put(integer3, "INTERNAL_ERROR");
  }
  
  public static String zza(int paramInt) {
    Map map = zza;
    Integer integer = Integer.valueOf(paramInt);
    if (!map.containsKey(integer))
      return ""; 
    String str1 = (String)zza.get(integer);
    String str2 = (String)zzb.get(integer);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(" (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#");
    stringBuilder.append(str2);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\model\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */