package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public abstract class CancellationToken {
  public abstract boolean isCancellationRequested();
  
  @NonNull
  public abstract CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener paramOnTokenCanceledListener);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\CancellationToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */