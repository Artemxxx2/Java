package androidx.lifecycle;

import androidx.annotation.NonNull;

public interface Factory {
  @NonNull
  <T extends ViewModel> T create(@NonNull Class<T> paramClass);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ViewModelProvider$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */