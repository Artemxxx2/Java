package com.google.android.play.core.review;

import android.app.PendingIntent;

final class zza extends ReviewInfo {
  private final PendingIntent zza;
  
  private final boolean zzb;
  
  zza(PendingIntent paramPendingIntent, boolean paramBoolean) {
    if (paramPendingIntent != null) {
      this.zza = paramPendingIntent;
      this.zzb = paramBoolean;
      return;
    } 
    throw new NullPointerException("Null pendingIntent");
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ReviewInfo) {
      paramObject = paramObject;
      if (this.zza.equals(paramObject.zza()) && this.zzb == paramObject.zzb())
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    char c;
    int i = this.zza.hashCode();
    if (true != this.zzb) {
      c = 'ӕ';
    } else {
      c = 'ӏ';
    } 
    return (i ^ 0xF4243) * 1000003 ^ c;
  }
  
  public final String toString() {
    String str = this.zza.toString();
    boolean bool = this.zzb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ReviewInfo{pendingIntent=");
    stringBuilder.append(str);
    stringBuilder.append(", isNoOp=");
    stringBuilder.append(bool);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  final PendingIntent zza() {
    return this.zza;
  }
  
  final boolean zzb() {
    return this.zzb;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */