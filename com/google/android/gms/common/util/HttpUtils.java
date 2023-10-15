package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzx;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@KeepForSdk
public class HttpUtils {
  private static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  
  private static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  
  private static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  
  @NonNull
  @KeepForSdk
  public static Map<String, String> parse(@NonNull URI paramURI, @NonNull String paramString) {
    List<String> list;
    Map<?, ?> map2 = Collections.emptyMap();
    String str = paramURI.getRawQuery();
    Map<?, ?> map1 = map2;
    if (str != null) {
      map1 = map2;
      if (str.length() > 0) {
        map2 = new HashMap<Object, Object>();
        zzx zzx = zzx.zzc(zzo.zzb('='));
        Iterator<String> iterator = zzx.zzc(zzo.zzb('&')).zzb().zzd(str).iterator();
        while (true) {
          map1 = map2;
          if (iterator.hasNext()) {
            list = zzx.zzf(iterator.next());
            if (!list.isEmpty() && list.size() <= 2) {
              String str1 = zza(list.get(0), paramString);
              if (list.size() == 2) {
                String str2 = zza(list.get(1), paramString);
              } else {
                list = null;
              } 
              map2.put(str1, list);
              continue;
            } 
            throw new IllegalArgumentException("bad parameter");
          } 
          break;
        } 
      } 
    } 
    return (Map)list;
  }
  
  private static String zza(String paramString1, String paramString2) {
    String str = paramString2;
    if (paramString2 == null)
      str = "ISO-8859-1"; 
    try {
      return URLDecoder.decode(paramString1, str);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalArgumentException(unsupportedEncodingException);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */