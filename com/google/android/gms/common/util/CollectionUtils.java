package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
  @KeepForSdk
  public static boolean isEmpty(@Nullable Collection<?> paramCollection) {
    return (paramCollection == null) ? true : paramCollection.isEmpty();
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static <T> List<T> listOf() {
    return Collections.emptyList();
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static <T> List<T> listOf(@NonNull T paramT) {
    return Collections.singletonList(paramT);
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static <T> List<T> listOf(@NonNull T... paramVarArgs) {
    switch (paramVarArgs.length) {
      default:
        return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
      case 1:
        return listOf(paramVarArgs[0]);
      case 0:
        break;
    } 
    return listOf();
  }
  
  @NonNull
  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(@NonNull K paramK1, @NonNull V paramV1, @NonNull K paramK2, @NonNull V paramV2, @NonNull K paramK3, @NonNull V paramV3) {
    Map<K, V> map = zza(3, false);
    map.put(paramK1, paramV1);
    map.put(paramK2, paramV2);
    map.put(paramK3, paramV3);
    return Collections.unmodifiableMap(map);
  }
  
  @NonNull
  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(@NonNull K paramK1, @NonNull V paramV1, @NonNull K paramK2, @NonNull V paramV2, @NonNull K paramK3, @NonNull V paramV3, @NonNull K paramK4, @NonNull V paramV4, @NonNull K paramK5, @NonNull V paramV5, @NonNull K paramK6, @NonNull V paramV6) {
    Map<K, V> map = zza(6, false);
    map.put(paramK1, paramV1);
    map.put(paramK2, paramV2);
    map.put(paramK3, paramV3);
    map.put(paramK4, paramV4);
    map.put(paramK5, paramV5);
    map.put(paramK6, paramV6);
    return Collections.unmodifiableMap(map);
  }
  
  @NonNull
  @KeepForSdk
  public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] paramArrayOfK, @NonNull V[] paramArrayOfV) {
    int i = paramArrayOfK.length;
    int j = paramArrayOfV.length;
    if (i == j) {
      Map<K, V> map;
      j = 0;
      switch (i) {
        default:
          map = zza(i, false);
          break;
        case 1:
          return Collections.singletonMap(paramArrayOfK[0], paramArrayOfV[0]);
        case 0:
          return Collections.emptyMap();
      } 
      while (j < paramArrayOfK.length) {
        map.put(paramArrayOfK[j], paramArrayOfV[j]);
        j++;
      } 
      return Collections.unmodifiableMap(map);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Key and values array lengths not equal: ");
    stringBuilder.append(i);
    stringBuilder.append(" != ");
    stringBuilder.append(j);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @NonNull
  @KeepForSdk
  public static <T> Set<T> mutableSetOfWithSize(int paramInt) {
    Set<T> set;
    if (paramInt == 0) {
      ArraySet arraySet = new ArraySet();
    } else {
      set = zzb(paramInt, true);
    } 
    return set;
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static <T> Set<T> setOf(@NonNull T paramT1, @NonNull T paramT2, @NonNull T paramT3) {
    Set<T> set = zzb(3, false);
    set.add(paramT1);
    set.add(paramT2);
    set.add(paramT3);
    return Collections.unmodifiableSet(set);
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static <T> Set<T> setOf(@NonNull T... paramVarArgs) {
    Set<T> set1;
    Set<? super T> set;
    T t1;
    Set<T> set2;
    T t2;
    Set<Set<T>> set3;
    T t3;
    T t4;
    int i = paramVarArgs.length;
    switch (i) {
      default:
        set = zzb(i, false);
        Collections.addAll(set, paramVarArgs);
        return Collections.unmodifiableSet((Set)set);
      case 4:
        t1 = paramVarArgs[0];
        t2 = paramVarArgs[1];
        t3 = paramVarArgs[2];
        t4 = paramVarArgs[3];
        set1 = zzb(4, false);
        set1.add(t1);
        set1.add(t2);
        set1.add(t3);
        set1.add(t4);
        return Collections.unmodifiableSet(set1);
      case 3:
        return setOf((T)set1[0], (T)set1[1], (T)set1[2]);
      case 2:
        set2 = set1[0];
        set1 = set1[1];
        set3 = zzb(2, false);
        set3.add(set2);
        set3.add(set1);
        return Collections.unmodifiableSet((Set)set3);
      case 1:
        return Collections.singleton((T)set1[0]);
      case 0:
        break;
    } 
    return Collections.emptySet();
  }
  
  private static Map zza(int paramInt, boolean paramBoolean) {
    HashMap<Object, Object> hashMap;
    if (paramInt <= 256) {
      ArrayMap arrayMap = new ArrayMap(paramInt);
    } else {
      hashMap = new HashMap<Object, Object>(paramInt, 1.0F);
    } 
    return hashMap;
  }
  
  private static Set zzb(int paramInt, boolean paramBoolean) {
    float f;
    char c;
    HashSet hashSet;
    if (true != paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.75F;
    } 
    if (true != paramBoolean) {
      c = 'Ā';
    } else {
      c = '';
    } 
    if (paramInt <= c) {
      ArraySet arraySet = new ArraySet(paramInt);
    } else {
      hashSet = new HashSet(paramInt, f);
    } 
    return hashSet;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\CollectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */