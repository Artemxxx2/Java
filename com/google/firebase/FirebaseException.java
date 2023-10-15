package com.google.firebase;

import androidx.annotation.NonNull;

public class FirebaseException extends Exception {
  @Deprecated
  protected FirebaseException() {}
  
  public FirebaseException(@NonNull String paramString) {
    super(paramString);
  }
  
  public FirebaseException(@NonNull String paramString, @NonNull Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\firebase\FirebaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */