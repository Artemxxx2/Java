package com.google.android.gms.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.PACKAGE})
@TypeQualifierDefault({ElementType.METHOD, ElementType.PARAMETER})
@KeepForSdk
public @interface NonNullApi {}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\annotation\NonNullApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */