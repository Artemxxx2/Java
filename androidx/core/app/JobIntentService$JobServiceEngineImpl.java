package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class JobServiceEngineImpl extends JobServiceEngine implements JobIntentService.CompatJobEngine {
  static final boolean DEBUG = false;
  
  static final String TAG = "JobServiceEngineImpl";
  
  final Object mLock = new Object();
  
  JobParameters mParams;
  
  final JobIntentService mService;
  
  JobServiceEngineImpl(JobIntentService paramJobIntentService) {
    super(paramJobIntentService);
    this.mService = paramJobIntentService;
  }
  
  public IBinder compatGetBinder() {
    return getBinder();
  }
  
  public JobIntentService.GenericWorkItem dequeueWork() {
    synchronized (this.mLock) {
      if (this.mParams == null)
        return null; 
      JobWorkItem jobWorkItem = this.mParams.dequeueWork();
      if (jobWorkItem != null) {
        jobWorkItem.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
        return new WrapperWorkItem(jobWorkItem);
      } 
      return null;
    } 
  }
  
  public boolean onStartJob(JobParameters paramJobParameters) {
    this.mParams = paramJobParameters;
    this.mService.ensureProcessorRunningLocked(false);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters) {
    boolean bool = this.mService.doStopCurrentWork();
    synchronized (this.mLock) {
      this.mParams = null;
      return bool;
    } 
  }
  
  final class WrapperWorkItem implements JobIntentService.GenericWorkItem {
    final JobWorkItem mJobWork;
    
    WrapperWorkItem(JobWorkItem param2JobWorkItem) {
      this.mJobWork = param2JobWorkItem;
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
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$JobServiceEngineImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */