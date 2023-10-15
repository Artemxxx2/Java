package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

public final class zzn {
  public static String zza(@CheckForNull String paramString, @CheckForNull Object... paramVarArgs) {
    int i = 0;
    int j = 0;
    while (true) {
      int k = paramVarArgs.length;
      if (j < k) {
        String str;
        Object object = paramVarArgs[j];
        if (object == null) {
          str = "null";
        } else {
          try {
            str = object.toString();
          } catch (Exception exception) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(object.getClass().getName());
            stringBuilder1.append('@');
            stringBuilder1.append(Integer.toHexString(System.identityHashCode(object)));
            String str1 = stringBuilder1.toString();
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str1), exception);
            object = new StringBuilder();
            object.append("<");
            object.append(str1);
            object.append(" threw ");
            object.append(exception.getClass().getName());
            object.append(">");
            str = object.toString();
          } 
        } 
        paramVarArgs[j] = str;
        j++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder(paramString.length() + k * 16);
      k = 0;
      j = i;
      while (true) {
        i = paramVarArgs.length;
        if (j < i) {
          int m = paramString.indexOf("%s", k);
          if (m == -1)
            break; 
          stringBuilder.append(paramString, k, m);
          stringBuilder.append(paramVarArgs[j]);
          k = m + 2;
          j++;
          continue;
        } 
        break;
      } 
      stringBuilder.append(paramString, k, paramString.length());
      if (j < i) {
        stringBuilder.append(" [");
        k = j + 1;
        stringBuilder.append(paramVarArgs[j]);
        for (j = k; j < paramVarArgs.length; j++) {
          stringBuilder.append(", ");
          stringBuilder.append(paramVarArgs[j]);
        } 
        stringBuilder.append(']');
      } 
      return stringBuilder.toString();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */