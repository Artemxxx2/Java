package com.google.android.gms.tasks;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask) throws ExecutionException, InterruptedException {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete())
      return (TResult)zza(paramTask); 
    zzad zzad = new zzad(null);
    zzb(paramTask, zzad);
    zzad.zza();
    return (TResult)zza(paramTask);
  }
  
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask, long paramLong, @NonNull TimeUnit paramTimeUnit) throws ExecutionException, InterruptedException, TimeoutException {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
      return (TResult)zza(paramTask); 
    zzad zzad = new zzad(null);
    zzb(paramTask, zzad);
    if (zzad.zzb(paramLong, paramTimeUnit))
      return (TResult)zza(paramTask); 
    throw new TimeoutException("Timed out waiting for Task");
  }
  
  @Deprecated
  @NonNull
  public static <TResult> Task<TResult> call(@NonNull Callable<TResult> paramCallable) {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  @Deprecated
  @NonNull
  public static <TResult> Task<TResult> call(@NonNull Executor paramExecutor, @NonNull Callable<TResult> paramCallable) {
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    zzw<TResult> zzw = new zzw();
    paramExecutor.execute(new zzz(zzw, paramCallable));
    return zzw;
  }
  
  @NonNull
  public static <TResult> Task<TResult> forCanceled() {
    zzw<TResult> zzw = new zzw();
    zzw.zzc();
    return zzw;
  }
  
  @NonNull
  public static <TResult> Task<TResult> forException(@NonNull Exception paramException) {
    zzw<TResult> zzw = new zzw();
    zzw.zza(paramException);
    return zzw;
  }
  
  @NonNull
  public static <TResult> Task<TResult> forResult(TResult paramTResult) {
    zzw<TResult> zzw = new zzw();
    zzw.zzb(paramTResult);
    return zzw;
  }
  
  @NonNull
  public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> paramCollection) {
    if (paramCollection == null || paramCollection.isEmpty())
      return forResult(null); 
    Iterator<? extends Task<?>> iterator2 = paramCollection.iterator();
    while (iterator2.hasNext()) {
      if ((Task)iterator2.next() != null)
        continue; 
      throw new NullPointerException("null tasks are not accepted");
    } 
    zzw<Void> zzw = new zzw();
    zzaf zzaf = new zzaf(paramCollection.size(), zzw);
    Iterator<? extends Task<?>> iterator1 = paramCollection.iterator();
    while (iterator1.hasNext())
      zzb(iterator1.next(), zzaf); 
    return zzw;
  }
  
  @NonNull
  public static Task<Void> whenAll(@Nullable Task<?>... paramVarArgs) {
    return (paramVarArgs == null || paramVarArgs.length == 0) ? forResult(null) : whenAll(Arrays.asList(paramVarArgs));
  }
  
  @NonNull
  public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> paramCollection) {
    if (paramCollection == null || paramCollection.isEmpty())
      return forResult(Collections.emptyList()); 
    Task<Void> task = whenAll(paramCollection);
    zzab zzab = new zzab(paramCollection);
    return task.continueWithTask(TaskExecutors.MAIN_THREAD, zzab);
  }
  
  @NonNull
  public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... paramVarArgs) {
    return (paramVarArgs == null || paramVarArgs.length == 0) ? forResult(Collections.emptyList()) : whenAllComplete(Arrays.asList(paramVarArgs));
  }
  
  @NonNull
  public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task> paramCollection) {
    if (paramCollection == null || paramCollection.isEmpty())
      return forResult(Collections.emptyList()); 
    Task<Void> task = whenAll((Collection)paramCollection);
    zzaa zzaa = new zzaa(paramCollection);
    return task.continueWith(TaskExecutors.MAIN_THREAD, zzaa);
  }
  
  @NonNull
  public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task... paramVarArgs) {
    return (paramVarArgs == null || paramVarArgs.length == 0) ? forResult(Collections.emptyList()) : whenAllSuccess(Arrays.asList(paramVarArgs));
  }
  
  @NonNull
  public static <T> Task<T> withTimeout(@NonNull Task<T> paramTask, long paramLong, @NonNull TimeUnit paramTimeUnit) {
    boolean bool;
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Timeout must be positive");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    zzb zzb = new zzb();
    TaskCompletionSource<T> taskCompletionSource = new TaskCompletionSource(zzb);
    zza zza = new zza(Looper.getMainLooper());
    zza.postDelayed(new zzx(taskCompletionSource), paramTimeUnit.toMillis(paramLong));
    paramTask.addOnCompleteListener(new zzy(zza, taskCompletionSource, zzb));
    return taskCompletionSource.getTask();
  }
  
  private static Object zza(@NonNull Task paramTask) throws ExecutionException {
    if (paramTask.isSuccessful())
      return paramTask.getResult(); 
    if (paramTask.isCanceled())
      throw new CancellationException("Task is already canceled"); 
    throw new ExecutionException(paramTask.getException());
  }
  
  private static void zzb(Task paramTask, zzae paramzzae) {
    paramTask.addOnSuccessListener(TaskExecutors.zza, paramzzae);
    paramTask.addOnFailureListener(TaskExecutors.zza, paramzzae);
    paramTask.addOnCanceledListener(TaskExecutors.zza, paramzzae);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\Tasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */