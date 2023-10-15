package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ViewUtils {
  @Nullable
  @KeepForSdk
  public static String getXmlAttributeString(@NonNull String paramString1, @NonNull String paramString2, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, @NonNull String paramString3) {
    if (paramAttributeSet == null) {
      paramString1 = null;
    } else {
      paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
    } 
    String str = paramString1;
    if (paramString1 != null) {
      str = paramString1;
      if (paramString1.startsWith("@string/")) {
        str = paramString1;
        if (paramBoolean1) {
          String str1 = paramString1.substring(8);
          String str2 = paramContext.getPackageName();
          TypedValue typedValue = new TypedValue();
          try {
            Resources resources = paramContext.getResources();
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(str2);
            stringBuilder.append(":string/");
            stringBuilder.append(str1);
            resources.getValue(stringBuilder.toString(), typedValue, true);
          } catch (android.content.res.Resources.NotFoundException notFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find resource for ");
            stringBuilder.append(paramString2);
            stringBuilder.append(": ");
            stringBuilder.append(paramString1);
            Log.w(paramString3, stringBuilder.toString());
          } 
          if (typedValue.string != null) {
            str = typedValue.string.toString();
          } else {
            str = str.toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resource ");
            stringBuilder.append(paramString2);
            stringBuilder.append(" was not a string: ");
            stringBuilder.append(str);
            Log.w(paramString3, stringBuilder.toString());
            str = paramString1;
          } 
        } 
      } 
    } 
    if (paramBoolean2 && str == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Required XML attribute \"");
      stringBuilder.append(paramString2);
      stringBuilder.append("\" missing");
      Log.w(paramString3, stringBuilder.toString());
    } 
    return str;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */