package by.chemerisuk.cordova;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import org.apache.cordova.CallbackContext;

class null implements OnCompleteListener<ReviewInfo> {
  public void onComplete(Task<ReviewInfo> paramTask) {
    if (paramTask.isSuccessful()) {
      manager.launchReviewFlow(activity, (ReviewInfo)paramTask.getResult()).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> param2Task) {
              if (param2Task.isSuccessful()) {
                callbackContext.success();
              } else {
                AppReviewPlugin.access$000(AppReviewPlugin.this, param2Task.getException(), callbackContext);
              } 
            }
          });
    } else {
      AppReviewPlugin.access$000(AppReviewPlugin.this, paramTask.getException(), callbackContext);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\by\chemerisuk\cordova\AppReviewPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */