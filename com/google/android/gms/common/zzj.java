package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzj extends zzy {
  private final int zza;
  
  protected zzj(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte.length == 25) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    this.zza = Arrays.hashCode(paramArrayOfbyte);
  }
  
  protected static byte[] zze(String paramString) {
    try {
      return paramString.getBytes("ISO-8859-1");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    if (paramObject == null || !(paramObject instanceof com.google.android.gms.common.internal.zzz))
      return false; 
    try {
      paramObject = paramObject;
      if (paramObject.zzc() != this.zza)
        return false; 
      paramObject = paramObject.zzd();
      if (paramObject == null)
        return false; 
      paramObject = ObjectWrapper.unwrap((IObjectWrapper)paramObject);
      return Arrays.equals(zzf(), (byte[])paramObject);
    } catch (RemoteException remoteException) {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)remoteException);
      return false;
    } 
  }
  
  public final int hashCode() {
    return this.zza;
  }
  
  public final int zzc() {
    return this.zza;
  }
  
  public final IObjectWrapper zzd() {
    return ObjectWrapper.wrap(zzf());
  }
  
  abstract byte[] zzf();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */