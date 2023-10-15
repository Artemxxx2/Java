package androidx.core.provider;

import android.os.Handler;
import android.os.Message;

class null implements Handler.Callback {
  public boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return true;
      case 1:
        SelfDestructiveThread.this.onInvokeRunnable((Runnable)paramMessage.obj);
        return true;
      case 0:
        break;
    } 
    SelfDestructiveThread.this.onDestruction();
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\SelfDestructiveThread$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */