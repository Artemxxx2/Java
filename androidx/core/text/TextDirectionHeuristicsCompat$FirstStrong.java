package androidx.core.text;

class FirstStrong implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
  static final FirstStrong INSTANCE = new FirstStrong();
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    int i = 2;
    for (int j = paramInt1; j < paramInt2 + paramInt1 && i == 2; j++)
      i = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(paramCharSequence.charAt(j))); 
    return i;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\TextDirectionHeuristicsCompat$FirstStrong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */