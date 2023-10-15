package androidx.core.provider;

import java.util.Comparator;

final class null implements Comparator<byte[]> {
  public int compare(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte1.length != paramArrayOfbyte2.length)
      return paramArrayOfbyte1.length - paramArrayOfbyte2.length; 
    for (byte b = 0; b < paramArrayOfbyte1.length; b++) {
      if (paramArrayOfbyte1[b] != paramArrayOfbyte2[b])
        return paramArrayOfbyte1[b] - paramArrayOfbyte2[b]; 
    } 
    return 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */