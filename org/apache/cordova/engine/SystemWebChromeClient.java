package org.apache.cordova.engine;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Arrays;
import org.apache.cordova.CordovaDialogsHelper;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

public class SystemWebChromeClient extends WebChromeClient {
  private static final int FILECHOOSER_RESULTCODE = 5173;
  
  private static final String LOG_TAG = "SystemWebChromeClient";
  
  private long MAX_QUOTA = 104857600L;
  
  private Context appContext;
  
  private CordovaDialogsHelper dialogsHelper;
  
  private View mCustomView;
  
  private WebChromeClient.CustomViewCallback mCustomViewCallback;
  
  private View mVideoProgressView;
  
  protected final SystemWebViewEngine parentEngine;
  
  public SystemWebChromeClient(SystemWebViewEngine paramSystemWebViewEngine) {
    this.parentEngine = paramSystemWebViewEngine;
    this.appContext = paramSystemWebViewEngine.webView.getContext();
    this.dialogsHelper = new CordovaDialogsHelper(this.appContext);
  }
  
  public void destroyLastDialog() {
    this.dialogsHelper.destroyLastDialog();
  }
  
  public View getVideoLoadingProgressView() {
    if (this.mVideoProgressView == null) {
      LinearLayout linearLayout = new LinearLayout(this.parentEngine.getView().getContext());
      linearLayout.setOrientation(1);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(13);
      linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      ProgressBar progressBar = new ProgressBar(this.parentEngine.getView().getContext());
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams1.gravity = 17;
      progressBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      linearLayout.addView((View)progressBar);
      this.mVideoProgressView = (View)linearLayout;
    } 
    return this.mVideoProgressView;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage) {
    if (paramConsoleMessage.message() != null)
      LOG.d("SystemWebChromeClient", "%s: Line %d : %s", new Object[] { paramConsoleMessage.sourceId(), Integer.valueOf(paramConsoleMessage.lineNumber()), paramConsoleMessage.message() }); 
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater) {
    LOG.d("SystemWebChromeClient", "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(paramLong3) });
    paramQuotaUpdater.updateQuota(this.MAX_QUOTA);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback) {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    paramCallback.invoke(paramString, true, false);
    CordovaPlugin cordovaPlugin = this.parentEngine.pluginManager.getPlugin("Geolocation");
    if (cordovaPlugin != null && !cordovaPlugin.hasPermisssion())
      cordovaPlugin.requestPermissions(0); 
  }
  
  public void onHideCustomView() {
    this.parentEngine.getCordovaWebView().hideCustomView();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, final JsResult result) {
    this.dialogsHelper.showAlert(paramString2, new CordovaDialogsHelper.Result() {
          public void gotResult(boolean param1Boolean, String param1String) {
            if (param1Boolean) {
              result.confirm();
            } else {
              result.cancel();
            } 
          }
        });
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, final JsResult result) {
    this.dialogsHelper.showConfirm(paramString2, new CordovaDialogsHelper.Result() {
          public void gotResult(boolean param1Boolean, String param1String) {
            if (param1Boolean) {
              result.confirm();
            } else {
              result.cancel();
            } 
          }
        });
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, final JsPromptResult result) {
    String str = this.parentEngine.bridge.promptOnJsPrompt(paramString1, paramString2, paramString3);
    if (str != null) {
      result.confirm(str);
    } else {
      this.dialogsHelper.showPrompt(paramString2, paramString3, new CordovaDialogsHelper.Result() {
            public void gotResult(boolean param1Boolean, String param1String) {
              if (param1Boolean) {
                result.confirm(param1String);
              } else {
                result.cancel();
              } 
            }
          });
    } 
    return true;
  }
  
  @TargetApi(21)
  public void onPermissionRequest(PermissionRequest paramPermissionRequest) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPermissionRequest: ");
    stringBuilder.append(Arrays.toString((Object[])paramPermissionRequest.getResources()));
    LOG.d("SystemWebChromeClient", stringBuilder.toString());
    paramPermissionRequest.grant(paramPermissionRequest.getResources());
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
    this.parentEngine.getCordovaWebView().showCustomView(paramView, paramCustomViewCallback);
  }
  
  @TargetApi(21)
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams) {
    Boolean bool = Boolean.valueOf(false);
    if (paramFileChooserParams.getMode() == 1)
      bool = Boolean.valueOf(true); 
    Intent intent = paramFileChooserParams.createIntent();
    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", bool);
    try {
      CordovaInterface cordovaInterface = this.parentEngine.cordova;
      CordovaPlugin cordovaPlugin = new CordovaPlugin() {
          public void onActivityResult(int param1Int1, int param1Int2, Intent param1Intent) {
            // Byte code:
            //   0: iload_2
            //   1: iconst_m1
            //   2: if_icmpne -> 147
            //   5: aload_3
            //   6: ifnull -> 147
            //   9: aload_3
            //   10: invokevirtual getClipData : ()Landroid/content/ClipData;
            //   13: ifnull -> 99
            //   16: aload_3
            //   17: invokevirtual getClipData : ()Landroid/content/ClipData;
            //   20: invokevirtual getItemCount : ()I
            //   23: istore_2
            //   24: iload_2
            //   25: anewarray android/net/Uri
            //   28: astore #4
            //   30: iconst_0
            //   31: istore_1
            //   32: aload #4
            //   34: astore #5
            //   36: iload_1
            //   37: iload_2
            //   38: if_icmpge -> 150
            //   41: aload #4
            //   43: iload_1
            //   44: aload_3
            //   45: invokevirtual getClipData : ()Landroid/content/ClipData;
            //   48: iload_1
            //   49: invokevirtual getItemAt : (I)Landroid/content/ClipData$Item;
            //   52: invokevirtual getUri : ()Landroid/net/Uri;
            //   55: aastore
            //   56: new java/lang/StringBuilder
            //   59: dup
            //   60: invokespecial <init> : ()V
            //   63: astore #5
            //   65: aload #5
            //   67: ldc 'Receive file chooser URL: '
            //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   72: pop
            //   73: aload #5
            //   75: aload #4
            //   77: iload_1
            //   78: aaload
            //   79: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   82: pop
            //   83: ldc 'SystemWebChromeClient'
            //   85: aload #5
            //   87: invokevirtual toString : ()Ljava/lang/String;
            //   90: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
            //   93: iinc #1, 1
            //   96: goto -> 32
            //   99: aload_3
            //   100: invokevirtual getData : ()Landroid/net/Uri;
            //   103: ifnull -> 147
            //   106: iload_2
            //   107: aload_3
            //   108: invokestatic parseResult : (ILandroid/content/Intent;)[Landroid/net/Uri;
            //   111: astore #5
            //   113: new java/lang/StringBuilder
            //   116: dup
            //   117: invokespecial <init> : ()V
            //   120: astore_3
            //   121: aload_3
            //   122: ldc 'Receive file chooser URL: '
            //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   127: pop
            //   128: aload_3
            //   129: aload #5
            //   131: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   134: pop
            //   135: ldc 'SystemWebChromeClient'
            //   137: aload_3
            //   138: invokevirtual toString : ()Ljava/lang/String;
            //   141: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
            //   144: goto -> 150
            //   147: aconst_null
            //   148: astore #5
            //   150: aload_0
            //   151: getfield val$filePathsCallback : Landroid/webkit/ValueCallback;
            //   154: aload #5
            //   156: invokeinterface onReceiveValue : (Ljava/lang/Object;)V
            //   161: return
          }
        };
      super(this, paramValueCallback);
      cordovaInterface.startActivityForResult(cordovaPlugin, intent, 5173);
    } catch (ActivityNotFoundException activityNotFoundException) {
      LOG.w("No activity found to handle file chooser intent.", (Throwable)activityNotFoundException);
      paramValueCallback.onReceiveValue(null);
    } 
    return true;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback) {
    openFileChooser(paramValueCallback, "*/*");
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString) {
    openFileChooser(paramValueCallback, paramString, null);
  }
  
  public void openFileChooser(final ValueCallback<Uri> uploadMsg, String paramString1, String paramString2) {
    Intent intent = new Intent("android.intent.action.GET_CONTENT");
    intent.addCategory("android.intent.category.OPENABLE");
    intent.setType("*/*");
    this.parentEngine.cordova.startActivityForResult(new CordovaPlugin() {
          public void onActivityResult(int param1Int1, int param1Int2, Intent param1Intent) {
            Uri uri;
            if (param1Intent == null || param1Int2 != -1) {
              param1Intent = null;
            } else {
              uri = param1Intent.getData();
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Receive file chooser URL: ");
            stringBuilder.append(uri);
            LOG.d("SystemWebChromeClient", stringBuilder.toString());
            uploadMsg.onReceiveValue(uri);
          }
        }intent, 5173);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */