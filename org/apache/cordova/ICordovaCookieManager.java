package org.apache.cordova;

public interface ICordovaCookieManager {
  void clearCookies();
  
  void flush();
  
  String getCookie(String paramString);
  
  void setCookie(String paramString1, String paramString2);
  
  void setCookiesEnabled(boolean paramBoolean);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\ICordovaCookieManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */