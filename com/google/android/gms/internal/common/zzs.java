package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzs {
  @CanIgnoreReturnValue
  public static int zza(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 < 0 || paramInt1 >= paramInt2) {
      if (paramInt1 >= 0) {
        if (paramInt2 < 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("negative size: ");
          stringBuilder.append(paramInt2);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        paramString = zzy.zza("%s (%s) must be less than size (%s)", new Object[] { "index", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      } else {
        paramString = zzy.zza("%s (%s) must not be negative", new Object[] { "index", Integer.valueOf(paramInt1) });
      } 
      throw new IndexOutOfBoundsException(paramString);
    } 
    return paramInt1;
  }
  
  @CanIgnoreReturnValue
  public static int zzb(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 >= 0 && paramInt1 <= paramInt2)
      return paramInt1; 
    throw new IndexOutOfBoundsException(zzd(paramInt1, paramInt2, "index"));
  }
  
  public static void zzc(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 < 0 || paramInt2 < paramInt1 || paramInt2 > paramInt3) {
      String str;
      if (paramInt1 >= 0 && paramInt1 <= paramInt3) {
        if (paramInt2 < 0 || paramInt2 > paramInt3) {
          String str1 = zzd(paramInt2, paramInt3, "end index");
          throw new IndexOutOfBoundsException(str1);
        } 
        str = zzy.zza("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      } else {
        str = zzd(paramInt1, paramInt3, "start index");
      } 
      throw new IndexOutOfBoundsException(str);
    } 
  }
  
  private static String zzd(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 < 0)
      return zzy.zza("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
    if (paramInt2 >= 0)
      return zzy.zza("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("negative size: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */