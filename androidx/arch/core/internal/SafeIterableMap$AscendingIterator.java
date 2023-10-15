package androidx.arch.core.internal;

class AscendingIterator<K, V> extends SafeIterableMap.ListIterator<K, V> {
  AscendingIterator(SafeIterableMap.Entry<K, V> paramEntry1, SafeIterableMap.Entry<K, V> paramEntry2) {
    super(paramEntry1, paramEntry2);
  }
  
  SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> paramEntry) {
    return paramEntry.mPrevious;
  }
  
  SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> paramEntry) {
    return paramEntry.mNext;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\internal\SafeIterableMap$AscendingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */