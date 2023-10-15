package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {
  @KeepForSdk
  public static final int CONNECT_STATE_CONNECTED = 4;
  
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  
  @NonNull
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  
  @NonNull
  @KeepForSdk
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
  
  @NonNull
  @KeepForSdk
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  
  private static final Feature[] zze = new Feature[0];
  
  @Nullable
  private volatile String zzA;
  
  @Nullable
  private ConnectionResult zzB = null;
  
  private boolean zzC = false;
  
  @Nullable
  private volatile zzj zzD = null;
  
  @VisibleForTesting
  zzu zza;
  
  final Handler zzb;
  
  @NonNull
  @VisibleForTesting
  protected ConnectionProgressReportCallbacks zzc;
  
  @NonNull
  @VisibleForTesting
  protected AtomicInteger zzd = new AtomicInteger(0);
  
  private int zzf;
  
  private long zzg;
  
  private long zzh;
  
  private int zzi;
  
  private long zzj;
  
  @Nullable
  private volatile String zzk = null;
  
  private final Context zzl;
  
  private final Looper zzm;
  
  private final GmsClientSupervisor zzn;
  
  private final GoogleApiAvailabilityLight zzo;
  
  private final Object zzp = new Object();
  
  private final Object zzq = new Object();
  
  @Nullable
  @GuardedBy("mServiceBrokerLock")
  private IGmsServiceBroker zzr;
  
  @Nullable
  @GuardedBy("mLock")
  private IInterface zzs;
  
  private final ArrayList zzt = new ArrayList();
  
  @Nullable
  @GuardedBy("mLock")
  private zze zzu;
  
  @GuardedBy("mLock")
  private int zzv = 1;
  
  @Nullable
  private final BaseConnectionCallbacks zzw;
  
  @Nullable
  private final BaseOnConnectionFailedListener zzx;
  
  private final int zzy;
  
  @Nullable
  private final String zzz;
  
  static {
    GOOGLE_PLUS_REQUIRED_FEATURES = new String[] { "service_esmobile", "service_googleme" };
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(@NonNull Context paramContext, @NonNull Handler paramHandler, @NonNull GmsClientSupervisor paramGmsClientSupervisor, @NonNull GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, @Nullable BaseConnectionCallbacks paramBaseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    this.zzl = paramContext;
    Preconditions.checkNotNull(paramHandler, "Handler must not be null");
    this.zzb = paramHandler;
    this.zzm = paramHandler.getLooper();
    Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    this.zzn = paramGmsClientSupervisor;
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    this.zzo = paramGoogleApiAvailabilityLight;
    this.zzy = paramInt;
    this.zzw = paramBaseConnectionCallbacks;
    this.zzx = paramBaseOnConnectionFailedListener;
    this.zzz = null;
  }
  
  @KeepForSdk
  protected BaseGmsClient(@NonNull Context paramContext, @NonNull Looper paramLooper, int paramInt, @Nullable BaseConnectionCallbacks paramBaseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, @Nullable String paramString) {
    this(paramContext, paramLooper, gmsClientSupervisor, googleApiAvailabilityLight, paramInt, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, paramString);
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(@NonNull Context paramContext, @NonNull Looper paramLooper, @NonNull GmsClientSupervisor paramGmsClientSupervisor, @NonNull GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, @Nullable BaseConnectionCallbacks paramBaseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, @Nullable String paramString) {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    this.zzl = paramContext;
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    this.zzm = paramLooper;
    Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    this.zzn = paramGmsClientSupervisor;
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    this.zzo = paramGoogleApiAvailabilityLight;
    this.zzb = (Handler)new zzb(this, paramLooper);
    this.zzy = paramInt;
    this.zzw = paramBaseConnectionCallbacks;
    this.zzx = paramBaseOnConnectionFailedListener;
    this.zzz = paramString;
  }
  
  private final void zzp(int paramInt, @Nullable IInterface paramIInterface) {
    boolean bool1;
    boolean bool2;
    boolean bool = false;
    if (paramInt != 4) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    if (paramIInterface == null) {
      bool2 = false;
    } else {
      bool2 = true;
    } 
    if (bool1 == bool2)
      bool = true; 
    Preconditions.checkArgument(bool);
    synchronized (this.zzp) {
      zze zze2;
      zzu zzu1;
      IllegalStateException illegalStateException;
      zze zze1;
      zze zze3;
      this.zzv = paramInt;
      this.zzs = paramIInterface;
      switch (paramInt) {
        case 4:
          Preconditions.checkNotNull(paramIInterface);
          onConnectedLocked((T)paramIInterface);
          break;
        case 2:
        case 3:
          zze2 = this.zzu;
          if (zze2 != null) {
            zzu zzu2 = this.zza;
            if (zzu2 != null) {
              String str2 = zzu2.zzc();
              String str1 = zzu2.zzb();
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
              stringBuilder.append(str2);
              stringBuilder.append(" on ");
              stringBuilder.append(str1);
              Log.e("GmsClient", stringBuilder.toString());
              GmsClientSupervisor gmsClientSupervisor = this.zzn;
              str1 = this.zza.zzc();
              Preconditions.checkNotNull(str1);
              gmsClientSupervisor.zzb(str1, this.zza.zzb(), this.zza.zza(), zze2, zze(), this.zza.zzd());
              this.zzd.incrementAndGet();
            } 
          } 
          zze3 = new zze();
          this(this, this.zzd.get());
          this.zzu = zze3;
          if (this.zzv == 3 && getLocalStartServiceAction() != null) {
            zzu1 = new zzu();
            this(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
          } else {
            zzu1 = new zzu(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
          } 
          this.zza = zzu1;
          if (!this.zza.zzd() || getMinApkVersion() >= 17895000) {
            GmsClientSupervisor gmsClientSupervisor = this.zzn;
            String str1 = this.zza.zzc();
            Preconditions.checkNotNull(str1);
            String str2 = this.zza.zzb();
            paramInt = this.zza.zza();
            String str3 = zze();
            bool = this.zza.zzd();
            Executor executor = getBindServiceExecutor();
            zzn zzn = new zzn();
            this(str1, str2, paramInt, bool);
            if (!gmsClientSupervisor.zzc(zzn, zze3, str3, executor)) {
              String str = this.zza.zzc();
              str1 = this.zza.zzb();
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("unable to connect to service: ");
              stringBuilder.append(str);
              stringBuilder.append(" on ");
              stringBuilder.append(str1);
              Log.w("GmsClient", stringBuilder.toString());
              zzl(16, null, this.zzd.get());
            } 
            break;
          } 
          illegalStateException = new IllegalStateException();
          this("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zzc())));
          throw illegalStateException;
        case 1:
          zze1 = this.zzu;
          if (zze1 != null) {
            GmsClientSupervisor gmsClientSupervisor = this.zzn;
            String str = this.zza.zzc();
            Preconditions.checkNotNull(str);
            gmsClientSupervisor.zzb(str, this.zza.zzb(), this.zza.zza(), zze1, zze(), this.zza.zzd());
            this.zzu = null;
          } 
          break;
      } 
      return;
    } 
  }
  
  @KeepForSdk
  public void checkAvailabilityAndConnect() {
    int i = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
    if (i != 0) {
      zzp(1, null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(this), i, null);
      return;
    } 
    connect(new LegacyClientCallbackAdapter(this));
  }
  
  @KeepForSdk
  protected final void checkConnected() {
    if (isConnected())
      return; 
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  @KeepForSdk
  public void connect(@NonNull ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks) {
    Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    this.zzc = paramConnectionProgressReportCallbacks;
    zzp(2, null);
  }
  
  @Nullable
  @KeepForSdk
  protected abstract T createServiceInterface(@NonNull IBinder paramIBinder);
  
  @KeepForSdk
  public void disconnect() {
    this.zzd.incrementAndGet();
    synchronized (this.zzt) {
      int i = this.zzt.size();
      for (byte b = 0; b < i; b++)
        ((zzc)this.zzt.get(b)).zzf(); 
      this.zzt.clear();
      synchronized (this.zzq) {
        this.zzr = null;
        zzp(1, null);
        return;
      } 
    } 
  }
  
  @KeepForSdk
  public void disconnect(@NonNull String paramString) {
    this.zzk = paramString;
    disconnect();
  }
  
  @KeepForSdk
  public void dump(@NonNull String paramString, @NonNull FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @NonNull String[] paramArrayOfString) {
    synchronized (this.zzp) {
      int i = this.zzv;
      IInterface iInterface = this.zzs;
      synchronized (this.zzq) {
        IGmsServiceBroker iGmsServiceBroker = this.zzr;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i) {
          default:
            paramPrintWriter.print("UNKNOWN");
            break;
          case 5:
            paramPrintWriter.print("DISCONNECTING");
            break;
          case 4:
            paramPrintWriter.print("CONNECTED");
            break;
          case 3:
            paramPrintWriter.print("LOCAL_CONNECTING");
            break;
          case 2:
            paramPrintWriter.print("REMOTE_CONNECTING");
            break;
          case 1:
            paramPrintWriter.print("DISCONNECTED");
            break;
        } 
        paramPrintWriter.append(" mService=");
        if (iInterface == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        } 
        paramPrintWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        } 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0L) {
          PrintWriter printWriter = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          long l = this.zzh;
          null = simpleDateFormat.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append((String)null);
          printWriter.println(stringBuilder.toString());
        } 
        if (this.zzg > 0L) {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = this.zzf;
          switch (i) {
            default:
              paramPrintWriter.append(String.valueOf(i));
              break;
            case 3:
              paramPrintWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
              break;
            case 2:
              paramPrintWriter.append("CAUSE_NETWORK_LOST");
              break;
            case 1:
              paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
              break;
          } 
          PrintWriter printWriter = paramPrintWriter.append(" lastSuspendedTime=");
          long l = this.zzg;
          String str = simpleDateFormat.format(new Date(l));
          null = new StringBuilder();
          null.append(l);
          null.append(" ");
          null.append(str);
          printWriter.println(null.toString());
        } 
        if (this.zzj > 0L) {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzi));
          PrintWriter printWriter = paramPrintWriter.append(" lastFailedTime=");
          long l = this.zzj;
          String str = simpleDateFormat.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          printWriter.println(stringBuilder.toString());
        } 
        return;
      } 
    } 
  }
  
  @KeepForSdk
  protected boolean enableLocalFallback() {
    return false;
  }
  
  @Nullable
  @KeepForSdk
  public Account getAccount() {
    return null;
  }
  
  @NonNull
  @KeepForSdk
  public Feature[] getApiFeatures() {
    return zze;
  }
  
  @Nullable
  @KeepForSdk
  public final Feature[] getAvailableFeatures() {
    zzj zzj1 = this.zzD;
    return (zzj1 == null) ? null : zzj1.zzb;
  }
  
  @Nullable
  @KeepForSdk
  protected Executor getBindServiceExecutor() {
    return null;
  }
  
  @Nullable
  @KeepForSdk
  public Bundle getConnectionHint() {
    return null;
  }
  
  @NonNull
  @KeepForSdk
  public final Context getContext() {
    return this.zzl;
  }
  
  @NonNull
  @KeepForSdk
  public String getEndpointPackageName() {
    if (isConnected()) {
      zzu zzu1 = this.zza;
      if (zzu1 != null)
        return zzu1.zzb(); 
    } 
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  @KeepForSdk
  public int getGCoreServiceId() {
    return this.zzy;
  }
  
  @NonNull
  @KeepForSdk
  protected Bundle getGetServiceRequestExtraArgs() {
    return new Bundle();
  }
  
  @Nullable
  @KeepForSdk
  public String getLastDisconnectMessage() {
    return this.zzk;
  }
  
  @Nullable
  @KeepForSdk
  protected String getLocalStartServiceAction() {
    return null;
  }
  
  @NonNull
  @KeepForSdk
  public final Looper getLooper() {
    return this.zzm;
  }
  
  @KeepForSdk
  public int getMinApkVersion() {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  @WorkerThread
  @KeepForSdk
  public void getRemoteService(@Nullable IAccountAccessor paramIAccountAccessor, @NonNull Set<Scope> paramSet) {
    Bundle bundle1 = getGetServiceRequestExtraArgs();
    int i = this.zzy;
    String str = this.zzA;
    int j = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    Scope[] arrayOfScope = GetServiceRequest.zza;
    Bundle bundle2 = new Bundle();
    Feature[] arrayOfFeature = GetServiceRequest.zzb;
    GetServiceRequest getServiceRequest = new GetServiceRequest(6, i, j, null, null, arrayOfScope, bundle2, null, arrayOfFeature, arrayOfFeature, true, 0, false, str);
    getServiceRequest.zzf = this.zzl.getPackageName();
    getServiceRequest.zzi = bundle1;
    if (paramSet != null)
      getServiceRequest.zzh = paramSet.<Scope>toArray(new Scope[0]); 
    if (requiresSignIn()) {
      Account account2 = getAccount();
      Account account1 = account2;
      if (account2 == null)
        account1 = new Account("<<default account>>", "com.google"); 
      getServiceRequest.zzj = account1;
      if (paramIAccountAccessor != null)
        getServiceRequest.zzg = paramIAccountAccessor.asBinder(); 
    } else if (requiresAccount()) {
      getServiceRequest.zzj = getAccount();
    } 
    getServiceRequest.zzk = zze;
    getServiceRequest.zzl = getApiFeatures();
    if (usesClientTelemetry())
      getServiceRequest.zzo = true; 
    try {
      synchronized (this.zzq) {
        IGmsServiceBroker iGmsServiceBroker = this.zzr;
        if (iGmsServiceBroker != null) {
          zzd zzd = new zzd();
          this(this, this.zzd.get());
          iGmsServiceBroker.getService(zzd, getServiceRequest);
        } else {
          Log.w("GmsClient", "mServiceBroker is null, client disconnected");
        } 
        return;
      } 
    } catch (DeadObjectException deadObjectException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)deadObjectException);
      triggerConnectionSuspended(3);
      return;
    } catch (SecurityException securityException) {
      throw securityException;
    } catch (RemoteException|RuntimeException remoteException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)remoteException);
      onPostInitHandler(8, null, null, this.zzd.get());
      return;
    } 
  }
  
  @NonNull
  @KeepForSdk
  protected Set<Scope> getScopes() {
    return Collections.emptySet();
  }
  
  @NonNull
  @KeepForSdk
  public final T getService() throws DeadObjectException {
    synchronized (this.zzp) {
      if (this.zzv != 5) {
        checkConnected();
        IInterface iInterface = this.zzs;
        Preconditions.checkNotNull(iInterface, "Client is connected but service is null");
        return (T)iInterface;
      } 
      DeadObjectException deadObjectException = new DeadObjectException();
      this();
      throw deadObjectException;
    } 
  }
  
  @Nullable
  @KeepForSdk
  public IBinder getServiceBrokerBinder() {
    synchronized (this.zzq) {
      IGmsServiceBroker iGmsServiceBroker = this.zzr;
      if (iGmsServiceBroker == null)
        return null; 
      return iGmsServiceBroker.asBinder();
    } 
  }
  
  @NonNull
  @KeepForSdk
  protected abstract String getServiceDescriptor();
  
  @NonNull
  @KeepForSdk
  public Intent getSignInIntent() {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  @NonNull
  @KeepForSdk
  protected abstract String getStartServiceAction();
  
  @NonNull
  @KeepForSdk
  protected String getStartServicePackage() {
    return "com.google.android.gms";
  }
  
  @Nullable
  @KeepForSdk
  public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
    zzj zzj1 = this.zzD;
    return (zzj1 == null) ? null : zzj1.zzd;
  }
  
  @KeepForSdk
  protected boolean getUseDynamicLookup() {
    return (getMinApkVersion() >= 211700000);
  }
  
  @KeepForSdk
  public boolean hasConnectionInfo() {
    return (this.zzD != null);
  }
  
  @KeepForSdk
  public boolean isConnected() {
    synchronized (this.zzp) {
      boolean bool;
      if (this.zzv == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } 
  }
  
  @KeepForSdk
  public boolean isConnecting() {
    synchronized (this.zzp) {
      int i = this.zzv;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (i != 2)
        if (i == 3) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }  
      return bool2;
    } 
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectedLocked(@NonNull T paramT) {
    this.zzh = System.currentTimeMillis();
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult) {
    this.zzi = paramConnectionResult.getErrorCode();
    this.zzj = System.currentTimeMillis();
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectionSuspended(int paramInt) {
    this.zzf = paramInt;
    this.zzg = System.currentTimeMillis();
  }
  
  @KeepForSdk
  protected void onPostInitHandler(int paramInt1, @Nullable IBinder paramIBinder, @Nullable Bundle paramBundle, int paramInt2) {
    Handler handler = this.zzb;
    handler.sendMessage(handler.obtainMessage(1, paramInt2, -1, new zzf(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  @KeepForSdk
  public void onUserSignOut(@NonNull SignOutCallbacks paramSignOutCallbacks) {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  @KeepForSdk
  public boolean providesSignIn() {
    return false;
  }
  
  @KeepForSdk
  public boolean requiresAccount() {
    return false;
  }
  
  @KeepForSdk
  public boolean requiresGooglePlayServices() {
    return true;
  }
  
  @KeepForSdk
  public boolean requiresSignIn() {
    return false;
  }
  
  @KeepForSdk
  public void setAttributionTag(@NonNull String paramString) {
    this.zzA = paramString;
  }
  
  @KeepForSdk
  public void triggerConnectionSuspended(int paramInt) {
    Handler handler = this.zzb;
    handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), paramInt));
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, @Nullable PendingIntent paramPendingIntent) {
    Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    this.zzc = paramConnectionProgressReportCallbacks;
    Handler handler = this.zzb;
    handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), paramInt, paramPendingIntent));
  }
  
  @KeepForSdk
  public boolean usesClientTelemetry() {
    return false;
  }
  
  @NonNull
  protected final String zze() {
    String str1 = this.zzz;
    String str2 = str1;
    if (str1 == null)
      str2 = this.zzl.getClass().getName(); 
    return str2;
  }
  
  protected final void zzl(int paramInt1, @Nullable Bundle paramBundle, int paramInt2) {
    Handler handler = this.zzb;
    handler.sendMessage(handler.obtainMessage(7, paramInt2, -1, new zzg(this, paramInt1, null)));
  }
  
  @KeepForSdk
  public static interface BaseConnectionCallbacks {
    @KeepForSdk
    public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
    
    @KeepForSdk
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    @KeepForSdk
    void onConnected(@Nullable Bundle param1Bundle);
    
    @KeepForSdk
    void onConnectionSuspended(int param1Int);
  }
  
  @KeepForSdk
  public static interface BaseOnConnectionFailedListener {
    @KeepForSdk
    void onConnectionFailed(@NonNull ConnectionResult param1ConnectionResult);
  }
  
  @KeepForSdk
  public static interface ConnectionProgressReportCallbacks {
    @KeepForSdk
    void onReportServiceBinding(@NonNull ConnectionResult param1ConnectionResult);
  }
  
  protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
    @KeepForSdk
    public LegacyClientCallbackAdapter(BaseGmsClient this$0) {}
    
    public final void onReportServiceBinding(@NonNull ConnectionResult param1ConnectionResult) {
      BaseGmsClient baseGmsClient;
      if (param1ConnectionResult.isSuccess()) {
        baseGmsClient = this.zza;
        baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
        return;
      } 
      if (BaseGmsClient.zzc(this.zza) != null)
        BaseGmsClient.zzc(this.zza).onConnectionFailed((ConnectionResult)baseGmsClient); 
    }
  }
  
  @KeepForSdk
  public static interface SignOutCallbacks {
    @KeepForSdk
    void onSignOutComplete();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\BaseGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */