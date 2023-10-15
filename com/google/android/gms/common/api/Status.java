package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;

@Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
  @NonNull
  public static final Parcelable.Creator<Status> CREATOR;
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_CANCELED;
  
  @NonNull
  @KeepForSdk
  public static final Status RESULT_DEAD_CLIENT;
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_INTERNAL_ERROR;
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_INTERRUPTED;
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static final Status RESULT_SUCCESS;
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_TIMEOUT;
  
  @NonNull
  @ShowFirstParty
  public static final Status zza;
  
  @VersionField(id = 1000)
  final int zzb;
  
  @Field(getter = "getStatusCode", id = 1)
  private final int zzc;
  
  @Nullable
  @Field(getter = "getStatusMessage", id = 2)
  private final String zzd;
  
  @Nullable
  @Field(getter = "getPendingIntent", id = 3)
  private final PendingIntent zze;
  
  @Nullable
  @Field(getter = "getConnectionResult", id = 4)
  private final ConnectionResult zzf;
  
  static {
    RESULT_SUCCESS = new Status(0);
    RESULT_INTERRUPTED = new Status(14);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_TIMEOUT = new Status(15);
    RESULT_CANCELED = new Status(16);
    zza = new Status(17);
    RESULT_DEAD_CLIENT = new Status(18);
    CREATOR = new zzb();
  }
  
  public Status(int paramInt) {
    this(paramInt, (String)null);
  }
  
  @Constructor
  Status(@Param(id = 1000) int paramInt1, @Param(id = 1) int paramInt2, @Nullable @Param(id = 2) String paramString, @Nullable @Param(id = 3) PendingIntent paramPendingIntent, @Nullable @Param(id = 4) ConnectionResult paramConnectionResult) {
    this.zzb = paramInt1;
    this.zzc = paramInt2;
    this.zzd = paramString;
    this.zze = paramPendingIntent;
    this.zzf = paramConnectionResult;
  }
  
  public Status(int paramInt, @Nullable String paramString) {
    this(1, paramInt, paramString, null, null);
  }
  
  public Status(int paramInt, @Nullable String paramString, @Nullable PendingIntent paramPendingIntent) {
    this(1, paramInt, paramString, paramPendingIntent, null);
  }
  
  public Status(@NonNull ConnectionResult paramConnectionResult, @NonNull String paramString) {
    this(paramConnectionResult, paramString, 17);
  }
  
  @Deprecated
  @KeepForSdk
  public Status(@NonNull ConnectionResult paramConnectionResult, @NonNull String paramString, int paramInt) {
    this(1, paramInt, paramString, paramConnectionResult.getResolution(), paramConnectionResult);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (!(paramObject instanceof Status))
      return false; 
    paramObject = paramObject;
    return (this.zzb == ((Status)paramObject).zzb && this.zzc == ((Status)paramObject).zzc && Objects.equal(this.zzd, ((Status)paramObject).zzd) && Objects.equal(this.zze, ((Status)paramObject).zze) && Objects.equal(this.zzf, ((Status)paramObject).zzf));
  }
  
  @Nullable
  public ConnectionResult getConnectionResult() {
    return this.zzf;
  }
  
  @Nullable
  public PendingIntent getResolution() {
    return this.zze;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Status getStatus() {
    return this;
  }
  
  public int getStatusCode() {
    return this.zzc;
  }
  
  @Nullable
  public String getStatusMessage() {
    return this.zzd;
  }
  
  @VisibleForTesting
  public boolean hasResolution() {
    return (this.zze != null);
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf });
  }
  
  public boolean isCanceled() {
    return (this.zzc == 16);
  }
  
  public boolean isInterrupted() {
    return (this.zzc == 14);
  }
  
  @CheckReturnValue
  public boolean isSuccess() {
    return (this.zzc <= 0);
  }
  
  public void startResolutionForResult(@NonNull Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    if (!hasResolution())
      return; 
    PendingIntent pendingIntent = this.zze;
    Preconditions.checkNotNull(pendingIntent);
    paramActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  @NonNull
  public String toString() {
    Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this);
    toStringHelper.add("statusCode", zza());
    toStringHelper.add("resolution", this.zze);
    return toStringHelper.toString();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getStatusCode());
    SafeParcelWriter.writeString(paramParcel, 2, getStatusMessage(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zze, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzb);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @NonNull
  public final String zza() {
    String str = this.zzd;
    return (str != null) ? str : CommonStatusCodes.getStatusCodeString(this.zzc);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */