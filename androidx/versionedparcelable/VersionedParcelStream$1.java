package androidx.versionedparcelable;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class null extends FilterInputStream {
  null(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  public int read() throws IOException {
    if (VersionedParcelStream.this.mFieldSize == -1 || VersionedParcelStream.this.mCount < VersionedParcelStream.this.mFieldSize) {
      int i = super.read();
      VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
      versionedParcelStream.mCount++;
      return i;
    } 
    throw new IOException();
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (VersionedParcelStream.this.mFieldSize == -1 || VersionedParcelStream.this.mCount < VersionedParcelStream.this.mFieldSize) {
      paramInt1 = super.read(paramArrayOfbyte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
        versionedParcelStream.mCount += paramInt1;
      } 
      return paramInt1;
    } 
    throw new IOException();
  }
  
  public long skip(long paramLong) throws IOException {
    if (VersionedParcelStream.this.mFieldSize == -1 || VersionedParcelStream.this.mCount < VersionedParcelStream.this.mFieldSize) {
      paramLong = super.skip(paramLong);
      if (paramLong > 0L) {
        VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
        versionedParcelStream.mCount += (int)paramLong;
      } 
      return paramLong;
    } 
    throw new IOException();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\VersionedParcelStream$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */