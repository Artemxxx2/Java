package androidx.core.graphics;

import androidx.core.provider.FontsContractCompat;

class null implements TypefaceCompatBaseImpl.StyleExtractor<FontsContractCompat.FontInfo> {
  public int getWeight(FontsContractCompat.FontInfo paramFontInfo) {
    return paramFontInfo.getWeight();
  }
  
  public boolean isItalic(FontsContractCompat.FontInfo paramFontInfo) {
    return paramFontInfo.isItalic();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\graphics\TypefaceCompatBaseImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */