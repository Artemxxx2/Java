package com.google.android.gms.common.internal.safeparcel;

import androidx.annotation.NonNull;

public @interface RemovedParam {
  @NonNull
  String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";
  
  @NonNull
  String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";
  
  int id();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelable$RemovedParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */