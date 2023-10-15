package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
  private final long zza;
  
  @KeepForSdk
  public NativeOnCompleteListener(long paramLong) {
    this.zza = paramLong;
  }
  
  @KeepForSdk
  public static void createAndAddCallback(@NonNull Task<Object> paramTask, long paramLong) {
    paramTask.addOnCompleteListener(new NativeOnCompleteListener(paramLong));
  }
  
  @KeepForSdk
  public native void nativeOnComplete(long paramLong, @Nullable Object paramObject, boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString);
  
  @KeepForSdk
  public void onComplete(@NonNull Task<Object> paramTask) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual isSuccessful : ()Z
    //   4: ifeq -> 17
    //   7: aload_1
    //   8: invokevirtual getResult : ()Ljava/lang/Object;
    //   11: astore_2
    //   12: aconst_null
    //   13: astore_3
    //   14: goto -> 47
    //   17: aload_1
    //   18: invokevirtual isCanceled : ()Z
    //   21: ifne -> 43
    //   24: aload_1
    //   25: invokevirtual getException : ()Ljava/lang/Exception;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 43
    //   33: aload_2
    //   34: invokevirtual getMessage : ()Ljava/lang/String;
    //   37: astore_3
    //   38: aconst_null
    //   39: astore_2
    //   40: goto -> 47
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_2
    //   46: astore_3
    //   47: aload_0
    //   48: aload_0
    //   49: getfield zza : J
    //   52: aload_2
    //   53: aload_1
    //   54: invokevirtual isSuccessful : ()Z
    //   57: aload_1
    //   58: invokevirtual isCanceled : ()Z
    //   61: aload_3
    //   62: invokevirtual nativeOnComplete : (JLjava/lang/Object;ZZLjava/lang/String;)V
    //   65: return
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\NativeOnCompleteListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */