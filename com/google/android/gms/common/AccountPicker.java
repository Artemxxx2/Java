package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker {
  @Deprecated
  @NonNull
  public static Intent newChooseAccountIntent(@Nullable Account paramAccount, @Nullable ArrayList<Account> paramArrayList, @Nullable String[] paramArrayOfString1, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String[] paramArrayOfString2, @Nullable Bundle paramBundle) {
    Intent intent = new Intent();
    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    intent.setPackage("com.google.android.gms");
    intent.putExtra("allowableAccounts", paramArrayList);
    intent.putExtra("allowableAccountTypes", paramArrayOfString1);
    intent.putExtra("addAccountOptions", paramBundle);
    intent.putExtra("selectedAccount", (Parcelable)paramAccount);
    intent.putExtra("alwaysPromptForAccount", paramBoolean);
    intent.putExtra("descriptionTextOverride", paramString1);
    intent.putExtra("authTokenType", paramString2);
    intent.putExtra("addAccountRequiredFeatures", paramArrayOfString2);
    intent.putExtra("setGmsCoreAccount", false);
    intent.putExtra("overrideTheme", 0);
    intent.putExtra("overrideCustomTheme", 0);
    intent.putExtra("hostedDomainFilter", null);
    return intent;
  }
  
  @NonNull
  public static Intent newChooseAccountIntent(@NonNull AccountChooserOptions paramAccountChooserOptions) {
    Intent intent = new Intent();
    AccountChooserOptions.zzD(paramAccountChooserOptions);
    AccountChooserOptions.zze(paramAccountChooserOptions);
    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
    AccountChooserOptions.zzd(paramAccountChooserOptions);
    Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
    AccountChooserOptions.zzB(paramAccountChooserOptions);
    Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
    AccountChooserOptions.zzD(paramAccountChooserOptions);
    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    intent.setPackage("com.google.android.gms");
    intent.putExtra("allowableAccounts", AccountChooserOptions.zzi(paramAccountChooserOptions));
    if (AccountChooserOptions.zzh(paramAccountChooserOptions) != null)
      intent.putExtra("allowableAccountTypes", (String[])AccountChooserOptions.zzh(paramAccountChooserOptions).toArray((Object[])new String[0])); 
    intent.putExtra("addAccountOptions", AccountChooserOptions.zzc(paramAccountChooserOptions));
    intent.putExtra("selectedAccount", (Parcelable)AccountChooserOptions.zzb(paramAccountChooserOptions));
    AccountChooserOptions.zzB(paramAccountChooserOptions);
    intent.putExtra("selectedAccountIsNotClickable", false);
    intent.putExtra("alwaysPromptForAccount", AccountChooserOptions.zzy(paramAccountChooserOptions));
    intent.putExtra("descriptionTextOverride", AccountChooserOptions.zzg(paramAccountChooserOptions));
    AccountChooserOptions.zzC(paramAccountChooserOptions);
    intent.putExtra("setGmsCoreAccount", false);
    AccountChooserOptions.zzf(paramAccountChooserOptions);
    intent.putExtra("realClientPackage", null);
    AccountChooserOptions.zza(paramAccountChooserOptions);
    intent.putExtra("overrideTheme", 0);
    AccountChooserOptions.zzD(paramAccountChooserOptions);
    intent.putExtra("overrideCustomTheme", 0);
    AccountChooserOptions.zze(paramAccountChooserOptions);
    intent.putExtra("hostedDomainFilter", null);
    Bundle bundle = new Bundle();
    AccountChooserOptions.zzD(paramAccountChooserOptions);
    AccountChooserOptions.zzd(paramAccountChooserOptions);
    AccountChooserOptions.zzz(paramAccountChooserOptions);
    AccountChooserOptions.zzA(paramAccountChooserOptions);
    if (!bundle.isEmpty())
      intent.putExtra("first_party_options_bundle", bundle); 
    return intent;
  }
  
  public static class AccountChooserOptions {
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
    public Builder setAllowableAccounts(@Nullable List<Account> param1List) {
      if (param1List == null) {
        param1List = null;
      } else {
        param1List = new ArrayList<Account>(param1List);
      } 
      this.zzb = (ArrayList)param1List;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setAllowableAccountsTypes(@Nullable List<String> param1List) {
      if (param1List == null) {
        param1List = null;
      } else {
        param1List = new ArrayList<String>(param1List);
      } 
      this.zzc = (ArrayList)param1List;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setAlwaysShowAccountPicker(boolean param1Boolean) {
      this.zzd = param1Boolean;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setOptionsForAddingAccount(@Nullable Bundle param1Bundle) {
      this.zzf = param1Bundle;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setSelectedAccount(@Nullable Account param1Account) {
      this.zza = param1Account;
      return this;
    }
    
    @NonNull
    @CanIgnoreReturnValue
    public Builder setTitleOverrideText(@Nullable String param1String) {
      this.zze = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\AccountPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */