package androidx.core.app;

import android.content.Intent;

final class CompatWorkItem implements JobIntentService.GenericWorkItem {
  final Intent mIntent;
  
  final int mStartId;
  
  CompatWorkItem(Intent paramIntent, int paramInt) {
    this.mIntent = paramIntent;
    this.mStartId = paramInt;
  }
  
  public void complete() {
    JobIntentService.this.stopSelf(this.mStartId);
  }
  
  public Intent getIntent() {
    return this.mIntent;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$CompatWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */