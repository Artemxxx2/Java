package by.chemerisuk.cordova;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import by.chemerisuk.cordova.support.CordovaMethod;
import by.chemerisuk.cordova.support.ReflectiveCordovaPlugin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import org.apache.cordova.CallbackContext;

public class AppReviewPlugin extends ReflectiveCordovaPlugin {
  @CordovaMethod
  private void openStoreScreen(String paramString, CallbackContext paramCallbackContext) {
    String str = paramString;
    if (paramString == null)
      str = this.cordova.getActivity().getPackageName(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("market://details?id=");
    stringBuilder.append(str);
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
    intent.addFlags(1208483840);
    this.cordova.getActivity().startActivity(intent);
    paramCallbackContext.success();
  }
  
  @CordovaMethod
  private void requestReview(final CallbackContext callbackContext) {
    final Activity activity = this.cordova.getActivity();
    final ReviewManager manager = ReviewManagerFactory.create((Context)activity);
    reviewManager.requestReviewFlow().addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
          public void onComplete(Task<ReviewInfo> param1Task) {
            if (param1Task.isSuccessful()) {
              manager.launchReviewFlow(activity, (ReviewInfo)param1Task.getResult()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(Task<Void> param2Task) {
                      if (param2Task.isSuccessful()) {
                        callbackContext.success();
                      } else {
                        AppReviewPlugin.this.respondWith(param2Task.getException(), callbackContext);
                      } 
                    }
                  });
            } else {
              AppReviewPlugin.this.respondWith(param1Task.getException(), callbackContext);
            } 
          }
        });
  }
  
  private void respondWith(Exception paramException, CallbackContext paramCallbackContext) {
    String str;
    if (paramException != null) {
      str = paramException.getMessage();
    } else {
      str = "Unknown error";
    } 
    paramCallbackContext.error(str);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\by\chemerisuk\cordova\AppReviewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */