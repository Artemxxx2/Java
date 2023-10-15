package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class Stub extends zzb implements IFragmentWrapper {
  public Stub() {
    super("com.google.android.gms.dynamic.IFragmentWrapper");
  }
  
  @NonNull
  public static IFragmentWrapper asInterface(@NonNull IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
    return (iInterface instanceof IFragmentWrapper) ? (IFragmentWrapper)iInterface : new zza(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, @NonNull Parcel paramParcel1, @NonNull Parcel paramParcel2, int paramInt2) throws RemoteException {
    IObjectWrapper iObjectWrapper3;
    IFragmentWrapper iFragmentWrapper2;
    String str;
    IObjectWrapper iObjectWrapper2;
    IFragmentWrapper iFragmentWrapper1;
    Bundle bundle;
    IObjectWrapper iObjectWrapper5;
    Intent intent;
    IObjectWrapper iObjectWrapper4;
    boolean bool;
    switch (paramInt1) {
      default:
        return false;
      case 27:
        iObjectWrapper5 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        zzc.zzb(paramParcel1);
        zzr(iObjectWrapper5);
        paramParcel2.writeNoException();
        return true;
      case 26:
        intent = (Intent)zzc.zza(paramParcel1, Intent.CREATOR);
        paramInt1 = paramParcel1.readInt();
        zzc.zzb(paramParcel1);
        zzq(intent, paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 25:
        intent = (Intent)zzc.zza(paramParcel1, Intent.CREATOR);
        zzc.zzb(paramParcel1);
        zzp(intent);
        paramParcel2.writeNoException();
        return true;
      case 24:
        bool = zzc.zzg(paramParcel1);
        zzc.zzb(paramParcel1);
        zzo(bool);
        paramParcel2.writeNoException();
        return true;
      case 23:
        bool = zzc.zzg(paramParcel1);
        zzc.zzb(paramParcel1);
        zzn(bool);
        paramParcel2.writeNoException();
        return true;
      case 22:
        bool = zzc.zzg(paramParcel1);
        zzc.zzb(paramParcel1);
        zzm(bool);
        paramParcel2.writeNoException();
        return true;
      case 21:
        bool = zzc.zzg(paramParcel1);
        zzc.zzb(paramParcel1);
        zzl(bool);
        paramParcel2.writeNoException();
        return true;
      case 20:
        iObjectWrapper4 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        zzc.zzb(paramParcel1);
        zzk(iObjectWrapper4);
        paramParcel2.writeNoException();
        return true;
      case 19:
        bool = zzA();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 18:
        bool = zzz();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 17:
        bool = zzy();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 16:
        bool = zzx();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 15:
        bool = zzw();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 14:
        bool = zzv();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 13:
        bool = zzu();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 12:
        iObjectWrapper3 = zzi();
        paramParcel2.writeNoException();
        zzc.zzf(paramParcel2, iObjectWrapper3);
        return true;
      case 11:
        bool = zzt();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 10:
        paramInt1 = zzc();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9:
        iFragmentWrapper2 = zzf();
        paramParcel2.writeNoException();
        zzc.zzf(paramParcel2, iFragmentWrapper2);
        return true;
      case 8:
        str = zzj();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      case 7:
        bool = zzs();
        paramParcel2.writeNoException();
        zzc.zzc(paramParcel2, bool);
        return true;
      case 6:
        iObjectWrapper2 = zzh();
        paramParcel2.writeNoException();
        zzc.zzf(paramParcel2, iObjectWrapper2);
        return true;
      case 5:
        iFragmentWrapper1 = zze();
        paramParcel2.writeNoException();
        zzc.zzf(paramParcel2, iFragmentWrapper1);
        return true;
      case 4:
        paramInt1 = zzb();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3:
        bundle = zzd();
        paramParcel2.writeNoException();
        zzc.zze(paramParcel2, (Parcelable)bundle);
        return true;
      case 2:
        break;
    } 
    IObjectWrapper iObjectWrapper1 = zzg();
    paramParcel2.writeNoException();
    zzc.zzf(paramParcel2, iObjectWrapper1);
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamic\IFragmentWrapper$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */