package androidx.fragment.app;

final class FragmentLifecycleCallbacksHolder {
  final FragmentManager.FragmentLifecycleCallbacks mCallback;
  
  final boolean mRecursive;
  
  FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean) {
    this.mCallback = paramFragmentLifecycleCallbacks;
    this.mRecursive = paramBoolean;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$FragmentLifecycleCallbacksHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */