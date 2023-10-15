package androidx.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
  int mEnd;
  
  boolean mEntryValid = false;
  
  int mIndex;
  
  MapIterator() {
    this.mEnd = paramMapCollections.colGetSize() - 1;
    this.mIndex = -1;
  }
  
  public boolean equals(Object paramObject) {
    if (this.mEntryValid) {
      boolean bool = paramObject instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      paramObject = paramObject;
      bool = bool1;
      if (ContainerHelpers.equal(paramObject.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0))) {
        bool = bool1;
        if (ContainerHelpers.equal(paramObject.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1)))
          bool = true; 
      } 
      return bool;
    } 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public K getKey() {
    if (this.mEntryValid)
      return (K)MapCollections.this.colGetEntry(this.mIndex, 0); 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public V getValue() {
    if (this.mEntryValid)
      return (V)MapCollections.this.colGetEntry(this.mIndex, 1); 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public boolean hasNext() {
    boolean bool;
    if (this.mIndex < this.mEnd) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    if (this.mEntryValid) {
      MapCollections mapCollections = MapCollections.this;
      int i = this.mIndex;
      int j = 0;
      Object object2 = mapCollections.colGetEntry(i, 0);
      Object object1 = MapCollections.this.colGetEntry(this.mIndex, 1);
      if (object2 == null) {
        i = 0;
      } else {
        i = object2.hashCode();
      } 
      if (object1 != null)
        j = object1.hashCode(); 
      return i ^ j;
    } 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public Map.Entry<K, V> next() {
    if (hasNext()) {
      this.mIndex++;
      this.mEntryValid = true;
      return this;
    } 
    throw new NoSuchElementException();
  }
  
  public void remove() {
    if (this.mEntryValid) {
      MapCollections.this.colRemoveAt(this.mIndex);
      this.mIndex--;
      this.mEnd--;
      this.mEntryValid = false;
      return;
    } 
    throw new IllegalStateException();
  }
  
  public V setValue(V paramV) {
    if (this.mEntryValid)
      return (V)MapCollections.this.colSetValue(this.mIndex, paramV); 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getKey());
    stringBuilder.append("=");
    stringBuilder.append(getValue());
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\collection\MapCollections$MapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */