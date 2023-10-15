package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

public final class zzm {
  public static int zza(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 < 0 || paramInt1 >= paramInt2) {
      if (paramInt1 >= 0) {
        if (paramInt2 < 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("negative size: ");
          stringBuilder.append(paramInt2);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        paramString = zzn.zza("%s (%s) must be less than size (%s)", new Object[] { "index", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      } else {
        paramString = zzn.zza("%s (%s) must not be negative", new Object[] { "index", Integer.valueOf(paramInt1) });
      } 
      throw new IndexOutOfBoundsException(paramString);
    } 
    return paramInt1;
  }
  
  public static int zzb(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 >= 0 && paramInt1 <= paramInt2)
      return paramInt1; 
    throw new IndexOutOfBoundsException(zze(paramInt1, paramInt2, "index"));
  }
  
  public static Object zzc(@CheckForNull Object paramObject1, @CheckForNull Object paramObject2) {
    if (paramObject1 != null)
      return paramObject1; 
    throw new NullPointerException((String)paramObject2);
  }
  
  public static void zzd(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 < 0 || paramInt2 < paramInt1 || paramInt2 > paramInt3) {
      String str;
      if (paramInt1 >= 0 && paramInt1 <= paramInt3) {
        if (paramInt2 < 0 || paramInt2 > paramInt3) {
          String str1 = zze(paramInt2, paramInt3, "end index");
          throw new IndexOutOfBoundsException(str1);
        } 
        str = zzn.zza("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      } else {
        str = zze(paramInt1, paramInt3, "start index");
      } 
      throw new IndexOutOfBoundsException(str);
    } 
  }
  
  private static String zze(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 < 0)
      return zzn.zza("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
    if (paramInt2 >= 0)
      return zzn.zza("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("negative size: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */