package org.apache.cordova.whitelist;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.LOG;
import org.apache.cordova.Whitelist;
import org.xmlpull.v1.XmlPullParser;

class CustomConfigXmlParser extends ConfigXmlParser {
  private CustomConfigXmlParser() {}
  
  public void handleEndTag(XmlPullParser paramXmlPullParser) {}
  
  public void handleStartTag(XmlPullParser paramXmlPullParser) {
    String str1;
    String str2 = paramXmlPullParser.getName();
    if (str2.equals("content")) {
      str1 = paramXmlPullParser.getAttributeValue(null, "src");
      WhitelistPlugin.access$100(WhitelistPlugin.this).addWhiteListEntry(str1, false);
    } else if (str2.equals("allow-navigation")) {
      str1 = str1.getAttributeValue(null, "href");
      if ("*".equals(str1)) {
        WhitelistPlugin.access$100(WhitelistPlugin.this).addWhiteListEntry("http://*/*", false);
        WhitelistPlugin.access$100(WhitelistPlugin.this).addWhiteListEntry("https://*/*", false);
        WhitelistPlugin.access$100(WhitelistPlugin.this).addWhiteListEntry("data:*", false);
      } else {
        WhitelistPlugin.access$100(WhitelistPlugin.this).addWhiteListEntry(str1, false);
      } 
    } else if (str2.equals("allow-intent")) {
      str1 = str1.getAttributeValue(null, "href");
      WhitelistPlugin.access$200(WhitelistPlugin.this).addWhiteListEntry(str1, false);
    } else if (str2.equals("access")) {
      boolean bool3;
      str2 = str1.getAttributeValue(null, "origin");
      String str = str1.getAttributeValue(null, "subdomains");
      str1 = str1.getAttributeValue(null, "launch-external");
      boolean bool1 = true;
      boolean bool2 = true;
      if (str1 != null) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (str2 != null)
        if (bool3) {
          LOG.w("WhitelistPlugin", "Found <access launch-external> within config.xml. Please use <allow-intent> instead.");
          Whitelist whitelist = WhitelistPlugin.access$200(WhitelistPlugin.this);
          if (str == null || str.compareToIgnoreCase("true") != 0)
            bool2 = false; 
          whitelist.addWhiteListEntry(str2, bool2);
        } else if ("*".equals(str2)) {
          WhitelistPlugin.access$300(WhitelistPlugin.this).addWhiteListEntry("http://*/*", false);
          WhitelistPlugin.access$300(WhitelistPlugin.this).addWhiteListEntry("https://*/*", false);
        } else {
          Whitelist whitelist = WhitelistPlugin.access$300(WhitelistPlugin.this);
          if (str != null && str.compareToIgnoreCase("true") == 0) {
            bool2 = bool1;
          } else {
            bool2 = false;
          } 
          whitelist.addWhiteListEntry(str2, bool2);
        }  
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\whitelist\WhitelistPlugin$CustomConfigXmlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */