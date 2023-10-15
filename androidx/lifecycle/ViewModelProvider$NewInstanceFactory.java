package androidx.lifecycle;

import androidx.annotation.NonNull;

public class NewInstanceFactory implements ViewModelProvider.Factory {
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass) {
    try {
      return paramClass.newInstance();
    } catch (InstantiationException instantiationException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot create an instance of ");
      stringBuilder.append(paramClass);
      throw new RuntimeException(stringBuilder.toString(), instantiationException);
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot create an instance of ");
      stringBuilder.append(paramClass);
      throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ViewModelProvider$NewInstanceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */