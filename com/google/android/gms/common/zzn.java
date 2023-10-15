package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import java.security.MessageDigest;

@CheckReturnValue
final class zzn {
  static final zzl zza = new zzf(zzj.zze("0\005È0\003° \003\002\001\002\002\024\020e\bsù/Qí"));
  
  static final zzl zzb = new zzg(zzj.zze("0\006\0040\003ì \003\002\001\002\002\024\003£²­×árÊkì"));
  
  static final zzl zzc = new zzh(zzj.zze("0\004C0\003+ \003\002\001\002\002\t\000ÂàFdJ00"));
  
  static final zzl zzd = new zzi(zzj.zze("0\004¨0\003 \003\002\001\002\002\t\000Õ¸l}ÓNõ0"));
  
  private static volatile zzaf zze;
  
  private static final Object zzf = new Object();
  
  private static Context zzg;
  
  static zzx zza(String paramString, zzj paramzzj, boolean paramBoolean1, boolean paramBoolean2) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      return zzh(paramString, paramzzj, paramBoolean1, paramBoolean2);
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  static zzx zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return zzi(paramString, paramBoolean1, false, false, true);
  }
  
  static zzx zzc(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return zzi(paramString, paramBoolean1, false, false, false);
  }
  
  static void zze(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/common/zzn
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/zzn.zzg : Landroid/content/Context;
    //   6: ifnonnull -> 28
    //   9: aload_0
    //   10: ifnull -> 24
    //   13: aload_0
    //   14: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   17: putstatic com/google/android/gms/common/zzn.zzg : Landroid/content/Context;
    //   20: ldc com/google/android/gms/common/zzn
    //   22: monitorexit
    //   23: return
    //   24: ldc com/google/android/gms/common/zzn
    //   26: monitorexit
    //   27: return
    //   28: ldc 'GoogleCertificates'
    //   30: ldc 'GoogleCertificates has been initialized already'
    //   32: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: ldc com/google/android/gms/common/zzn
    //   38: monitorexit
    //   39: return
    //   40: astore_0
    //   41: ldc com/google/android/gms/common/zzn
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	40	finally
    //   13	20	40	finally
    //   28	36	40	finally
  }
  
  static boolean zzf() {
    Exception exception;
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      zzj();
      boolean bool = zze.zzg();
      StrictMode.setThreadPolicy(threadPolicy);
      return bool;
    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException|RemoteException loadingException) {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)loadingException);
      StrictMode.setThreadPolicy(threadPolicy);
      return false;
    } finally {}
    StrictMode.setThreadPolicy(threadPolicy);
    throw exception;
  }
  
  static boolean zzg() {
    Exception exception;
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      zzj();
      boolean bool = zze.zzi();
      StrictMode.setThreadPolicy(threadPolicy);
      return bool;
    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException|RemoteException loadingException) {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)loadingException);
      StrictMode.setThreadPolicy(threadPolicy);
      return false;
    } finally {}
    StrictMode.setThreadPolicy(threadPolicy);
    throw exception;
  }
  
  private static zzx zzh(String paramString, zzj paramzzj, boolean paramBoolean1, boolean paramBoolean2) {
    try {
      zzj();
      Preconditions.checkNotNull(zzg);
      zzs zzs = new zzs(paramString, paramzzj, paramBoolean1, paramBoolean2);
      try {
        paramBoolean2 = zze.zzh(zzs, ObjectWrapper.wrap(zzg.getPackageManager()));
        return paramBoolean2 ? zzx.zzb() : new zzv(new zze(paramBoolean1, paramString, paramzzj), null);
      } catch (RemoteException remoteException) {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)remoteException);
        return zzx.zzd("module call", (Throwable)remoteException);
      } 
    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loadingException) {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)loadingException);
      return zzx.zzd("module init: ".concat(String.valueOf(loadingException.getMessage())), (Throwable)loadingException);
    } 
  }
  
  private static zzx zzi(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    // Byte code:
    //   0: invokestatic allowThreadDiskReads : ()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore #5
    //   5: getstatic com/google/android/gms/common/zzn.zzg : Landroid/content/Context;
    //   8: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: invokestatic zzj : ()V
    //   15: new com/google/android/gms/common/zzo
    //   18: astore #6
    //   20: aload #6
    //   22: aload_0
    //   23: iload_1
    //   24: iconst_0
    //   25: getstatic com/google/android/gms/common/zzn.zzg : Landroid/content/Context;
    //   28: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   31: iconst_0
    //   32: invokespecial <init> : (Ljava/lang/String;ZZLandroid/os/IBinder;Z)V
    //   35: iload #4
    //   37: ifeq -> 54
    //   40: getstatic com/google/android/gms/common/zzn.zze : Lcom/google/android/gms/common/internal/zzaf;
    //   43: aload #6
    //   45: invokeinterface zze : (Lcom/google/android/gms/common/zzo;)Lcom/google/android/gms/common/zzq;
    //   50: astore_0
    //   51: goto -> 65
    //   54: getstatic com/google/android/gms/common/zzn.zze : Lcom/google/android/gms/common/internal/zzaf;
    //   57: aload #6
    //   59: invokeinterface zzf : (Lcom/google/android/gms/common/zzo;)Lcom/google/android/gms/common/zzq;
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual zzb : ()Z
    //   69: ifeq -> 83
    //   72: aload_0
    //   73: invokevirtual zzc : ()I
    //   76: invokestatic zzf : (I)Lcom/google/android/gms/common/zzx;
    //   79: astore_0
    //   80: goto -> 192
    //   83: aload_0
    //   84: invokevirtual zza : ()Ljava/lang/String;
    //   87: astore #7
    //   89: aload_0
    //   90: invokevirtual zzd : ()I
    //   93: iconst_4
    //   94: if_icmpne -> 110
    //   97: new android/content/pm/PackageManager$NameNotFoundException
    //   100: astore #6
    //   102: aload #6
    //   104: invokespecial <init> : ()V
    //   107: goto -> 113
    //   110: aconst_null
    //   111: astore #6
    //   113: aload #7
    //   115: astore #8
    //   117: aload #7
    //   119: ifnonnull -> 126
    //   122: ldc 'error checking package certificate'
    //   124: astore #8
    //   126: aload_0
    //   127: invokevirtual zzc : ()I
    //   130: aload_0
    //   131: invokevirtual zzd : ()I
    //   134: aload #8
    //   136: aload #6
    //   138: invokestatic zzg : (IILjava/lang/String;Ljava/lang/Throwable;)Lcom/google/android/gms/common/zzx;
    //   141: astore_0
    //   142: goto -> 192
    //   145: astore_0
    //   146: ldc 'GoogleCertificates'
    //   148: ldc 'Failed to get Google certificates from remote'
    //   150: aload_0
    //   151: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   154: pop
    //   155: ldc 'module call'
    //   157: aload_0
    //   158: invokestatic zzd : (Ljava/lang/String;Ljava/lang/Throwable;)Lcom/google/android/gms/common/zzx;
    //   161: astore_0
    //   162: goto -> 192
    //   165: astore_0
    //   166: ldc 'GoogleCertificates'
    //   168: ldc 'Failed to get Google certificates from remote'
    //   170: aload_0
    //   171: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: ldc 'module init: '
    //   177: aload_0
    //   178: invokevirtual getMessage : ()Ljava/lang/String;
    //   181: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   187: aload_0
    //   188: invokestatic zzd : (Ljava/lang/String;Ljava/lang/Throwable;)Lcom/google/android/gms/common/zzx;
    //   191: astore_0
    //   192: aload #5
    //   194: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   197: aload_0
    //   198: areturn
    //   199: astore_0
    //   200: aload #5
    //   202: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   205: aload_0
    //   206: athrow
    // Exception table:
    //   from	to	target	type
    //   5	12	199	finally
    //   12	15	165	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   12	15	199	finally
    //   15	35	199	finally
    //   40	51	145	android/os/RemoteException
    //   40	51	199	finally
    //   54	65	145	android/os/RemoteException
    //   54	65	199	finally
    //   65	80	199	finally
    //   83	107	199	finally
    //   126	142	199	finally
    //   146	162	199	finally
    //   166	192	199	finally
  }
  
  private static void zzj() throws DynamiteModule.LoadingException {
    if (zze != null)
      return; 
    Preconditions.checkNotNull(zzg);
    synchronized (zzf) {
      if (zze == null)
        zze = zzae.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl")); 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */