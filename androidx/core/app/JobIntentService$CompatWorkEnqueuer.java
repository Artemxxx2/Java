package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

final class CompatWorkEnqueuer extends JobIntentService.WorkEnqueuer {
  private final Context mContext;
  
  private final PowerManager.WakeLock mLaunchWakeLock;
  
  boolean mLaunchingService;
  
  private final PowerManager.WakeLock mRunWakeLock;
  
  boolean mServiceProcessing;
  
  CompatWorkEnqueuer(Context paramContext, ComponentName paramComponentName) {
    super(paramComponentName);
    this.mContext = paramContext.getApplicationContext();
    PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramComponentName.getClassName());
    stringBuilder.append(":launch");
    this.mLaunchWakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
    this.mLaunchWakeLock.setReferenceCounted(false);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramComponentName.getClassName());
    stringBuilder.append(":run");
    this.mRunWakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
    this.mRunWakeLock.setReferenceCounted(false);
  }
  
  void enqueueWork(Intent paramIntent) {
    // Byte code:
    //   0: new android/content/Intent
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Landroid/content/Intent;)V
    //   8: astore_1
    //   9: aload_1
    //   10: aload_0
    //   11: getfield mComponentName : Landroid/content/ComponentName;
    //   14: invokevirtual setComponent : (Landroid/content/ComponentName;)Landroid/content/Intent;
    //   17: pop
    //   18: aload_0
    //   19: getfield mContext : Landroid/content/Context;
    //   22: aload_1
    //   23: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
    //   26: ifnull -> 70
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield mLaunchingService : Z
    //   35: ifne -> 60
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield mLaunchingService : Z
    //   43: aload_0
    //   44: getfield mServiceProcessing : Z
    //   47: ifne -> 60
    //   50: aload_0
    //   51: getfield mLaunchWakeLock : Landroid/os/PowerManager$WakeLock;
    //   54: ldc2_w 60000
    //   57: invokevirtual acquire : (J)V
    //   60: aload_0
    //   61: monitorexit
    //   62: goto -> 70
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: return
    // Exception table:
    //   from	to	target	type
    //   31	60	65	finally
    //   60	62	65	finally
    //   66	68	65	finally
  }
  
  public void serviceProcessingFinished() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mServiceProcessing : Z
    //   6: ifeq -> 38
    //   9: aload_0
    //   10: getfield mLaunchingService : Z
    //   13: ifeq -> 26
    //   16: aload_0
    //   17: getfield mLaunchWakeLock : Landroid/os/PowerManager$WakeLock;
    //   20: ldc2_w 60000
    //   23: invokevirtual acquire : (J)V
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield mServiceProcessing : Z
    //   31: aload_0
    //   32: getfield mRunWakeLock : Landroid/os/PowerManager$WakeLock;
    //   35: invokevirtual release : ()V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	41	finally
    //   26	38	41	finally
    //   38	40	41	finally
    //   42	44	41	finally
  }
  
  public void serviceProcessingStarted() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mServiceProcessing : Z
    //   6: ifne -> 31
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield mServiceProcessing : Z
    //   14: aload_0
    //   15: getfield mRunWakeLock : Landroid/os/PowerManager$WakeLock;
    //   18: ldc2_w 600000
    //   21: invokevirtual acquire : (J)V
    //   24: aload_0
    //   25: getfield mLaunchWakeLock : Landroid/os/PowerManager$WakeLock;
    //   28: invokevirtual release : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
    //   31	33	34	finally
    //   35	37	34	finally
  }
  
  public void serviceStartReceived() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield mLaunchingService : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	10	finally
    //   11	13	10	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\JobIntentService$CompatWorkEnqueuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */