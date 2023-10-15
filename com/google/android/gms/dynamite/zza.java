package com.google.android.gms.dynamite;

import android.os.Process;

final class zza extends Thread {
  zza(ThreadGroup paramThreadGroup, String paramString) {
    super(paramThreadGroup, "GmsDynamite");
  }
  
  public final void run() {
    Exception exception;
    Process.setThreadPriority(19);
    /* monitor enter ThisExpression{ObjectType{com/google/android/gms/dynamite/zza}} */
    try {
      while (true)
        wait(); 
    } catch (InterruptedException null) {
      /* monitor exit ThisExpression{ObjectType{com/google/android/gms/dynamite/zza}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/google/android/gms/dynamite/zza}} */
    throw exception;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */