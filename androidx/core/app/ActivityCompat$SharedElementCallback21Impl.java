package androidx.core.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
class SharedElementCallback21Impl extends SharedElementCallback {
  private final SharedElementCallback mCallback;
  
  SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback) {
    this.mCallback = paramSharedElementCallback;
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF) {
    return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable) {
    return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {
    this.mCallback.onMapSharedElements(paramList, paramMap);
  }
  
  public void onRejectSharedElements(List<View> paramList) {
    this.mCallback.onRejectSharedElements(paramList);
  }
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {
    this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
  }
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {
    this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
  }
  
  @RequiresApi(23)
  public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener listener) {
    this.mCallback.onSharedElementsArrived(paramList, paramList1, new SharedElementCallback.OnSharedElementsReadyListener() {
          public void onSharedElementsReady() {
            listener.onSharedElementsReady();
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityCompat$SharedElementCallback21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */