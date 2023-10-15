package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ArrayIterator<T> implements Iterator<T> {
  boolean mCanRemove = false;
  
  int mIndex;
  
  final int mOffset;
  
  int mSize;
  
  ArrayIterator(int paramInt) {
    this.mOffset = paramInt;
    this.mSize = paramMapCollections.colGetSize();
  }
  
  public boolean hasNext() {
    boolean bool;
    if (this.mIndex < this.mSize) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public T next() {
    if (hasNext()) {
      Object object = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
      this.mIndex++;
      this.mCanRemove = true;
      return (T)object;
    } 
    throw new NoSuchElementException();
  }
  
  public void remove() {
    if (this.mCanRemove) {
      this.mIndex--;
      this.mSize--;
      this.mCanRemove = false;
      MapCollections.this.colRemoveAt(this.mIndex);
      return;
    } 
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\collection\MapCollections$ArrayIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */