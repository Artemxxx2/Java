package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@KeepForSdk
public final class Objects {
  private Objects() {
    throw new AssertionError("Uninstantiable");
  }
  
  @KeepForSdk
  public static boolean checkBundlesEquality(@NonNull Bundle paramBundle1, @NonNull Bundle paramBundle2) {
    if (paramBundle1 == null || paramBundle2 == null)
      return (paramBundle1 == paramBundle2); 
    if (paramBundle1.size() != paramBundle2.size())
      return false; 
    Set set = paramBundle1.keySet();
    if (!set.containsAll(paramBundle2.keySet()))
      return false; 
    for (String str : set) {
      if (!equal(paramBundle1.get(str), paramBundle2.get(str)))
        return false; 
    } 
    return true;
  }
  
  @KeepForSdk
  public static boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramObject1 != paramObject2)
      if (paramObject1 != null) {
        if (paramObject1.equals(paramObject2)) {
          bool2 = bool1;
        } else {
          return false;
        } 
      } else {
        bool2 = false;
      }  
    return bool2;
  }
  
  @KeepForSdk
  public static int hashCode(@NonNull Object... paramVarArgs) {
    return Arrays.hashCode(paramVarArgs);
  }
  
  @NonNull
  @KeepForSdk
  public static ToStringHelper toStringHelper(@NonNull Object paramObject) {
    return new ToStringHelper(paramObject, null);
  }
  
  @KeepForSdk
  public static final class ToStringHelper {
    private final List zza;
    
    private final Object zzb;
    
    @NonNull
    @KeepForSdk
    @CanIgnoreReturnValue
    public ToStringHelper add(@NonNull String param1String, @Nullable Object param1Object) {
      List<String> list = this.zza;
      Preconditions.checkNotNull(param1String);
      param1Object = String.valueOf(param1Object);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append("=");
      stringBuilder.append((String)param1Object);
      list.add(stringBuilder.toString());
      return this;
    }
    
    @NonNull
    @KeepForSdk
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(100);
      stringBuilder.append(this.zzb.getClass().getSimpleName());
      stringBuilder.append('{');
      int i = this.zza.size();
      for (byte b = 0; b < i; b++) {
        stringBuilder.append(this.zza.get(b));
        if (b < i - 1)
          stringBuilder.append(", "); 
      } 
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */