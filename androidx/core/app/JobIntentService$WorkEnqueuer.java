package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;

abstract class WorkEnqueuer {
  final ComponentName mComponentName;
  
  boolean mHasJobId;
  
  int mJobId;
  
  WorkEnqueuer(ComponentName paramComponentName) {
    this.mComponentName = paramComponentName;
  }
  
  abstract void enqueueWork(Intent paramIntent);
  
  void ensureJobId(int paramInt) {
    if (!this.mHasJobId) {
      this.mHasJobId = true;
      this.mJobId = paramInt;
    } else if (this.mJobId != paramInt) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Given job ID ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" is different than previous ");
      stringBuilder.append(this.mJobId);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public void serviceProcessingFinished() {}
  
  public void serviceProcessingStarted() {}
  
  public void serviceStartReceived() {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$WorkEnqueuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */