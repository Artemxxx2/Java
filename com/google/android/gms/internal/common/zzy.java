package com.google.android.gms.internal.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzy {
  public static String zza(@CheckForNull String paramString, @CheckForNull Object... paramVarArgs) {
    int i = 0;
    int j = 0;
    while (true) {
      int m;
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
            object = stringBuilder1.toString();
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat((String)object), exception);
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("<");
            stringBuilder1.append((String)object);
            stringBuilder1.append(" threw ");
            stringBuilder1.append(exception.getClass().getName());
            stringBuilder1.append(">");
            str = stringBuilder1.toString();
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
        m = paramVarArgs.length;
        if (j < m) {
          i = paramString.indexOf("%s", k);
          if (i == -1)
            break; 
          stringBuilder.append(paramString, k, i);
          stringBuilder.append(paramVarArgs[j]);
          k = i + 2;
          j++;
          continue;
        } 
        break;
      } 
      stringBuilder.append(paramString, k, paramString.length());
      if (j < m) {
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */