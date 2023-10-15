package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class HexDumpUtils {
  @Nullable
  @KeepForSdk
  public static String dump(@NonNull byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 400
    //   4: aload_0
    //   5: arraylength
    //   6: istore #4
    //   8: iload #4
    //   10: ifeq -> 400
    //   13: iload_1
    //   14: iflt -> 400
    //   17: iload_2
    //   18: ifle -> 400
    //   21: iload_1
    //   22: iload_2
    //   23: iadd
    //   24: iload #4
    //   26: if_icmple -> 32
    //   29: goto -> 400
    //   32: iload_3
    //   33: ifeq -> 43
    //   36: bipush #75
    //   38: istore #4
    //   40: goto -> 47
    //   43: bipush #57
    //   45: istore #4
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: iload #4
    //   53: iload_2
    //   54: bipush #15
    //   56: iadd
    //   57: bipush #16
    //   59: idiv
    //   60: imul
    //   61: invokespecial <init> : (I)V
    //   64: astore #5
    //   66: iload_2
    //   67: istore #4
    //   69: iconst_0
    //   70: istore #6
    //   72: iconst_0
    //   73: istore #7
    //   75: iload #4
    //   77: ifle -> 394
    //   80: iload #6
    //   82: ifne -> 144
    //   85: iload_2
    //   86: ldc 65536
    //   88: if_icmpge -> 116
    //   91: aload #5
    //   93: ldc '%04X:'
    //   95: iconst_1
    //   96: anewarray java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iload_1
    //   102: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: goto -> 138
    //   116: aload #5
    //   118: ldc '%08X:'
    //   120: iconst_1
    //   121: anewarray java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: iload_1
    //   127: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: iload_1
    //   139: istore #8
    //   141: goto -> 167
    //   144: iload #7
    //   146: istore #8
    //   148: iload #6
    //   150: bipush #8
    //   152: if_icmpne -> 167
    //   155: aload #5
    //   157: ldc ' -'
    //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: iload #7
    //   165: istore #8
    //   167: aload #5
    //   169: ldc ' %02X'
    //   171: iconst_1
    //   172: anewarray java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_0
    //   178: iload_1
    //   179: baload
    //   180: sipush #255
    //   183: iand
    //   184: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   187: aastore
    //   188: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: iload #4
    //   197: iconst_1
    //   198: isub
    //   199: istore #9
    //   201: iload #6
    //   203: iconst_1
    //   204: iadd
    //   205: istore #7
    //   207: iload_3
    //   208: ifeq -> 349
    //   211: iload #7
    //   213: bipush #16
    //   215: if_icmpeq -> 223
    //   218: iload #9
    //   220: ifne -> 349
    //   223: bipush #16
    //   225: iload #7
    //   227: isub
    //   228: istore #6
    //   230: iload #6
    //   232: ifle -> 259
    //   235: iconst_0
    //   236: istore #4
    //   238: iload #4
    //   240: iload #6
    //   242: if_icmpge -> 259
    //   245: aload #5
    //   247: ldc '   '
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: iinc #4, 1
    //   256: goto -> 238
    //   259: iload #6
    //   261: bipush #8
    //   263: if_icmplt -> 274
    //   266: aload #5
    //   268: ldc '  '
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload #5
    //   276: ldc '  '
    //   278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: iconst_0
    //   283: istore #4
    //   285: iload #4
    //   287: iload #7
    //   289: if_icmpge -> 349
    //   292: aload_0
    //   293: iload #8
    //   295: iload #4
    //   297: iadd
    //   298: baload
    //   299: i2c
    //   300: istore #6
    //   302: bipush #46
    //   304: istore #10
    //   306: iload #10
    //   308: istore #11
    //   310: iload #6
    //   312: bipush #32
    //   314: if_icmplt -> 335
    //   317: iload #6
    //   319: bipush #126
    //   321: if_icmple -> 331
    //   324: iload #10
    //   326: istore #11
    //   328: goto -> 335
    //   331: iload #6
    //   333: istore #11
    //   335: aload #5
    //   337: iload #11
    //   339: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: iinc #4, 1
    //   346: goto -> 285
    //   349: iload #7
    //   351: bipush #16
    //   353: if_icmpeq -> 365
    //   356: iload #7
    //   358: istore #4
    //   360: iload #9
    //   362: ifne -> 376
    //   365: aload #5
    //   367: bipush #10
    //   369: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: iconst_0
    //   374: istore #4
    //   376: iinc #1, 1
    //   379: iload #4
    //   381: istore #6
    //   383: iload #8
    //   385: istore #7
    //   387: iload #9
    //   389: istore #4
    //   391: goto -> 75
    //   394: aload #5
    //   396: invokevirtual toString : ()Ljava/lang/String;
    //   399: areturn
    //   400: aconst_null
    //   401: areturn
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\HexDumpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */