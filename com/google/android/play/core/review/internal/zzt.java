package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.zze;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzt {
  private static final Map zza = new HashMap<Object, Object>();
  
  private final Context zzb;
  
  private final zzi zzc;
  
  private final String zzd;
  
  private final List zze = new ArrayList();
  
  @GuardedBy("attachedRemoteTasksLock")
  private final Set zzf = new HashSet();
  
  private final Object zzg = new Object();
  
  private boolean zzh;
  
  private final Intent zzi;
  
  private final WeakReference zzj;
  
  private final IBinder.DeathRecipient zzk = new zzl(this);
  
  @GuardedBy("attachedRemoteTasksLock")
  private final AtomicInteger zzl = new AtomicInteger(0);
  
  @Nullable
  private ServiceConnection zzm;
  
  @Nullable
  private IInterface zzn;
  
  private final zze zzo;
  
  public zzt(Context paramContext, zzi paramzzi, String paramString, Intent paramIntent, zze paramzze, @Nullable zzo paramzzo, byte[] paramArrayOfbyte) {
    this.zzb = paramContext;
    this.zzc = paramzzi;
    this.zzd = "com.google.android.finsky.inappreviewservice.InAppReviewService";
    this.zzi = paramIntent;
    this.zzo = paramzze;
    this.zzj = new WeakReference(null);
  }
  
  private final RemoteException zzs() {
    RemoteException remoteException;
    if (Build.VERSION.SDK_INT < 15) {
      remoteException = new RemoteException();
    } else {
      remoteException = new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    } 
    return remoteException;
  }
  
  private final void zzt() {
    synchronized (this.zzg) {
      Iterator<TaskCompletionSource> iterator = this.zzf.iterator();
      while (iterator.hasNext())
        ((TaskCompletionSource)iterator.next()).trySetException((Exception)zzs()); 
      this.zzf.clear();
      return;
    } 
  }
  
  public final Handler zzc() {
    synchronized (zza) {
      if (!zza.containsKey(this.zzd)) {
        HandlerThread handlerThread = new HandlerThread();
        this(this.zzd, 10);
        handlerThread.start();
        Map<String, Handler> map = zza;
        String str = this.zzd;
        Handler handler = new Handler();
        this(handlerThread.getLooper());
        map.put(str, handler);
      } 
      return (Handler)zza.get(this.zzd);
    } 
  }
  
  @Nullable
  public final IInterface zze() {
    return this.zzn;
  }
  
  public final void zzp(zzj paramzzj, @Nullable TaskCompletionSource paramTaskCompletionSource) {
    synchronized (this.zzg) {
      this.zzf.add(paramTaskCompletionSource);
      Task task = paramTaskCompletionSource.getTask();
      zzk zzk = new zzk();
      this(this, paramTaskCompletionSource);
      task.addOnCompleteListener(zzk);
      synchronized (this.zzg) {
        if (this.zzl.getAndIncrement() > 0)
          this.zzc.zza("Already connected to the service.", new Object[0]); 
        paramzzj = new zzm(this, paramzzj.zzb(), paramzzj);
        zzc().post(paramzzj);
        return;
      } 
    } 
  }
  
  public final void zzr(TaskCompletionSource paramTaskCompletionSource) {
    synchronized (this.zzg) {
      this.zzf.remove(paramTaskCompletionSource);
      synchronized (this.zzg) {
        if (this.zzl.get() > 0 && this.zzl.decrementAndGet() > 0) {
          this.zzc.zzd("Leaving the connection open for other ongoing calls.", new Object[0]);
          return;
        } 
        null = new zzn(this);
        zzc().post((Runnable)null);
        return;
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */