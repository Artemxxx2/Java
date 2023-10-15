package androidx.core.app;

import android.app.job.JobWorkItem;
import android.content.Intent;

final class WrapperWorkItem implements JobIntentService.GenericWorkItem {
  final JobWorkItem mJobWork;
  
  WrapperWorkItem(JobWorkItem paramJobWorkItem) {
    this.mJobWork = paramJobWorkItem;
  }
  
  public void complete() {
    synchronized (JobIntentService.JobServiceEngineImpl.this.mLock) {
      if (JobIntentService.JobServiceEngineImpl.this.mParams != null)
        JobIntentService.JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork); 
      return;
    } 
  }
  
  public Intent getIntent() {
    return this.mJobWork.getIntent();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$JobServiceEngineImpl$WrapperWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */