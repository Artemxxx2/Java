package android.support.v4.os;

import android.os.Bundle;

class MyRunnable implements Runnable {
  final int mResultCode;
  
  final Bundle mResultData;
  
  MyRunnable(int paramInt, Bundle paramBundle) {
    this.mResultCode = paramInt;
    this.mResultData = paramBundle;
  }
  
  public void run() {
    ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\os\ResultReceiver$MyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */