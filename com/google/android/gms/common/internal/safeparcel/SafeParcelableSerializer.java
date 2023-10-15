package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KeepForSdk
@VisibleForTesting
public final class SafeParcelableSerializer {
  @NonNull
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromBytes(@NonNull byte[] paramArrayOfbyte, @NonNull Parcelable.Creator<T> paramCreator) {
    Preconditions.checkNotNull(paramCreator);
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    SafeParcelable safeParcelable = (SafeParcelable)paramCreator.createFromParcel(parcel);
    parcel.recycle();
    return (T)safeParcelable;
  }
  
  @Nullable
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromIntentExtra(@NonNull Intent paramIntent, @NonNull String paramString, @NonNull Parcelable.Creator<T> paramCreator) {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra(paramString);
    return (arrayOfByte == null) ? null : deserializeFromBytes(arrayOfByte, paramCreator);
  }
  
  @NonNull
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromString(@NonNull String paramString, @NonNull Parcelable.Creator<T> paramCreator) {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }
  
  @Deprecated
  @Nullable
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull Parcelable.Creator<T> paramCreator) {
    ArrayList<byte[]> arrayList = (ArrayList)paramBundle.getSerializable(paramString);
    if (arrayList == null)
      return null; 
    ArrayList<T> arrayList1 = new ArrayList(arrayList.size());
    int i = arrayList.size();
    for (byte b = 0; b < i; b++)
      arrayList1.add(deserializeFromBytes(arrayList.get(b), paramCreator)); 
    return arrayList1;
  }
  
  @Nullable
  @KeepForSdk
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull Parcelable.Creator<T> paramCreator) {
    return deserializeIterableFromBytes(paramBundle.getByteArray(paramString), paramCreator);
  }
  
  @Nullable
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(@Nullable byte[] paramArrayOfbyte, @NonNull Parcelable.Creator<T> paramCreator) {
    if (paramArrayOfbyte == null)
      return null; 
    int i = paramArrayOfbyte.length;
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, i);
    parcel.setDataPosition(0);
    try {
      ArrayList<T> arrayList = new ArrayList();
      this();
      parcel.readTypedList(arrayList, paramCreator);
      return arrayList;
    } finally {
      parcel.recycle();
    } 
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(@NonNull Intent paramIntent, @NonNull String paramString, @NonNull Parcelable.Creator<T> paramCreator) {
    ArrayList<byte[]> arrayList = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (arrayList == null)
      return null; 
    ArrayList<T> arrayList1 = new ArrayList(arrayList.size());
    int i = arrayList.size();
    for (byte b = 0; b < i; b++)
      arrayList1.add(deserializeFromBytes(arrayList.get(b), paramCreator)); 
    return arrayList1;
  }
  
  @Nullable
  @KeepForSdk
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(@NonNull Intent paramIntent, @NonNull String paramString, @NonNull Parcelable.Creator<T> paramCreator) {
    return deserializeIterableFromBytes(paramIntent.getByteArrayExtra(paramString), paramCreator);
  }
  
  @Deprecated
  public static <T extends SafeParcelable> void serializeIterableToBundle(@NonNull Iterable<T> paramIterable, @NonNull Bundle paramBundle, @NonNull String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramBundle.putSerializable(paramString, arrayList);
  }
  
  public static <T extends SafeParcelable> void serializeIterableToBundleSafe(@NonNull Iterable<T> paramIterable, @NonNull Bundle paramBundle, @NonNull String paramString) {
    paramBundle.putByteArray(paramString, zza(paramIterable));
  }
  
  @Deprecated
  @KeepForSdk
  public static <T extends SafeParcelable> void serializeIterableToIntentExtra(@NonNull Iterable<T> paramIterable, @NonNull Intent paramIntent, @NonNull String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramIntent.putExtra(paramString, arrayList);
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(@NonNull Iterable<T> paramIterable, @NonNull Intent paramIntent, @NonNull String paramString) {
    paramIntent.putExtra(paramString, zza(paramIterable));
  }
  
  @NonNull
  @KeepForSdk
  public static <T extends SafeParcelable> byte[] serializeToBytes(@NonNull T paramT) {
    Parcel parcel = Parcel.obtain();
    paramT.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> void serializeToIntentExtra(@NonNull T paramT, @NonNull Intent paramIntent, @NonNull String paramString) {
    paramIntent.putExtra(paramString, serializeToBytes(paramT));
  }
  
  @NonNull
  @KeepForSdk
  public static <T extends SafeParcelable> String serializeToString(@NonNull T paramT) {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramT));
  }
  
  private static byte[] zza(Iterable paramIterable) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeTypedList((List)zzag.zzj(paramIterable));
      return parcel.marshall();
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */