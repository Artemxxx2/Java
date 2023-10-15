package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
  public static int beginObjectHeader(@NonNull Parcel paramParcel) {
    return zza(paramParcel, 20293);
  }
  
  public static void finishObjectHeader(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBigDecimal(@NonNull Parcel paramParcel, int paramInt, @NonNull BigDecimal paramBigDecimal, boolean paramBoolean) {
    if (paramBigDecimal == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigDecimal.unscaledValue().toByteArray());
    paramParcel.writeInt(paramBigDecimal.scale());
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBigDecimalArray(@NonNull Parcel paramParcel, int paramInt, @NonNull BigDecimal[] paramArrayOfBigDecimal, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfBigDecimal == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfBigDecimal.length;
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeByteArray(paramArrayOfBigDecimal[paramInt].unscaledValue().toByteArray());
      paramParcel.writeInt(paramArrayOfBigDecimal[paramInt].scale());
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeBigInteger(@NonNull Parcel paramParcel, int paramInt, @NonNull BigInteger paramBigInteger, boolean paramBoolean) {
    if (paramBigInteger == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigInteger.toByteArray());
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBigIntegerArray(@NonNull Parcel paramParcel, int paramInt, @NonNull BigInteger[] paramArrayOfBigInteger, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfBigInteger == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfBigInteger.length;
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeByteArray(paramArrayOfBigInteger[paramInt].toByteArray()); 
    zzb(paramParcel, i);
  }
  
  public static void writeBoolean(@NonNull Parcel paramParcel, int paramInt, boolean paramBoolean) {
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramBoolean);
  }
  
  public static void writeBooleanArray(@NonNull Parcel paramParcel, int paramInt, @NonNull boolean[] paramArrayOfboolean, boolean paramBoolean) {
    if (paramArrayOfboolean == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfboolean);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBooleanList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<Boolean> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeInt(((Boolean)paramList.get(paramInt)).booleanValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeBooleanObject(@NonNull Parcel paramParcel, int paramInt, @NonNull Boolean paramBoolean, boolean paramBoolean1) {
    if (paramBoolean == null) {
      if (paramBoolean1)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramBoolean.booleanValue());
  }
  
  public static void writeBundle(@NonNull Parcel paramParcel, int paramInt, @NonNull Bundle paramBundle, boolean paramBoolean) {
    if (paramBundle == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeByte(@NonNull Parcel paramParcel, int paramInt, byte paramByte) {
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void writeByteArray(@NonNull Parcel paramParcel, int paramInt, @NonNull byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfbyte);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeByteArrayArray(@NonNull Parcel paramParcel, int paramInt, @NonNull byte[][] paramArrayOfbyte, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfbyte == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfbyte.length;
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeByteArray(paramArrayOfbyte[paramInt]); 
    zzb(paramParcel, i);
  }
  
  public static void writeByteArraySparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<byte[]> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeByteArray((byte[])paramSparseArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeChar(@NonNull Parcel paramParcel, int paramInt, char paramChar) {
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramChar);
  }
  
  public static void writeCharArray(@NonNull Parcel paramParcel, int paramInt, @NonNull char[] paramArrayOfchar, boolean paramBoolean) {
    if (paramArrayOfchar == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeCharArray(paramArrayOfchar);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeDouble(@NonNull Parcel paramParcel, int paramInt, double paramDouble) {
    zzc(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void writeDoubleArray(@NonNull Parcel paramParcel, int paramInt, @NonNull double[] paramArrayOfdouble, boolean paramBoolean) {
    if (paramArrayOfdouble == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeDoubleArray(paramArrayOfdouble);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeDoubleList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<Double> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeDouble(((Double)paramList.get(paramInt)).doubleValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeDoubleObject(@NonNull Parcel paramParcel, int paramInt, @NonNull Double paramDouble, boolean paramBoolean) {
    if (paramDouble == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    zzc(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble.doubleValue());
  }
  
  public static void writeDoubleSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<Double> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeDouble(((Double)paramSparseArray.valueAt(paramInt)).doubleValue());
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeFloat(@NonNull Parcel paramParcel, int paramInt, float paramFloat) {
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void writeFloatArray(@NonNull Parcel paramParcel, int paramInt, @NonNull float[] paramArrayOffloat, boolean paramBoolean) {
    if (paramArrayOffloat == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeFloatArray(paramArrayOffloat);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeFloatList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<Float> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeFloat(((Float)paramList.get(paramInt)).floatValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeFloatObject(@NonNull Parcel paramParcel, int paramInt, @NonNull Float paramFloat, boolean paramBoolean) {
    if (paramFloat == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat.floatValue());
  }
  
  public static void writeFloatSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<Float> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeFloat(((Float)paramSparseArray.valueAt(paramInt)).floatValue());
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeIBinder(@NonNull Parcel paramParcel, int paramInt, @NonNull IBinder paramIBinder, boolean paramBoolean) {
    if (paramIBinder == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIBinderArray(@NonNull Parcel paramParcel, int paramInt, @NonNull IBinder[] paramArrayOfIBinder, boolean paramBoolean) {
    if (paramArrayOfIBinder == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBinderArray(paramArrayOfIBinder);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIBinderList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<IBinder> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBinderList(paramList);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIBinderSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<IBinder> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeStrongBinder((IBinder)paramSparseArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeInt(@NonNull Parcel paramParcel, int paramInt1, int paramInt2) {
    zzc(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void writeIntArray(@NonNull Parcel paramParcel, int paramInt, @NonNull int[] paramArrayOfint, boolean paramBoolean) {
    if (paramArrayOfint == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfint);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIntegerList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<Integer> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeIntegerObject(@NonNull Parcel paramParcel, int paramInt, @NonNull Integer paramInteger, boolean paramBoolean) {
    if (paramInteger == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void writeList(@NonNull Parcel paramParcel, int paramInt, @NonNull List paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeLong(@NonNull Parcel paramParcel, int paramInt, long paramLong) {
    zzc(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void writeLongArray(@NonNull Parcel paramParcel, int paramInt, @NonNull long[] paramArrayOflong, boolean paramBoolean) {
    if (paramArrayOflong == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeLongArray(paramArrayOflong);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeLongList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<Long> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeLong(((Long)paramList.get(paramInt)).longValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeLongObject(@NonNull Parcel paramParcel, int paramInt, @NonNull Long paramLong, boolean paramBoolean) {
    if (paramLong == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    zzc(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }
  
  public static void writeParcel(@NonNull Parcel paramParcel1, int paramInt, @NonNull Parcel paramParcel2, boolean paramBoolean) {
    if (paramParcel2 == null) {
      if (paramBoolean)
        zzc(paramParcel1, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel1, paramInt);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    zzb(paramParcel1, paramInt);
  }
  
  public static void writeParcelArray(@NonNull Parcel paramParcel, int paramInt, @NonNull Parcel[] paramArrayOfParcel, boolean paramBoolean) {
    if (paramArrayOfParcel == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfParcel.length;
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcel parcel = paramArrayOfParcel[paramInt];
      if (parcel != null) {
        paramParcel.writeInt(parcel.dataSize());
        paramParcel.appendFrom(parcel, 0, parcel.dataSize());
      } else {
        paramParcel.writeInt(0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeParcelList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<Parcel> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcel parcel = paramList.get(paramInt);
      if (parcel != null) {
        paramParcel.writeInt(parcel.dataSize());
        paramParcel.appendFrom(parcel, 0, parcel.dataSize());
      } else {
        paramParcel.writeInt(0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeParcelSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<Parcel> paramSparseArray, boolean paramBoolean) {
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      Parcel parcel = (Parcel)paramSparseArray.valueAt(paramInt);
      if (parcel != null) {
        paramParcel.writeInt(parcel.dataSize());
        paramParcel.appendFrom(parcel, 0, parcel.dataSize());
      } else {
        paramParcel.writeInt(0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeParcelable(@NonNull Parcel paramParcel, int paramInt1, @NonNull Parcelable paramParcelable, int paramInt2, boolean paramBoolean) {
    if (paramParcelable == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt1, 0); 
      return;
    } 
    paramInt1 = zza(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzb(paramParcel, paramInt1);
  }
  
  public static void writePendingIntent(@NonNull Parcel paramParcel, int paramInt, @NonNull PendingIntent paramPendingIntent, boolean paramBoolean) {
    if (paramPendingIntent == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    PendingIntent.writePendingIntentOrNullToParcel(paramPendingIntent, paramParcel);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeShort(@NonNull Parcel paramParcel, int paramInt, short paramShort) {
    zzc(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void writeSparseBooleanArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean) {
    if (paramSparseBooleanArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeSparseBooleanArray(paramSparseBooleanArray);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeSparseIntArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseIntArray paramSparseIntArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseIntArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseIntArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseIntArray.keyAt(paramInt));
      paramParcel.writeInt(paramSparseIntArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeSparseLongArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseLongArray paramSparseLongArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseLongArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseLongArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseLongArray.keyAt(paramInt));
      paramParcel.writeLong(paramSparseLongArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeString(@NonNull Parcel paramParcel, int paramInt, @NonNull String paramString, boolean paramBoolean) {
    if (paramString == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeStringArray(@NonNull Parcel paramParcel, int paramInt, @NonNull String[] paramArrayOfString, boolean paramBoolean) {
    if (paramArrayOfString == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeStringList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<String> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeStringSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<String> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeString((String)paramSparseArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel paramParcel, int paramInt1, @NonNull T[] paramArrayOfT, int paramInt2, boolean paramBoolean) {
    if (paramArrayOfT == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt1, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt1);
    int j = paramArrayOfT.length;
    paramParcel.writeInt(j);
    for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
      T t = paramArrayOfT[paramInt1];
      if (t == null) {
        paramParcel.writeInt(0);
      } else {
        zzd(paramParcel, (Parcelable)t, paramInt2);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static <T extends Parcelable> void writeTypedList(@NonNull Parcel paramParcel, int paramInt, @NonNull List<T> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcelable parcelable = (Parcelable)paramList.get(paramInt);
      if (parcelable == null) {
        paramParcel.writeInt(0);
      } else {
        zzd(paramParcel, parcelable, 0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull SparseArray<T> paramSparseArray, boolean paramBoolean) {
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzc(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      Parcelable parcelable = (Parcelable)paramSparseArray.valueAt(paramInt);
      if (parcelable == null) {
        paramParcel.writeInt(0);
      } else {
        zzd(paramParcel, parcelable, 0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  private static int zza(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(paramInt | 0xFFFF0000);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void zzb(Parcel paramParcel, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  private static void zzc(Parcel paramParcel, int paramInt1, int paramInt2) {
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
  
  private static void zzd(Parcel paramParcel, Parcelable paramParcelable, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramParcelable.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */