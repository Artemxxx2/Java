package androidx.core.provider;

import android.os.Handler;
import java.util.concurrent.Callable;

class null implements Runnable {
  public void run() {
    try {
      exception = (Exception)callable.call();
    } catch (Exception exception) {
      exception = null;
    } 
    callingHandler.post(new Runnable() {
          public void run() {
            reply.onReply(result);
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\SelfDestructiveThread$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */