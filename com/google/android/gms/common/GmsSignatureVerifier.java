package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;
import java.util.List;

@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class GmsSignatureVerifier {
  private static final zzab zza;
  
  private static final zzab zzb;
  
  private static final HashMap zzc = new HashMap<Object, Object>();
  
  static {
    zzz zzz = new zzz();
    zzz.zzd("com.google.android.gms");
    zzz.zza(204200000L);
    zzz.zzc((List)zzag.zzn(zzn.zzd.zzf(), zzn.zzb.zzf()));
    zzz.zzb((List)zzag.zzn(zzn.zzc.zzf(), zzn.zza.zzf()));
    zza = zzz.zze();
    zzz = new zzz();
    zzz.zzd("com.android.vending");
    zzz.zza(82240000L);
    zzz.zzc((List)zzag.zzm(zzn.zzd.zzf()));
    zzz.zzb((List)zzag.zzm(zzn.zzc.zzf()));
    zzb = zzz.zze();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\GmsSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */