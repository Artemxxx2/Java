package org.apache.cordova.device;

import android.os.Build;
import android.provider.Settings;
import java.util.TimeZone;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Device extends CordovaPlugin {
  private static final String AMAZON_DEVICE = "Amazon";
  
  private static final String AMAZON_PLATFORM = "amazon-fireos";
  
  private static final String ANDROID_PLATFORM = "Android";
  
  public static final String TAG = "Device";
  
  public static String platform;
  
  public static String uuid;
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    if ("getDeviceInfo".equals(paramString)) {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("uuid", uuid);
      jSONObject.put("version", getOSVersion());
      jSONObject.put("platform", getPlatform());
      jSONObject.put("model", getModel());
      jSONObject.put("manufacturer", getManufacturer());
      jSONObject.put("isVirtual", isVirtual());
      jSONObject.put("serial", getSerialNumber());
      jSONObject.put("sdkVersion", getSDKVersion());
      paramCallbackContext.success(jSONObject);
      return true;
    } 
    return false;
  }
  
  public String getManufacturer() {
    return Build.MANUFACTURER;
  }
  
  public String getModel() {
    return Build.MODEL;
  }
  
  public String getOSVersion() {
    return Build.VERSION.RELEASE;
  }
  
  public String getPlatform() {
    String str;
    if (isAmazonDevice()) {
      str = "amazon-fireos";
    } else {
      str = "Android";
    } 
    return str;
  }
  
  public String getProductName() {
    return Build.PRODUCT;
  }
  
  public String getSDKVersion() {
    return String.valueOf(Build.VERSION.SDK_INT);
  }
  
  public String getSerialNumber() {
    return Build.SERIAL;
  }
  
  public String getTimeZoneID() {
    return TimeZone.getDefault().getID();
  }
  
  public String getUuid() {
    return Settings.Secure.getString(this.cordova.getActivity().getContentResolver(), "android_id");
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView) {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    uuid = getUuid();
  }
  
  public boolean isAmazonDevice() {
    return Build.MANUFACTURER.equals("Amazon");
  }
  
  public boolean isVirtual() {
    return (Build.FINGERPRINT.contains("generic") || Build.PRODUCT.contains("sdk"));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\device\Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */