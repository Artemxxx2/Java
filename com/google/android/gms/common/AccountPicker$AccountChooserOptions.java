package com.google.android.gms.common;

import android.accounts.Account;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

public class AccountChooserOptions {
  @Nullable
  private Account zza;
  
  private boolean zzb;
  
  @Nullable
  private ArrayList zzc;
  
  @Nullable
  private ArrayList zzd;
  
  private boolean zze;
  
  @Nullable
  private String zzf;
  
  @Nullable
  private Bundle zzg;
  
  private boolean zzh;
  
  private int zzi;
  
  @Nullable
  private String zzj;
  
  private boolean zzk;
  
  @Nullable
  private zza zzl;
  
  @Nullable
  private String zzm;
  
  private boolean zzn;
  
  private boolean zzo;
  
  public static class Builder {
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
    public Builder setAllowableAccounts(@Nullable List<Account> param2List) {
      if (param2List == null) {
        param2List = null;
      } else {
        param2List = new ArrayList<Account>(param2List);
      } 
      this.zzb = (ArrayList)param2List;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setAllowableAccountsTypes(@Nullable List<String> param2List) {
      if (param2List == null) {
        param2List = null;
      } else {
        param2List = new ArrayList<String>(param2List);
      } 
      this.zzc = (ArrayList)param2List;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setAlwaysShowAccountPicker(boolean param2Boolean) {
      this.zzd = param2Boolean;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setOptionsForAddingAccount(@Nullable Bundle param2Bundle) {
      this.zzf = param2Bundle;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setSelectedAccount(@Nullable Account param2Account) {
      this.zza = param2Account;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setTitleOverrideText(@Nullable String param2String) {
      this.zze = param2String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\AccountPicker$AccountChooserOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */