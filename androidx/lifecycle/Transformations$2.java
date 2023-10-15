package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

final class null implements Observer<X> {
  LiveData<Y> mSource;
  
  public void onChanged(@Nullable X paramX) {
    LiveData<Y> liveData2 = (LiveData)switchMapFunction.apply(paramX);
    LiveData<Y> liveData1 = this.mSource;
    if (liveData1 == liveData2)
      return; 
    if (liveData1 != null)
      result.removeSource(liveData1); 
    this.mSource = liveData2;
    liveData1 = this.mSource;
    if (liveData1 != null)
      result.addSource(liveData1, new Observer() {
            public void onChanged(@Nullable Y param2Y) {
              result.setValue(param2Y);
            }
          }); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\Transformations$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */