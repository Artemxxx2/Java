package org.apache.cordova.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.util.Arrays;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

public class StatusBar extends CordovaPlugin {
  private static final String TAG = "StatusBar";
  
  private void setStatusBarBackgroundColor(String paramString) {
    if (Build.VERSION.SDK_INT >= 21 && paramString != null && !paramString.isEmpty()) {
      Window window = this.cordova.getActivity().getWindow();
      window.clearFlags(67108864);
      window.addFlags(-2147483648);
      try {
        window.getClass().getMethod("setStatusBarColor", new Class[] { int.class }).invoke(window, new Object[] { Integer.valueOf(Color.parseColor(paramString)) });
      } catch (IllegalArgumentException illegalArgumentException) {
        LOG.e("StatusBar", "Invalid hexString argument, use f.i. '#999999'");
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Method window.setStatusBarColor not found for SDK level ");
        stringBuilder.append(Build.VERSION.SDK_INT);
        LOG.w("StatusBar", stringBuilder.toString());
      } 
    } 
  }
  
  private void setStatusBarStyle(String paramString) {
    if (Build.VERSION.SDK_INT >= 23 && paramString != null && !paramString.isEmpty()) {
      View view = this.cordova.getActivity().getWindow().getDecorView();
      int i = view.getSystemUiVisibility();
      if (Arrays.<String>asList(new String[] { "default" }).contains(paramString.toLowerCase())) {
        view.setSystemUiVisibility(i | 0x2000);
        return;
      } 
      if (Arrays.<String>asList(new String[] { "lightcontent", "blacktranslucent", "blackopaque" }).contains(paramString.toLowerCase())) {
        view.setSystemUiVisibility(i & 0xFFFFDFFF);
        return;
      } 
      LOG.e("StatusBar", "Invalid style, must be either 'default', 'lightcontent' or the deprecated 'blacktranslucent' and 'blackopaque'");
    } 
  }
  
  private void setStatusBarTransparent(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = this.cordova.getActivity().getWindow();
      if (paramBoolean) {
        window.getDecorView().setSystemUiVisibility(1280);
        window.setStatusBarColor(0);
      } else {
        window.getDecorView().setSystemUiVisibility(256);
      } 
    } 
  }
  
  public boolean execute(String paramString, final CordovaArgs args, CallbackContext paramCallbackContext) throws JSONException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Executing action: ");
    stringBuilder.append(paramString);
    LOG.v("StatusBar", stringBuilder.toString());
    final Window window = this.cordova.getActivity().getWindow();
    boolean bool = "_ready".equals(paramString);
    boolean bool1 = false;
    if (bool) {
      if (((window.getAttributes()).flags & 0x400) == 0)
        bool1 = true; 
      paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool1));
      return true;
    } 
    if ("show".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              if (Build.VERSION.SDK_INT >= 19) {
                int i = window.getDecorView().getSystemUiVisibility();
                window.getDecorView().setSystemUiVisibility(i & 0xFFFFFBFF & 0xFFFFFFFB);
              } 
              window.clearFlags(1024);
            }
          });
      return true;
    } 
    if ("hide".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              if (Build.VERSION.SDK_INT >= 19) {
                int i = window.getDecorView().getSystemUiVisibility();
                window.getDecorView().setSystemUiVisibility(i | 0x400 | 0x4);
              } 
              window.addFlags(1024);
            }
          });
      return true;
    } 
    if ("backgroundColorByHexString".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              try {
                StatusBar.this.setStatusBarBackgroundColor(args.getString(0));
              } catch (JSONException jSONException) {
                LOG.e("StatusBar", "Invalid hexString argument, use f.i. '#777777'");
              } 
            }
          });
      return true;
    } 
    if ("overlaysWebView".equals(paramString)) {
      if (Build.VERSION.SDK_INT >= 21) {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
              public void run() {
                try {
                  StatusBar.this.setStatusBarTransparent(args.getBoolean(0));
                } catch (JSONException jSONException) {
                  LOG.e("StatusBar", "Invalid boolean argument");
                } 
              }
            });
        return true;
      } 
      return args.getBoolean(0) ^ true;
    } 
    if ("styleDefault".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              StatusBar.this.setStatusBarStyle("default");
            }
          });
      return true;
    } 
    if ("styleLightContent".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              StatusBar.this.setStatusBarStyle("lightcontent");
            }
          });
      return true;
    } 
    if ("styleBlackTranslucent".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              StatusBar.this.setStatusBarStyle("blacktranslucent");
            }
          });
      return true;
    } 
    if ("styleBlackOpaque".equals(paramString)) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              StatusBar.this.setStatusBarStyle("blackopaque");
            }
          });
      return true;
    } 
    return false;
  }
  
  public void initialize(final CordovaInterface cordova, CordovaWebView paramCordovaWebView) {
    LOG.v("StatusBar", "StatusBar: initialization");
    super.initialize(cordova, paramCordovaWebView);
    this.cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
            cordova.getActivity().getWindow().clearFlags(2048);
            StatusBar statusBar = StatusBar.this;
            statusBar.setStatusBarTransparent(statusBar.preferences.getBoolean("StatusBarOverlaysWebView", true));
            statusBar = StatusBar.this;
            statusBar.setStatusBarBackgroundColor(statusBar.preferences.getString("StatusBarBackgroundColor", "#000000"));
            String str = StatusBar.this.preferences.getString("StatusBarStyle", "lightcontent");
            if (str.equalsIgnoreCase("blacktranslucent") || str.equalsIgnoreCase("blackopaque")) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(str);
              stringBuilder.append(" is deprecated and will be removed in next major release, use lightcontent");
              LOG.w("StatusBar", stringBuilder.toString());
            } 
            StatusBar.this.setStatusBarStyle(str);
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\statusbar\StatusBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */