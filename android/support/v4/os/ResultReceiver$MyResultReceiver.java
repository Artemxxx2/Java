package android.support.v4.os;

import android.os.Bundle;

class MyResultReceiver extends IResultReceiver.Stub {
  public void send(int paramInt, Bundle paramBundle) {
    if (ResultReceiver.this.mHandler != null) {
      ResultReceiver.this.mHandler.post(new ResultReceiver.MyRunnable(ResultReceiver.this, paramInt, paramBundle));
    } else {
      ResultReceiver.this.onReceiveResult(paramInt, paramBundle);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\os\ResultReceiver$MyResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */