package com.google.android.gms.common.api;

import androidx.annotation.NonNull;

public class Response<T extends Result> {
  private Result zza;
  
  public Response() {}
  
  protected Response(@NonNull T paramT) {
    this.zza = (Result)paramT;
  }
  
  @NonNull
  protected T getResult() {
    return (T)this.zza;
  }
  
  public void setResult(@NonNull T paramT) {
    this.zza = (Result)paramT;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */