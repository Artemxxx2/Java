package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Iterator;

@KeepForSdk
public class MapUtils {
  @KeepForSdk
  public static void writeStringMapToJson(@NonNull StringBuilder paramStringBuilder, @NonNull HashMap<String, String> paramHashMap) {
    paramStringBuilder.append("{");
    Iterator<String> iterator = paramHashMap.keySet().iterator();
    for (boolean bool = true; iterator.hasNext(); bool = false) {
      String str1 = iterator.next();
      if (!bool)
        paramStringBuilder.append(","); 
      String str2 = paramHashMap.get(str1);
      paramStringBuilder.append("\"");
      paramStringBuilder.append(str1);
      paramStringBuilder.append("\":");
      if (str2 == null) {
        paramStringBuilder.append("null");
        bool = false;
        continue;
      } 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(str2);
      paramStringBuilder.append("\"");
    } 
    paramStringBuilder.append("}");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\MapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */