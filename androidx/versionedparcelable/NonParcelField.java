package androidx.versionedparcelable;

import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public @interface NonParcelField {}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\NonParcelField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */