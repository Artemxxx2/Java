package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class JobWorkEnqueuer extends JobIntentService.WorkEnqueuer {
  private final JobInfo mJobInfo;
  
  private final JobScheduler mJobScheduler;
  
  JobWorkEnqueuer(Context paramContext, ComponentName paramComponentName, int paramInt) {
    super(paramComponentName);
    ensureJobId(paramInt);
    this.mJobInfo = (new JobInfo.Builder(paramInt, this.mComponentName)).setOverrideDeadline(0L).build();
    this.mJobScheduler = (JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler");
  }
  
  void enqueueWork(Intent paramIntent) {
    this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(paramIntent));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$JobWorkEnqueuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */