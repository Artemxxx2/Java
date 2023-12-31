package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcelUtils {
  private static final String INNER_BUNDLE_KEY = "a";
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T extends VersionedParcelable> T fromInputStream(InputStream paramInputStream) {
    return (new VersionedParcelStream(paramInputStream, null)).readVersionedParcelable();
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T extends VersionedParcelable> T fromParcelable(Parcelable paramParcelable) {
    if (paramParcelable instanceof ParcelImpl)
      return ((ParcelImpl)paramParcelable).getVersionedParcel(); 
    throw new IllegalArgumentException("Invalid parcel");
  }
  
  @Nullable
  public static <T extends VersionedParcelable> T getVersionedParcelable(@NonNull Bundle paramBundle, @NonNull String paramString) {
    try {
      paramBundle = (Bundle)paramBundle.getParcelable(paramString);
      if (paramBundle == null)
        return null; 
      paramBundle.setClassLoader(ParcelUtils.class.getClassLoader());
      return (T)fromParcelable(paramBundle.getParcelable("a"));
    } catch (RuntimeException runtimeException) {
      return null;
    } 
  }
  
  @Nullable
  public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle paramBundle, String paramString) {
    ArrayList<T> arrayList = new ArrayList();
    try {
      paramBundle = (Bundle)paramBundle.getParcelable(paramString);
      paramBundle.setClassLoader(ParcelUtils.class.getClassLoader());
      Iterator<Parcelable> iterator = paramBundle.getParcelableArrayList("a").iterator();
      while (iterator.hasNext())
        arrayList.add(fromParcelable(iterator.next())); 
      return arrayList;
    } catch (RuntimeException runtimeException) {
      return null;
    } 
  }
  
  public static void putVersionedParcelable(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable VersionedParcelable paramVersionedParcelable) {
    if (paramVersionedParcelable == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putParcelable("a", toParcelable(paramVersionedParcelable));
    paramBundle.putParcelable(paramString, (Parcelable)bundle);
  }
  
  public static void putVersionedParcelableList(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull List<? extends VersionedParcelable> paramList) {
    Bundle bundle = new Bundle();
    ArrayList<Parcelable> arrayList = new ArrayList();
    Iterator<? extends VersionedParcelable> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(toParcelable(iterator.next())); 
    bundle.putParcelableArrayList("a", arrayList);
    paramBundle.putParcelable(paramString, (Parcelable)bundle);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void toOutputStream(VersionedParcelable paramVersionedParcelable, OutputStream paramOutputStream) {
    VersionedParcelStream versionedParcelStream = new VersionedParcelStream(null, paramOutputStream);
    versionedParcelStream.writeVersionedParcelable(paramVersionedParcelable);
    versionedParcelStream.closeField();
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Parcelable toParcelable(VersionedParcelable paramVersionedParcelable) {
    return new ParcelImpl(paramVersionedParcelable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\ParcelUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */