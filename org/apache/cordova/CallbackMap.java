package org.apache.cordova;

import android.util.Pair;
import android.util.SparseArray;

public class CallbackMap {
  private SparseArray<Pair<CordovaPlugin, Integer>> callbacks = new SparseArray();
  
  private int currentCallbackId = 0;
  
  public Pair<CordovaPlugin, Integer> getAndRemoveCallback(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield callbacks : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast android/util/Pair
    //   13: astore_2
    //   14: aload_0
    //   15: getfield callbacks : Landroid/util/SparseArray;
    //   18: iload_1
    //   19: invokevirtual remove : (I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_2
    //   25: areturn
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	26	finally
  }
  
  public int registerCallback(CordovaPlugin paramCordovaPlugin, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield currentCallbackId : I
    //   6: istore_3
    //   7: aload_0
    //   8: iload_3
    //   9: iconst_1
    //   10: iadd
    //   11: putfield currentCallbackId : I
    //   14: aload_0
    //   15: getfield callbacks : Landroid/util/SparseArray;
    //   18: astore #4
    //   20: new android/util/Pair
    //   23: astore #5
    //   25: aload #5
    //   27: aload_1
    //   28: iload_2
    //   29: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   32: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   35: aload #4
    //   37: iload_3
    //   38: aload #5
    //   40: invokevirtual put : (ILjava/lang/Object;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_3
    //   46: ireturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	47	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CallbackMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */