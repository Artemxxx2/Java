package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;

final class null implements Runnable {
  public void run() {
    try {
      FontsContractCompat.FontFamilyResult fontFamilyResult = FontsContractCompat.fetchFonts(appContext, null, request);
      if (fontFamilyResult.getStatusCode() != 0) {
        switch (fontFamilyResult.getStatusCode()) {
          default:
            callerThreadHandler.post(new Runnable() {
                  public void run() {
                    callback.onTypefaceRequestFailed(-3);
                  }
                });
            return;
          case 2:
            callerThreadHandler.post(new Runnable() {
                  public void run() {
                    callback.onTypefaceRequestFailed(-3);
                  }
                });
            return;
          case 1:
            break;
        } 
        callerThreadHandler.post(new Runnable() {
              public void run() {
                callback.onTypefaceRequestFailed(-2);
              }
            });
        return;
      } 
      FontsContractCompat.FontInfo[] arrayOfFontInfo = fontFamilyResult.getFonts();
      if (arrayOfFontInfo == null || arrayOfFontInfo.length == 0) {
        callerThreadHandler.post(new Runnable() {
              public void run() {
                callback.onTypefaceRequestFailed(1);
              }
            });
        return;
      } 
      int i = arrayOfFontInfo.length;
      for (final int resultCode = 0; j < i; j++) {
        FontsContractCompat.FontInfo fontInfo = arrayOfFontInfo[j];
        if (fontInfo.getResultCode() != 0) {
          j = fontInfo.getResultCode();
          if (j < 0) {
            callerThreadHandler.post(new Runnable() {
                  public void run() {
                    callback.onTypefaceRequestFailed(-3);
                  }
                });
          } else {
            callerThreadHandler.post(new Runnable() {
                  public void run() {
                    callback.onTypefaceRequestFailed(resultCode);
                  }
                });
          } 
          return;
        } 
      } 
      final Typeface typeface = FontsContractCompat.buildTypeface(appContext, null, arrayOfFontInfo);
      if (typeface == null) {
        callerThreadHandler.post(new Runnable() {
              public void run() {
                callback.onTypefaceRequestFailed(-3);
              }
            });
        return;
      } 
      callerThreadHandler.post(new Runnable() {
            public void run() {
              callback.onTypefaceRetrieved(typeface);
            }
          });
      return;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      callerThreadHandler.post(new Runnable() {
            public void run() {
              callback.onTypefaceRequestFailed(-1);
            }
          });
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */