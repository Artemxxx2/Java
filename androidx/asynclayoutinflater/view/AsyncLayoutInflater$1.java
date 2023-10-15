package androidx.asynclayoutinflater.view;

import android.os.Handler;
import android.os.Message;

class null implements Handler.Callback {
  public boolean handleMessage(Message paramMessage) {
    AsyncLayoutInflater.InflateRequest inflateRequest = (AsyncLayoutInflater.InflateRequest)paramMessage.obj;
    if (inflateRequest.view == null)
      inflateRequest.view = AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false); 
    inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
    AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\asynclayoutinflater\view\AsyncLayoutInflater$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */