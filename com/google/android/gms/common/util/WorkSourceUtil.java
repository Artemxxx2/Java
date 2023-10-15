package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {
  private static final int zza;
  
  private static final Method zzb;
  
  private static final Method zzc;
  
  private static final Method zzd;
  
  private static final Method zze;
  
  private static final Method zzf;
  
  private static final Method zzg;
  
  private static final Method zzh;
  
  private static final Method zzi;
  
  static {
    // Byte code:
    //   0: invokestatic myUid : ()I
    //   3: putstatic com/google/android/gms/common/util/WorkSourceUtil.zza : I
    //   6: aconst_null
    //   7: astore_0
    //   8: aconst_null
    //   9: astore_1
    //   10: ldc android/os/WorkSource
    //   12: ldc 'add'
    //   14: iconst_1
    //   15: anewarray java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   23: aastore
    //   24: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   27: astore_2
    //   28: goto -> 34
    //   31: astore_2
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_2
    //   35: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzb : Ljava/lang/reflect/Method;
    //   38: invokestatic isAtLeastJellyBeanMR2 : ()Z
    //   41: ifeq -> 70
    //   44: ldc android/os/WorkSource
    //   46: ldc 'add'
    //   48: iconst_2
    //   49: anewarray java/lang/Class
    //   52: dup
    //   53: iconst_0
    //   54: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc java/lang/String
    //   62: aastore
    //   63: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   66: astore_2
    //   67: goto -> 72
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzc : Ljava/lang/reflect/Method;
    //   76: ldc android/os/WorkSource
    //   78: ldc 'size'
    //   80: iconst_0
    //   81: anewarray java/lang/Class
    //   84: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   87: astore_2
    //   88: goto -> 94
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_2
    //   95: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzd : Ljava/lang/reflect/Method;
    //   98: ldc android/os/WorkSource
    //   100: ldc 'get'
    //   102: iconst_1
    //   103: anewarray java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   111: aastore
    //   112: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   115: astore_2
    //   116: goto -> 122
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: putstatic com/google/android/gms/common/util/WorkSourceUtil.zze : Ljava/lang/reflect/Method;
    //   126: invokestatic isAtLeastJellyBeanMR2 : ()Z
    //   129: ifeq -> 153
    //   132: ldc android/os/WorkSource
    //   134: ldc 'getName'
    //   136: iconst_1
    //   137: anewarray java/lang/Class
    //   140: dup
    //   141: iconst_0
    //   142: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   145: aastore
    //   146: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   149: astore_2
    //   150: goto -> 155
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzf : Ljava/lang/reflect/Method;
    //   159: invokestatic isAtLeastP : ()Z
    //   162: ifeq -> 195
    //   165: ldc android/os/WorkSource
    //   167: ldc 'createWorkChain'
    //   169: iconst_0
    //   170: anewarray java/lang/Class
    //   173: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   176: astore_2
    //   177: goto -> 197
    //   180: astore_2
    //   181: ldc 'WorkSourceUtil'
    //   183: ldc 'Missing WorkChain API createWorkChain'
    //   185: aload_2
    //   186: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   189: pop
    //   190: aconst_null
    //   191: astore_2
    //   192: goto -> 197
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_2
    //   198: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzg : Ljava/lang/reflect/Method;
    //   201: invokestatic isAtLeastP : ()Z
    //   204: ifeq -> 251
    //   207: ldc 'android.os.WorkSource$WorkChain'
    //   209: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   212: ldc 'addNode'
    //   214: iconst_2
    //   215: anewarray java/lang/Class
    //   218: dup
    //   219: iconst_0
    //   220: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: ldc java/lang/String
    //   228: aastore
    //   229: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   232: astore_2
    //   233: goto -> 253
    //   236: astore_2
    //   237: ldc 'WorkSourceUtil'
    //   239: ldc 'Missing WorkChain class'
    //   241: aload_2
    //   242: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   245: pop
    //   246: aconst_null
    //   247: astore_2
    //   248: goto -> 253
    //   251: aconst_null
    //   252: astore_2
    //   253: aload_2
    //   254: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzh : Ljava/lang/reflect/Method;
    //   257: aload_1
    //   258: astore_2
    //   259: invokestatic isAtLeastP : ()Z
    //   262: ifeq -> 288
    //   265: aload_0
    //   266: astore_2
    //   267: ldc android/os/WorkSource
    //   269: ldc 'isEmpty'
    //   271: iconst_0
    //   272: anewarray java/lang/Class
    //   275: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   278: astore_0
    //   279: aload_0
    //   280: astore_2
    //   281: aload_0
    //   282: iconst_1
    //   283: invokevirtual setAccessible : (Z)V
    //   286: aload_0
    //   287: astore_2
    //   288: aload_2
    //   289: putstatic com/google/android/gms/common/util/WorkSourceUtil.zzi : Ljava/lang/reflect/Method;
    //   292: return
    //   293: astore_2
    //   294: goto -> 70
    //   297: astore_2
    //   298: goto -> 153
    //   301: astore_0
    //   302: goto -> 288
    // Exception table:
    //   from	to	target	type
    //   10	28	31	java/lang/Exception
    //   44	67	293	java/lang/Exception
    //   76	88	91	java/lang/Exception
    //   98	116	119	java/lang/Exception
    //   132	150	297	java/lang/Exception
    //   165	177	180	java/lang/Exception
    //   207	233	236	java/lang/Exception
    //   267	279	301	java/lang/Exception
    //   281	286	301	java/lang/Exception
  }
  
  @KeepForSdk
  public static void add(@NonNull WorkSource paramWorkSource, int paramInt, @NonNull String paramString) {
    Method method2 = zzc;
    if (method2 != null) {
      String str = paramString;
      if (paramString == null)
        str = ""; 
      try {
        method2.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
        return;
      } 
    } 
    Method method1 = zzb;
    if (method1 != null)
      try {
        method1.invoke(exception, new Object[] { Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception1) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception1);
        return;
      }  
  }
  
  @NonNull
  @KeepForSdk
  public static WorkSource fromPackage(@NonNull Context paramContext, @NonNull String paramString) {
    if (paramContext != null && paramContext.getPackageManager() != null && paramString != null)
      try {
        ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
        if (applicationInfo == null) {
          Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(paramString));
          return null;
        } 
        int i = applicationInfo.uid;
        WorkSource workSource = new WorkSource();
        add(workSource, i, paramString);
        return workSource;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.e("WorkSourceUtil", "Could not find package: ".concat(paramString));
        return null;
      }  
    return null;
  }
  
  @NonNull
  @KeepForSdk
  public static WorkSource fromPackageAndModuleExperimentalPi(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2) {
    if (paramContext == null || paramContext.getPackageManager() == null || paramString2 == null || paramString1 == null) {
      Log.w("WorkSourceUtil", "Unexpected null arguments");
      return null;
    } 
    int i = -1;
    try {
      ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString1, 0);
      if (applicationInfo == null) {
        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(paramString1));
      } else {
        i = applicationInfo.uid;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("WorkSourceUtil", "Could not find package: ".concat(paramString1));
    } 
    if (i < 0)
      return null; 
    WorkSource workSource = new WorkSource();
    Method method = zzg;
    if (method == null || zzh == null) {
      add(workSource, i, paramString1);
      return workSource;
    } 
    try {
      Object object = method.invoke(workSource, new Object[0]);
      if (i != zza)
        zzh.invoke(object, new Object[] { Integer.valueOf(i), paramString1 }); 
      zzh.invoke(object, new Object[] { Integer.valueOf(zza), paramString2 });
    } catch (Exception exception) {
      Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", exception);
    } 
    return workSource;
  }
  
  @KeepForSdk
  public static int get(@NonNull WorkSource paramWorkSource, int paramInt) {
    Method method = zze;
    if (method != null)
      try {
        Object object = method.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        Preconditions.checkNotNull(object);
        return ((Integer)object).intValue();
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return 0;
  }
  
  @NonNull
  @KeepForSdk
  public static String getName(@NonNull WorkSource paramWorkSource, int paramInt) {
    Method method = zzf;
    if (method != null)
      try {
        return (String)method.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return null;
  }
  
  @NonNull
  @KeepForSdk
  public static List<String> getNames(@NonNull WorkSource paramWorkSource) {
    int i;
    ArrayList<String> arrayList = new ArrayList();
    byte b = 0;
    if (paramWorkSource == null) {
      i = 0;
    } else {
      i = size(paramWorkSource);
    } 
    if (i != 0)
      while (b < i) {
        String str = getName(paramWorkSource, b);
        if (!Strings.isEmptyOrWhitespace(str)) {
          Preconditions.checkNotNull(str);
          arrayList.add(str);
        } 
        b++;
      }  
    return arrayList;
  }
  
  @KeepForSdk
  public static boolean hasWorkSourcePermission(@NonNull Context paramContext) {
    return (paramContext == null) ? false : ((paramContext.getPackageManager() == null) ? false : ((Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0)));
  }
  
  @KeepForSdk
  public static boolean isEmpty(@NonNull WorkSource paramWorkSource) {
    Method method = zzi;
    if (method != null)
      try {
        Object object = method.invoke(paramWorkSource, new Object[0]);
        Preconditions.checkNotNull(object);
        return ((Boolean)object).booleanValue();
      } catch (Exception exception) {
        Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", exception);
      }  
    return (size(paramWorkSource) == 0);
  }
  
  @KeepForSdk
  public static int size(@NonNull WorkSource paramWorkSource) {
    Method method = zzd;
    if (method != null)
      try {
        Object object = method.invoke(paramWorkSource, new Object[0]);
        Preconditions.checkNotNull(object);
        return ((Integer)object).intValue();
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\WorkSourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */