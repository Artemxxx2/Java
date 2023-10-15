package androidx.loader.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

final class null implements ViewModelProvider.Factory {
  @NonNull
  public <T extends androidx.lifecycle.ViewModel> T create(@NonNull Class<T> paramClass) {
    return (T)new LoaderManagerImpl.LoaderViewModel();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\app\LoaderManagerImpl$LoaderViewModel$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */