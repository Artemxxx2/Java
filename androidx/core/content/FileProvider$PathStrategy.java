package androidx.core.content;

import android.net.Uri;
import java.io.File;

interface PathStrategy {
  File getFileForUri(Uri paramUri);
  
  Uri getUriForFile(File paramFile);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\FileProvider$PathStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */