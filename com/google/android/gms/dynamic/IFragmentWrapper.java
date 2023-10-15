package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IFragmentWrapper extends IInterface {
  boolean zzA() throws RemoteException;
  
  int zzb() throws RemoteException;
  
  int zzc() throws RemoteException;
  
  @Nullable
  Bundle zzd() throws RemoteException;
  
  @Nullable
  IFragmentWrapper zze() throws RemoteException;
  
  @Nullable
  IFragmentWrapper zzf() throws RemoteException;
  
  @NonNull
  IObjectWrapper zzg() throws RemoteException;
  
  @NonNull
  IObjectWrapper zzh() throws RemoteException;
  
  @NonNull
  IObjectWrapper zzi() throws RemoteException;
  
  @Nullable
  String zzj() throws RemoteException;
  
  void zzk(@NonNull IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void zzl(boolean paramBoolean) throws RemoteException;
  
  void zzm(boolean paramBoolean) throws RemoteException;
  
  void zzn(boolean paramBoolean) throws RemoteException;
  
  void zzo(boolean paramBoolean) throws RemoteException;
  
  void zzp(@NonNull Intent paramIntent) throws RemoteException;
  
  void zzq(@NonNull Intent paramIntent, int paramInt) throws RemoteException;
  
  void zzr(@NonNull IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  boolean zzs() throws RemoteException;
  
  boolean zzt() throws RemoteException;
  
  boolean zzu() throws RemoteException;
  
  boolean zzv() throws RemoteException;
  
  boolean zzw() throws RemoteException;
  
  boolean zzx() throws RemoteException;
  
  boolean zzy() throws RemoteException;
  
  boolean zzz() throws RemoteException;
  
  public static abstract class Stub extends zzb implements IFragmentWrapper {
    public Stub() {
      super("com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    @NonNull
    public static IFragmentWrapper asInterface(@NonNull IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      return (iInterface instanceof IFragmentWrapper) ? (IFragmentWrapper)iInterface : new zza(param1IBinder);
    }
    
    protected final boolean zza(int param1Int1, @NonNull Parcel param1Parcel1, @NonNull Parcel param1Parcel2, int param1Int2) throws RemoteException {
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
      switch (param1Int1) {
        default:
          return false;
        case 27:
          iObjectWrapper5 = IObjectWrapper.Stub.asInterface(param1Parcel1.readStrongBinder());
          zzc.zzb(param1Parcel1);
          zzr(iObjectWrapper5);
          param1Parcel2.writeNoException();
          return true;
        case 26:
          intent = (Intent)zzc.zza(param1Parcel1, Intent.CREATOR);
          param1Int1 = param1Parcel1.readInt();
          zzc.zzb(param1Parcel1);
          zzq(intent, param1Int1);
          param1Parcel2.writeNoException();
          return true;
        case 25:
          intent = (Intent)zzc.zza(param1Parcel1, Intent.CREATOR);
          zzc.zzb(param1Parcel1);
          zzp(intent);
          param1Parcel2.writeNoException();
          return true;
        case 24:
          bool = zzc.zzg(param1Parcel1);
          zzc.zzb(param1Parcel1);
          zzo(bool);
          param1Parcel2.writeNoException();
          return true;
        case 23:
          bool = zzc.zzg(param1Parcel1);
          zzc.zzb(param1Parcel1);
          zzn(bool);
          param1Parcel2.writeNoException();
          return true;
        case 22:
          bool = zzc.zzg(param1Parcel1);
          zzc.zzb(param1Parcel1);
          zzm(bool);
          param1Parcel2.writeNoException();
          return true;
        case 21:
          bool = zzc.zzg(param1Parcel1);
          zzc.zzb(param1Parcel1);
          zzl(bool);
          param1Parcel2.writeNoException();
          return true;
        case 20:
          iObjectWrapper4 = IObjectWrapper.Stub.asInterface(param1Parcel1.readStrongBinder());
          zzc.zzb(param1Parcel1);
          zzk(iObjectWrapper4);
          param1Parcel2.writeNoException();
          return true;
        case 19:
          bool = zzA();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 18:
          bool = zzz();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 17:
          bool = zzy();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 16:
          bool = zzx();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 15:
          bool = zzw();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 14:
          bool = zzv();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 13:
          bool = zzu();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 12:
          iObjectWrapper3 = zzi();
          param1Parcel2.writeNoException();
          zzc.zzf(param1Parcel2, iObjectWrapper3);
          return true;
        case 11:
          bool = zzt();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 10:
          param1Int1 = zzc();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 9:
          iFragmentWrapper2 = zzf();
          param1Parcel2.writeNoException();
          zzc.zzf(param1Parcel2, iFragmentWrapper2);
          return true;
        case 8:
          str = zzj();
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return true;
        case 7:
          bool = zzs();
          param1Parcel2.writeNoException();
          zzc.zzc(param1Parcel2, bool);
          return true;
        case 6:
          iObjectWrapper2 = zzh();
          param1Parcel2.writeNoException();
          zzc.zzf(param1Parcel2, iObjectWrapper2);
          return true;
        case 5:
          iFragmentWrapper1 = zze();
          param1Parcel2.writeNoException();
          zzc.zzf(param1Parcel2, iFragmentWrapper1);
          return true;
        case 4:
          param1Int1 = zzb();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 3:
          bundle = zzd();
          param1Parcel2.writeNoException();
          zzc.zze(param1Parcel2, (Parcelable)bundle);
          return true;
        case 2:
          break;
      } 
      IObjectWrapper iObjectWrapper1 = zzg();
      param1Parcel2.writeNoException();
      zzc.zzf(param1Parcel2, iObjectWrapper1);
      return true;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamic\IFragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */