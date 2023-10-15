package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class zzf extends zza {
  @Nullable
  public final IBinder zze;
  
  @BinderThread
  public zzf(BaseGmsClient paramBaseGmsClient, @Nullable int paramInt, @Nullable IBinder paramIBinder, Bundle paramBundle) {
    super(paramBaseGmsClient, paramInt, paramBundle);
    this.zze = paramIBinder;
  }
  
  protected final void zzb(ConnectionResult paramConnectionResult) {
    if (BaseGmsClient.zzc(this.zzf) != null)
      BaseGmsClient.zzc(this.zzf).onConnectionFailed(paramConnectionResult); 
    this.zzf.onConnectionFailed(paramConnectionResult);
  }
  
  protected final boolean zzd() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield zze : Landroid/os/IBinder;
    //   6: astore_2
    //   7: aload_2
    //   8: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_2
    //   13: invokeinterface getInterfaceDescriptor : ()Ljava/lang/String;
    //   18: astore_3
    //   19: aload_0
    //   20: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   23: invokevirtual getServiceDescriptor : ()Ljava/lang/String;
    //   26: aload_3
    //   27: invokevirtual equals : (Ljava/lang/Object;)Z
    //   30: ifne -> 93
    //   33: aload_0
    //   34: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   37: invokevirtual getServiceDescriptor : ()Ljava/lang/String;
    //   40: astore_2
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #4
    //   50: aload #4
    //   52: ldc 'service descriptor mismatch: '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #4
    //   60: aload_2
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #4
    //   67: ldc ' vs. '
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #4
    //   75: aload_3
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc 'GmsClient'
    //   82: aload #4
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   97: aload_0
    //   98: getfield zze : Landroid/os/IBinder;
    //   101: invokevirtual createServiceInterface : (Landroid/os/IBinder;)Landroid/os/IInterface;
    //   104: astore_2
    //   105: iload_1
    //   106: istore #5
    //   108: aload_2
    //   109: ifnull -> 184
    //   112: aload_0
    //   113: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   116: iconst_2
    //   117: iconst_4
    //   118: aload_2
    //   119: invokestatic zzn : (Lcom/google/android/gms/common/internal/BaseGmsClient;IILandroid/os/IInterface;)Z
    //   122: ifne -> 141
    //   125: iload_1
    //   126: istore #5
    //   128: aload_0
    //   129: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   132: iconst_3
    //   133: iconst_4
    //   134: aload_2
    //   135: invokestatic zzn : (Lcom/google/android/gms/common/internal/BaseGmsClient;IILandroid/os/IInterface;)Z
    //   138: ifeq -> 184
    //   141: aload_0
    //   142: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   145: aconst_null
    //   146: invokestatic zzg : (Lcom/google/android/gms/common/internal/BaseGmsClient;Lcom/google/android/gms/common/ConnectionResult;)V
    //   149: aload_0
    //   150: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   153: invokevirtual getConnectionHint : ()Landroid/os/Bundle;
    //   156: astore #4
    //   158: aload_0
    //   159: getfield zzf : Lcom/google/android/gms/common/internal/BaseGmsClient;
    //   162: astore_2
    //   163: aload_2
    //   164: invokestatic zzb : (Lcom/google/android/gms/common/internal/BaseGmsClient;)Lcom/google/android/gms/common/internal/BaseGmsClient$BaseConnectionCallbacks;
    //   167: ifnull -> 181
    //   170: aload_2
    //   171: invokestatic zzb : (Lcom/google/android/gms/common/internal/BaseGmsClient;)Lcom/google/android/gms/common/internal/BaseGmsClient$BaseConnectionCallbacks;
    //   174: aload #4
    //   176: invokeinterface onConnected : (Landroid/os/Bundle;)V
    //   181: iconst_1
    //   182: istore #5
    //   184: iload #5
    //   186: ireturn
    //   187: astore_2
    //   188: ldc 'GmsClient'
    //   190: ldc 'service probably died'
    //   192: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: iconst_0
    //   197: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	19	187	android/os/RemoteException
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */