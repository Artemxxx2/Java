package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SafeIterableMap.SupportRemove<K, V> {
  SafeIterableMap.Entry<K, V> mExpectedEnd;
  
  SafeIterableMap.Entry<K, V> mNext;
  
  ListIterator(SafeIterableMap.Entry<K, V> paramEntry1, SafeIterableMap.Entry<K, V> paramEntry2) {
    this.mExpectedEnd = paramEntry2;
    this.mNext = paramEntry1;
  }
  
  private SafeIterableMap.Entry<K, V> nextNode() {
    SafeIterableMap.Entry<K, V> entry1 = this.mNext;
    SafeIterableMap.Entry<K, V> entry2 = this.mExpectedEnd;
    return (entry1 == entry2 || entry2 == null) ? null : forward(entry1);
  }
  
  abstract SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> paramEntry);
  
  abstract SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> paramEntry);
  
  public boolean hasNext() {
    boolean bool;
    if (this.mNext != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Map.Entry<K, V> next() {
    SafeIterableMap.Entry<K, V> entry = this.mNext;
    this.mNext = nextNode();
    return entry;
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry<K, V> paramEntry) {
    if (this.mExpectedEnd == paramEntry && paramEntry == this.mNext) {
      this.mNext = null;
      this.mExpectedEnd = null;
    } 
    SafeIterableMap.Entry<K, V> entry = this.mExpectedEnd;
    if (entry == paramEntry)
      this.mExpectedEnd = backward(entry); 
    if (this.mNext == paramEntry)
      this.mNext = nextNode(); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\internal\SafeIterableMap$ListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */