package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

public class AndroidViewModelFactory extends ViewModelProvider.NewInstanceFactory {
  private static AndroidViewModelFactory sInstance;
  
  private Application mApplication;
  
  public AndroidViewModelFactory(@NonNull Application paramApplication) {
    this.mApplication = paramApplication;
  }
  
  @NonNull
  public static AndroidViewModelFactory getInstance(@NonNull Application paramApplication) {
    if (sInstance == null)
      sInstance = new AndroidViewModelFactory(paramApplication); 
    return sInstance;
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass) {
    if (AndroidViewModel.class.isAssignableFrom(paramClass))
      try {
        return (T)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.mApplication });
      } catch (NoSuchMethodException noSuchMethodException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create an instance of ");
        stringBuilder.append(paramClass);
        throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create an instance of ");
        stringBuilder.append(paramClass);
        throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
      } catch (InstantiationException instantiationException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create an instance of ");
        stringBuilder.append(paramClass);
        throw new RuntimeException(stringBuilder.toString(), instantiationException);
      } catch (InvocationTargetException invocationTargetException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create an instance of ");
        stringBuilder.append(paramClass);
        throw new RuntimeException(stringBuilder.toString(), invocationTargetException);
      }  
    return super.create(paramClass);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ViewModelProvider$AndroidViewModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */