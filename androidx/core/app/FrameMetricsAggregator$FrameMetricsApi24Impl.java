package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RequiresApi(24)
class FrameMetricsApi24Impl extends FrameMetricsAggregator.FrameMetricsBaseImpl {
  private static final int NANOS_PER_MS = 1000000;
  
  private static final int NANOS_ROUNDING_VALUE = 500000;
  
  private static Handler sHandler;
  
  private static HandlerThread sHandlerThread;
  
  private ArrayList<WeakReference<Activity>> mActivities = new ArrayList<WeakReference<Activity>>();
  
  Window.OnFrameMetricsAvailableListener mListener = new Window.OnFrameMetricsAvailableListener() {
      public void onFrameMetricsAvailable(Window param2Window, FrameMetrics param2FrameMetrics, int param2Int) {
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x1) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[0], param2FrameMetrics.getMetric(8));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x2) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[1], param2FrameMetrics.getMetric(1));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x4) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[2], param2FrameMetrics.getMetric(3));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x8) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[3], param2FrameMetrics.getMetric(4));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x10) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[4], param2FrameMetrics.getMetric(5));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x40) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[6], param2FrameMetrics.getMetric(7));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x20) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[5], param2FrameMetrics.getMetric(6));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x80) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[7], param2FrameMetrics.getMetric(0));
        } 
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x100) != 0) {
          FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[8], param2FrameMetrics.getMetric(2));
        } 
      }
    };
  
  SparseIntArray[] mMetrics = new SparseIntArray[9];
  
  int mTrackingFlags;
  
  FrameMetricsApi24Impl(int paramInt) {
    this.mTrackingFlags = paramInt;
  }
  
  public void add(Activity paramActivity) {
    if (sHandlerThread == null) {
      sHandlerThread = new HandlerThread("FrameMetricsAggregator");
      sHandlerThread.start();
      sHandler = new Handler(sHandlerThread.getLooper());
    } 
    for (byte b = 0; b <= 8; b++) {
      SparseIntArray[] arrayOfSparseIntArray = this.mMetrics;
      if (arrayOfSparseIntArray[b] == null && (this.mTrackingFlags & 1 << b) != 0)
        arrayOfSparseIntArray[b] = new SparseIntArray(); 
    } 
    paramActivity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
    this.mActivities.add(new WeakReference<Activity>(paramActivity));
  }
  
  void addDurationItem(SparseIntArray paramSparseIntArray, long paramLong) {
    if (paramSparseIntArray != null) {
      int i = (int)((500000L + paramLong) / 1000000L);
      if (paramLong >= 0L)
        paramSparseIntArray.put(i, paramSparseIntArray.get(i) + 1); 
    } 
  }
  
  public SparseIntArray[] getMetrics() {
    return this.mMetrics;
  }
  
  public SparseIntArray[] remove(Activity paramActivity) {
    for (WeakReference<Activity> weakReference : this.mActivities) {
      if (weakReference.get() == paramActivity) {
        this.mActivities.remove(weakReference);
        break;
      } 
    } 
    paramActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
    return this.mMetrics;
  }
  
  public SparseIntArray[] reset() {
    SparseIntArray[] arrayOfSparseIntArray = this.mMetrics;
    this.mMetrics = new SparseIntArray[9];
    return arrayOfSparseIntArray;
  }
  
  public SparseIntArray[] stop() {
    for (int i = this.mActivities.size() - 1; i >= 0; i--) {
      WeakReference<Activity> weakReference = this.mActivities.get(i);
      Activity activity = weakReference.get();
      if (weakReference.get() != null) {
        activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
        this.mActivities.remove(i);
      } 
    } 
    return this.mMetrics;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\FrameMetricsAggregator$FrameMetricsApi24Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */