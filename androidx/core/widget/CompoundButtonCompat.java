package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {
  private static final String TAG = "CompoundButtonCompat";
  
  private static Field sButtonDrawableField;
  
  private static boolean sButtonDrawableFieldFetched;
  
  @Nullable
  public static Drawable getButtonDrawable(@NonNull CompoundButton paramCompoundButton) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramCompoundButton.getButtonDrawable(); 
    if (!sButtonDrawableFieldFetched) {
      try {
        sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
        sButtonDrawableField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", noSuchFieldException);
      } 
      sButtonDrawableFieldFetched = true;
    } 
    Field field = sButtonDrawableField;
    if (field != null)
      try {
        return (Drawable)field.get(paramCompoundButton);
      } catch (IllegalAccessException illegalAccessException) {
        Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", illegalAccessException);
        sButtonDrawableField = null;
      }  
    return null;
  }
  
  @Nullable
  public static ColorStateList getButtonTintList(@NonNull CompoundButton paramCompoundButton) {
    return (Build.VERSION.SDK_INT >= 21) ? paramCompoundButton.getButtonTintList() : ((paramCompoundButton instanceof TintableCompoundButton) ? ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList() : null);
  }
  
  @Nullable
  public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton paramCompoundButton) {
    return (Build.VERSION.SDK_INT >= 21) ? paramCompoundButton.getButtonTintMode() : ((paramCompoundButton instanceof TintableCompoundButton) ? ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode() : null);
  }
  
  public static void setButtonTintList(@NonNull CompoundButton paramCompoundButton, @Nullable ColorStateList paramColorStateList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    } else if (paramCompoundButton instanceof TintableCompoundButton) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    } 
  }
  
  public static void setButtonTintMode(@NonNull CompoundButton paramCompoundButton, @Nullable PorterDuff.Mode paramMode) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintMode(paramMode);
    } else if (paramCompoundButton instanceof TintableCompoundButton) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\CompoundButtonCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */