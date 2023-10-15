package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzd extends Fragment implements LifecycleFragment {
  private static final WeakHashMap zza = new WeakHashMap<Object, Object>();
  
  private final Map zzb = Collections.synchronizedMap((Map<?, ?>)new ArrayMap());
  
  private int zzc = 0;
  
  @Nullable
  private Bundle zzd;
  
  public static zzd zzc(FragmentActivity paramFragmentActivity) {
    WeakReference<zzd> weakReference = (WeakReference)zza.get(paramFragmentActivity);
    if (weakReference != null) {
      zzd zzd1 = weakReference.get();
      if (zzd1 != null)
        return zzd1; 
    } 
    try {
      zzd zzd2 = (zzd)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
      if (zzd2 != null) {
        zzd zzd3 = zzd2;
        if (zzd2.isRemoving()) {
          zzd3 = new zzd();
          paramFragmentActivity.getSupportFragmentManager().beginTransaction().add(zzd3, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
          zza.put(paramFragmentActivity, new WeakReference<zzd>(zzd3));
          return zzd3;
        } 
        zza.put(paramFragmentActivity, new WeakReference<zzd>(zzd3));
        return zzd3;
      } 
      zzd zzd1 = new zzd();
      paramFragmentActivity.getSupportFragmentManager().beginTransaction().add(zzd1, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      zza.put(paramFragmentActivity, new WeakReference<zzd>(zzd1));
      return zzd1;
    } catch (ClassCastException classCastException) {
      throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", classCastException);
    } 
  }
  
  public final void addCallback(String paramString, @NonNull LifecycleCallback paramLifecycleCallback) {
    if (!this.zzb.containsKey(paramString)) {
      this.zzb.put(paramString, paramLifecycleCallback);
      if (this.zzc > 0) {
        (new zzi(Looper.getMainLooper())).post(new zzc(this, paramLifecycleCallback, paramString));
        return;
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LifecycleCallback with tag ");
    stringBuilder.append(paramString);
    stringBuilder.append(" already added to this fragment.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void dump(String paramString, @Nullable FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
  }
  
  @Nullable
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass) {
    return paramClass.cast(this.zzb.get(paramString));
  }
  
  public final boolean isCreated() {
    return (this.zzc > 0);
  }
  
  public final boolean isStarted() {
    return (this.zzc >= 2);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public final void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.zzc = 1;
    this.zzd = paramBundle;
    for (Map.Entry entry : this.zzb.entrySet()) {
      LifecycleCallback lifecycleCallback = (LifecycleCallback)entry.getValue();
      if (paramBundle != null) {
        Bundle bundle = paramBundle.getBundle((String)entry.getKey());
      } else {
        entry = null;
      } 
      lifecycleCallback.onCreate((Bundle)entry);
    } 
  }
  
  public final void onDestroy() {
    super.onDestroy();
    this.zzc = 5;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onDestroy(); 
  }
  
  public final void onResume() {
    super.onResume();
    this.zzc = 3;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onResume(); 
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null)
      return; 
    for (Map.Entry entry : this.zzb.entrySet()) {
      Bundle bundle = new Bundle();
      ((LifecycleCallback)entry.getValue()).onSaveInstanceState(bundle);
      paramBundle.putBundle((String)entry.getKey(), bundle);
    } 
  }
  
  public final void onStart() {
    super.onStart();
    this.zzc = 2;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onStart(); 
  }
  
  public final void onStop() {
    super.onStop();
    this.zzc = 4;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onStop(); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */