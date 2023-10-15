package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public class Hex {
  private static final char[] zza = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  private static final char[] zzb = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  @NonNull
  @KeepForSdk
  public static String bytesToStringLowercase(@NonNull byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[i + i];
    i = 0;
    int j = 0;
    while (i < paramArrayOfbyte.length) {
      int k = paramArrayOfbyte[i] & 0xFF;
      int m = j + 1;
      char[] arrayOfChar1 = zzb;
      arrayOfChar[j] = (char)arrayOfChar1[k >>> 4];
      j = m + 1;
      arrayOfChar[m] = (char)arrayOfChar1[k & 0xF];
      i++;
    } 
    return new String(arrayOfChar);
  }
  
  @NonNull
  @KeepForSdk
  public static String bytesToStringUppercase(@NonNull byte[] paramArrayOfbyte) {
    return bytesToStringUppercase(paramArrayOfbyte, false);
  }
  
  @NonNull
  @KeepForSdk
  public static String bytesToStringUppercase(@NonNull byte[] paramArrayOfbyte, boolean paramBoolean) {
    int i = paramArrayOfbyte.length;
    StringBuilder stringBuilder = new StringBuilder(i + i);
    for (byte b = 0; b < i && (!paramBoolean || b != i - 1 || (paramArrayOfbyte[b] & 0xFF) != 0); b++) {
      stringBuilder.append(zza[(paramArrayOfbyte[b] & 0xF0) >>> 4]);
      stringBuilder.append(zza[paramArrayOfbyte[b] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  @NonNull
  @KeepForSdk
  public static byte[] stringToBytes(@NonNull String paramString) throws IllegalArgumentException {
    int i = paramString.length();
    if (i % 2 == 0) {
      byte[] arrayOfByte = new byte[i / 2];
      for (int j = 0; j < i; j = k) {
        int k = j + 2;
        arrayOfByte[j / 2] = (byte)(byte)Integer.parseInt(paramString.substring(j, k), 16);
      } 
      return arrayOfByte;
    } 
    throw new IllegalArgumentException("Hex string has odd number of characters");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */