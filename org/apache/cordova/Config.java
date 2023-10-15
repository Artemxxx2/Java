package org.apache.cordova;

import android.app.Activity;
import android.content.Context;
import java.util.List;

@Deprecated
public class Config {
  private static final String TAG = "Config";
  
  static ConfigXmlParser parser;
  
  public static String getErrorUrl() {
    return parser.getPreferences().getString("errorurl", null);
  }
  
  public static List<PluginEntry> getPluginEntries() {
    return parser.getPluginEntries();
  }
  
  public static CordovaPreferences getPreferences() {
    return parser.getPreferences();
  }
  
  public static String getStartUrl() {
    ConfigXmlParser configXmlParser = parser;
    return (configXmlParser == null) ? "file:///android_asset/www/index.html" : configXmlParser.getLaunchUrl();
  }
  
  public static void init() {
    if (parser == null)
      parser = new ConfigXmlParser(); 
  }
  
  public static void init(Activity paramActivity) {
    parser = new ConfigXmlParser();
    parser.parse((Context)paramActivity);
    parser.getPreferences().setPreferencesBundle(paramActivity.getIntent().getExtras());
  }
  
  public static boolean isInitialized() {
    boolean bool;
    if (parser != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */