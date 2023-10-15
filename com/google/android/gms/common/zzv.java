package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzv extends zzx {
  private final Callable zze;
  
  final String zza() {
    try {
      return this.zze.call();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */