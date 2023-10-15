package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
  @Nullable
  private final Bundle mArgs;
  
  private final int mId;
  
  private LifecycleOwner mLifecycleOwner;
  
  @NonNull
  private final Loader<D> mLoader;
  
  private LoaderManagerImpl.LoaderObserver<D> mObserver;
  
  private Loader<D> mPriorLoader;
  
  LoaderInfo(int paramInt, @Nullable Bundle paramBundle, @NonNull Loader<D> paramLoader1, @Nullable Loader<D> paramLoader2) {
    this.mId = paramInt;
    this.mArgs = paramBundle;
    this.mLoader = paramLoader1;
    this.mPriorLoader = paramLoader2;
    this.mLoader.registerListener(paramInt, this);
  }
  
  @MainThread
  Loader<D> destroy(boolean paramBoolean) {
    if (LoaderManagerImpl.DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("  Destroying: ");
      stringBuilder.append(this);
      Log.v("LoaderManager", stringBuilder.toString());
    } 
    this.mLoader.cancelLoad();
    this.mLoader.abandon();
    LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
    if (loaderObserver != null) {
      removeObserver(loaderObserver);
      if (paramBoolean)
        loaderObserver.reset(); 
    } 
    this.mLoader.unregisterListener(this);
    if ((loaderObserver != null && !loaderObserver.hasDeliveredData()) || paramBoolean) {
      this.mLoader.reset();
      return this.mPriorLoader;
    } 
    return this.mLoader;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(this.mArgs);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(this.mLoader);
    Loader<D> loader = this.mLoader;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("  ");
    loader.dump(stringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.mObserver != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.mObserver);
      LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("  ");
      loaderObserver.dump(stringBuilder1.toString(), paramPrintWriter);
    } 
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mData=");
    paramPrintWriter.println(getLoader().dataToString(getValue()));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.println(hasActiveObservers());
  }
  
  @NonNull
  Loader<D> getLoader() {
    return this.mLoader;
  }
  
  boolean isCallbackWaitingForData() {
    boolean bool = hasActiveObservers();
    boolean bool1 = false;
    if (!bool)
      return false; 
    LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
    bool = bool1;
    if (loaderObserver != null) {
      bool = bool1;
      if (!loaderObserver.hasDeliveredData())
        bool = true; 
    } 
    return bool;
  }
  
  void markForRedelivery() {
    LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
    LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
    if (lifecycleOwner != null && loaderObserver != null) {
      super.removeObserver(loaderObserver);
      observe(lifecycleOwner, loaderObserver);
    } 
  }
  
  protected void onActive() {
    if (LoaderManagerImpl.DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("  Starting: ");
      stringBuilder.append(this);
      Log.v("LoaderManager", stringBuilder.toString());
    } 
    this.mLoader.startLoading();
  }
  
  protected void onInactive() {
    if (LoaderManagerImpl.DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("  Stopping: ");
      stringBuilder.append(this);
      Log.v("LoaderManager", stringBuilder.toString());
    } 
    this.mLoader.stopLoading();
  }
  
  public void onLoadComplete(@NonNull Loader<D> paramLoader, @Nullable D paramD) {
    if (LoaderManagerImpl.DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onLoadComplete: ");
      stringBuilder.append(this);
      Log.v("LoaderManager", stringBuilder.toString());
    } 
    if (Looper.myLooper() == Looper.getMainLooper()) {
      setValue(paramD);
    } else {
      if (LoaderManagerImpl.DEBUG)
        Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread"); 
      postValue(paramD);
    } 
  }
  
  public void removeObserver(@NonNull Observer<? super D> paramObserver) {
    super.removeObserver(paramObserver);
    this.mLifecycleOwner = null;
    this.mObserver = null;
  }
  
  @MainThread
  @NonNull
  Loader<D> setCallback(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    LoaderManagerImpl.LoaderObserver<D> loaderObserver2 = new LoaderManagerImpl.LoaderObserver<D>(this.mLoader, paramLoaderCallbacks);
    observe(paramLifecycleOwner, loaderObserver2);
    LoaderManagerImpl.LoaderObserver<D> loaderObserver1 = this.mObserver;
    if (loaderObserver1 != null)
      removeObserver(loaderObserver1); 
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mObserver = loaderObserver2;
    return this.mLoader;
  }
  
  public void setValue(D paramD) {
    super.setValue(paramD);
    Loader<D> loader = this.mPriorLoader;
    if (loader != null) {
      loader.reset();
      this.mPriorLoader = null;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(64);
    stringBuilder.append("LoaderInfo{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" #");
    stringBuilder.append(this.mId);
    stringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\app\LoaderManagerImpl$LoaderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */