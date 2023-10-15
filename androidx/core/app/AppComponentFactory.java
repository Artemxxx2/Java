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
import java.lang.reflect.InvocationTargetException;

@RequiresApi(28)
public class AppComponentFactory extends AppComponentFactory {
  @NonNull
  public final Activity instantiateActivity(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return CoreComponentFactory.<Activity>checkCompatWrapper(instantiateActivityCompat(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Activity instantiateActivityCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    try {
      return Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (InvocationTargetException|NoSuchMethodException invocationTargetException) {
      throw new RuntimeException("Couldn't call constructor", invocationTargetException);
    } 
  }
  
  @NonNull
  public final Application instantiateApplication(@NonNull ClassLoader paramClassLoader, @NonNull String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return CoreComponentFactory.<Application>checkCompatWrapper(instantiateApplicationCompat(paramClassLoader, paramString));
  }
  
  @NonNull
  public Application instantiateApplicationCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    try {
      return Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (InvocationTargetException|NoSuchMethodException invocationTargetException) {
      throw new RuntimeException("Couldn't call constructor", invocationTargetException);
    } 
  }
  
  @NonNull
  public final ContentProvider instantiateProvider(@NonNull ClassLoader paramClassLoader, @NonNull String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return CoreComponentFactory.<ContentProvider>checkCompatWrapper(instantiateProviderCompat(paramClassLoader, paramString));
  }
  
  @NonNull
  public ContentProvider instantiateProviderCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    try {
      return Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (InvocationTargetException|NoSuchMethodException invocationTargetException) {
      throw new RuntimeException("Couldn't call constructor", invocationTargetException);
    } 
  }
  
  @NonNull
  public final BroadcastReceiver instantiateReceiver(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return CoreComponentFactory.<BroadcastReceiver>checkCompatWrapper(instantiateReceiverCompat(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public BroadcastReceiver instantiateReceiverCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    try {
      return Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (InvocationTargetException|NoSuchMethodException invocationTargetException) {
      throw new RuntimeException("Couldn't call constructor", invocationTargetException);
    } 
  }
  
  @NonNull
  public final Service instantiateService(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return CoreComponentFactory.<Service>checkCompatWrapper(instantiateServiceCompat(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Service instantiateServiceCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    try {
      return Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (InvocationTargetException|NoSuchMethodException invocationTargetException) {
      throw new RuntimeException("Couldn't call constructor", invocationTargetException);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\AppComponentFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */