package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils {
  @Nullable
  private static String zza;
  
  private static int zzb;
  
  @Nullable
  @KeepForSdk
  public static String getMyProcessName() {
    if (zza == null) {
      int i = zzb;
      int j = i;
      if (i == 0) {
        j = Process.myPid();
        zzb = j;
      } 
      StringBuilder stringBuilder1 = null;
      StringBuilder stringBuilder2 = null;
      String str = null;
      if (j <= 0) {
        stringBuilder1 = stringBuilder2;
      } else {
        IOException iOException1;
        try {
          stringBuilder2 = new StringBuilder();
          this();
          stringBuilder2.append("/proc/");
          stringBuilder2.append(j);
          stringBuilder2.append("/cmdline");
          String str1 = stringBuilder2.toString();
          StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
          try {
            BufferedReader bufferedReader = new BufferedReader();
            FileReader fileReader = new FileReader();
            this(str1);
            this(fileReader);
            StrictMode.setThreadPolicy(threadPolicy);
          } finally {
            StrictMode.setThreadPolicy(threadPolicy);
          } 
          IOUtils.closeQuietly((Closeable)stringBuilder2);
          throw stringBuilder1;
        } catch (IOException null) {
        
        } finally {
          iOException1 = iOException2;
          IOUtils.closeQuietly((Closeable)iOException1);
        } 
        IOUtils.closeQuietly((Closeable)iOException1);
      } 
      zza = (String)stringBuilder1;
    } 
    return zza;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\ProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */