package com.google.android.gms.internal.play_billing;

final class zzv {
  private final Object zza;
  
  private final Object zzb;
  
  private final Object zzc;
  
  zzv(Object paramObject1, Object paramObject2, Object paramObject3) {
    this.zza = paramObject1;
    this.zzb = paramObject2;
    this.zzc = paramObject3;
  }
  
  final IllegalArgumentException zza() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Multiple entries with same key: ");
    stringBuilder.append(this.zza);
    stringBuilder.append("=");
    stringBuilder.append(this.zzb);
    stringBuilder.append(" and ");
    stringBuilder.append(this.zza);
    stringBuilder.append("=");
    stringBuilder.append(this.zzc);
    return new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */