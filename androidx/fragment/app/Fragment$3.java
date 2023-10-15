package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

class null implements LifecycleOwner {
  public Lifecycle getLifecycle() {
    if (Fragment.this.mViewLifecycleRegistry == null) {
      Fragment fragment = Fragment.this;
      fragment.mViewLifecycleRegistry = new LifecycleRegistry(fragment.mViewLifecycleOwner);
    } 
    return (Lifecycle)Fragment.this.mViewLifecycleRegistry;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\Fragment$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */