package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class DuplicateTaskCompletionException extends IllegalStateException {
  private DuplicateTaskCompletionException(String paramString, @Nullable Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  @NonNull
  public static IllegalStateException of(@NonNull Task<?> paramTask) {
    String str;
    if (!paramTask.isComplete())
      return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task."); 
    Exception exception = paramTask.getException();
    if (exception != null) {
      str = "failure";
    } else if (str.isSuccessful()) {
      str = "result ".concat(String.valueOf(String.valueOf(str.getResult())));
    } else if (str.isCanceled()) {
      str = "cancellation";
    } else {
      str = "unknown issue";
    } 
    return new DuplicateTaskCompletionException("Complete with: ".concat(str), exception);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\DuplicateTaskCompletionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */