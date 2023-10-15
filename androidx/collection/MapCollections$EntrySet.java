package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class EntrySet implements Set<Map.Entry<K, V>> {
  public boolean add(Map.Entry<K, V> paramEntry) {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection) {
    boolean bool;
    int i = MapCollections.this.colGetSize();
    for (Map.Entry<K, V> entry : paramCollection)
      MapCollections.this.colPut(entry.getKey(), entry.getValue()); 
    if (i != MapCollections.this.colGetSize()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void clear() {
    MapCollections.this.colClear();
  }
  
  public boolean contains(Object paramObject) {
    if (!(paramObject instanceof Map.Entry))
      return false; 
    paramObject = paramObject;
    int i = MapCollections.this.colIndexOfKey(paramObject.getKey());
    return (i < 0) ? false : ContainerHelpers.equal(MapCollections.this.colGetEntry(i, 1), paramObject.getValue());
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public boolean equals(Object paramObject) {
    return MapCollections.equalsSetHelper(this, paramObject);
  }
  
  public int hashCode() {
    int i = MapCollections.this.colGetSize() - 1;
    int j = 0;
    while (i >= 0) {
      int k;
      int m;
      Object object1 = MapCollections.this.colGetEntry(i, 0);
      Object object2 = MapCollections.this.colGetEntry(i, 1);
      if (object1 == null) {
        k = 0;
      } else {
        k = object1.hashCode();
      } 
      if (object2 == null) {
        m = 0;
      } else {
        m = object2.hashCode();
      } 
      j += k ^ m;
      i--;
    } 
    return j;
  }
  
  public boolean isEmpty() {
    boolean bool;
    if (MapCollections.this.colGetSize() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Iterator<Map.Entry<K, V>> iterator() {
    return new MapCollections.MapIterator(MapCollections.this);
  }
  
  public boolean remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public int size() {
    return MapCollections.this.colGetSize();
  }
  
  public Object[] toArray() {
    throw new UnsupportedOperationException();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\collection\MapCollections$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */