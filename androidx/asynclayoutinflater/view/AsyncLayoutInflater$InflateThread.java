package androidx.asynclayoutinflater.view;

import android.os.Message;
import android.util.Log;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

class InflateThread extends Thread {
  private static final InflateThread sInstance = new InflateThread();
  
  private ArrayBlockingQueue<AsyncLayoutInflater.InflateRequest> mQueue = new ArrayBlockingQueue<AsyncLayoutInflater.InflateRequest>(10);
  
  private Pools.SynchronizedPool<AsyncLayoutInflater.InflateRequest> mRequestPool = new Pools.SynchronizedPool(10);
  
  static {
    sInstance.start();
  }
  
  public static InflateThread getInstance() {
    return sInstance;
  }
  
  public void enqueue(AsyncLayoutInflater.InflateRequest paramInflateRequest) {
    try {
      this.mQueue.put(paramInflateRequest);
      return;
    } catch (InterruptedException interruptedException) {
      throw new RuntimeException("Failed to enqueue async inflate request", interruptedException);
    } 
  }
  
  public AsyncLayoutInflater.InflateRequest obtainRequest() {
    AsyncLayoutInflater.InflateRequest inflateRequest1 = (AsyncLayoutInflater.InflateRequest)this.mRequestPool.acquire();
    AsyncLayoutInflater.InflateRequest inflateRequest2 = inflateRequest1;
    if (inflateRequest1 == null)
      inflateRequest2 = new AsyncLayoutInflater.InflateRequest(); 
    return inflateRequest2;
  }
  
  public void releaseRequest(AsyncLayoutInflater.InflateRequest paramInflateRequest) {
    paramInflateRequest.callback = null;
    paramInflateRequest.inflater = null;
    paramInflateRequest.parent = null;
    paramInflateRequest.resid = 0;
    paramInflateRequest.view = null;
    this.mRequestPool.release(paramInflateRequest);
  }
  
  public void run() {
    while (true)
      runInner(); 
  }
  
  public void runInner() {
    try {
      AsyncLayoutInflater.InflateRequest inflateRequest = this.mQueue.take();
      try {
        inflateRequest.view = inflateRequest.inflater.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
      } catch (RuntimeException runtimeException) {
        Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", runtimeException);
      } 
      Message.obtain(inflateRequest.inflater.mHandler, 0, inflateRequest).sendToTarget();
      return;
    } catch (InterruptedException interruptedException) {
      Log.w("AsyncLayoutInflater", interruptedException);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\asynclayoutinflater\view\AsyncLayoutInflater$InflateThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */