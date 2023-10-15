package androidx.loader.app;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderViewModel extends ViewModel {
  private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory() {
      @NonNull
      public <T extends ViewModel> T create(@NonNull Class<T> param2Class) {
        return (T)new LoaderManagerImpl.LoaderViewModel();
      }
    };
  
  private boolean mCreatingLoader = false;
  
  private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();
  
  @NonNull
  static LoaderViewModel getInstance(ViewModelStore paramViewModelStore) {
    return (LoaderViewModel)(new ViewModelProvider(paramViewModelStore, FACTORY)).get(LoaderViewModel.class);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    if (this.mLoaders.size() > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("    ");
      String str = stringBuilder.toString();
      for (byte b = 0; b < this.mLoaders.size(); b++) {
        LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(b);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(b));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderInfo.toString());
        loaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
  }
  
  void finishCreatingLoader() {
    this.mCreatingLoader = false;
  }
  
  <D> LoaderManagerImpl.LoaderInfo<D> getLoader(int paramInt) {
    return (LoaderManagerImpl.LoaderInfo<D>)this.mLoaders.get(paramInt);
  }
  
  boolean hasRunningLoaders() {
    int i = this.mLoaders.size();
    for (byte b = 0; b < i; b++) {
      if (((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(b)).isCallbackWaitingForData())
        return true; 
    } 
    return false;
  }
  
  boolean isCreatingLoader() {
    return this.mCreatingLoader;
  }
  
  void markForRedelivery() {
    int i = this.mLoaders.size();
    for (byte b = 0; b < i; b++)
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(b)).markForRedelivery(); 
  }
  
  protected void onCleared() {
    super.onCleared();
    int i = this.mLoaders.size();
    for (byte b = 0; b < i; b++)
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(b)).destroy(true); 
    this.mLoaders.clear();
  }
  
  void putLoader(int paramInt, @NonNull LoaderManagerImpl.LoaderInfo paramLoaderInfo) {
    this.mLoaders.put(paramInt, paramLoaderInfo);
  }
  
  void removeLoader(int paramInt) {
    this.mLoaders.remove(paramInt);
  }
  
  void startCreatingLoader() {
    this.mCreatingLoader = true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\app\LoaderManagerImpl$LoaderViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */