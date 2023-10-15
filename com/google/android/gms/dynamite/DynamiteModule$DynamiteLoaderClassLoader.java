package com.google.android.gms.dynamite;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.DynamiteApi;
import javax.annotation.concurrent.GuardedBy;

@DynamiteApi
public class DynamiteLoaderClassLoader {
  @Nullable
  @GuardedBy("DynamiteLoaderClassLoader.class")
  public static ClassLoader sClassLoader;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\DynamiteModule$DynamiteLoaderClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */