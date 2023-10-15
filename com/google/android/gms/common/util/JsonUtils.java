package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
@VisibleForTesting
public final class JsonUtils {
  private static final Pattern zza = Pattern.compile("\\\\.");
  
  private static final Pattern zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  @KeepForSdk
  public static boolean areJsonValuesEquivalent(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramObject1 != null || paramObject2 != null) {
      if (paramObject1 == null || paramObject2 == null)
        return false; 
      if (paramObject1 instanceof JSONObject && paramObject2 instanceof JSONObject) {
        paramObject1 = paramObject1;
        JSONObject jSONObject = (JSONObject)paramObject2;
        if (paramObject1.length() != jSONObject.length())
          return false; 
        paramObject2 = paramObject1.keys();
        while (paramObject2.hasNext()) {
          String str = paramObject2.next();
          if (!jSONObject.has(str))
            return false; 
          try {
            Preconditions.checkNotNull(str);
            boolean bool = areJsonValuesEquivalent(paramObject1.get(str), jSONObject.get(str));
            if (!bool)
              return false; 
          } catch (JSONException null) {
            return false;
          } 
        } 
        return true;
      } 
      if (jSONException instanceof JSONArray && paramObject2 instanceof JSONArray) {
        JSONArray jSONArray = (JSONArray)jSONException;
        paramObject2 = paramObject2;
        if (jSONArray.length() == paramObject2.length()) {
          byte b = 0;
          while (b < jSONArray.length()) {
            try {
              boolean bool = areJsonValuesEquivalent(jSONArray.get(b), paramObject2.get(b));
              if (bool) {
                b++;
                continue;
              } 
              return false;
            } catch (JSONException jSONException) {
              return false;
            } 
          } 
          return true;
        } 
        return false;
      } 
      return jSONException.equals(paramObject2);
    } 
    return true;
  }
  
  @Nullable
  @KeepForSdk
  public static String escapeString(@Nullable String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      StringBuffer stringBuffer;
      Matcher matcher = zzb.matcher(paramString);
      str = null;
      while (matcher.find()) {
        StringBuffer stringBuffer1;
        String str1 = str;
        if (str == null)
          stringBuffer1 = new StringBuffer(); 
        char c = matcher.group().charAt(0);
        if (c != '"') {
          if (c != '/') {
            if (c != '\\') {
              switch (c) {
                default:
                  switch (c) {
                    default:
                      stringBuffer4 = stringBuffer1;
                      continue;
                    case '\r':
                      matcher.appendReplacement(stringBuffer1, "\\\\r");
                      stringBuffer4 = stringBuffer1;
                      continue;
                    case '\f':
                      break;
                  } 
                  matcher.appendReplacement(stringBuffer1, "\\\\f");
                  stringBuffer4 = stringBuffer1;
                  continue;
                case '\n':
                  matcher.appendReplacement(stringBuffer1, "\\\\n");
                  stringBuffer4 = stringBuffer1;
                  continue;
                case '\t':
                  matcher.appendReplacement(stringBuffer1, "\\\\t");
                  stringBuffer4 = stringBuffer1;
                  continue;
                case '\b':
                  break;
              } 
              matcher.appendReplacement(stringBuffer1, "\\\\b");
              StringBuffer stringBuffer4 = stringBuffer1;
              continue;
            } 
            matcher.appendReplacement(stringBuffer1, "\\\\\\\\");
            StringBuffer stringBuffer3 = stringBuffer1;
            continue;
          } 
          matcher.appendReplacement(stringBuffer1, "\\\\/");
          StringBuffer stringBuffer2 = stringBuffer1;
          continue;
        } 
        matcher.appendReplacement(stringBuffer1, "\\\\\\\"");
        stringBuffer = stringBuffer1;
      } 
      if (stringBuffer == null)
        return paramString; 
      matcher.appendTail(stringBuffer);
      str = stringBuffer.toString();
    } 
    return str;
  }
  
  @NonNull
  @KeepForSdk
  public static String unescapeString(@NonNull String paramString) {
    StringBuffer stringBuffer;
    if (!TextUtils.isEmpty(paramString)) {
      StringBuffer stringBuffer1;
      String str1 = zzc.zza(paramString);
      Matcher matcher = zza.matcher(str1);
      String str2 = null;
      while (matcher.find()) {
        paramString = str2;
        if (str2 == null)
          stringBuffer = new StringBuffer(); 
        char c = matcher.group().charAt(1);
        if (c != '"') {
          if (c != '/') {
            if (c != '\\') {
              if (c != 'b') {
                if (c != 'f') {
                  if (c != 'n') {
                    if (c != 'r') {
                      if (c == 't') {
                        matcher.appendReplacement(stringBuffer, "\t");
                        StringBuffer stringBuffer8 = stringBuffer;
                        continue;
                      } 
                      throw new IllegalStateException("Found an escaped character that should never be.");
                    } 
                    matcher.appendReplacement(stringBuffer, "\r");
                    StringBuffer stringBuffer7 = stringBuffer;
                    continue;
                  } 
                  matcher.appendReplacement(stringBuffer, "\n");
                  StringBuffer stringBuffer6 = stringBuffer;
                  continue;
                } 
                matcher.appendReplacement(stringBuffer, "\f");
                StringBuffer stringBuffer5 = stringBuffer;
                continue;
              } 
              matcher.appendReplacement(stringBuffer, "\b");
              StringBuffer stringBuffer4 = stringBuffer;
              continue;
            } 
            matcher.appendReplacement(stringBuffer, "\\\\");
            StringBuffer stringBuffer3 = stringBuffer;
            continue;
          } 
          matcher.appendReplacement(stringBuffer, "/");
          StringBuffer stringBuffer2 = stringBuffer;
          continue;
        } 
        matcher.appendReplacement(stringBuffer, "\"");
        stringBuffer1 = stringBuffer;
      } 
      if (stringBuffer1 == null)
        return str1; 
      matcher.appendTail(stringBuffer1);
      return stringBuffer1.toString();
    } 
    return (String)stringBuffer;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */