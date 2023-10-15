package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@SuppressLint({"NewApi"})
@KeepForSdk
public final class FragmentWrapper extends IFragmentWrapper.Stub {
  private Fragment zza;
  
  private FragmentWrapper(Fragment paramFragment) {
    this.zza = paramFragment;
  }
  
  @Nullable
  @KeepForSdk
  public static FragmentWrapper wrap(@Nullable Fragment paramFragment) {
    return (paramFragment != null) ? new FragmentWrapper(paramFragment) : null;
  }
  
  public final boolean zzA() {
    return this.zza.isVisible();
  }
  
  public final int zzb() {
    return this.zza.getId();
  }
  
  public final int zzc() {
    return this.zza.getTargetRequestCode();
  }
  
  @Nullable
  public final Bundle zzd() {
    return this.zza.getArguments();
  }
  
  @Nullable
  public final IFragmentWrapper zze() {
    return wrap(this.zza.getParentFragment());
  }
  
  @Nullable
  public final IFragmentWrapper zzf() {
    return wrap(this.zza.getTargetFragment());
  }
  
  @NonNull
  public final IObjectWrapper zzg() {
    return ObjectWrapper.wrap(this.zza.getActivity());
  }
  
  @NonNull
  public final IObjectWrapper zzh() {
    return ObjectWrapper.wrap(this.zza.getResources());
  }
  
  @NonNull
  public final IObjectWrapper zzi() {
    return ObjectWrapper.wrap(this.zza.getView());
  }
  
  @Nullable
  public final String zzj() {
    return this.zza.getTag();
  }
  
  public final void zzk(@NonNull IObjectWrapper paramIObjectWrapper) {
    View view = ObjectWrapper.<View>unwrap(paramIObjectWrapper);
    Fragment fragment = this.zza;
    Preconditions.checkNotNull(view);
    fragment.registerForContextMenu(view);
  }
  
  public final void zzl(boolean paramBoolean) {
    this.zza.setHasOptionsMenu(paramBoolean);
  }
  
  public final void zzm(boolean paramBoolean) {
    this.zza.setMenuVisibility(paramBoolean);
  }
  
  public final void zzn(boolean paramBoolean) {
    this.zza.setRetainInstance(paramBoolean);
  }
  
  public final void zzo(boolean paramBoolean) {
    this.zza.setUserVisibleHint(paramBoolean);
  }
  
  public final void zzp(@NonNull Intent paramIntent) {
    this.zza.startActivity(paramIntent);
  }
  
  public final void zzq(@NonNull Intent paramIntent, int paramInt) {
    this.zza.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void zzr(@NonNull IObjectWrapper paramIObjectWrapper) {
    View view = ObjectWrapper.<View>unwrap(paramIObjectWrapper);
    Fragment fragment = this.zza;
    Preconditions.checkNotNull(view);
    fragment.unregisterForContextMenu(view);
  }
  
  public final boolean zzs() {
    return this.zza.getRetainInstance();
  }
  
  public final boolean zzt() {
    return this.zza.getUserVisibleHint();
  }
  
  public final boolean zzu() {
    return this.zza.isAdded();
  }
  
  public final boolean zzv() {
    return this.zza.isDetached();
  }
  
  public final boolean zzw() {
    return this.zza.isHidden();
  }
  
  public final boolean zzx() {
    return this.zza.isInLayout();
  }
  
  public final boolean zzy() {
    return this.zza.isRemoving();
  }
  
  public final boolean zzz() {
    return this.zza.isResumed();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamic\FragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */