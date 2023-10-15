package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzw<TResult> extends Task<TResult> {
  private final Object zza = new Object();
  
  private final zzr zzb = new zzr();
  
  @GuardedBy("mLock")
  private boolean zzc;
  
  private volatile boolean zzd;
  
  @Nullable
  @GuardedBy("mLock")
  private Object zze;
  
  @GuardedBy("mLock")
  private Exception zzf;
  
  @GuardedBy("mLock")
  private final void zzf() {
    Preconditions.checkState(this.zzc, "Task is not yet complete");
  }
  
  @GuardedBy("mLock")
  private final void zzg() {
    if (!this.zzd)
      return; 
    throw new CancellationException("Task is already canceled.");
  }
  
  @GuardedBy("mLock")
  private final void zzh() {
    if (!this.zzc)
      return; 
    throw DuplicateTaskCompletionException.of(this);
  }
  
  private final void zzi() {
    synchronized (this.zza) {
      if (!this.zzc)
        return; 
      this.zzb.zzb(this);
      return;
    } 
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull Activity paramActivity, @NonNull OnCanceledListener paramOnCanceledListener) {
    zzh zzh = new zzh(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzb.zza(zzh);
    zzv.zza(paramActivity).zzb(zzh);
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener paramOnCanceledListener) {
    super.addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCanceledListener(@NonNull Executor paramExecutor, @NonNull OnCanceledListener paramOnCanceledListener) {
    this.zzb.zza(new zzh(paramExecutor, paramOnCanceledListener));
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull Activity paramActivity, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    zzj zzj = new zzj(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzb.zza(zzj);
    zzv.zza(paramActivity).zzb(zzj);
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    Executor executor = TaskExecutors.MAIN_THREAD;
    this.zzb.zza(new zzj(executor, paramOnCompleteListener));
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnCompleteListener(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    this.zzb.zza(new zzj(paramExecutor, paramOnCompleteListener));
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull Activity paramActivity, @NonNull OnFailureListener paramOnFailureListener) {
    zzl zzl = new zzl(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzb.zza(zzl);
    zzv.zza(paramActivity).zzb(zzl);
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener paramOnFailureListener) {
    addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnFailureListener(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener) {
    this.zzb.zza(new zzl(paramExecutor, paramOnFailureListener));
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull Activity paramActivity, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    zzn zzn = new zzn(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzb.zza(zzn);
    zzv.zza(paramActivity).zzb(zzn);
    zzi();
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    return this;
  }
  
  @NonNull
  public final Task<TResult> addOnSuccessListener(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener) {
    this.zzb.zza(new zzn(paramExecutor, paramOnSuccessListener));
    zzi();
    return this;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> paramContinuation) {
    return super.continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation) {
    zzw<TContinuationResult> zzw1 = new zzw();
    this.zzb.zza(new zzd(paramExecutor, paramContinuation, zzw1));
    zzi();
    return zzw1;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    return super.continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    zzw<TContinuationResult> zzw1 = new zzw();
    this.zzb.zza(new zzf<Object, Object>(paramExecutor, paramContinuation, zzw1));
    zzi();
    return zzw1;
  }
  
  @Nullable
  public final Exception getException() {
    synchronized (this.zza) {
      return this.zzf;
    } 
  }
  
  public final TResult getResult() {
    synchronized (this.zza) {
      zzf();
      zzg();
      Exception exception = this.zzf;
      if (exception == null)
        return (TResult)this.zze; 
      RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException();
      this(exception);
      throw runtimeExecutionException;
    } 
  }
  
  public final <X extends Throwable> TResult getResult(@NonNull Class<X> paramClass) throws X {
    synchronized (this.zza) {
      RuntimeExecutionException runtimeExecutionException;
      zzf();
      zzg();
      if (!paramClass.isInstance(this.zzf)) {
        Exception exception = this.zzf;
        if (exception == null)
          return (TResult)this.zze; 
        runtimeExecutionException = new RuntimeExecutionException();
        this(exception);
        throw (X)runtimeExecutionException;
      } 
      throw (X)runtimeExecutionException.cast(this.zzf);
    } 
  }
  
  public final boolean isCanceled() {
    return this.zzd;
  }
  
  public final boolean isComplete() {
    synchronized (this.zza) {
      return this.zzc;
    } 
  }
  
  public final boolean isSuccessful() {
    synchronized (this.zza) {
      boolean bool = this.zzc;
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool) {
        bool2 = bool1;
        if (!this.zzd) {
          bool2 = bool1;
          if (this.zzf == null)
            bool2 = true; 
        } 
      } 
      return bool2;
    } 
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    Executor executor = TaskExecutors.MAIN_THREAD;
    zzw<TContinuationResult> zzw1 = new zzw();
    this.zzb.zza(new zzp<Object, Object>(executor, paramSuccessContinuation, zzw1));
    zzi();
    return zzw1;
  }
  
  @NonNull
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    zzw<TContinuationResult> zzw1 = new zzw();
    this.zzb.zza(new zzp<Object, Object>(paramExecutor, paramSuccessContinuation, zzw1));
    zzi();
    return zzw1;
  }
  
  public final void zza(@NonNull Exception paramException) {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.zza) {
      zzh();
      this.zzc = true;
      this.zzf = paramException;
      this.zzb.zzb(this);
      return;
    } 
  }
  
  public final void zzb(@Nullable Object paramObject) {
    synchronized (this.zza) {
      zzh();
      this.zzc = true;
      this.zze = paramObject;
      this.zzb.zzb(this);
      return;
    } 
  }
  
  public final boolean zzc() {
    synchronized (this.zza) {
      if (this.zzc)
        return false; 
      this.zzc = true;
      this.zzd = true;
      this.zzb.zzb(this);
      return true;
    } 
  }
  
  public final boolean zzd(@NonNull Exception paramException) {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.zza) {
      if (this.zzc)
        return false; 
      this.zzc = true;
      this.zzf = paramException;
      this.zzb.zzb(this);
      return true;
    } 
  }
  
  public final boolean zze(@Nullable Object paramObject) {
    synchronized (this.zza) {
      if (this.zzc)
        return false; 
      this.zzc = true;
      this.zze = paramObject;
      this.zzb.zzb(this);
      return true;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */