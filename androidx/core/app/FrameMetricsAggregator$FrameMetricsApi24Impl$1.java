package androidx.core.app;

import android.view.FrameMetrics;
import android.view.Window;

class null implements Window.OnFrameMetricsAvailableListener {
  public void onFrameMetricsAvailable(Window paramWindow, FrameMetrics paramFrameMetrics, int paramInt) {
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x1) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[0], paramFrameMetrics.getMetric(8));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x2) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[1], paramFrameMetrics.getMetric(1));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x4) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[2], paramFrameMetrics.getMetric(3));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x8) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[3], paramFrameMetrics.getMetric(4));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x10) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[4], paramFrameMetrics.getMetric(5));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x40) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[6], paramFrameMetrics.getMetric(7));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x20) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[5], paramFrameMetrics.getMetric(6));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x80) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[7], paramFrameMetrics.getMetric(0));
    } 
    if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x100) != 0) {
      FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
      frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[8], paramFrameMetrics.getMetric(2));
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\FrameMetricsAggregator$FrameMetricsApi24Impl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */