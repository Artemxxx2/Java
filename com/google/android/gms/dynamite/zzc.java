package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zzc extends PathClassLoader {
  zzc(String paramString, ClassLoader paramClassLoader) {
    super(paramString, paramClassLoader);
  }
  
  protected final Class loadClass(String paramString, boolean paramBoolean) throws ClassNotFoundException {
    if (!paramString.startsWith("java.") && !paramString.startsWith("android."))
      try {
        return findClass(paramString);
      } catch (ClassNotFoundException classNotFoundException) {} 
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */