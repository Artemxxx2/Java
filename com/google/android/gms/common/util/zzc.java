package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzc {
  private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
  
  public static String zza(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      StringBuilder stringBuilder;
      Matcher matcher = zza.matcher(paramString);
      int i = 0;
      String str1 = null;
      while (matcher.find()) {
        StringBuilder stringBuilder1;
        str = str1;
        if (str1 == null)
          stringBuilder1 = new StringBuilder(); 
        int j = matcher.start();
        int k;
        for (k = j; k >= 0 && paramString.charAt(k) == '\\'; k--);
        stringBuilder = stringBuilder1;
        if ((j - k) % 2 != 0) {
          k = Integer.parseInt(matcher.group().substring(2), 16);
          stringBuilder1.append(paramString, i, matcher.start());
          if (k == 92) {
            stringBuilder1.append("\\\\");
          } else {
            stringBuilder1.append(Character.toChars(k));
          } 
          i = matcher.end();
          stringBuilder = stringBuilder1;
        } 
      } 
      if (stringBuilder == null)
        return paramString; 
      if (i < matcher.regionEnd())
        stringBuilder.append(paramString, i, matcher.regionEnd()); 
      str = stringBuilder.toString();
    } 
    return str;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */