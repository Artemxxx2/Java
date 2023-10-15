package androidx.collection;

import java.util.Collection;
import java.util.Iterator;

final class ValuesCollection implements Collection<V> {
  public boolean add(V paramV) {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public void clear() {
    MapCollections.this.colClear();
  }
  
  public boolean contains(Object paramObject) {
    boolean bool;
    if (MapCollections.this.colIndexOfValue(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
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
  
  public Iterator<V> iterator() {
    return new MapCollections.ArrayIterator<V>(MapCollections.this, 1);
  }
  
  public boolean remove(Object paramObject) {
    int i = MapCollections.this.colIndexOfValue(paramObject);
    if (i >= 0) {
      MapCollections.this.colRemoveAt(i);
      return true;
    } 
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    int i = MapCollections.this.colGetSize();
    int j = 0;
    boolean bool = false;
    while (j < i) {
      int k = i;
      int m = j;
      if (paramCollection.contains(MapCollections.this.colGetEntry(j, 1))) {
        MapCollections.this.colRemoveAt(j);
        m = j - 1;
        k = i - 1;
        bool = true;
      } 
      j = m + 1;
      i = k;
    } 
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    int i = MapCollections.this.colGetSize();
    int j = 0;
    boolean bool = false;
    while (j < i) {
      int k = i;
      int m = j;
      if (!paramCollection.contains(MapCollections.this.colGetEntry(j, 1))) {
        MapCollections.this.colRemoveAt(j);
        m = j - 1;
        k = i - 1;
        bool = true;
      } 
      j = m + 1;
      i = k;
    } 
    return bool;
  }
  
  public int size() {
    return MapCollections.this.colGetSize();
  }
  
  public Object[] toArray() {
    return MapCollections.this.toArrayHelper(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return (T[])MapCollections.this.toArrayHelper((Object[])paramArrayOfT, 1);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\collection\MapCollections$ValuesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */