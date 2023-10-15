package by.chemerisuk.cordova;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

class null implements OnCompleteListener<Void> {
  public void onComplete(Task<Void> paramTask) {
    if (paramTask.isSuccessful()) {
      callbackContext.success();
    } else {
      AppReviewPlugin.access$000(this.this$1.this$0, paramTask.getException(), callbackContext);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\by\chemerisuk\cordova\AppReviewPlugin$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */