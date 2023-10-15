package androidx.core.text;

import java.util.Locale;

class TextDirectionHeuristicLocale extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
  static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
  
  TextDirectionHeuristicLocale() {
    super(null);
  }
  
  protected boolean defaultIsRtl() {
    int i = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault());
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */