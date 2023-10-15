package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
  public static final int API_DISABLED = 23;
  
  public static final int API_DISABLED_FOR_CONNECTION = 24;
  
  public static final int API_UNAVAILABLE = 16;
  
  public static final int CANCELED = 13;
  
  @NonNull
  public static final Parcelable.Creator<ConnectionResult> CREATOR;
  
  public static final int DEVELOPER_ERROR = 10;
  
  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  
  public static final int INTERNAL_ERROR = 8;
  
  public static final int INTERRUPTED = 15;
  
  public static final int INVALID_ACCOUNT = 5;
  
  public static final int LICENSE_CHECK_FAILED = 11;
  
  public static final int NETWORK_ERROR = 7;
  
  public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
  
  public static final int RESOLUTION_REQUIRED = 6;
  
  public static final int RESTRICTED_PROFILE = 20;
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
  
  public static final int SERVICE_DISABLED = 3;
  
  public static final int SERVICE_INVALID = 9;
  
  public static final int SERVICE_MISSING = 1;
  
  public static final int SERVICE_MISSING_PERMISSION = 19;
  
  public static final int SERVICE_UPDATING = 18;
  
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  
  public static final int SIGN_IN_FAILED = 17;
  
  public static final int SIGN_IN_REQUIRED = 4;
  
  public static final int SUCCESS = 0;
  
  public static final int TIMEOUT = 14;
  
  @KeepForSdk
  public static final int UNKNOWN = -1;
  
  @VersionField(id = 1)
  final int zza;
  
  @Field(getter = "getErrorCode", id = 2)
  private final int zzb;
  
  @Nullable
  @Field(getter = "getResolution", id = 3)
  private final PendingIntent zzc;
  
  @Nullable
  @Field(getter = "getErrorMessage", id = 4)
  private final String zzd;
  
  static {
    CREATOR = new zzb();
  }
  
  public ConnectionResult(int paramInt) {
    this(paramInt, null, null);
  }
  
  @Constructor
  ConnectionResult(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Nullable @Param(id = 3) PendingIntent paramPendingIntent, @Nullable @Param(id = 4) String paramString) {
    this.zza = paramInt1;
    this.zzb = paramInt2;
    this.zzc = paramPendingIntent;
    this.zzd = paramString;
  }
  
  public ConnectionResult(int paramInt, @Nullable PendingIntent paramPendingIntent) {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, @Nullable PendingIntent paramPendingIntent, @Nullable String paramString) {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  @NonNull
  static String zza(int paramInt) {
    if (paramInt != 99) {
      if (paramInt != 1500) {
        StringBuilder stringBuilder;
        switch (paramInt) {
          default:
            switch (paramInt) {
              default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("UNKNOWN_ERROR_CODE(");
                stringBuilder.append(paramInt);
                stringBuilder.append(")");
                return stringBuilder.toString();
              case 24:
                return "API_DISABLED_FOR_CONNECTION";
              case 23:
                return "API_DISABLED";
              case 22:
                return "RESOLUTION_ACTIVITY_NOT_FOUND";
              case 21:
                return "API_VERSION_UPDATE_REQUIRED";
              case 20:
                return "RESTRICTED_PROFILE";
              case 19:
                return "SERVICE_MISSING_PERMISSION";
              case 18:
                return "SERVICE_UPDATING";
              case 17:
                return "SIGN_IN_FAILED";
              case 16:
                return "API_UNAVAILABLE";
              case 15:
                return "INTERRUPTED";
              case 14:
                return "TIMEOUT";
              case 13:
                break;
            } 
            return "CANCELED";
          case 11:
            return "LICENSE_CHECK_FAILED";
          case 10:
            return "DEVELOPER_ERROR";
          case 9:
            return "SERVICE_INVALID";
          case 8:
            return "INTERNAL_ERROR";
          case 7:
            return "NETWORK_ERROR";
          case 6:
            return "RESOLUTION_REQUIRED";
          case 5:
            return "INVALID_ACCOUNT";
          case 4:
            return "SIGN_IN_REQUIRED";
          case 3:
            return "SERVICE_DISABLED";
          case 2:
            return "SERVICE_VERSION_UPDATE_REQUIRED";
          case 1:
            return "SERVICE_MISSING";
          case 0:
            return "SUCCESS";
          case -1:
            break;
        } 
        return "UNKNOWN";
      } 
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    } 
    return "UNFINISHED";
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ConnectionResult))
      return false; 
    paramObject = paramObject;
    return (this.zzb == ((ConnectionResult)paramObject).zzb && Objects.equal(this.zzc, ((ConnectionResult)paramObject).zzc) && Objects.equal(this.zzd, ((ConnectionResult)paramObject).zzd));
  }
  
  public int getErrorCode() {
    return this.zzb;
  }
  
  @Nullable
  public String getErrorMessage() {
    return this.zzd;
  }
  
  @Nullable
  public PendingIntent getResolution() {
    return this.zzc;
  }
  
  public boolean hasResolution() {
    return (this.zzb != 0 && this.zzc != null);
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzb), this.zzc, this.zzd });
  }
  
  public boolean isSuccess() {
    return (this.zzb == 0);
  }
  
  public void startResolutionForResult(@NonNull Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    if (!hasResolution())
      return; 
    PendingIntent pendingIntent = this.zzc;
    Preconditions.checkNotNull(pendingIntent);
    paramActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  @NonNull
  public String toString() {
    Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this);
    toStringHelper.add("statusCode", zza(this.zzb));
    toStringHelper.add("resolution", this.zzc);
    toStringHelper.add("message", this.zzd);
    return toStringHelper.toString();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\ConnectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */