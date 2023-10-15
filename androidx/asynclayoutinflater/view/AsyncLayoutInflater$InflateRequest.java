package androidx.asynclayoutinflater.view;

import android.view.View;
import android.view.ViewGroup;

class InflateRequest {
  AsyncLayoutInflater.OnInflateFinishedListener callback;
  
  AsyncLayoutInflater inflater;
  
  ViewGroup parent;
  
  int resid;
  
  View view;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\asynclayoutinflater\view\AsyncLayoutInflater$InflateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */