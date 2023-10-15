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
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {
  @NonNull
  public static BigDecimal createBigDecimal(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(i + paramInt);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  @NonNull
  public static BigDecimal[] createBigDecimalArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    for (paramInt = 0; paramInt < k; paramInt++) {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int m = paramParcel.readInt();
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(arrayOfByte), m);
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }
  
  @NonNull
  public static BigInteger createBigInteger(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return new BigInteger(arrayOfByte);
  }
  
  @NonNull
  public static BigInteger[] createBigIntegerArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray()); 
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }
  
  @NonNull
  public static boolean[] createBooleanArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfBoolean;
  }
  
  @NonNull
  public static ArrayList<Boolean> createBooleanList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Boolean> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayList.add(Boolean.valueOf(bool));
    } 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  @NonNull
  public static Bundle createBundle(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Bundle bundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + paramInt);
    return bundle;
  }
  
  @NonNull
  public static byte[] createByteArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfByte;
  }
  
  @NonNull
  public static byte[][] createByteArrayArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayOfByte[paramInt] = paramParcel.createByteArray(); 
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }
  
  @NonNull
  public static SparseArray<byte[]> createByteArraySparseArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    SparseArray<byte[]> sparseArray = new SparseArray(k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.createByteArray()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  @NonNull
  public static char[] createCharArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfChar;
  }
  
  @NonNull
  public static double[] createDoubleArray(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfDouble;
  }
  
  @NonNull
  public static ArrayList<Double> createDoubleList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Double> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Double.valueOf(paramParcel.readDouble())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  @NonNull
  public static SparseArray<Double> createDoubleSparseArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseArray<Double> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble())); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  @NonNull
  public static float[] createFloatArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfFloat;
  }
  
  @NonNull
  public static ArrayList<Float> createFloatList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Float> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Float.valueOf(paramParcel.readFloat())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  @NonNull
  public static SparseArray<Float> createFloatSparseArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseArray<Float> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat())); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  @NonNull
  public static IBinder[] createIBinderArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfIBinder;
  }
  
  @NonNull
  public static ArrayList<IBinder> createIBinderList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<IBinder> arrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return arrayList;
  }
  
  @NonNull
  public static SparseArray<IBinder> createIBinderSparseArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    SparseArray<IBinder> sparseArray = new SparseArray(k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  @NonNull
  public static int[] createIntArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfInt;
  }
  
  @NonNull
  public static ArrayList<Integer> createIntegerList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Integer> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Integer.valueOf(paramParcel.readInt())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  @NonNull
  public static long[] createLongArray(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfLong;
  }
  
  @NonNull
  public static ArrayList<Long> createLongList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Long> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Long.valueOf(paramParcel.readLong())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  @NonNull
  public static Parcel createParcel(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Parcel parcel = Parcel.obtain();
    parcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(i + paramInt);
    return parcel;
  }
  
  @NonNull
  public static Parcel[] createParcelArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      if (m != 0) {
        int n = paramParcel.dataPosition();
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = parcel;
        paramParcel.setDataPosition(n + m);
      } else {
        arrayOfParcel[paramInt] = null;
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }
  
  @NonNull
  public static ArrayList<Parcel> createParcelList(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    ArrayList<Parcel> arrayList = new ArrayList();
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      if (m != 0) {
        int n = paramParcel.dataPosition();
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, n, m);
        arrayList.add(parcel);
        paramParcel.setDataPosition(n + m);
      } else {
        arrayList.add(null);
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  @NonNull
  public static SparseArray<Parcel> createParcelSparseArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    SparseArray<Parcel> sparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n != 0) {
        int i1 = paramParcel.dataPosition();
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, i1, n);
        sparseArray.append(m, parcel);
        paramParcel.setDataPosition(i1 + n);
      } else {
        sparseArray.append(m, null);
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  @NonNull
  public static <T extends Parcelable> T createParcelable(@NonNull Parcel paramParcel, int paramInt, @NonNull Parcelable.Creator<T> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Parcelable parcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + paramInt);
    return (T)parcelable;
  }
  
  @NonNull
  public static SparseBooleanArray createSparseBooleanArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseBooleanArray sparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return sparseBooleanArray;
  }
  
  @NonNull
  public static SparseIntArray createSparseIntArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseIntArray sparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseIntArray.append(paramParcel.readInt(), paramParcel.readInt()); 
    paramParcel.setDataPosition(j + i);
    return sparseIntArray;
  }
  
  @NonNull
  public static SparseLongArray createSparseLongArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseLongArray sparseLongArray = new SparseLongArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseLongArray.append(paramParcel.readInt(), paramParcel.readLong()); 
    paramParcel.setDataPosition(j + i);
    return sparseLongArray;
  }
  
  @NonNull
  public static String createString(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    return str;
  }
  
  @NonNull
  public static String[] createStringArray(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfString;
  }
  
  @NonNull
  public static ArrayList<String> createStringList(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ArrayList<String> arrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(i + paramInt);
    return arrayList;
  }
  
  @NonNull
  public static SparseArray<String> createStringSparseArray(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseArray<String> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.readString()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  @NonNull
  public static <T> T[] createTypedArray(@NonNull Parcel paramParcel, int paramInt, @NonNull Parcelable.Creator<T> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return (T[])arrayOfObject;
  }
  
  @NonNull
  public static <T> ArrayList<T> createTypedList(@NonNull Parcel paramParcel, int paramInt, @NonNull Parcelable.Creator<T> paramCreator) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<T> arrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return arrayList;
  }
  
  @NonNull
  public static <T> SparseArray<T> createTypedSparseArray(@NonNull Parcel paramParcel, int paramInt, @NonNull Parcelable.Creator<T> paramCreator) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    SparseArray<T> sparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++) {
      Object object;
      int m = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        object = paramCreator.createFromParcel(paramParcel);
      } else {
        object = null;
      } 
      sparseArray.append(m, object);
    } 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static void ensureAtEnd(@NonNull Parcel paramParcel, int paramInt) {
    if (paramParcel.dataPosition() == paramInt)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Overread allowed size end=");
    stringBuilder.append(paramInt);
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  public static int getFieldId(int paramInt) {
    return (char)paramInt;
  }
  
  public static boolean readBoolean(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 4);
    return (paramParcel.readInt() != 0);
  }
  
  @NonNull
  public static Boolean readBooleanObject(@NonNull Parcel paramParcel, int paramInt) {
    boolean bool;
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
  
  public static byte readByte(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static char readChar(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }
  
  public static double readDouble(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  @NonNull
  public static Double readDoubleObject(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static float readFloat(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  @NonNull
  public static Float readFloatObject(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }
  
  public static int readHeader(@NonNull Parcel paramParcel) {
    return paramParcel.readInt();
  }
  
  @NonNull
  public static IBinder readIBinder(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    IBinder iBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + paramInt);
    return iBinder;
  }
  
  public static int readInt(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  @NonNull
  public static Integer readIntegerObject(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static void readList(@NonNull Parcel paramParcel, int paramInt, @NonNull List paramList, @NonNull ClassLoader paramClassLoader) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return; 
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(i + paramInt);
  }
  
  public static long readLong(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  @NonNull
  public static Long readLongObject(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  @NonNull
  public static PendingIntent readPendingIntent(@NonNull Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    PendingIntent pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    return pendingIntent;
  }
  
  public static short readShort(@NonNull Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int readSize(@NonNull Parcel paramParcel, int paramInt) {
    return ((paramInt & 0xFFFF0000) != -65536) ? (char)(paramInt >> 16) : paramParcel.readInt();
  }
  
  public static void skipUnknownField(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    paramParcel.setDataPosition(paramParcel.dataPosition() + paramInt);
  }
  
  public static int validateObjectHeader(@NonNull Parcel paramParcel) {
    int i = readHeader(paramParcel);
    int j = readSize(paramParcel, i);
    int k = paramParcel.dataPosition();
    if (getFieldId(i) == 20293) {
      j += k;
      if (j >= k && j <= paramParcel.dataSize())
        return j; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Size read is invalid start=");
      stringBuilder.append(k);
      stringBuilder.append(" end=");
      stringBuilder.append(j);
      throw new ParseException(stringBuilder.toString(), paramParcel);
    } 
    throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), paramParcel);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == paramInt3)
      return; 
    String str = Integer.toHexString(paramInt2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt1, int paramInt2) {
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 == paramInt2)
      return; 
    String str = Integer.toHexString(paramInt1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  public static class ParseException extends RuntimeException {
    public ParseException(@NonNull String param1String, @NonNull Parcel param1Parcel) {
      super(stringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\safeparcel\SafeParcelReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */