package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Deprecated
@KeepForSdk
@ShowFirstParty
public final class IOUtils {
  @KeepForSdk
  public static void closeQuietly(@Nullable ParcelFileDescriptor paramParcelFileDescriptor) {
    if (paramParcelFileDescriptor != null)
      try {
        paramParcelFileDescriptor.close();
      } catch (IOException iOException) {} 
  }
  
  @KeepForSdk
  public static void closeQuietly(@Nullable Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (IOException iOException) {} 
  }
  
  @Deprecated
  @KeepForSdk
  public static long copyStream(@NonNull InputStream paramInputStream, @NonNull OutputStream paramOutputStream) throws IOException {
    return copyStream(paramInputStream, paramOutputStream, false, 1024);
  }
  
  @Deprecated
  @KeepForSdk
  public static long copyStream(@NonNull InputStream paramInputStream, @NonNull OutputStream paramOutputStream, boolean paramBoolean, int paramInt) throws IOException {
    null = new byte[paramInt];
    long l = 0L;
    try {
      while (true) {
        paramInt = paramInputStream.read(null, 0, null.length);
        if (paramInt != -1) {
          l += paramInt;
          paramOutputStream.write(null, 0, paramInt);
          continue;
        } 
        return l;
      } 
    } finally {
      if (paramBoolean) {
        closeQuietly(paramInputStream);
        closeQuietly(paramOutputStream);
      } 
    } 
  }
  
  @KeepForSdk
  public static boolean isGzipByteBuffer(@NonNull byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length > 1) {
      byte b = paramArrayOfbyte[0];
      if (((paramArrayOfbyte[1] & 0xFF) << 8 | b & 0xFF) == 35615)
        return true; 
    } 
    return false;
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static byte[] readInputStreamFully(@NonNull InputStream paramInputStream) throws IOException {
    return readInputStreamFully(paramInputStream, true);
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static byte[] readInputStreamFully(@NonNull InputStream paramInputStream, boolean paramBoolean) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(paramInputStream, byteArrayOutputStream, paramBoolean, 1024);
    return byteArrayOutputStream.toByteArray();
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static byte[] toByteArray(@NonNull InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(byteArrayOutputStream);
    byte[] arrayOfByte = new byte[4096];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return byteArrayOutputStream.toByteArray(); 
      byteArrayOutputStream.write(arrayOfByte, 0, i);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */