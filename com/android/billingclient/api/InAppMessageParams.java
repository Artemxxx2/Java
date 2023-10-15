package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzf
public final class InAppMessageParams {
  private final ArrayList<Integer> mInAppMessageCategories;
  
  private InAppMessageParams(Set<Integer> paramSet) {
    this.mInAppMessageCategories = new ArrayList<Integer>(Collections.unmodifiableList(new ArrayList<Integer>(paramSet)));
  }
  
  @NonNull
  public static Builder newBuilder() {
    return new Builder();
  }
  
  ArrayList<Integer> getInAppMessageCategoriesToShow() {
    return this.mInAppMessageCategories;
  }
  
  @zzf
  public static final class Builder {
    private final Set<Integer> mInAppMessageCategories = new HashSet<Integer>();
    
    @NonNull
    public Builder addAllInAppMessageCategoriesToShow() {
      this.mInAppMessageCategories.add(Integer.valueOf(2));
      return this;
    }
    
    @NonNull
    public Builder addInAppMessageCategoryToShow(int param1Int) {
      this.mInAppMessageCategories.add(Integer.valueOf(param1Int));
      return this;
    }
    
    @NonNull
    public InAppMessageParams build() {
      return new InAppMessageParams(this.mInAppMessageCategories, null);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @zzf
  public static @interface InAppMessageCategoryId {
    public static final int TRANSACTIONAL = 2;
    
    public static final int UNKNOWN_IN_APP_MESSAGE_CATEGORY_ID = 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\InAppMessageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */