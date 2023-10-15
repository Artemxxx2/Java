package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SafeIterableMap.SupportRemove<K, V> {
  private boolean mBeforeStart = true;
  
  private SafeIterableMap.Entry<K, V> mCurrent;
  
  public boolean hasNext() {
    boolean bool = this.mBeforeStart;
    boolean bool1 = true;
    boolean bool2 = true;
    if (bool) {
      if (SafeIterableMap.this.mStart == null)
        bool2 = false; 
      return bool2;
    } 
    SafeIterableMap.Entry<K, V> entry = this.mCurrent;
    if (entry != null && entry.mNext != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    return bool2;
  }
  
  public Map.Entry<K, V> next() {
    if (this.mBeforeStart) {
      this.mBeforeStart = false;
      this.mCurrent = SafeIterableMap.this.mStart;
    } else {
      SafeIterableMap.Entry<K, V> entry = this.mCurrent;
      if (entry != null) {
        entry = entry.mNext;
      } else {
        entry = null;
      } 
      this.mCurrent = entry;
    } 
    return this.mCurrent;
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry<K, V> paramEntry) {
    SafeIterableMap.Entry<K, V> entry = this.mCurrent;
    if (paramEntry == entry) {
      boolean bool;
      this.mCurrent = entry.mPrevious;
      if (this.mCurrent == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.mBeforeStart = bool;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\internal\SafeIterableMap$IteratorWithAdditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */