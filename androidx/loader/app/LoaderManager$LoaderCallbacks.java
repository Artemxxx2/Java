package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;

public interface LoaderCallbacks<D> {
  @MainThread
  @NonNull
  Loader<D> onCreateLoader(int paramInt, @Nullable Bundle paramBundle);
  
  @MainThread
  void onLoadFinished(@NonNull Loader<D> paramLoader, D paramD);
  
  @MainThread
  void onLoaderReset(@NonNull Loader<D> paramLoader);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\app\LoaderManager$LoaderCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */