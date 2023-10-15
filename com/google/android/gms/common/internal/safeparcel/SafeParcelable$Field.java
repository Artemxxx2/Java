package com.google.android.gms.common.internal.safeparcel;

import androidx.annotation.NonNull;

public @interface Field {
  @NonNull
  String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";
  
  @NonNull
  String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";
  
  @NonNull
  String getter() default "SAFE_PARCELABLE_NULL_STRING";
  
  int id();
  
  @NonNull
  String type() default "SAFE_PARCELABLE_NULL_STRING";
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelable$Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */