package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface SuccessContinuation<TResult, TContinuationResult> {
  @NonNull
  Task<TContinuationResult> then(TResult paramTResult) throws Exception;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\SuccessContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */