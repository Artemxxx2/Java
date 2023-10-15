package androidx.core.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public final class Builder {
  private boolean mAllowFreeFormTextInput = true;
  
  private final Set<String> mAllowedDataTypes = new HashSet<String>();
  
  private CharSequence[] mChoices;
  
  private int mEditChoicesBeforeSending = 0;
  
  private final Bundle mExtras = new Bundle();
  
  private CharSequence mLabel;
  
  private final String mResultKey;
  
  public Builder(@NonNull String paramString) {
    if (paramString != null) {
      this.mResultKey = paramString;
      return;
    } 
    throw new IllegalArgumentException("Result key can't be null");
  }
  
  @NonNull
  public Builder addExtras(@NonNull Bundle paramBundle) {
    if (paramBundle != null)
      this.mExtras.putAll(paramBundle); 
    return this;
  }
  
  @NonNull
  public RemoteInput build() {
    return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
  }
  
  @NonNull
  public Bundle getExtras() {
    return this.mExtras;
  }
  
  @NonNull
  public Builder setAllowDataType(@NonNull String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      this.mAllowedDataTypes.add(paramString);
    } else {
      this.mAllowedDataTypes.remove(paramString);
    } 
    return this;
  }
  
  @NonNull
  public Builder setAllowFreeFormInput(boolean paramBoolean) {
    this.mAllowFreeFormTextInput = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setChoices(@Nullable CharSequence[] paramArrayOfCharSequence) {
    this.mChoices = paramArrayOfCharSequence;
    return this;
  }
  
  @NonNull
  public Builder setEditChoicesBeforeSending(int paramInt) {
    this.mEditChoicesBeforeSending = paramInt;
    return this;
  }
  
  @NonNull
  public Builder setLabel(@Nullable CharSequence paramCharSequence) {
    this.mLabel = paramCharSequence;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\RemoteInput$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */