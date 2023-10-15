package com.google.android.gms.internal.common;

final class zzl extends zzk {
  private final char zza;
  
  zzl(char paramChar) {
    this.zza = (char)paramChar;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CharMatcher.is('");
    char c = this.zza;
    char[] arrayOfChar = new char[6];
    arrayOfChar[0] = '\\';
    arrayOfChar[1] = 'u';
    arrayOfChar[2] = Character.MIN_VALUE;
    arrayOfChar[3] = Character.MIN_VALUE;
    arrayOfChar[4] = Character.MIN_VALUE;
    arrayOfChar[5] = Character.MIN_VALUE;
    for (byte b = 0; b < 4; b++) {
      arrayOfChar[5 - b] = "0123456789ABCDEF".charAt(c & 0xF);
      int i = c >> 4;
    } 
    stringBuilder.append(String.copyValueOf(arrayOfChar));
    stringBuilder.append("')");
    return stringBuilder.toString();
  }
  
  public final boolean zza(char paramChar) {
    return (paramChar == this.zza);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */