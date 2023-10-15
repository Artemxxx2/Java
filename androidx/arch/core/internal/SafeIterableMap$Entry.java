package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Map;

class Entry<K, V> implements Map.Entry<K, V> {
  @NonNull
  final K mKey;
  
  Entry<K, V> mNext;
  
  Entry<K, V> mPrevious;
  
  @NonNull
  final V mValue;
  
  Entry(@NonNull K paramK, @NonNull V paramV) {
    this.mKey = paramK;
    this.mValue = paramV;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Entry))
      return false; 
    paramObject = paramObject;
    if (!this.mKey.equals(((Entry)paramObject).mKey) || !this.mValue.equals(((Entry)paramObject).mValue))
      bool = false; 
    return bool;
  }
  
  @NonNull
  public K getKey() {
    return this.mKey;
  }
  
  @NonNull
  public V getValue() {
    return this.mValue;
  }
  
  public int hashCode() {
    return this.mKey.hashCode() ^ this.mValue.hashCode();
  }
  
  public V setValue(V paramV) {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mKey);
    stringBuilder.append("=");
    stringBuilder.append(this.mValue);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\internal\SafeIterableMap$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */