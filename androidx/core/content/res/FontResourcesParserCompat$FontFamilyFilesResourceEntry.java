package androidx.core.content.res;

import androidx.annotation.NonNull;

public final class FontFamilyFilesResourceEntry implements FontResourcesParserCompat.FamilyResourceEntry {
  @NonNull
  private final FontResourcesParserCompat.FontFileResourceEntry[] mEntries;
  
  public FontFamilyFilesResourceEntry(@NonNull FontResourcesParserCompat.FontFileResourceEntry[] paramArrayOfFontFileResourceEntry) {
    this.mEntries = paramArrayOfFontFileResourceEntry;
  }
  
  @NonNull
  public FontResourcesParserCompat.FontFileResourceEntry[] getEntries() {
    return this.mEntries;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\res\FontResourcesParserCompat$FontFamilyFilesResourceEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */