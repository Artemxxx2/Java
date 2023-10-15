package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface SafeParcelable extends Parcelable {
  @NonNull
  public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";
  
  public static @interface Class {
    @NonNull
    String creator();
    
    boolean doNotParcelTypeDefaultValues() default false;
    
    boolean validate() default false;
  }
  
  public static @interface Constructor {}
  
  public static @interface Field {
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
  
  public static @interface Indicator {
    @NonNull
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
  }
  
  public static @interface Param {
    int id();
  }
  
  public static @interface RemovedParam {
    @NonNull
    String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";
    
    @NonNull
    String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";
    
    int id();
  }
  
  public static @interface Reserved {
    @NonNull
    int[] value();
  }
  
  public static @interface VersionField {
    @NonNull
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
    
    int id();
    
    @NonNull
    String type() default "SAFE_PARCELABLE_NULL_STRING";
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */