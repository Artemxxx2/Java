package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class InternalHandler extends Handler {
  InternalHandler() {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage) {
    ModernAsyncTask.AsyncTaskResult asyncTaskResult = (ModernAsyncTask.AsyncTaskResult)paramMessage.obj;
    switch (paramMessage.what) {
      default:
        return;
      case 2:
        asyncTaskResult.mTask.onProgressUpdate((Object[])asyncTaskResult.mData);
      case 1:
        break;
    } 
    asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$InternalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */