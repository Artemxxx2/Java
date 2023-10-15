package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T> {
  private final String zza;
  
  private Object zzb;
  
  @KeepForSdk
  protected RemoteCreator(@NonNull String paramString) {
    this.zza = paramString;
  }
  
  @NonNull
  @KeepForSdk
  protected abstract T getRemoteCreator(@NonNull IBinder paramIBinder);
  
  @NonNull
  @KeepForSdk
  protected final T getRemoteCreatorInstance(@NonNull Context paramContext) throws RemoteCreatorException {
    if (this.zzb == null) {
      Preconditions.checkNotNull(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext != null) {
        ClassLoader classLoader = paramContext.getClassLoader();
        try {
          this.zzb = getRemoteCreator((IBinder)classLoader.loadClass(this.zza).newInstance());
        } catch (ClassNotFoundException classNotFoundException) {
          throw new RemoteCreatorException("Could not load creator class.", classNotFoundException);
        } catch (InstantiationException instantiationException) {
          throw new RemoteCreatorException("Could not instantiate creator.", instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          throw new RemoteCreatorException("Could not access creator.", illegalAccessException);
        } 
      } else {
        throw new RemoteCreatorException("Could not get remote context.");
      } 
    } 
    return (T)this.zzb;
  }
  
  @KeepForSdk
  public static class RemoteCreatorException extends Exception {
    @KeepForSdk
    public RemoteCreatorException(@NonNull String param1String) {
      super(param1String);
    }
    
    @KeepForSdk
    public RemoteCreatorException(@NonNull String param1String, @NonNull Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamic\RemoteCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */