package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil {
  @NonNull
  @KeepForSdk
  public static String[] toScopeString(@NonNull Set<Scope> paramSet) {
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    Scope[] arrayOfScope = paramSet.<Scope>toArray(new Scope[paramSet.size()]);
    Preconditions.checkNotNull(arrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[arrayOfScope.length];
    for (byte b = 0; b < arrayOfScope.length; b++)
      arrayOfString[b] = arrayOfScope[b].getScopeUri(); 
    return arrayOfString;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\ScopeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */