package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
public class BlockingServiceConnection implements ServiceConnection {
  boolean zza = false;
  
  private final BlockingQueue zzb = new LinkedBlockingQueue();
  
  @NonNull
  @KeepForSdk
  public IBinder getService() throws InterruptedException {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
    if (!this.zza) {
      this.zza = true;
      return this.zzb.take();
    } 
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  @NonNull
  @KeepForSdk
  public IBinder getServiceWithTimeout(long paramLong, @NonNull TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (!this.zza) {
      this.zza = true;
      IBinder iBinder = this.zzb.poll(paramLong, paramTimeUnit);
      if (iBinder != null)
        return iBinder; 
      throw new TimeoutException("Timed out waiting for the service connection");
    } 
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public final void onServiceConnected(@NonNull ComponentName paramComponentName, @NonNull IBinder paramIBinder) {
    this.zzb.add(paramIBinder);
  }
  
  public final void onServiceDisconnected(@NonNull ComponentName paramComponentName) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\BlockingServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */