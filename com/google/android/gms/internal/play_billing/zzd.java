package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzd extends zzi implements zze {
  public static zze zzo(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
    return (iInterface instanceof zze) ? (zze)iInterface : new zzc(paramIBinder);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */