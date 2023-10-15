package com.google.android.gms.internal.play_billing;

final class zzp {
  static void zza(Object paramObject1, Object paramObject2) {
    if (paramObject1 != null) {
      if (paramObject2 != null)
        return; 
      paramObject2 = new StringBuilder();
      paramObject2.append("null value in entry: ");
      paramObject2.append(paramObject1);
      paramObject2.append("=null");
      throw new NullPointerException(paramObject2.toString());
    } 
    paramObject1 = new StringBuilder();
    paramObject1.append("null key in entry: null=");
    paramObject1.append(paramObject2);
    throw new NullPointerException("null key in entry: null=".concat(String.valueOf(paramObject2)));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */