package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Pair<F, S> {
  @Nullable
  public final F first;
  
  @Nullable
  public final S second;
  
  public Pair(@Nullable F paramF, @Nullable S paramS) {
    this.first = paramF;
    this.second = paramS;
  }
  
  @NonNull
  public static <A, B> Pair<A, B> create(@Nullable A paramA, @Nullable B paramB) {
    return new Pair<A, B>(paramA, paramB);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Pair;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (ObjectsCompat.equals(((Pair)paramObject).first, this.first)) {
      bool = bool1;
      if (ObjectsCompat.equals(((Pair)paramObject).second, this.second))
        bool = true; 
    } 
    return bool;
  }
  
  public int hashCode() {
    int j;
    F f = this.first;
    int i = 0;
    if (f == null) {
      j = 0;
    } else {
      j = f.hashCode();
    } 
    S s = this.second;
    if (s != null)
      i = s.hashCode(); 
    return j ^ i;
  }
  
  @NonNull
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Pair{");
    stringBuilder.append(String.valueOf(this.first));
    stringBuilder.append(" ");
    stringBuilder.append(String.valueOf(this.second));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cor\\util\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */