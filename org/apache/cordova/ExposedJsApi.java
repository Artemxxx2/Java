package org.apache.cordova;

import org.json.JSONException;

public interface ExposedJsApi {
  String exec(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) throws JSONException, IllegalAccessException;
  
  String retrieveJsMessages(int paramInt, boolean paramBoolean) throws IllegalAccessException;
  
  void setNativeToJsBridgeMode(int paramInt1, int paramInt2) throws IllegalAccessException;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\ExposedJsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */