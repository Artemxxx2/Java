package org.apache.cordova.file;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LimitedInputStream extends FilterInputStream {
  long numBytesToRead;
  
  public LimitedInputStream(InputStream paramInputStream, long paramLong) {
    super(paramInputStream);
    this.numBytesToRead = paramLong;
  }
  
  public int read() throws IOException {
    long l = this.numBytesToRead;
    if (l <= 0L)
      return -1; 
    this.numBytesToRead = l - 1L;
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    long l = this.numBytesToRead;
    if (l <= 0L)
      return -1; 
    int i = paramInt2;
    if (paramInt2 > l)
      i = (int)l; 
    paramInt1 = this.in.read(paramArrayOfbyte, paramInt1, i);
    this.numBytesToRead -= paramInt1;
    return paramInt1;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\Filesystem$LimitedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */