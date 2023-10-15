package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(api = 28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CoreComponentFactory extends AppComponentFactory {
  static <T> T checkCompatWrapper(T paramT) {
    if (paramT instanceof CompatWrapped) {
      Object object = ((CompatWrapped)paramT).getWrapper();
      if (object != null)
        return (T)object; 
    } 
    return paramT;
  }
  
  @NonNull
  public Activity instantiateActivity(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return checkCompatWrapper(super.instantiateActivity(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Application instantiateApplication(@NonNull ClassLoader paramClassLoader, @NonNull String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return checkCompatWrapper(super.instantiateApplication(paramClassLoader, paramString));
  }
  
  @NonNull
  public ContentProvider instantiateProvider(@NonNull ClassLoader paramClassLoader, @NonNull String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return checkCompatWrapper(super.instantiateProvider(paramClassLoader, paramString));
  }
  
  @NonNull
  public BroadcastReceiver instantiateReceiver(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return checkCompatWrapper(super.instantiateReceiver(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Service instantiateService(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return checkCompatWrapper(super.instantiateService(paramClassLoader, paramString, paramIntent));
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static interface CompatWrapped {
    Object getWrapper();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\CoreComponentFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */