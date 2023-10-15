package androidx.core.app;

import android.os.IBinder;

interface CompatJobEngine {
  IBinder compatGetBinder();
  
  JobIntentService.GenericWorkItem dequeueWork();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$CompatJobEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */