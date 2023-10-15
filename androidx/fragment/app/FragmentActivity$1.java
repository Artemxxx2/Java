package androidx.fragment.app;

import android.os.Handler;
import android.os.Message;

class null extends Handler {
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 2) {
      super.handleMessage(paramMessage);
    } else {
      FragmentActivity.this.onResumeFragments();
      FragmentActivity.this.mFragments.execPendingActions();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */