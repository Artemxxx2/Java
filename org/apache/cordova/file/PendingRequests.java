package org.apache.cordova.file;

import android.util.SparseArray;
import org.apache.cordova.CallbackContext;

class PendingRequests {
  private int currentReqId = 0;
  
  private SparseArray<Request> requests = new SparseArray();
  
  public int createRequest(String paramString, int paramInt, CallbackContext paramCallbackContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new org/apache/cordova/file/PendingRequests$Request
    //   5: astore #4
    //   7: aload #4
    //   9: aload_0
    //   10: aload_1
    //   11: iload_2
    //   12: aload_3
    //   13: aconst_null
    //   14: invokespecial <init> : (Lorg/apache/cordova/file/PendingRequests;Ljava/lang/String;ILorg/apache/cordova/CallbackContext;Lorg/apache/cordova/file/PendingRequests$1;)V
    //   17: aload_0
    //   18: getfield requests : Landroid/util/SparseArray;
    //   21: aload #4
    //   23: invokestatic access$100 : (Lorg/apache/cordova/file/PendingRequests$Request;)I
    //   26: aload #4
    //   28: invokevirtual put : (ILjava/lang/Object;)V
    //   31: aload #4
    //   33: invokestatic access$100 : (Lorg/apache/cordova/file/PendingRequests$Request;)I
    //   36: istore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_2
    //   40: ireturn
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	41	finally
  }
  
  public Request getAndRemove(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield requests : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast org/apache/cordova/file/PendingRequests$Request
    //   13: astore_2
    //   14: aload_0
    //   15: getfield requests : Landroid/util/SparseArray;
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
  
  public class Request {
    private int action;
    
    private CallbackContext callbackContext;
    
    private String rawArgs;
    
    private int requestCode;
    
    private Request(String param1String, int param1Int, CallbackContext param1CallbackContext) {
      this.rawArgs = param1String;
      this.action = param1Int;
      this.callbackContext = param1CallbackContext;
      this.requestCode = PendingRequests.access$208(PendingRequests.this);
    }
    
    public int getAction() {
      return this.action;
    }
    
    public CallbackContext getCallbackContext() {
      return this.callbackContext;
    }
    
    public String getRawArgs() {
      return this.rawArgs;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\PendingRequests.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */