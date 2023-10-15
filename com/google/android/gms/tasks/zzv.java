package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzv extends LifecycleCallback {
  private final List zza = new ArrayList();
  
  private zzv(LifecycleFragment paramLifecycleFragment) {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
  }
  
  public static zzv zza(Activity paramActivity) {
    LifecycleFragment lifecycleFragment = getFragment(paramActivity);
    zzv zzv2 = (zzv)lifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zzv.class);
    zzv zzv1 = zzv2;
    if (zzv2 == null)
      zzv1 = new zzv(lifecycleFragment); 
    return zzv1;
  }
  
  @MainThread
  public final void onStop() {
    synchronized (this.zza) {
      Iterator<WeakReference<zzq>> iterator = this.zza.iterator();
      while (iterator.hasNext()) {
        zzq zzq = ((WeakReference<zzq>)iterator.next()).get();
        if (zzq != null)
          zzq.zzc(); 
      } 
      this.zza.clear();
      return;
    } 
  }
  
  public final void zzb(zzq paramzzq) {
    synchronized (this.zza) {
      List<WeakReference> list = this.zza;
      WeakReference weakReference = new WeakReference();
      this((T)paramzzq);
      list.add(weakReference);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */