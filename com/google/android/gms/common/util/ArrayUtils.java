package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils {
  @NonNull
  @KeepForSdk
  public static <T> T[] concat(@NonNull T[]... paramVarArgs) {
    if (paramVarArgs.length != 0) {
      int i = 0;
      int j = 0;
      while (i < paramVarArgs.length) {
        j += (paramVarArgs[i]).length;
        i++;
      } 
      Object[] arrayOfObject = Arrays.copyOf((Object[])paramVarArgs[0], j);
      i = (paramVarArgs[0]).length;
      for (j = 1; j < paramVarArgs.length; j++) {
        T[] arrayOfT = paramVarArgs[j];
        int k = arrayOfT.length;
        System.arraycopy(arrayOfT, 0, arrayOfObject, i, k);
        i += k;
      } 
      return (T[])arrayOfObject;
    } 
    return (T[])Array.newInstance(paramVarArgs.getClass(), 0);
  }
  
  @NonNull
  @KeepForSdk
  public static byte[] concatByteArrays(@NonNull byte[]... paramVarArgs) {
    if (paramVarArgs.length != 0) {
      byte b = 0;
      int i = 0;
      while (b < paramVarArgs.length) {
        i += (paramVarArgs[b]).length;
        b++;
      } 
      byte[] arrayOfByte = Arrays.copyOf(paramVarArgs[0], i);
      i = (paramVarArgs[0]).length;
      for (b = 1; b < paramVarArgs.length; b++) {
        byte[] arrayOfByte1 = paramVarArgs[b];
        int j = arrayOfByte1.length;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, j);
        i += j;
      } 
      return arrayOfByte;
    } 
    return new byte[0];
  }
  
  @KeepForSdk
  public static boolean contains(@NonNull int[] paramArrayOfint, int paramInt) {
    if (paramArrayOfint == null)
      return false; 
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfint[b] == paramInt)
        return true; 
    } 
    return false;
  }
  
  @KeepForSdk
  public static <T> boolean contains(@NonNull T[] paramArrayOfT, @NonNull T paramT) {
    byte b1;
    if (paramArrayOfT != null) {
      b1 = paramArrayOfT.length;
    } else {
      b1 = 0;
    } 
    for (byte b2 = 0; b2 < b1; b2++) {
      if (Objects.equal(paramArrayOfT[b2], paramT)) {
        if (b2 >= 0)
          return true; 
        break;
      } 
    } 
    return false;
  }
  
  @NonNull
  @KeepForSdk
  public static <T> ArrayList<T> newArrayList() {
    return new ArrayList<T>();
  }
  
  @Nullable
  @KeepForSdk
  public static <T> T[] removeAll(@NonNull T[] paramArrayOfT1, @NonNull T... paramVarArgs1) {
    T[] arrayOfT = null;
    if (paramArrayOfT1 == null)
      return null; 
    if (paramVarArgs1 != null) {
      int k;
      int i = paramVarArgs1.length;
      if (i == 0)
        return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length); 
      Class<?> clazz = paramVarArgs1.getClass().getComponentType();
      int j = paramArrayOfT1.length;
      Object[] arrayOfObject = (Object[])Array.newInstance(clazz, j);
      byte b = 0;
      if (i == 1) {
        b = 0;
        i = 0;
        while (true) {
          k = i;
          if (b < j) {
            T t = paramArrayOfT1[b];
            k = i;
            if (!Objects.equal(paramVarArgs1[0], t)) {
              arrayOfObject[i] = t;
              k = i + 1;
            } 
            b++;
            i = k;
            continue;
          } 
          break;
        } 
      } else {
        i = 0;
        while (true) {
          k = i;
          if (b < j) {
            T t = paramArrayOfT1[b];
            k = i;
            if (!contains(paramVarArgs1, t)) {
              arrayOfObject[i] = t;
              k = i + 1;
            } 
            b++;
            i = k;
            continue;
          } 
          break;
        } 
      } 
      if (arrayOfObject == null) {
        paramArrayOfT1 = arrayOfT;
      } else {
        return (T[])((k == arrayOfObject.length) ? arrayOfObject : (Object)Arrays.copyOf((T[])arrayOfObject, k));
      } 
      return paramArrayOfT1;
    } 
    return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length);
  }
  
  @NonNull
  @KeepForSdk
  public static <T> ArrayList<T> toArrayList(@NonNull T[] paramArrayOfT) {
    int i = paramArrayOfT.length;
    ArrayList<T> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(paramArrayOfT[b]); 
    return arrayList;
  }
  
  @NonNull
  @KeepForSdk
  public static int[] toPrimitiveArray(@NonNull Collection<Integer> paramCollection) {
    byte b = 0;
    if (paramCollection == null || paramCollection.isEmpty())
      return new int[0]; 
    int[] arrayOfInt = new int[paramCollection.size()];
    Iterator<Integer> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      arrayOfInt[b] = ((Integer)iterator.next()).intValue();
      b++;
    } 
    return arrayOfInt;
  }
  
  @Nullable
  @KeepForSdk
  public static Integer[] toWrapperArray(@NonNull int[] paramArrayOfint) {
    if (paramArrayOfint == null)
      return null; 
    int i = paramArrayOfint.length;
    Integer[] arrayOfInteger = new Integer[i];
    for (byte b = 0; b < i; b++)
      arrayOfInteger[b] = Integer.valueOf(paramArrayOfint[b]); 
    return arrayOfInteger;
  }
  
  @KeepForSdk
  public static void writeArray(@NonNull StringBuilder paramStringBuilder, @NonNull double[] paramArrayOfdouble) {
    int i = paramArrayOfdouble.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Double.toString(paramArrayOfdouble[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeArray(@NonNull StringBuilder paramStringBuilder, @NonNull float[] paramArrayOffloat) {
    int i = paramArrayOffloat.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Float.toString(paramArrayOffloat[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeArray(@NonNull StringBuilder paramStringBuilder, @NonNull int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Integer.toString(paramArrayOfint[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeArray(@NonNull StringBuilder paramStringBuilder, @NonNull long[] paramArrayOflong) {
    int i = paramArrayOflong.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Long.toString(paramArrayOflong[b]));
    } 
  }
  
  @KeepForSdk
  public static <T> void writeArray(@NonNull StringBuilder paramStringBuilder, @NonNull T[] paramArrayOfT) {
    int i = paramArrayOfT.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(paramArrayOfT[b]);
    } 
  }
  
  @KeepForSdk
  public static void writeArray(@NonNull StringBuilder paramStringBuilder, @NonNull boolean[] paramArrayOfboolean) {
    int i = paramArrayOfboolean.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Boolean.toString(paramArrayOfboolean[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeStringArray(@NonNull StringBuilder paramStringBuilder, @NonNull String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[b]);
      paramStringBuilder.append("\"");
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */