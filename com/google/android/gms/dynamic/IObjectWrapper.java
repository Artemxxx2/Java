package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;

public interface IObjectWrapper extends IInterface {
  public static abstract class Stub extends zzb implements IObjectWrapper {
    public Stub() {
      super("com.google.android.gms.dynamic.IObjectWrapper");
    }
    
    @NonNull
    public static IObjectWrapper asInterface(@NonNull IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
      return (iInterface instanceof IObjectWrapper) ? (IObjectWrapper)iInterface : new zzb(param1IBinder);
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamic\IObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */