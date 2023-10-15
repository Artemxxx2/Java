package androidx.versionedparcelable;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class CustomVersionedParcelable implements VersionedParcelable {
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void onPostParceling() {}
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void onPreParceling(boolean paramBoolean) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\CustomVersionedParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */