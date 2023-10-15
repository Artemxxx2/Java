package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import javax.annotation.CheckForNull;

final class zzaf extends zzx {
  static final zzx zza = new zzaf(null, new Object[0], 0);
  
  final transient Object[] zzb;
  
  @CheckForNull
  private final transient Object zzc;
  
  private final transient int zzd;
  
  private zzaf(@CheckForNull Object paramObject, Object[] paramArrayOfObject, int paramInt) {
    this.zzc = paramObject;
    this.zzb = paramArrayOfObject;
    this.zzd = paramInt;
  }
  
  static zzaf zzf(int paramInt, Object[] paramArrayOfObject, zzw paramzzw) {
    Object object1;
    Object object2;
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramInt == 0)
      return (zzaf)zza; 
    paramArrayOfObject = null;
    if (paramInt == 1) {
      object2 = arrayOfObject[0];
      object2.getClass();
      object1 = arrayOfObject[1];
      object1.getClass();
      zzp.zza(object2, object1);
      return new zzaf(null, arrayOfObject, 1);
    } 
    zzm.zzb(paramInt, arrayOfObject.length >> 1, "index");
    int i = Math.max(paramInt, 2);
    int j = 1073741824;
    if (i < 751619276) {
      int k = Integer.highestOneBit(i - 1);
      k += k;
      while (true) {
        double d = k;
        Double.isNaN(d);
        j = k;
        if (d * 0.7D < i) {
          k += k;
          continue;
        } 
        break;
      } 
    } else if (i >= 1073741824) {
      throw new IllegalArgumentException("collection too large");
    } 
    if (paramInt == 1) {
      Object object3 = arrayOfObject[0];
      object3.getClass();
      Object object4 = arrayOfObject[1];
      object4.getClass();
      zzp.zza(object3, object4);
    } else {
      int k = j - 1;
      if (j <= 128) {
        byte[] arrayOfByte = new byte[j];
        Arrays.fill(arrayOfByte, (byte)-1);
        paramArrayOfObject = null;
        byte b = 0;
        j = 0;
        label95: while (b < paramInt) {
          i = b + b;
          int m = j + j;
          Object object4 = arrayOfObject[i];
          object4.getClass();
          Object object3 = arrayOfObject[i ^ 0x1];
          object3.getClass();
          zzp.zza(object4, object3);
          i = zzq.zza(object4.hashCode());
          while (true) {
            int n = i & k;
            i = arrayOfByte[n] & 0xFF;
            if (i == 255) {
              arrayOfByte[n] = (byte)(byte)m;
              if (j < b) {
                arrayOfObject[m] = object4;
                arrayOfObject[m ^ 0x1] = object3;
              } 
              j++;
            } else if (object4.equals(arrayOfObject[i])) {
              i ^= 0x1;
              object1 = arrayOfObject[i];
              object1.getClass();
              object1 = new zzv(object4, object3, object1);
              arrayOfObject[i] = object3;
            } else {
              i = n + 1;
              continue;
            } 
            b++;
            continue label95;
          } 
        } 
        if (j == paramInt) {
          object1 = arrayOfByte;
        } else {
          Object[] arrayOfObject1 = new Object[3];
          arrayOfObject1[0] = arrayOfByte;
          arrayOfObject1[1] = Integer.valueOf(j);
          arrayOfObject1[2] = object1;
          object1 = arrayOfObject1;
        } 
      } else if (j <= 32768) {
        short[] arrayOfShort = new short[j];
        Arrays.fill(arrayOfShort, (short)-1);
        paramArrayOfObject = null;
        byte b = 0;
        j = 0;
        label96: while (b < paramInt) {
          i = b + b;
          int m = j + j;
          Object object4 = arrayOfObject[i];
          object4.getClass();
          Object object3 = arrayOfObject[i ^ 0x1];
          object3.getClass();
          zzp.zza(object4, object3);
          i = zzq.zza(object4.hashCode());
          while (true) {
            i &= k;
            char c = (char)arrayOfShort[i];
            if (c == Character.MAX_VALUE) {
              arrayOfShort[i] = (short)(short)m;
              if (j < b) {
                arrayOfObject[m] = object4;
                arrayOfObject[m ^ 0x1] = object3;
              } 
              j++;
            } else if (object4.equals(arrayOfObject[c])) {
              i = c ^ 0x1;
              object1 = arrayOfObject[i];
              object1.getClass();
              object1 = new zzv(object4, object3, object1);
              arrayOfObject[i] = object3;
            } else {
              i++;
              continue;
            } 
            b++;
            continue label96;
          } 
        } 
        if (j == paramInt) {
          object1 = arrayOfShort;
        } else {
          Object[] arrayOfObject1 = new Object[3];
          arrayOfObject1[0] = arrayOfShort;
          arrayOfObject1[1] = Integer.valueOf(j);
          arrayOfObject1[2] = object1;
          object1 = arrayOfObject1;
        } 
      } else {
        int[] arrayOfInt = new int[j];
        Arrays.fill(arrayOfInt, -1);
        paramArrayOfObject = null;
        byte b = 0;
        j = 0;
        label97: while (b < paramInt) {
          i = b + b;
          int m = j + j;
          Object object4 = arrayOfObject[i];
          object4.getClass();
          Object object3 = arrayOfObject[i ^ 0x1];
          object3.getClass();
          zzp.zza(object4, object3);
          i = zzq.zza(object4.hashCode());
          while (true) {
            i &= k;
            int n = arrayOfInt[i];
            if (n == -1) {
              arrayOfInt[i] = m;
              if (j < b) {
                arrayOfObject[m] = object4;
                arrayOfObject[m ^ 0x1] = object3;
              } 
              j++;
            } else if (object4.equals(arrayOfObject[n])) {
              i = n ^ 0x1;
              object1 = arrayOfObject[i];
              object1.getClass();
              object1 = new zzv(object4, object3, object1);
              arrayOfObject[i] = object3;
            } else {
              i++;
              continue;
            } 
            b++;
            continue label97;
          } 
        } 
        if (j == paramInt) {
          object1 = arrayOfInt;
        } else {
          Object[] arrayOfObject1 = new Object[3];
          arrayOfObject1[0] = arrayOfInt;
          arrayOfObject1[1] = Integer.valueOf(j);
          arrayOfObject1[2] = object1;
          object1 = arrayOfObject1;
        } 
      } 
    } 
    if (object1 instanceof Object[]) {
      Object[] arrayOfObject1 = (Object[])object1;
      ((zzw)object2).zzc = (zzv)arrayOfObject1[2];
      object1 = arrayOfObject1[0];
      paramInt = ((Integer)arrayOfObject1[1]).intValue();
      arrayOfObject = Arrays.copyOf(arrayOfObject, paramInt + paramInt);
    } 
    return new zzaf(object1, arrayOfObject, paramInt);
  }
  
  @CheckForNull
  public final Object get(@CheckForNull Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzc : Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield zzb : [Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_0
    //   11: getfield zzd : I
    //   14: istore #4
    //   16: aload_1
    //   17: ifnonnull -> 25
    //   20: aconst_null
    //   21: astore_1
    //   22: goto -> 298
    //   25: iload #4
    //   27: iconst_1
    //   28: if_icmpne -> 60
    //   31: aload_3
    //   32: iconst_0
    //   33: aaload
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual getClass : ()Ljava/lang/Class;
    //   39: pop
    //   40: aload_2
    //   41: aload_1
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 64
    //   48: aload_3
    //   49: iconst_1
    //   50: aaload
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual getClass : ()Ljava/lang/Class;
    //   56: pop
    //   57: goto -> 298
    //   60: aload_2
    //   61: ifnonnull -> 69
    //   64: aconst_null
    //   65: astore_1
    //   66: goto -> 298
    //   69: aload_2
    //   70: instanceof [B
    //   73: ifeq -> 153
    //   76: aload_2
    //   77: checkcast [B
    //   80: astore_2
    //   81: aload_2
    //   82: arraylength
    //   83: istore #5
    //   85: aload_1
    //   86: invokevirtual hashCode : ()I
    //   89: invokestatic zza : (I)I
    //   92: istore #4
    //   94: iload #4
    //   96: iload #5
    //   98: iconst_1
    //   99: isub
    //   100: iand
    //   101: istore #4
    //   103: aload_2
    //   104: iload #4
    //   106: baload
    //   107: sipush #255
    //   110: iand
    //   111: istore #6
    //   113: iload #6
    //   115: sipush #255
    //   118: if_icmpne -> 126
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -> 298
    //   126: aload_1
    //   127: aload_3
    //   128: iload #6
    //   130: aaload
    //   131: invokevirtual equals : (Ljava/lang/Object;)Z
    //   134: ifeq -> 147
    //   137: aload_3
    //   138: iload #6
    //   140: iconst_1
    //   141: ixor
    //   142: aaload
    //   143: astore_1
    //   144: goto -> 298
    //   147: iinc #4, 1
    //   150: goto -> 94
    //   153: aload_2
    //   154: instanceof [S
    //   157: ifeq -> 236
    //   160: aload_2
    //   161: checkcast [S
    //   164: astore_2
    //   165: aload_2
    //   166: arraylength
    //   167: istore #5
    //   169: aload_1
    //   170: invokevirtual hashCode : ()I
    //   173: invokestatic zza : (I)I
    //   176: istore #4
    //   178: iload #4
    //   180: iload #5
    //   182: iconst_1
    //   183: isub
    //   184: iand
    //   185: istore #6
    //   187: aload_2
    //   188: iload #6
    //   190: saload
    //   191: i2c
    //   192: istore #4
    //   194: iload #4
    //   196: ldc 65535
    //   198: if_icmpne -> 206
    //   201: aconst_null
    //   202: astore_1
    //   203: goto -> 298
    //   206: aload_1
    //   207: aload_3
    //   208: iload #4
    //   210: aaload
    //   211: invokevirtual equals : (Ljava/lang/Object;)Z
    //   214: ifeq -> 227
    //   217: aload_3
    //   218: iload #4
    //   220: iconst_1
    //   221: ixor
    //   222: aaload
    //   223: astore_1
    //   224: goto -> 298
    //   227: iload #6
    //   229: iconst_1
    //   230: iadd
    //   231: istore #4
    //   233: goto -> 178
    //   236: aload_2
    //   237: checkcast [I
    //   240: astore_2
    //   241: aload_2
    //   242: arraylength
    //   243: istore #5
    //   245: aload_1
    //   246: invokevirtual hashCode : ()I
    //   249: invokestatic zza : (I)I
    //   252: istore #4
    //   254: iload #4
    //   256: iload #5
    //   258: iconst_1
    //   259: isub
    //   260: iand
    //   261: istore #6
    //   263: aload_2
    //   264: iload #6
    //   266: iaload
    //   267: istore #4
    //   269: iload #4
    //   271: iconst_m1
    //   272: if_icmpne -> 280
    //   275: aconst_null
    //   276: astore_1
    //   277: goto -> 298
    //   280: aload_1
    //   281: aload_3
    //   282: iload #4
    //   284: aaload
    //   285: invokevirtual equals : (Ljava/lang/Object;)Z
    //   288: ifeq -> 306
    //   291: aload_3
    //   292: iload #4
    //   294: iconst_1
    //   295: ixor
    //   296: aaload
    //   297: astore_1
    //   298: aload_1
    //   299: ifnonnull -> 304
    //   302: aconst_null
    //   303: areturn
    //   304: aload_1
    //   305: areturn
    //   306: iload #6
    //   308: iconst_1
    //   309: iadd
    //   310: istore #4
    //   312: goto -> 254
  }
  
  public final int size() {
    return this.zzd;
  }
  
  final zzr zza() {
    return new zzae(this.zzb, 1, this.zzd);
  }
  
  final zzy zzc() {
    return new zzac(this, this.zzb, 0, this.zzd);
  }
  
  final zzy zzd() {
    return new zzad(this, new zzae(this.zzb, 0, this.zzd));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */