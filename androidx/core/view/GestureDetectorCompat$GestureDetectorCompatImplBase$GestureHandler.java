package androidx.core.view;

import android.os.Handler;
import android.os.Message;

class GestureHandler extends Handler {
  GestureHandler() {}
  
  GestureHandler(Handler paramHandler) {
    super(paramHandler.getLooper());
  }
  
  public void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    switch (paramMessage.what) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown message ");
        stringBuilder.append(paramMessage);
        throw new RuntimeException(stringBuilder.toString());
      case 3:
        if (GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener != null)
          if (!GestureDetectorCompat.GestureDetectorCompatImplBase.this.mStillDown) {
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
          } else {
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
          }  
        return;
      case 2:
        GestureDetectorCompat.GestureDetectorCompatImplBase.this.dispatchLongPress();
        return;
      case 1:
        break;
    } 
    GestureDetectorCompat.GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */