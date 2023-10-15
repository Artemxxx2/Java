package com.google.android.gms.common;

import android.accounts.Account;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

public class Builder {
  @Nullable
  private Account zza;
  
  @Nullable
  private ArrayList zzb;
  
  @Nullable
  private ArrayList zzc;
  
  private boolean zzd = false;
  
  @Nullable
  private String zze;
  
  @Nullable
  private Bundle zzf;
  
  @NonNull
  public AccountPicker.AccountChooserOptions build() {
    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
    Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
    AccountPicker.AccountChooserOptions accountChooserOptions = new AccountPicker.AccountChooserOptions();
    AccountPicker.AccountChooserOptions.zzj(accountChooserOptions, this.zzc);
    AccountPicker.AccountChooserOptions.zzk(accountChooserOptions, this.zzb);
    AccountPicker.AccountChooserOptions.zzl(accountChooserOptions, this.zzd);
    AccountPicker.AccountChooserOptions.zzm(accountChooserOptions, null);
    AccountPicker.AccountChooserOptions.zzp(accountChooserOptions, null);
    AccountPicker.AccountChooserOptions.zzq(accountChooserOptions, this.zzf);
    AccountPicker.AccountChooserOptions.zzs(accountChooserOptions, this.zza);
    AccountPicker.AccountChooserOptions.zzt(accountChooserOptions, false);
    AccountPicker.AccountChooserOptions.zzu(accountChooserOptions, false);
    AccountPicker.AccountChooserOptions.zzr(accountChooserOptions, null);
    AccountPicker.AccountChooserOptions.zzv(accountChooserOptions, 0);
    AccountPicker.AccountChooserOptions.zzw(accountChooserOptions, this.zze);
    AccountPicker.AccountChooserOptions.zzx(accountChooserOptions, false);
    AccountPicker.AccountChooserOptions.zzn(accountChooserOptions, false);
    AccountPicker.AccountChooserOptions.zzo(accountChooserOptions, false);
    return accountChooserOptions;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Builder setAllowableAccounts(@Nullable List<Account> paramList) {
    if (paramList == null) {
      paramList = null;
    } else {
      paramList = new ArrayList<Account>(paramList);
    } 
    this.zzb = (ArrayList)paramList;
    return this;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Builder setAllowableAccountsTypes(@Nullable List<String> paramList) {
    if (paramList == null) {
      paramList = null;
    } else {
      paramList = new ArrayList<String>(paramList);
    } 
    this.zzc = (ArrayList)paramList;
    return this;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Builder setAlwaysShowAccountPicker(boolean paramBoolean) {
    this.zzd = paramBoolean;
    return this;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Builder setOptionsForAddingAccount(@Nullable Bundle paramBundle) {
    this.zzf = paramBundle;
    return this;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Builder setSelectedAccount(@Nullable Account paramAccount) {
    this.zza = paramAccount;
    return this;
  }
  
  @NonNull
  @CanIgnoreReturnValue
  public Builder setTitleOverrideText(@Nullable String paramString) {
    this.zze = paramString;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\AccountPicker$AccountChooserOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */