package androidx.loader.app;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.loader.content.Loader;
import java.io.PrintWriter;

class LoaderObserver<D> implements Observer<D> {
  @NonNull
  private final LoaderManager.LoaderCallbacks<D> mCallback;
  
  private boolean mDeliveredData = false;
  
  @NonNull
  private final Loader<D> mLoader;
  
  LoaderObserver(@NonNull Loader<D> paramLoader, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    this.mLoader = paramLoader;
    this.mCallback = paramLoaderCallbacks;
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mDeliveredData=");
    paramPrintWriter.println(this.mDeliveredData);
  }
  
  boolean hasDeliveredData() {
    return this.mDeliveredData;
  }
  
  public void onChanged(@Nullable D paramD) {
    if (LoaderManagerImpl.DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("  onLoadFinished in ");
      stringBuilder.append(this.mLoader);
      stringBuilder.append(": ");
      stringBuilder.append(this.mLoader.dataToString(paramD));
      Log.v("LoaderManager", stringBuilder.toString());
    } 
    this.mCallback.onLoadFinished(this.mLoader, paramD);
    this.mDeliveredData = true;
  }
  
  @MainThread
  void reset() {
    if (this.mDeliveredData) {
      if (LoaderManagerImpl.DEBUG) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Resetting: ");
        stringBuilder.append(this.mLoader);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.mCallback.onLoaderReset(this.mLoader);
    } 
  }
  
  public String toString() {
    return this.mCallback.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\app\LoaderManagerImpl$LoaderObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */