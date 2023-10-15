package com.google.android.gms.internal.play_billing;

enum zza {
  zza(-999),
  zzb(-3),
  zzc(-2),
  zzd(-1),
  zze(0),
  zzf(1),
  zzg(2),
  zzh(3),
  zzi(4),
  zzj(5),
  zzk(6),
  zzl(7),
  zzm(8),
  zzn(11);
  
  private static final zzx zzo;
  
  private final int zzq;
  
  static {
    zzw zzw = new zzw();
    zza[] arrayOfZza = values();
    int i = arrayOfZza.length;
    while (b < i) {
      zza zza1 = arrayOfZza[b];
      zzw.zza(Integer.valueOf(zza1.zzq), zza1);
      b++;
    } 
    zzo = zzw.zzb();
  }
  
  zza(int paramInt1) {
    this.zzq = paramInt1;
  }
  
  static zza zza(int paramInt) {
    zzx zzx1 = zzo;
    Integer integer = Integer.valueOf(paramInt);
    return !zzx1.containsKey(integer) ? zza : (zza)zzo.get(integer);
  }
  
  static {
    byte b = 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */