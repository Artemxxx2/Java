package androidx.core.provider;

import android.provider.BaseColumns;

public final class Columns implements BaseColumns {
  public static final String FILE_ID = "file_id";
  
  public static final String ITALIC = "font_italic";
  
  public static final String RESULT_CODE = "result_code";
  
  public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
  
  public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
  
  public static final int RESULT_CODE_MALFORMED_QUERY = 3;
  
  public static final int RESULT_CODE_OK = 0;
  
  public static final String TTC_INDEX = "font_ttc_index";
  
  public static final String VARIATION_SETTINGS = "font_variation_settings";
  
  public static final String WEIGHT = "font_weight";
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$Columns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */