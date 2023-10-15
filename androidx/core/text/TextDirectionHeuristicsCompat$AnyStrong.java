package androidx.core.text;

class AnyStrong implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
  static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
  
  private final boolean mLookForRtl;
  
  private AnyStrong(boolean paramBoolean) {
    this.mLookForRtl = paramBoolean;
  }
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    int i = 0;
    int j = paramInt1;
    while (true) {
      int k = j;
      if (k < paramInt2 + paramInt1) {
        switch (TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(paramCharSequence.charAt(k)))) {
          default:
            j = i;
            break;
          case 1:
            if (!this.mLookForRtl)
              return 1; 
            j = 1;
            break;
          case 0:
            if (this.mLookForRtl)
              return 0; 
            j = 1;
            break;
        } 
        k++;
        i = j;
        j = k;
        continue;
      } 
      return (i != 0) ? this.mLookForRtl : 2;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\TextDirectionHeuristicsCompat$AnyStrong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */