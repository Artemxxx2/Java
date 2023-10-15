package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public interface Continuation<TResult, TContinuationResult> {
  TContinuationResult then(@NonNull Task<TResult> paramTask) throws Exception;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\Continuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */