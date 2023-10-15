package com.google.android.gms.common.internal.safeparcel;

import androidx.annotation.NonNull;

public @interface Class {
  @NonNull
  String creator();
  
  boolean doNotParcelTypeDefaultValues() default false;
  
  boolean validate() default false;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelable$Class.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */