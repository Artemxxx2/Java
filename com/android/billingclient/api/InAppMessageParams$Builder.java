package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

@zzf
public final class Builder {
  private final Set<Integer> mInAppMessageCategories = new HashSet<Integer>();
  
  @NonNull
  public Builder addAllInAppMessageCategoriesToShow() {
    this.mInAppMessageCategories.add(Integer.valueOf(2));
    return this;
  }
  
  @NonNull
  public Builder addInAppMessageCategoryToShow(int paramInt) {
    this.mInAppMessageCategories.add(Integer.valueOf(paramInt));
    return this;
  }
  
  @NonNull
  public InAppMessageParams build() {
    return new InAppMessageParams(this.mInAppMessageCategories, null);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\InAppMessageParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */