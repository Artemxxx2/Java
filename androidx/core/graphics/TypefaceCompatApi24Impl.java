package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
  private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
  
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  
  private static final String TAG = "TypefaceCompatApi24Impl";
  
  private static final Method sAddFontWeightStyle;
  
  private static final Method sCreateFromFamiliesWithDefault;
  
  private static final Class<?> sFontFamily;
  
  private static final Constructor<?> sFontFamilyCtor;
  
  static {
    ClassNotFoundException classNotFoundException1;
    ClassNotFoundException classNotFoundException2;
    Constructor<?> constructor = null;
    try {
      Class<?> clazz = Class.forName("android.graphics.FontFamily");
      Constructor<?> constructor1 = clazz.getConstructor(new Class[0]);
      Method method1 = clazz.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, int.class, List.class, int.class, boolean.class });
      Method method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(clazz, 1).getClass() });
      constructor = constructor1;
    } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException3) {
      Log.e("TypefaceCompatApi24Impl", classNotFoundException3.getClass().getName(), classNotFoundException3);
      classNotFoundException1 = null;
      classNotFoundException3 = classNotFoundException1;
      classNotFoundException2 = classNotFoundException3;
    } 
    sFontFamilyCtor = constructor;
    sFontFamily = (Class<?>)classNotFoundException1;
    sAddFontWeightStyle = (Method)classNotFoundException2;
    sCreateFromFamiliesWithDefault = (Method)classNotFoundException3;
  }
  
  private static boolean addFontWeightStyle(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean) {
    try {
      return ((Boolean)sAddFontWeightStyle.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
    } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
      return false;
    } 
  }
  
  private static Typeface createFromFamiliesWithDefault(Object paramObject) {
    try {
      Object object = Array.newInstance(sFontFamily, 1);
      Array.set(object, 0, paramObject);
      return (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { object });
    } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
      return null;
    } 
  }
  
  public static boolean isUsable() {
    boolean bool;
    if (sAddFontWeightStyle == null)
      Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation."); 
    if (sAddFontWeightStyle != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static Object newFamily() {
    try {
      return sFontFamilyCtor.newInstance(new Object[0]);
    } catch (IllegalAccessException|InstantiationException|java.lang.reflect.InvocationTargetException illegalAccessException) {
      return null;
    } 
  }
  
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt) {
    Object object = newFamily();
    if (object == null)
      return null; 
    FontResourcesParserCompat.FontFileResourceEntry[] arrayOfFontFileResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int i = arrayOfFontFileResourceEntry.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = arrayOfFontFileResourceEntry[paramInt];
      ByteBuffer byteBuffer = TypefaceCompatUtil.copyToDirectBuffer(paramContext, paramResources, fontFileResourceEntry.getResourceId());
      if (byteBuffer == null)
        return null; 
      if (!addFontWeightStyle(object, byteBuffer, fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic()))
        return null; 
    } 
    return createFromFamiliesWithDefault(object);
  }
  
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    Object object = newFamily();
    if (object == null)
      return null; 
    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
    int i = paramArrayOfFontInfo.length;
    for (byte b = 0; b < i; b++) {
      FontsContractCompat.FontInfo fontInfo = paramArrayOfFontInfo[b];
      Uri uri = fontInfo.getUri();
      ByteBuffer byteBuffer1 = (ByteBuffer)simpleArrayMap.get(uri);
      ByteBuffer byteBuffer2 = byteBuffer1;
      if (byteBuffer1 == null) {
        byteBuffer2 = TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, uri);
        simpleArrayMap.put(uri, byteBuffer2);
      } 
      if (byteBuffer2 == null)
        return null; 
      if (!addFontWeightStyle(object, byteBuffer2, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic()))
        return null; 
    } 
    Typeface typeface = createFromFamiliesWithDefault(object);
    return (typeface == null) ? null : Typeface.create(typeface, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\graphics\TypefaceCompatApi24Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */