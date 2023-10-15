package androidx.core.text.util;

class ZipRange {
  int mException1;
  
  int mException2;
  
  int mHigh;
  
  int mLow;
  
  ZipRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mLow = paramInt1;
    this.mHigh = paramInt2;
    this.mException1 = paramInt3;
    this.mException2 = paramInt4;
  }
  
  boolean matches(String paramString) {
    boolean bool = false;
    int i = Integer.parseInt(paramString.substring(0, 2));
    if ((this.mLow <= i && i <= this.mHigh) || i == this.mException1 || i == this.mException2)
      bool = true; 
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\tex\\util\FindAddress$ZipRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */