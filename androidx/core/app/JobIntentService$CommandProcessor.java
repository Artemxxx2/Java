package androidx.core.app;

import android.os.AsyncTask;

final class CommandProcessor extends AsyncTask<Void, Void, Void> {
  protected Void doInBackground(Void... paramVarArgs) {
    while (true) {
      JobIntentService.GenericWorkItem genericWorkItem = JobIntentService.this.dequeueWork();
      if (genericWorkItem != null) {
        JobIntentService.this.onHandleWork(genericWorkItem.getIntent());
        genericWorkItem.complete();
        continue;
      } 
      return null;
    } 
  }
  
  protected void onCancelled(Void paramVoid) {
    JobIntentService.this.processorFinished();
  }
  
  protected void onPostExecute(Void paramVoid) {
    JobIntentService.this.processorFinished();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$CommandProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */