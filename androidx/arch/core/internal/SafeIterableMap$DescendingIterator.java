package androidx.arch.core.internal;

class DescendingIterator<K, V> extends SafeIterableMap.ListIterator<K, V> {
  DescendingIterator(SafeIterableMap.Entry<K, V> paramEntry1, SafeIterableMap.Entry<K, V> paramEntry2) {
    super(paramEntry1, paramEntry2);
  }
  
  SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> paramEntry) {
    return paramEntry.mNext;
  }
  
  SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> paramEntry) {
    return paramEntry.mPrevious;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\internal\SafeIterableMap$DescendingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */